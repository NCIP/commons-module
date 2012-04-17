package edu.wustl.common;

import edu.wustl.common.exception.ErrorKey;
import edu.wustl.common.test.BaseTestCase;
import edu.wustl.common.util.XMLPropertyHandler;
import edu.wustl.common.util.global.HibernateProperties;
import edu.wustl.common.util.logger.LoggerConfig;
/**
 * This is common test class.
 * All test classes in common package should extends this class.
 * @author ravi_kumar
 *
 */
public class CommonBaseTestCase extends BaseTestCase
{
	static
	{
		System.setProperty("app.propertiesFile",
				System.getProperty("user.dir")+"/caTissueCore_Properties.xml");
		LoggerConfig.configureLogger(System.getProperty("user.dir"));
		try
		{
			HibernateProperties.initBundle
			(System.getProperty("user.dir")+"/test/junitConf.properties");
			XMLPropertyHandler.init(System.getProperty("app.propertiesFile"));
			//setHibernateConfiguration();
			ErrorKey.init("~");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Constructor.
	 */
	public CommonBaseTestCase()
	{
		super();
	}
	/**
	 * Parameterized constructor.
	 * @param name name.
	 */
	public CommonBaseTestCase(String name)
	{
		super(name);
	}
	/**
	 *
	 */
	protected void setUp()
	{
		//empty method.
	}
	/*private static void setHibernateConfiguration()
	{
		Configuration config = new Configuration().
        setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect").
        setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver").
        setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:baseball").
        setProperty("hibernate.connection.username", "sa").
        setProperty("hibernate.connection.password", "").
        setProperty("hibernate.connection.pool_size", "1").
        setProperty("hibernate.connection.autocommit", "true").
        setProperty("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider").
        setProperty("hibernate.hbm2ddl.auto", "create-drop").
        setProperty("hibernate.show_sql", "true").
        addClass(edu.wustl.common.domain.MyDomainObject.class).
		addClass(edu.wustl.common.audit.AuditableImpl.class);
    	HibernateMetaData.initHibernateMetaData(config);
	}*/
}
