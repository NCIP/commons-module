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
