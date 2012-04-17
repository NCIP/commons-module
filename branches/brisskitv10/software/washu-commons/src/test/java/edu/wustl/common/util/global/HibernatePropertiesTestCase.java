package edu.wustl.common.util.global;

import java.io.IOException;

import edu.wustl.common.CommonBaseTestCase;


public class HibernatePropertiesTestCase extends CommonBaseTestCase
{
	public void testGetValue()
	{
		try
		{
			HibernateProperties.initBundle(System.getProperty("user.dir")+"/test/junitConf.properties");
			String keyValue=HibernateProperties.getValue("mail.host");
			assertTrue(keyValue.length()>0);
		}
		catch (Exception e)
		{
			fail("Not able to get value.");
		}

	}
}
