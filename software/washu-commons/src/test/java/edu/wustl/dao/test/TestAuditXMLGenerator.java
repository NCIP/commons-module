/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.dao.test;

import edu.wustl.common.audit.util.AuditXMLGenerator;
import edu.wustl.dao.exception.AuditException;


/**
 * @author kunal_kamble
 *
 */
public class TestAuditXMLGenerator extends BaseTestCase
{

	/**
	 * Test testMetadata.xml is getting generated for package "test"
	 */
	public void testAuditXMLGenerator()
	{
		String[] args = {"test","testMetadata.xml"};
		try
		{
			AuditXMLGenerator.generateAuditXML(args);

		}
		catch (AuditException e)
		{
			fail();
			e.printStackTrace();
		}

	}
}
