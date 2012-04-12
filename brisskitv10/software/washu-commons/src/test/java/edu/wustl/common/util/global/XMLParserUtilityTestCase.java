package edu.wustl.common.util.global;

import java.io.FileInputStream;
import java.io.InputStream;

import org.w3c.dom.Document;

import edu.wustl.common.CommonBaseTestCase;


public class XMLParserUtilityTestCase extends CommonBaseTestCase
{
	public void testGetDocumenetByStream()
	{
		try
		{
			InputStream inputXmlFile= new FileInputStream
			(System.getProperty("user.dir")+"/src/DataTypeConfigurations.xml");
			Document document=XMLParserUtility.getDocument(inputXmlFile);
			assertNotNull(document);
			assertTrue(document instanceof Document);
		}
		catch (Exception exception)
		{
			fail("didn't get Document object.");
		}
	}
}
