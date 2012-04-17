package edu.wustl.common.util.global;

import java.util.ArrayList;
import java.util.List;

import edu.wustl.common.CommonBaseTestCase;


public class ApplicationPropertiesTestCase extends CommonBaseTestCase
{
	static
	{
		ApplicationProperties.initBundle("ApplicationResources");
	}
	public void testGetValue()
	{
		String minYear=ApplicationProperties.getValue("min.year");
		assertEquals("1900",minYear);
	}

	public void testGetValueWithPlaceHolders()
	{
		List<String> placeHolders=new ArrayList<String>();
		placeHolders.add("TitliMapper");
		placeHolders.add("CommonPackage");
		String str=ApplicationProperties.getValue("junit.testing",placeHolders);
		assertTrue(str.length()>0);
	}

	public void testGetValueWithSinglePlaceHolders()
	{
		String str=ApplicationProperties.getValue("junit.testing","TitliMapper");
		assertTrue(str.length()>0);
	}
}
