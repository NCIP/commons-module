/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

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
