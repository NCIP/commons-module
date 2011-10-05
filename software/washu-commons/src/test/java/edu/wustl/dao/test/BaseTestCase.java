package edu.wustl.dao.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.wustl.common.audit.AuditManager;
import edu.wustl.common.exception.ErrorKey;
import edu.wustl.common.util.logger.Logger;
import edu.wustl.dao.daofactory.DAOConfigFactory;
import edu.wustl.dao.daofactory.IDAOFactory;

/**
 * @author kalpana_thakur
 *
 */
public class BaseTestCase extends TestCase
{

	/**
	 * DAO configFactory instance.
	 */
	protected DAOConfigFactory daoConfigFactory;

	/**
	 * Logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(BaseTestCase.class);

	/**
	 * This will invoke the daoFactory instance
	 * and returns the DAO object as per the application.
	 */
	@Before
	public void setUp()
	{
		try
		{
			daoConfigFactory = DAOConfigFactory.getInstance();
			ErrorKey.init(":");
			AuditManager.init();
			System.setProperty("app.propertiesFile",System.getProperty("user.dir")+"/caTissueCore_Properties.xml");
		}
		catch (Exception e)
		{
			logger.fatal("Problem while retrieving factory object :",e);
		}
	}

	/**
	 * This will test the instance of daoConfigFactory.
	 */
	@Test
	public void testDAOConfigFactory()
	{
		assertNotNull("DAO config factory object is null",daoConfigFactory);
	}


	/**
	 * This will test the instance of default DAOFACTORY.
	 */
	@Test
	public void testDefaultFactory()
	{
		IDAOFactory daoFactory = daoConfigFactory.getInstance().getDAOFactory();
		assertNotNull("DAO config factory object is null",daoFactory);
	}

}
