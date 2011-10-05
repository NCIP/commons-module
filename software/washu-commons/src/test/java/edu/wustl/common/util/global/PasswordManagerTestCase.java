package edu.wustl.common.util.global;

import java.io.File;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.beans.SessionDataBean;
import edu.wustl.common.exception.PasswordEncryptionException;
import edu.wustl.common.util.logger.Logger;
import edu.wustl.dao.MyDAOImpl;


public class PasswordManagerTestCase extends CommonBaseTestCase
{
	/**
	 * Generic Logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(PasswordManagerTestCase.class);

	static
	{
		ApplicationProperties.initBundle("ApplicationResources");
	}
	public void testGeneratePassword()
	{
		String password=PasswordManager.generatePassword();
		assertTrue(password.length()>0);
	}

	public void testEncryptDecrypt()
	{
		String password="password";
		try
		{
			String encryptedPass = PasswordManager.encrypt(password);
			String decryptedPass = PasswordManager.decrypt(encryptedPass);
			assertEquals(password, decryptedPass);
		}
		catch (PasswordEncryptionException exception)
		{
			logger.debug("encrypt-decrypt not successful.",exception);
			fail("encrypt-decrypt not successful.");
		}
	}

	public void testEncodeDecode()
	{
		String string="password";
		try
		{
			String encodedString = PasswordManager.encode(string);
			String decodedString = PasswordManager.decode(encodedString);
			assertEquals(string, decodedString);
		}
		catch (Exception exception)
		{
			logger.debug("Encode-Decode not successful.",exception);
			fail("Encode-Decode not successful.");
		}
	}

	public void testFailValidatePasswordOnFormBeanForPwdChangeInSameSession()
	{
		try
		{
			String oldPassword="oldPassword";
			String newPassword="newPassword";
			Boolean pwdChangedInsameSession=true;
			int result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.FAIL_SAME_SESSION, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password if it has changed in same session.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testFailValidatePasswordOnFormBeanForMinLength()
	{
		try
		{
			String oldPassword="oldPassword";
			String newPassword="abc";
			Boolean pwdChangedInsameSession=false;
			int result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.FAIL_LENGTH, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testFailValidatePasswordOnFormBeanForOldPassword()
	{
		try
		{
			String oldPassword="oldPassword";
			String newPassword="oldPassword";
			Boolean pwdChangedInsameSession=false;
			int result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.FAIL_SAME_AS_OLD, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testFailValidatePasswordUpLowerNumSpaceCharInPass()
	{
		try
		{
			String oldPassword="oldPassword";

			//Password must contains at least One Upper character.
			String newPassword="login123";
			Boolean pwdChangedInsameSession=false;
			int result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.FAIL_IN_PATTERN, result);

			//Password must contains at least One Lower character.
			newPassword="LOGINABCD";
			result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.FAIL_IN_PATTERN, result);

			//Password must contains at least One digit.
			newPassword="Loginabcd";
			result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.FAIL_IN_PATTERN, result);

			//Password must not contains any space.
			newPassword="Login abcd";
			result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.FAIL_IN_PATTERN, result);

		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testValidatePasswordOnFormBean()
	{
		try
		{
			String oldPassword="oldPassword";
			String newPassword="Login123";
			Boolean pwdChangedInsameSession=false;
			int result = PasswordManager.validatePasswordOnFormBean(
					newPassword,oldPassword,pwdChangedInsameSession);
			assertEquals(PasswordManager.SUCCESS, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testFailValidateForWrongOldPassword()
	{
		try
		{
			MyDAOImpl.returnUserPassword=true;
			String oldPassword="oldPassword";
			String newPassword="Login123";
			Boolean pwdChangedInsameSession=false;
			SessionDataBean sessionData= new SessionDataBean();
			int result = PasswordManager.validate(
					newPassword,oldPassword,pwdChangedInsameSession,sessionData);
			assertEquals(PasswordManager.FAIL_WRONG_OLD_PASSWORD, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testFailValidateForMail()
	{
		try
		{
			MyDAOImpl.returnUserPassword=true;
			String oldPassword="Login123";
			String newPassword="Login1234";
			Boolean pwdChangedInsameSession=false;
			SessionDataBean sessionData= new SessionDataBean();
			sessionData.setUserName("Login1234@pspl.com");
			int result = PasswordManager.validate(
					newPassword,oldPassword,pwdChangedInsameSession,sessionData);
			assertEquals(PasswordManager.FAIL_SAME_AS_USERNAME, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testValidateForUserName()
	{
		try
		{
			MyDAOImpl.returnUserPassword=true;
			String oldPassword="Login123";
			String newPassword="ravi_kumar@pspl.co.in";
			Boolean pwdChangedInsameSession=false;
			SessionDataBean sessionData= new SessionDataBean();
			sessionData.setUserName("ravi_kumar@pspl.co.in");
			int result = PasswordManager.validate(
					newPassword,oldPassword,pwdChangedInsameSession,sessionData);
			assertEquals(PasswordManager.FAIL_SAME_AS_USERNAME, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testValidate()
	{
		try
		{
			MyDAOImpl.returnUserPassword=true;
			String oldPassword="Login123";
			String newPassword="Login1234";
			Boolean pwdChangedInsameSession=false;
			SessionDataBean sessionData= new SessionDataBean();
			sessionData.setUserName("ravi_kumar@pspl.co.in");
			int result = PasswordManager.validate(
					newPassword,oldPassword,pwdChangedInsameSession,sessionData);
			assertEquals(PasswordManager.SUCCESS, result);
		}
		catch (Exception exception)
		{
			fail("Not validating password for minimum length.");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testMain()
	{
		try
		{
			String fileName=System.getProperty("user.dir")+"/pass.txt";
			String []args= {fileName,"Login123"};
			PasswordManager.main(args);
			File file= new File(fileName);
			assertTrue(file.exists());
		}
		catch (Exception exception)
		{
			fail("password not written in file..");
			logger.debug("Encode-Decode not successful.",exception);
		}
	}

	public void testGetErrorMessage()
	{
		try
		{
			String errorMessage = PasswordManager.getErrorMessage(PasswordManager.FAIL_IN_PATTERN);
			assertTrue(errorMessage.length()>0);
		}
		catch (Exception exception)
		{
			logger.debug("Fail in getting error message.",exception);
			fail("Fail in getting error message.");
		}
	}
}
