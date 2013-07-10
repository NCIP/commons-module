/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.sso;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessages;

public class SSOInformationObject {
	
	private String loginName;
	
	private HttpServletRequest request;
	
	private ActionMessages actionMessages;
	
	private ActionErrors actionErrors;
	
	private String forwardTo;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ActionMessages getActionMessages() {
		return actionMessages;
	}

	public void setActionMessages(ActionMessages actionMessages) {
		this.actionMessages = actionMessages;
	}

	public ActionErrors getActionErrors() {
		return actionErrors;
	}

	public void setActionErrors(ActionErrors actionErrors) {
		this.actionErrors = actionErrors;
	}

	public String getForwardTo() {
		return forwardTo;
	}

	public void setForwardTo(String forwardTo) {
		this.forwardTo = forwardTo;
	}

}
