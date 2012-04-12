/**
 * 
 */

package edu.wustl.common.util.global;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.beans.NameValueBean;

/**
 * @author prashant_bandal
 *
 */
public class ValidatorTestCase extends CommonBaseTestCase
{

	public void testIsValidEmailAddress()
	{
		try
		{
			String aEmailAddress = "admin@admin.com";
			Validator validator = new Validator();
			boolean isValid = validator.isValidEmailAddress(aEmailAddress);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Invalid Email Address.", true);
		}
	}

	public void testNegativeIsValidEmailAddress()
	{
		try
		{
			String aEmailAddress = "admin*admin.com";
			Validator validator = new Validator();
			boolean isValid = validator.isValidEmailAddress(aEmailAddress);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Invalid Email Address.", true);
		}
	}

	public void testEmptyIsValidEmailAddress()
	{
		try
		{
			String aEmailAddress = "";
			Validator validator = new Validator();
			boolean isValid = validator.isValidEmailAddress(aEmailAddress);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Invalid Email Address.", true);
		}
	}

	public void testIsValidSSN()
	{
		try
		{
			String ssn = "000-00-4444";
			Validator validator = new Validator();
			boolean isValid = validator.isValidSSN(ssn);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Invalid Email Address.", true);
		}
	}

	public void testIsEmpty()
	{
		try
		{
			String ssn = "string";
			boolean isValid = Validator.isEmpty(ssn);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to check is empty string.", true);
		}
	}

	public void testIsAlpha()
	{
		try
		{
			String alphaString = "string";
			Validator validator = new Validator();
			boolean isValid = validator.isAlpha(alphaString);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testNegativeIsAlpha()
	{
		try
		{
			String alphaString = "#string";
			Validator validator = new Validator();
			boolean isValid = validator.isAlpha(alphaString);
			assertEquals("The input String not contains only alphabetic characters.", false,
					isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testIsNumeric()
	{
		try
		{
			String numString = "1234";
			Validator validator = new Validator();
			boolean isValid = validator.isNumeric(numString);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testNegativeIsNumeric()
	{
		try
		{
			String numString = "1234asd";
			Validator validator = new Validator();
			boolean isValid = validator.isNumeric(numString);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testNegZeroIsNumeric()
	{
		try
		{
			String numString = "00";
			Validator validator = new Validator();
			boolean isValid = validator.isNumeric(numString);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testPositiveIsNumeric()
	{
		try
		{
			String numString = "1234";
			Validator validator = new Validator();
			boolean isValid = validator.isNumeric(numString, 12);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testNegatinePositiveIsNumeric()
	{
		try
		{
			String numString = "null";
			Validator validator = new Validator();
			boolean isValid = validator.isNumeric(numString, 12);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testNegatineIsNumeric()
	{
		try
		{
			String numString = "00";
			Validator validator = new Validator();
			boolean isValid = validator.isNumeric(numString, 12);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The input String not contains only alphabetic characters.", true);
		}
	}

	public void testIsDouble()
	{
		try
		{
			String numString = "12.12";
			Validator validator = new Validator();
			boolean isValid = validator.isDouble(numString);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The given String for double value is not double value.", true);
		}
	}

	public void testNegativeIsDouble()
	{
		try
		{
			String numString = "-1";
			Validator validator = new Validator();
			boolean isValid = validator.isDouble(numString);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The given String for double value is not double value.", true);
		}
	}

	public void testNaNCheckIsDouble()
	{
		try
		{
			String numString = "NaN";
			Validator validator = new Validator();
			boolean isValid = validator.isDouble(numString, true);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The given String for double value is not double value.", true);
		}
	}

	public void testPositiveCheckIsDouble()
	{
		try
		{
			String numString = "-1";
			Validator validator = new Validator();
			boolean isValid = validator.isDouble(numString, true);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("The given String for double value is not double value.", true);
		}
	}

	public void testIsValidOption()
	{
		try
		{
			String option = "1";
			Validator validator = new Validator();
			boolean isValid = validator.isValidOption(option);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not valid option.", true);
		}
	}

	public void testNegativeIsValidOption()
	{
		try
		{
			String option = "-1";
			Validator validator = new Validator();
			boolean isValid = validator.isValidOption(option);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not valid option.", true);
		}
	}

	public void testDelimiterExcludingGiven()
	{
		try
		{
			String ignoreList = ";:/?.>";
			String spChars = "!@#$%^&*()=+\\|{[ ]}\'\",<`~ -_";
			Validator validator = new Validator();
			String reqList = validator.delimiterExcludingGiven(ignoreList);
			assertEquals(spChars, reqList);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Exclud delimiter from Given list..", true);
		}
	}

	public void testCheckDate()
	{
		try
		{
			String checkDate = "12/122/2009";
			Validator validator = new Validator();
			boolean isValid = validator.checkDate(checkDate);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check Date.", true);
		}
	}

	public void testEmptyCheckDate()
	{
		try
		{
			String checkDate = "";
			Validator validator = new Validator();
			boolean isValid = validator.checkDate(checkDate);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check Date.", true);
		}
	}

	public void testCompareDateWithCurrent()
	{
		try
		{
			String dateToCheck = "01-01-2010";
			Validator validator = new Validator();
			boolean isValid = validator.compareDateWithCurrent(dateToCheck);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Compare Dates.", true);
		}
	}

	public void testNegativeCompareDateWithCurrent()
	{
		try
		{
			String dateToCheck = "01/011/2009";
			Validator validator = new Validator();
			boolean isValid = validator.compareDateWithCurrent(dateToCheck);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Compare Dates.", true);
		}
	}

	public void testCompareDates()
	{
		try
		{
			String startDate = "01-01-2009";
			String endDate = "01-01-2010";
			Validator validator = new Validator();
			boolean isValid = validator.compareDates(startDate, endDate);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Compare Dates.", true);
		}
	}

	public void testNegativeCompareDates()
	{
		try
		{
			String startDate = "01-01-2010";
			String endDate = "01-01-2009";
			Validator validator = new Validator();
			boolean isValid = validator.compareDates(startDate, endDate);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Compare Dates.", true);
		}
	}

	public void testValidateDate()
	{
		try
		{
			String strDate = "";
			boolean checkFutureDate = false;
			String returnString = "errors.item.required";
			Validator validator = new Validator();
			String str = validator.validateDate(strDate, checkFutureDate);
			assertEquals(returnString, str);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Validate Date.", true);
		}
	}

	public void testFutureValidateDate()
	{
		try
		{
			String strDate = "01-01-2010";
			boolean checkFutureDate = true;
			String returnString = "errors.invalid.date";
			Validator validator = new Validator();
			String str = validator.validateDate(strDate, checkFutureDate);
			assertEquals(returnString, str);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Validate Date.", true);
		}
	}

	public void testFormatValidateDate()
	{
		try
		{
			String strDate = "011/01/2010";
			boolean checkFutureDate = true;
			String returnString = "errors.date.format";
			Validator validator = new Validator();
			String str = validator.validateDate(strDate, checkFutureDate);
			assertEquals(returnString, str);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Validate Date.", true);
		}
	}

	public void testIsOperator()
	{
		try
		{
			String value = "-1";
			Validator validator = new Validator();
			boolean isValid = validator.isOperator(value);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check Operator.", true);
		}
	}

	public void testIsValue()
	{
		try
		{
			String value = "-1";
			Validator validator = new Validator();
			boolean isValid = validator.isValue(value);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check value.", true);
		}
	}

	public void testIsValidZipCode()
	{
		try
		{
			String zipCode = "99999-9999";
			Validator validator = new Validator();
			boolean isValid = validator.isValidZipCode(zipCode);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check Valid ZipCode.", true);
		}
	}

	public void testNegativeIsValidZipCode()
	{
		try
		{
			String zipCode = "99999-9999-222";
			Validator validator = new Validator();
			boolean isValid = validator.isValidZipCode(zipCode);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check Valid ZipCode.", true);
		}
	}

	public void testIsValidPhoneNumber()
	{
		try
		{
			String phoneNumber = "(999)999-9999";
			Validator validator = new Validator();
			boolean isValid = validator.isValidPhoneNumber(phoneNumber);
			assertEquals(true, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check Valid Phone Number.", true);
		}
	}

	public void testNegativeIsValidPhoneNumber()
	{
		try
		{
			String phoneNumber = "(999)999-9999-7777-8888";
			Validator validator = new Validator();
			boolean isValid = validator.isValidPhoneNumber(phoneNumber);
			assertEquals(false, isValid);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Check Valid Phone Number.", true);
		}
	}

	public void testIsEnumeratedValue()
	{
		try
		{
			List<NameValueBean> beanList = new ArrayList<NameValueBean>();
			NameValueBean bean1 = new NameValueBean("bean1","user");
			NameValueBean bean2 = new NameValueBean("bean2","product");
			beanList.add(bean1);
			beanList.add(bean2);
			boolean isPresent = Validator.isEnumeratedValue(beanList, "product");
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out Enumerated Value.", true);
		}
	}
	public void testStringArrayIsEnumeratedValue()
	{
		try
		{
			String[] list = {"user","product"};
			boolean isPresent = Validator.isEnumeratedValue(list, "product");
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out Enumerated Value.", true);
		}
	}
	public void testIsEnumeratedOrNullValue()
	{
		try
		{
			List<NameValueBean> beanList = new ArrayList<NameValueBean>();
			NameValueBean bean1 = new NameValueBean("bean1","user");
			NameValueBean bean2 = new NameValueBean("bean2","product");
			beanList.add(bean1);
			beanList.add(bean2);
			boolean isPresent = Validator.isEnumeratedOrNullValue(beanList, "product");
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out Enumerated Or Null Value.", true);
		}
	}
	public void testStringArrayIsEnumeratedOrNullValue()
	{
		try
		{
			String[] list = {"user","product"};
			boolean isPresent = Validator.isEnumeratedOrNullValue(list, "product");
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out Enumerated Or Null Value.", true);
		}
	}
	public void testNullIsEnumeratedOrNullValue()
	{
		try
		{
			List<NameValueBean> beanList = new ArrayList<NameValueBean>();
			NameValueBean bean1 = new NameValueBean("bean1","user");
			NameValueBean bean2 = new NameValueBean("bean2","product");
			beanList.add(bean1);
			beanList.add(bean2);
			boolean isPresent = Validator.isEnumeratedOrNullValue(beanList, null);
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out Enumerated Or Null Value.", true);
		}
	}
	public void testNullStringArrayIsEnumeratedOrNullValue()
	{
		try
		{
			String[] list = {"user","product"};
			boolean isPresent = Validator.isEnumeratedOrNullValue(list, null);
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out Enumerated Or Null Value.", true);
		}
	}
	public void testContainsSpecialCharacters()
	{
		try
		{
			String mainString = "Contains~Special~Characters";
			String delimiter ="~";
			Validator validator = new Validator();
			boolean isPresent = validator.containsSpecialCharacters(mainString, delimiter);
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out Contains Special Characters.", true);
		}
	}
	public void testGetDateDiff()
	{
		try
		{
			Date startDate = Calendar.getInstance().getTime();
			Date endDate = Calendar.getInstance().getTime();
			Validator validator = new Validator();
			Long diff = validator.getDateDiff(startDate, endDate);
			assertEquals(Long.valueOf(0), diff);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to Get Date Difference.", true);
		}
	}
	public void testIsXssVulnerable()
	{
		try
		{
			String value = "Contains<Vulnerable<Characters";
			boolean isPresent = Validator.isXssVulnerable(value);
			assertEquals(true, isPresent);
		}
		catch (Exception excep)
		{
			assertFalse("Not able to find out XssVulnerable.", true);
		}
	}
}
