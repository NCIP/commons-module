/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

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
