package edu.wustl.common.util.impexp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import edu.wustl.common.exception.ApplicationException;
import edu.wustl.common.util.global.HibernateProperties;
import edu.wustl.common.util.logger.Logger;


public class OracleAutomateImpExpTestCase extends CommonAutomateImpExpTestCase
{
	/**
	 * Generic Logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(OracleAutomateImpExpTestCase.class);
	private static final String []ARGS= new String[12];
	static
	{
		ARGS[0]=HibernateProperties.getValue("database.host");
		ARGS[1]=HibernateProperties.getValue("database.port");
		ARGS[2]=HibernateProperties.getValue("database.type");
		ARGS[3]=HibernateProperties.getValue("database.name");
		ARGS[4]=HibernateProperties.getValue("database.username");
		ARGS[5]=HibernateProperties.getValue("database.password");
		ARGS[6]=HibernateProperties.getValue("database.driver");
		ARGS[11]=HibernateProperties.getValue("oracle.tns.name");
	}

	private void testOracleAutomateImport()
	{
		ARGS[7]="import";
		ARGS[8]=System.getProperty("user.dir")+"/SQL/Common/test/Permissible_values/dumpFileColumnInfo.txt";
		ARGS[9]=System.getProperty("user.dir")+"/SQL/Common/test/Permissible_values/";
		ARGS[10]=System.getProperty("user.dir")+"/SQL/Common/test/Permissible_values/";
		try
		{	preImport();
			AutomateImport.main(ARGS);
			assertTrue("Metadata imported successfully.", true);
		}
		catch (Exception exception)
		{
			fail("Fail to import metadata.");
			logger.debug("Fail to import metadata.", exception);
		}
	}

	private void testOracleAutomateExport()
	{
		try
		{
			ARGS[7]="export";
			ARGS[8]=System.getProperty("user.dir")+"/SQL/Common/test/Permissible_values/dumpFileColumnInfo.txt";
			ARGS[9]=System.getProperty("user.dir")+"/SQL/Oracle/";
			ARGS[10]=System.getProperty("user.dir")+"/SQL/Oracle/";
			AutomateImport.main(ARGS);
			assertTrue("Metadata imported successfully.", true);
		}
		catch (Exception exception)
		{
			fail("Fail to import metadata.");
			logger.debug("Fail to import metadata.", exception);
		}
	}

	private void preImport() throws IOException, SQLException, ClassNotFoundException, ApplicationException
	{
		DatabaseUtility dbUtility= new DatabaseUtility();
		dbUtility.setDbParams(ARGS);
		setConnection(dbUtility.getConnection());
		try
		{
			runSQLFile(System.getProperty("user.dir")+"/SQL/Oracle/testAutomateImpExp.sql");
			runSQLFile(System.getProperty("user.dir")+"/SQL/Common/test/CDE_DummyData_Common.sql");
			getConnection().commit();
		}
		finally
		{
			getConnection().close();
		}
	}

	protected void loadScript() throws IOException, SQLException
	{
		BufferedReader reader = new BufferedReader(new FileReader(getScript()));
		String line;
		StringBuffer query = new StringBuffer();
		boolean queryEnds = false;

		while ((line = reader.readLine()) != null)
		{
			if (isComment(line))
			{
				continue;
			}
			query.append(line.substring(0,line.length()-1));
			//System.out.println("query->"+query);
			getStatement().addBatch(query.toString());
			query.setLength(0);
		}
	}
	
	public void testImport()
	{
		testOracleAutomateImport();
	}
	
	public void testExport()
	{
		testOracleAutomateExport();
	}
}
