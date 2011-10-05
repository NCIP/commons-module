package edu.wustl.common.util.global;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.util.logger.Logger;


public class PasswordEncrypterTestCase extends CommonBaseTestCase
{
	/**
	 * logger Logger - Generic logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(PasswordEncrypterTestCase.class);

	/*public void testMainForPasswordEncryption()
	{
		String []args={
				HibernateProperties.getValue("database.host"),
				HibernateProperties.getValue("database.port"),
				HibernateProperties.getValue("database.type"),
				HibernateProperties.getValue("database.name"),
				HibernateProperties.getValue("database.username"),
				HibernateProperties.getValue("database.password"),
				HibernateProperties.getValue("database.driver"),
				"catissue_password", //table name
				"password"	//field
		};
		try
		{
			PasswordEncrypter.main(args);
			assertTrue("Password updated successfully.",true);
		}
		catch (Exception exception)
		{
			logger.debug("Password not updated.", exception);
			fail("Password not updated.");
		}
	}*/
}
