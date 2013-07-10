/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.sso;

import edu.wustl.common.util.logger.Logger;

public class SSOAuthenticationFactory {
	
	/**
	 * LOGGER Logger - Generic LOGGER.
	 */
	private static final Logger LOGGER = Logger.getCommonLogger(SSOAuthenticationFactory.class);
	
	/**
	 * 
	 */
	private static SSOAuthentication ssoAuthentication = null;
	
	
	/**
	 * 
	 */
	private SSOAuthenticationFactory()
	{
		
	}
	
	/**
	 * 
	 * @param authenticationClassName
	 * @return
	 */
	public static SSOAuthentication getSSOAuthorizationInstance(String authenticationClassName)
	{
		LOGGER.info("In SSOAuthenticationFactory create instance method");
		if(ssoAuthentication == null)
		{
			try {
				ssoAuthentication = (SSOAuthentication)Class.forName(authenticationClassName).newInstance();				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ssoAuthentication;
	}
}