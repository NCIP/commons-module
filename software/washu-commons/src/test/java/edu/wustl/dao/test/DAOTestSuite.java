/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.dao.test;

import junit.framework.TestSuite;


/**
 * @author kalpana_thakur
 */
public class DAOTestSuite {

    /**
     * default constructor.
     */
    DAOTestSuite() {
        super();
    }

    /**
     * @param args :
     */
    public static void main(String[] args) {
        //org.junit.runner.JUnitCore.main("edu.wustl.dao.test.HibernateInsertTestCase");
        junit.awtui.TestRunner.run(DAOTestSuite.class);
    }

    /**
     * @return daoSuite.
     */
    public static junit.framework.Test suite() {
        TestSuite daoSuite = new TestSuite("Test for DAO Layer");
        daoSuite.addTestSuite(HibernateTestCaseForCatissue.class);
        daoSuite.addTestSuite(JDBCTestCasesForCatissue.class);
        daoSuite.addTestSuite(TestAuditXMLGenerator.class);
        return daoSuite;
    }

}
