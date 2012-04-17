package edu.wustl.common.util.impexp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.wustl.common.CommonBaseTestCase;


public abstract class CommonAutomateImpExpTestCase extends CommonBaseTestCase
{
	public final static char QUERY_ENDS = ';';

	private File script;

	private Connection connection=null;

	private Statement statement;
	
	public void runSQLFile(String fileName) throws SQLException, IOException
	{
		setScript(new File(fileName));		
		setStatement(getConnection().createStatement());
		loadScript();
		execute();
	}

	protected void loadScript() throws IOException, SQLException 
	{
		BufferedReader reader = new BufferedReader(new FileReader(script));
		String line;
		StringBuffer query = new StringBuffer();
		boolean queryEnds = false;
	
		while ((line = reader.readLine()) != null)
		{
			if (isComment(line))
				continue;
			queryEnds = checkStatementEnds(line);
			query.append(line);
			if (queryEnds) 
			{
				System.out.println("query->"+query);
				statement.addBatch(query.toString());
				query.setLength(0);
			}
		}
	}
	
	protected boolean isComment(String line)
	{
		if ((line != null) && (line.length() > 0))
			return (line.charAt(0) == '#');
		return false;
	}

	protected void execute() throws IOException, SQLException
	{
		statement.executeBatch();
	}

	protected boolean checkStatementEnds(String s)
	{
		return (s.indexOf(QUERY_ENDS) != -1);
	}

	
	/**
	 * @return the script
	 */
	public File getScript()
	{
		return script;
	}

	
	/**
	 * @param script the script to set
	 */
	public void setScript(File script)
	{
		this.script = script;
	}

	
	/**
	 * @return the connection
	 */
	public Connection getConnection()
	{
		return connection;
	}

	
	/**
	 * @param con the connection to set
	 */
	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}

	
	/**
	 * @return the statement
	 */
	public Statement getStatement()
	{
		return statement;
	}

	
	/**
	 * @param stat the statement to set
	 */
	public void setStatement(Statement statement)
	{
		this.statement = statement;
	}
	
	/**
	 * Method to test Automate Import.
	 */
	public abstract void testImport();
	
	/**
	 * Method to test Automate Export.
	 */
	public abstract void testExport();	
	
}
