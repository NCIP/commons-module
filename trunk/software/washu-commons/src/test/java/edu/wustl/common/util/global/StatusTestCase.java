package edu.wustl.common.util.global;

import edu.wustl.common.CommonBaseTestCase;


public class StatusTestCase extends CommonBaseTestCase
{
	public void testStatus()
	{
		assertEquals("Disabled", Status.ACTIVITY_STATUS_DISABLED.toString());
		assertEquals("activityStatus", Status.ACTIVITY_STATUS.toString());
		assertEquals("Active", Status.ACTIVITY_STATUS_ACTIVE.toString());
		assertEquals("Closed", Status.ACTIVITY_STATUS_CLOSED.toString());
		assertEquals("Approve", Status.ACTIVITY_STATUS_APPROVE.toString());
		assertEquals("Reject", Status.ACTIVITY_STATUS_REJECT.toString());
		assertEquals("New", Status.ACTIVITY_STATUS_NEW.toString());
		assertEquals("Pending", Status.ACTIVITY_STATUS_PENDING.toString());
		assertEquals("Approve", Status.APPROVE_USER_APPROVE_STATUS.toString());
		assertEquals("Reject", Status.APPROVE_USER_REJECT_STATUS.toString());
		assertEquals("Pending", Status.APPROVE_USER_PENDING_STATUS.toString());
	}
}
