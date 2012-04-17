package edu.wustl.common.util.global;

import java.util.Properties;

import javax.mail.Session;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.util.logger.Logger;

/**
 * This class is for junit test case for SendEmail class.
 * Please configure correct mail host in file junitConf.properties for this test case..
 * @author ravi_kumar
 *
 */
public class SendEmailTestCase extends CommonBaseTestCase
{

	private static org.apache.log4j.Logger logger = Logger.getLogger(SendEmailTestCase.class);
	/*public void testSendMail()
	{
		EmailDetails mailDetails = getEmailDetails();
		try
		{
			String mailHost=ApplicationProperties.getValue("mail.host");
			SendEmail mail= new SendEmail(mailHost,"from@pspl.com");
			mail.setFrom("from@pspl.com");
			mail.setHost(mailHost);
			boolean success=mail.sendMail(mailDetails);
			if(success)
			{
				logger.info("Test Case fails, please make sure that host name in junitConf.properties file is correct.");
			}
			assertTrue(success);
		}
		catch (Exception e)
		{
			fail("Please make sure that host name in junitConf.properties file is correct.");
			logger.debug("");
		}
	}
*/
	/**
	 * @return EmailDetails
	 */
	private EmailDetails getEmailDetails()
	{
		EmailDetails mailDetails= new EmailDetails();
		mailDetails.setSubject("Subject");
		mailDetails.setBody("Body");
		mailDetails.setToAddress(new String[]{"to@pspl.com"});
		mailDetails.addCcAddress("cc1@pspl.com");
		mailDetails.setCcAddress(new String[]{"cc@pspl.com"});
		mailDetails.addBccAddress("bcc@pspl.com");
		mailDetails.setBccAddress(new String[]{"bcc@pspl.com"});
		return mailDetails;
	}
}
