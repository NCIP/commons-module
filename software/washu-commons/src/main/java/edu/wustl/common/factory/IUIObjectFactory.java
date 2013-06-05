/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.factory;

import edu.wustl.common.actionForm.AbstractActionForm;
import edu.wustl.common.domain.UIObject;
import edu.wustl.common.exception.AssignDataException;

public interface IUIObjectFactory
{
	/**
	 * This method returns an AbstractDomain object copy of the form bean object.
	 * @param form Form bean object.
	 * @return an AbstractDomain object copy of the form bean object.
	 * @throws AssignDataException Assign Data Exception.
	 */
	UIObject getUIObject(AbstractActionForm form)
			throws AssignDataException;

}
