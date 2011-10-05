package edu.wustl.common.util.impexp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.wustl.common.exception.ApplicationException;
import edu.wustl.common.util.global.HibernateProperties;
import edu.wustl.common.util.logger.Logger;

/**
 * This is for testing of Automate import/export function for MSSQL server database.
 * Please make sure that all the parameters configured in junitConf.properties are correct.
 * Also database server must contains csv file because database searches file on server.
 * @author ravi_kumar
 *
 */
public class MsSqlAutomateImpExpTestCase extends CommonAutomateImpExpTestCase
{
	/**
	 * Generic Logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(MsSqlAutomateImpExpTestCase.class);
	private static final String []ARGS= new String[10];
	static
	{
			ARGS[0]=HibernateProperties.getValue("mssql.db.host");
			ARGS[1]=HibernateProperties.getValue("mssql.db.port");
			ARGS[2]="mssql";
			ARGS[3]=HibernateProperties.getValue("mssql.db.name");
			ARGS[4]=HibernateProperties.getValue("mssql.db.username");
			ARGS[5]=HibernateProperties.getValue("mssql.db.password");
			ARGS[6]=HibernateProperties.getValue("mssql.db.driver");
	}
	private void testMsSqlAutomateImport()
	{
		ARGS[7]="import";
		ARGS[8]=System.getProperty("user.dir")+"/SQL/Common/test/Permissible_values/dumpFileColumnInfo.txt";
		ARGS[9]=System.getProperty("user.dir")+"/SQL/Common/test/Permissible_values/";
		try
		{	preImport();
			AutomateImport.main(ARGS);
			assertTrue("Metadata imported successfully.", true);
		}
		catch (Exception exception)
		{
			logger.debug("Fail to import metadata.", exception);
			fail("Fail to import metadata.");
		}
	}

	private void preImport() throws IOException, SQLException, ClassNotFoundException, ApplicationException
	{
		DatabaseUtility dbUtility= new DatabaseUtility();
		dbUtility.setDbParams(ARGS);
		setConnection(dbUtility.getConnection());
		try
		{
			runSQLFile(System.getProperty("user.dir")+"/SQL/MSSQL/testAutomateImpExp.sql");
			executeQuery(getConnection(),"SET IDENTITY_INSERT CATISSUE_PERMISSIBLE_VALUE ON");
			runSQLFile(System.getProperty("user.dir")+"/SQL/Common/test/CDE_DummyData_Common.sql");
			executeQuery(getConnection(),"SET IDENTITY_INSERT CATISSUE_PERMISSIBLE_VALUE OFF");
		}
		finally
		{
			getConnection().close();
		}
	}

	private void executeQuery(Connection conn,String query) throws SQLException
	{
		Statement statement=conn.createStatement();
		statement.execute(query);
	}

	public void testImport()
	{
		testMsSqlAutomateImport();
	}
	
	public void testExport()
	{
		// this has not been implemented.
	}
}
