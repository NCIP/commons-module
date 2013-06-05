/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.util.impexp;

import java.util.HashMap;
import java.util.Map;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.util.global.HibernateProperties;

/**
 *
 */
public class AutomateImportTest extends CommonBaseTestCase
{
	/**
	 *
	 */
	private static String dbType;
	/**
	 *
	 */
	private static Map<String,String> dbTypeVsTestClass=new HashMap<String,String>();
	static
	{
		dbType=HibernateProperties.getValue("database.type");
		dbTypeVsTestClass.put("mysql","edu.wustl.common.util.impexp.MySqlAutomateImpExpTestCase");
		dbTypeVsTestClass.put("oracle","edu.wustl.common.util.impexp.OracleAutomateImpExpTestCase");
		dbTypeVsTestClass.put("mssqlserver","edu.wustl.common.util.impexp.MsSqlAutomateImpExpTestCase");
	}
	/**
	 *
	 */
	public void testAutomateImport()
	{
		CommonAutomateImpExpTestCase impExpObj=getAutomateImportObject();
		impExpObj.testImport();
	}
	/**
	 *
	 */
	public void testAutomateExport()
	{
		CommonAutomateImpExpTestCase impExpObj=getAutomateImportObject();
		impExpObj.testExport();
	}
	/**
	 *
	 * @return CommonAutomateImpExpTestCase
	 */
	private CommonAutomateImpExpTestCase getAutomateImportObject()
	{
		String className=(String)dbTypeVsTestClass.get(dbType);
		CommonAutomateImpExpTestCase impExpObj= null;
		try
		{
			impExpObj= (CommonAutomateImpExpTestCase)Class.forName(className).newInstance();
		}
		catch (Exception exception)
		{
			//System.out.println("Not able to get correct ImportExport test class");
			exception.printStackTrace();
		}
		return impExpObj;
	}
}
