package edu.wustl.common.factory;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.exception.BizLogicException;
import edu.wustl.common.util.logger.Logger;


public class AbstractFactoryConfigTestCase extends CommonBaseTestCase
{
	/**
	 * Generic Logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(AbstractFactoryConfigTestCase.class);

	public void testGetBizLogicFactory()
	{
		try
		{
			IFactory factory = AbstractFactoryConfig.getInstance().getBizLogicFactory();
			assertEquals(true, factory instanceof MyBizLogicFactory);
		}
		catch (BizLogicException exception)
		{
			fail("Didn't get Factory classes.");
			logger.debug("Didn't get Factory classes.",exception);
		}
	}
	public void testGetForwToFactory()
	{
		try
		{
			IForwordToFactory factory = AbstractFactoryConfig.getInstance()
			.getForwToFactory();
			assertEquals(true, factory instanceof MyBizLogicFactory);
		}
		catch (BizLogicException exception)
		{
			fail("Didn't get Factory classes.");
			logger.debug("Didn't get Factory classes.",exception);
		}
	}
	
	public void testGetDomainObjectFactory()
	{
		try
		{
			IDomainObjectFactory factory = AbstractFactoryConfig.getInstance()
			.getDomainObjectFactory();
			assertEquals(true, factory instanceof MyBizLogicFactory);
		}
		catch (BizLogicException exception)
		{
			fail("Didn't get Factory classes.");
			logger.debug("Didn't get Factory classes.",exception);
		}
	}
}
