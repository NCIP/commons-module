package edu.wustl.common.domain;

import edu.wustl.common.actionForm.IValueObject;
import edu.wustl.common.bizlogic.IActivityStatus;
import edu.wustl.common.exception.AssignDataException;

/**
 * Mock class for test cases for AbstractFactoryConfig,
 * used in AbstractFactoryConfigTestCase.
 * @author ravi_kumar
 *
 */
public class MyDomainObject extends AbstractDomainObject implements IActivityStatus
{

	private Long id;
	
	private String activityStatus;
	@Override
	public Long getId()
	{
		return id;
	}

	@Override
	public void setAllValues(IValueObject valueObject) throws AssignDataException
	{
	}

	@Override
	public void setId(Long identifier)
	{
		this.id=identifier;
	}

	public String getActivityStatus()
	{
		return this.activityStatus;
	}

	public void setActivityStatus(String activityStatus)
	{
		this.activityStatus=activityStatus;
	}
}
