
package edu.wustl.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.beans.NameValueBean;
import edu.wustl.common.util.global.CommonServiceLocator;
import edu.wustl.common.util.global.Variables;
import edu.wustl.common.util.logger.Logger;

public class UtilityTestCases extends CommonBaseTestCase
{

	/**
	 * logger -Generic Logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(UtilityTestCases.class);

	public void testDatePattern()
	{
		try
		{
			String dateStr = "01-02-2008";
			String expectedPattern = "MM-dd-yyyy";
			String datPattern = Utility.datePattern(dateStr);
			assertEquals(expectedPattern, datPattern);
			
			dateStr = "01/02/2008";
			expectedPattern = "MM/dd/yyyy";
			datPattern = Utility.datePattern(dateStr);
			assertEquals(expectedPattern, datPattern);
			
			dateStr = "2008-05-06";
			expectedPattern = "yyyy-MM-dd";
			datPattern = Utility.datePattern(dateStr);
			assertEquals(expectedPattern, datPattern);
			
			dateStr = "2008/05/06";
			expectedPattern = "yyyy/MM/dd";
			datPattern = Utility.datePattern(dateStr);
			assertEquals(expectedPattern, datPattern);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to return correct date format.", true);
		}
	}

	public void testParseDate()
	{
		try
		{
			String dateStr = "01/30/2008";
			String expectedPattern = "MM/dd/yyyy";
			Date date = Utility.parseDate(dateStr, expectedPattern);
			assertNotNull("Can parse date:", date);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to parse date.", true);
		}
	}

	public void testCreateAccessorMethodName()
	{
		try
		{
			String attr = "identifier";
			boolean isSetter = true;
			String methodName = Utility.createAccessorMethodName(attr, isSetter);
			assertEquals("Method name SetIdentifier", "setIdentifier", methodName);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to return correct method name.", true);
		}
	}

	public void testGetArrayString()
	{
		try
		{
			Long[] objeIds = {Long.valueOf(1), Long.valueOf(2)};
			String str = Utility.getArrayString(objeIds);
			assertNotNull("Can get array string:", str);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get array string.", true);
		}
	}

	public void testGetObject()
	{
		try
		{
			String className = "edu.wustl.common.datatypes.NumericDataType";
			Object obj = Utility.getObject(className);
			assertNotNull("Can get class object:", obj);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get class object.", true);
		}
	}
	public void testFailGetObject()
	{
		try
		{
			String className = "edu.wustl.common.tree.TreeNode";
			Object obj = Utility.getObject(className);
			assertNull("Can not create instance of class:", obj);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertTrue("Can not create instance of class.", true);
		}
	}

	public void testGetClassObject()
	{
		try
		{
			String fullClassName = "edu.wustl.common.datatypes.NumericDataType";
			Class obj = Utility.getClassObject(fullClassName);
			assertNotNull("Can get class object:", obj);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get class object.", true);
		}
	}
	public void testIsNull()
	{
		try
		{
			Object obj = null;
			assertEquals(true, Utility.isNull(obj));
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to check is null object.", true);
		}
	}

	public void testIsNullObject()
	{
		try
		{
			Object obj = new Object();
			assertEquals(false, Utility.isNull(obj));
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to check is null object.", true);
		}
	}

	public void testParseAttributeName()
	{
		try
		{
			String methodName = "getName";
			assertEquals("name", Utility.parseAttributeName(methodName));
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get attribute name.", true);
		}
	}

	public void testAddElement()
	{
		try
		{
			Object[] array = new Object[1];
			array[0] = "asd";
			String obj = "object";
			assertNotNull(Utility.addElement(array, obj));
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get attribute name.", true);
		}
	}

	public void testRemoveNull()
	{
		try
		{
			List<String> list = new ArrayList<String>();
			list.add("1");
			list.add(null);
			list.add("2");
			List newList = Utility.removeNull(list);
			assertEquals("Removed null object.", list.size() - 1, newList.size());
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get attribute name.", true);
		}
	}

	public void testParseClassName()
	{
		String simpleClassName = "";
		try
		{
			String className = "edu.wustl.common.datatypes.NumericDataType";
			simpleClassName = Utility.parseClassName(className);
			assertEquals(simpleClassName, "NumericDataType", simpleClassName);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get class name." + simpleClassName, true);
			exception.printStackTrace();
		}
	}

	public void testFailParseClassName()
	{
		String simpleClassName = "";
		try
		{
			String className = "NumericDataType";
			simpleClassName = Utility.parseClassName(className);
			assertEquals(simpleClassName, className, simpleClassName);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to parse class name:" + simpleClassName, true);
			exception.printStackTrace();
		}
	}

	public void testGetFormBeanName()
	{
		try
		{
			NameValueBean bean = new NameValueBean();
			String beanName = Utility.getFormBeanName(bean);
			assertEquals("nameValueBean", beanName);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get FormBeanName", true);
			exception.printStackTrace();
		}
	}

	public void testParseDateToString()
	{
		try
		{
			String date = Utility.parseDateToString(new Date("02/01/2009"), CommonServiceLocator
					.getInstance().getDatePattern());
			logger.info("date : " + date);
			assertEquals("02-01-2009", date);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get FormBeanName", true);
			exception.printStackTrace();
		}
	}

	public void testToString()
	{
		try
		{
			String str = Utility.toString(Long.valueOf(122));
			assertEquals("122", str);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get String", true);
			exception.printStackTrace();
		}
	}

	public void testNullToString()
	{
		try
		{
			String str = Utility.toString(null);
			assertEquals("", str);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get String", true);
			exception.printStackTrace();
		}
	}

	public void testGetTime()
	{
		try
		{
			String[] time = new String[2];
			time = Utility.getTime(Calendar.getInstance().getTime());
			logger.info("Time :" + time[0] + ":" + time[1]);
			assertNotNull(time);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get time", true);
			exception.printStackTrace();
		}
	}

	public void testToLongArray()
	{
		try
		{
			Collection<Long> collection = new ArrayList<Long>();
			collection.add(Long.valueOf(121));
			collection.add(Long.valueOf(122));
			collection.add(Long.valueOf(123));
			Long[] obj = Utility.toLongArray(collection);
			logger.info("Long Array Elements :" + obj[0] + "," + obj[1] + "," + obj[2]);
			assertNotNull(obj);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get LongArray", true);
			exception.printStackTrace();
		}
	}

	public void testToInt()
	{
		try
		{
			int value = Utility.toInt("12");
			assertNotNull(value);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get int value.", true);
			exception.printStackTrace();
		}
	}

	public void testToLong()
	{
		try
		{
			Long value = Utility.toLong("12");
			assertNotNull(value);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get Long value.", true);
			exception.printStackTrace();
		}
	}

	public void testToDouble()
	{
		try
		{
			Double value = Utility.toDouble(Double.valueOf(12));
			logger.info("double value = " + value);
			assertNotNull(value);
		}
		catch (Exception exception)
		{
			logger.info("Error = " + exception.getMessage());
			exception.printStackTrace();
			assertFalse("Not able to get Double value.", true);
			exception.printStackTrace();
		}
	}

	public void testIsPersistedValue()
	{
		try
		{
			Map map = new HashMap();
			map.put("1", "one");
			map.put("2", "two");
			boolean isPersistedValue = Utility.isPersistedValue(map, "1");
			assertEquals(true, isPersistedValue);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get LongArray", true);
			exception.printStackTrace();
		}
	}

	public void testInitCap()
	{
		try
		{
			String properCaseStr = Utility.initCap("praShaNT");
			logger.info("ProperCase : " + properCaseStr);
			assertEquals("Prashant", properCaseStr);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get Proper Case String.", true);
			exception.printStackTrace();
		}
	}

	public void testInitCapEmptyString()
	{
		try
		{
			String properCaseStr = Utility.initCap("");
			logger.info("ProperCase : " + properCaseStr);
			assertEquals("", properCaseStr);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get Proper Case String.", true);
			exception.printStackTrace();
		}
	}

	public void testGetColumnWidth()
	{
		try
		{
			String className = "edu.wustl.common.audit.AuditableImpl";
			String attributeName = "id";
			String colLength = Utility.getColumnWidth(Class.forName(className), attributeName);
			logger.info("colLength : " + colLength);
			assertEquals("50", colLength);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get column Length.", true);
			exception.printStackTrace();
		}
	}

	public void testRemoveSpecialCharactersFromString()
	{
		try
		{
			String properCaseStr = Utility
					.removeSpecialCharactersFromString("Remove\\SpecialCharactersFromString[]");
			logger.info("String : " + properCaseStr);
			assertEquals("RemoveSpecialCharactersFromString", properCaseStr);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get Proper String.", true);
			exception.printStackTrace();
		}
	}
	public void testGetDisplayLabel()
	{
		try
		{
			String properCaseStr = Utility
					.getDisplayLabel("firstName");
			logger.info("String : " + properCaseStr);
			assertEquals("First Name", properCaseStr);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to get Display Label.", true);
			exception.printStackTrace();
		}
	}
	public void testGetMonth()
	{
		try
		{
			int month = Utility.getMonth("01-01-2009");
			assertEquals(01, month);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get month.", true);
			exception.printStackTrace();
		}
	}
	public void testGetDay()
	{
		try
		{
			int day = Utility.getDay("01-01-2009");
			assertEquals(01, day);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get month.", true);
			exception.printStackTrace();
		}
	}
	public void testGetYear()
	{
		try
		{
			int year = Utility.getYear("01-01-2009");
			assertEquals(2009, year);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get year.", true);
			exception.printStackTrace();
		}
	}
	public void testReplaceAll()
	{
		try
		{
			String objectName = Utility.replaceAll("first*#name*#", "*#", "_");
			assertEquals("first_name_", objectName);
		}
		catch (Exception exception)
		{
			logger.info("exception : "+exception.getMessage());
			exception.printStackTrace();
			assertFalse("Not able to replace.", true);
		}
	}

	public void testReplaceAllSingleChar()
	{
		try
		{
			String objectName = Utility.replaceAll("first*name", "*", "_");
			assertEquals("first_name", objectName);
		}
		catch (Exception exception)
		{
			logger.info("exception : "+exception.getMessage());
			exception.printStackTrace();
			assertFalse("Not able to replace.", true);
		}
	}
	public void testReplaceAllNegative()
	{
		try
		{
			String objectName = Utility.replaceAll("firstname", "*#", "_");
			assertEquals("firstname", objectName);
		}
		catch (Exception exception)
		{
			logger.info("exception : "+exception.getMessage());
			exception.printStackTrace();
			assertFalse("Not able to replace.", true);
		}
	}
	public void testInitializePrivilegesMap()
	{
		try
		{
			Utility.initializePrivilegesMap();
			logger.info("Size : "+Variables.privilegeDetailsMap.size());
			assertNotSame(0, Variables.privilegeDetailsMap.size());
		}
		catch (Exception exception)
		{
			assertFalse("Not able to initialize Privileges Map.", true);
			exception.printStackTrace();
		}
	}

	public void testToGridFormat()
	{
		try
		{
			String strObj = "Grid\n\r\fFormat test";
			Object obj=Utility.toGridFormat(strObj);
			logger.info("GridFormat: "+obj.toString());
			assertNotNull(obj);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to GridFormat.", true);
			exception.printStackTrace();
		}
	}

	public void testGetAllPrivileges()
	{
		try
		{
			List<NameValueBean> allPrivileges=Utility.getAllPrivileges();
			logger.info("all Privileges Size : "+allPrivileges.size());
			assertNotNull(allPrivileges);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get All Privileges.", true);
			exception.printStackTrace();
		}
	}

	public void testGetActualClassName()
	{
		try
		{
			String name = "edu.wustl.common.datatypes.NumericDataType";
			String actualClassName = Utility.getActualClassName(name);
			logger.info("actualClassName : "+actualClassName);
			assertEquals("NumericDataType", actualClassName);
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get Actual Class Name.", true);
			exception.printStackTrace();
		}
	}

	/*public void testSortTreeVector()
	{
		try
		{
			SpecimenTreeNode treeNodeParent = new SpecimenTreeNode(Long.valueOf(1), "parent");
			SpecimenTreeNode treeNodeChild1 = new SpecimenTreeNode(Long.valueOf(2), "child1");
			SpecimenTreeNode treeNodeChild2 = new SpecimenTreeNode(Long.valueOf(3), "child2");
			List childNodes = new Vector();
			childNodes.add(treeNodeChild1);
			childNodes.add(treeNodeChild2);
			treeNodeParent.setChildNodes(childNodes);
			treeNodeChild1.setParentNode(treeNodeParent);
			treeNodeChild2.setParentNode(treeNodeParent);
			treeNodeChild1.setParentIdentifier("1");
			treeNodeChild1.setParentValue("parent");
			treeNodeChild2.setParentIdentifier("1");
			treeNodeChild2.setParentValue("parent");
			List nodeList = new Vector();
			nodeList.add(treeNodeChild1);
			nodeList.add(treeNodeChild2);
			nodeList.add(treeNodeParent);
			List nodeList1 = nodeList;
			Utility.sortTreeVector(nodeList);
			assertNotSame(nodeList1, nodeList);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			assertFalse("Not able to Sort Tree Vector.", true);
		}
	}*/
	public void testGetValueForWtihAttribute()
	{
		try
		{
			NameValueBean nameValueBean=new NameValueBean();
			nameValueBean.setName("protocol");
			Object value= Utility.getValueFor(nameValueBean,"name");
			assertEquals("protocol", value.toString());
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get the value.", true);
			exception.printStackTrace();
		}
	}

	public void testGetValueForWtihMethod()
	{
		try
		{
			NameValueBean nameValueBean=new NameValueBean();
			nameValueBean.setName("protocol");
			String methodName = Utility.createAccessorMethodName("name", false);
			Class objClass = nameValueBean.getClass();
			Method method = objClass.getMethod(methodName, new Class[0]);
			Object value= Utility.getValueFor(nameValueBean,method);
			assertEquals("protocol", value.toString());
		}
		catch (Exception exception)
		{
			assertFalse("Not able to get the value.", true);
			exception.printStackTrace();
		}
	}
}
