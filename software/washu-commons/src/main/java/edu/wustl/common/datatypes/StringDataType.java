/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

/**
 *
 */

package edu.wustl.common.datatypes;

import java.io.IOException;
import java.text.ParseException;

import org.apache.struts.action.ActionErrors;

import edu.wustl.common.util.global.TextConstants;

/**
 * @author prashant_bandal
 *
 */
public class StringDataType implements IDBDataType
{

	/* (non-Javadoc)
	 * @see edu.wustl.common.datatypes.IDBDataType
	 * #validate(java.lang.String, org.apache.struts.action.ActionErrors)
	 */
	/**
	 * This method validate String values.
	 * @param enteredValue entered Value as string.
	 * @param errors errors.
	 * @return conditionError boolean value.
	 */
	public boolean validate(String enteredValue, ActionErrors errors)
	{
		//write validation code for string.
		return false;
	}

	/**
	 * get string Object Value.
	 * @param str string value
	 * @return Object.
	 * @throws ParseException Parse Exception
	 * @throws IOException IOException
	 */
	public Object getObjectValue(String str) throws ParseException, IOException
	{
		/*Object obj = null;
		if (!TextConstants.EMPTY_STRING.equals(str))
		{
			obj = str;
		}*/
		return str;
	}

}
