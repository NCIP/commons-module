package edu.wustl.common.util;

import edu.wustl.common.CommonBaseTestCase;


public class XMLPropertyHandlerTestCase extends CommonBaseTestCase
{
	public void testGetValue()
	{
		String value=XMLPropertyHandler.getValue("server.port");
		assertEquals("8080", value);
	}
}
