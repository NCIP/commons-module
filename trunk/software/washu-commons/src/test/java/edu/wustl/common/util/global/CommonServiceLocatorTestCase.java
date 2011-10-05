package edu.wustl.common.util.global;

import edu.wustl.common.CommonBaseTestCase;


public class CommonServiceLocatorTestCase extends CommonBaseTestCase
{
	public void testSetAppURL()
	{
		CommonServiceLocator locator=CommonServiceLocator.getInstance();
		locator.setAppURL("http://ps2116:8080/commpkgrefactoring/cp.htm");
		String appUrl=locator.getAppURL();
		assertEquals("http://ps2116:8080/commpkgrefactoring",appUrl);
	}
	/*
	 * This test case test some getter methods which doesn't executes normally
	 */
	public void testGetterMethods()
	{
		CommonServiceLocator locator=CommonServiceLocator.getInstance();
		locator.setAppHome(System.getProperty("user.dir"));
		assertNotNull(locator.getAppHome());
		assertNotNull(locator.getAppName());
		assertNotNull(locator.getPropDirPath());
		assertNotNull(locator.getDateSeparatorSlash());
		assertNotNull(locator.getTimeStampPattern());
	}
}
