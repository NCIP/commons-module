/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.factory;

import edu.wustl.common.actionForm.AbstractActionForm;
import edu.wustl.common.bizlogic.IBizLogic;
import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.domain.UIRepOfDomain;
import edu.wustl.common.exception.ApplicationException;
import edu.wustl.common.exception.AssignDataException;
import edu.wustl.common.util.AbstractForwardToProcessor;


public class MyBizLogicFactory implements IFactory,IForwordToFactory,IDomainObjectFactory
{
    public AbstractDomainObject createDomainObject(UIRepOfDomain uiRepOfDomain) throws AssignDataException {
        return null;
    }

    public void overwriteDomainObject(AbstractDomainObject domainObject, UIRepOfDomain uiRep) throws AssignDataException {
    }

    public IBizLogic getBizLogic(int formId)
	{
		return null;
	}

	public AbstractForwardToProcessor getForwardToPrintProcessor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractForwardToProcessor getForwardToProcessor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractDomainObject getDomainObject(int formType, AbstractActionForm form)
			throws AssignDataException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getDomainObjectName(int formType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractActionForm getFormBean(Object domainObject, String operation)
			throws ApplicationException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public IBizLogic getBizLogic(String className)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
