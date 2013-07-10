/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.exceptionformatter;

/**
 * @author sachin_lale
 * Description: Interface defines method for formatting the database specific Exception message
 */
public interface ExceptionFormatter
{

	/**
	 * This method format Message.
	 * @param objExcp Exception.
	 * @return formated Message.
	 */
	String formatMessage(Exception objExcp);
}
