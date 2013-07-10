/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.jms;

import java.io.Serializable;

/**
 *
 * @author kalpana_thakur
 * TODO This interface is used to read the Object
 *
 */
public interface ObjectChangeNotifierInterface extends Serializable
{

	/**
	 * This method is used to read the object.
	 *  @param obj Object to read.
	 * */
	void read(Object obj);
}
