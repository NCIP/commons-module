
package edu.wustl.common;

/**
 * Main class to run junit test cases.
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.wustl.common.bizlogic.AbstractBizLogicTestCase;
import edu.wustl.common.bizlogic.DefaultBizLogicTestCase;
import edu.wustl.common.datatypes.DataTypeTestCase;
import edu.wustl.common.factory.AbstractFactoryConfigTestCase;
import edu.wustl.common.jobmanager.TestJobManager;
import edu.wustl.common.util.ExportReportTestCase;
import edu.wustl.common.util.XMLPropertyHandlerTestCase;
import edu.wustl.common.util.global.ApplicationPropertiesTestCase;
import edu.wustl.common.util.global.CommonServiceLocatorTestCase;
import edu.wustl.common.util.global.HibernatePropertiesTestCase;
import edu.wustl.common.util.global.PasswordManagerTestCase;
import edu.wustl.common.util.global.StatusTestCase;
import edu.wustl.common.util.global.ValidatorTestCase;
import edu.wustl.common.util.global.XMLParserUtilityTestCase;
import edu.wustl.common.util.impexp.AutomateImportTest;


/**
 * @author ravi kumar
 * Test Suite for testing all Common package test classes.
 */
public class TestAll extends TestCase
{
	/**
	 * Main method called by junit target in build.xml.
	 * @param args arguments to main method.
	 */
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(TestAll.class);
	}
	/**
	 *
	 * @return Test object.
	 */
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Test suite for Query Interface Classes");
		//suite.addTestSuite(UtilityTestCases.class);
		suite.addTestSuite(DefaultBizLogicTestCase.class);
		suite.addTestSuite(AbstractBizLogicTestCase.class);
		suite.addTestSuite(StatusTestCase.class);
		suite.addTestSuite(DataTypeTestCase.class);
		suite.addTestSuite(AbstractFactoryConfigTestCase.class);
		suite.addTestSuite(CommonServiceLocatorTestCase.class);
		//suite.addTestSuite(AuditManagerTestCase.class);
		suite.addTestSuite(XMLPropertyHandlerTestCase.class);
		suite.addTestSuite(AutomateImportTest.class);
		suite.addTestSuite(ExportReportTestCase.class);
		suite.addTestSuite(ApplicationPropertiesTestCase.class);
		//suite.addTestSuite(SendEmailTestCase.class);
		suite.addTestSuite(HibernatePropertiesTestCase.class);
		suite.addTestSuite(XMLParserUtilityTestCase.class);
		suite.addTestSuite(PasswordManagerTestCase.class);
		//suite.addTestSuite(PasswordEncrypterTestCase.class);
		suite.addTestSuite(ValidatorTestCase.class);
		suite.addTestSuite(TestJobManager.class);
		return suite;
	}
}
