/**
 * 
 */

package edu.wustl.common.datatypes;

import org.apache.struts.action.ActionErrors;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.exception.ApplicationException;

/**
 * This is for test cases of all classes in datatypes package.
 * @author prashant_bandal
 *
 */
public class DataTypeTestCase extends CommonBaseTestCase
{

	public void testValidateDate()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("date");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("12-12-2008", errors);
			assertEquals(false, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testFailValidateDate()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("date1");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("12-12-2008", errors);
			assertEquals(false, value);
			fail("Data type not valid.");
		}
		catch (ApplicationException e)
		{
			assertTrue("Data type not valid.", true);
			e.printStackTrace();
		}
	}
	public void testValidateInteger()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("integer");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("", errors);
			assertEquals(true, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateIntegerNegativeValue()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("integer");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("-1", errors);
			assertEquals(true, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateBigInt()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("bigint");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("1000", errors);
			assertEquals(false, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateDouble()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("double");
			ActionErrors errors = new ActionErrors();
			assertEquals(false,dbDataType.validate("100.111", errors));
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateDoubleValue()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("double");
			ActionErrors errors = new ActionErrors();
			assertEquals(true,dbDataType.validate("qw", errors));
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateTinyInt()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("tinyint");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("10", errors);
			assertEquals(true, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateString()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("string");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("qwer", errors);
			assertEquals(false, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateBoolean()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("boolean");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("true", errors);
			assertEquals(false, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateLong()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("long");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("qwe", errors);
			assertEquals(false, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testValidateTimestamptime()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("timestamptime");
			ActionErrors errors = new ActionErrors();
			boolean value = dbDataType.validate("12-12-2009", errors);
			assertEquals(true, value);
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}

	public void testValidateFloat()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("float");
			ActionErrors errors = new ActionErrors();
			assertEquals(false,dbDataType.validate("10.10", errors));
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}

	public void testValidateBlob()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("blob");
			ActionErrors errors = new ActionErrors();
			assertEquals(false,dbDataType.validate("10120", errors));
		}
		catch (ApplicationException e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueBoolean()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("boolean");
			assertNotNull(dbDataType.getObjectValue("true"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueBlob()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("blob");
			assertNotNull(dbDataType.getObjectValue(System.getProperty("user.dir")+"/test/TestBlobDataType.gif"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueString()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("string");
			assertNotNull(dbDataType.getObjectValue("String data type."));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueEmptyString()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("string");
			assertEquals("",dbDataType.getObjectValue(""));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueDate()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("date");
			assertNotNull(dbDataType.getObjectValue("12-12-2008"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueDouble()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("double");
			assertNotNull(dbDataType.getObjectValue("10.1222"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueFloat()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("float");
			assertNotNull(dbDataType.getObjectValue("10.12"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueLong()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("long");
			assertNotNull(dbDataType.getObjectValue("10112"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueTinyInt()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("tinyint");
			assertNull(dbDataType.getObjectValue("1"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueTimestamptime()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("timestamptime");
			assertNull(dbDataType.getObjectValue("11:11:12"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
	public void testGetObjectValueInteger()
	{
		IDBDataType dbDataType;
		try
		{
			dbDataType = DataTypeConfigFactory.getInstance().getDataType("integer");
			assertNotNull(dbDataType.getObjectValue("12"));
		}
		catch (Exception e)
		{
			fail("data type not valid.");
			e.printStackTrace();
		}
	}
}
