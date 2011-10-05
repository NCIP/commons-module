package edu.wustl.common.factory;

import edu.wustl.common.actionForm.AbstractActionForm;
import edu.wustl.common.bizlogic.IBizLogic;
import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.exception.ApplicationException;
import edu.wustl.common.exception.AssignDataException;
import edu.wustl.common.util.AbstractForwardToProcessor;


public class MyBizLogicFactory implements IFactory,IForwordToFactory,IDomainObjectFactory
{
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
