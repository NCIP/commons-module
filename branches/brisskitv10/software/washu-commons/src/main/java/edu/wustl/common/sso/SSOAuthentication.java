package edu.wustl.common.sso;

import edu.wustl.common.exception.ApplicationException;

public interface SSOAuthentication {
	
	/**
	 * 
	 * @param informationObject
	 * @return
	 * @throws ApplicationException
	 */
	SSOInformationObject authenticate(SSOInformationObject informationObject) throws ApplicationException;

}
