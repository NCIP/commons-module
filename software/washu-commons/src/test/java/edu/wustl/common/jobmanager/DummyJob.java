/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.jobmanager;

import edu.wustl.common.jobmanager.Job;
import edu.wustl.common.jobmanager.JobStatusListener;


public class DummyJob extends Job
{

	protected DummyJob(String jobName, String jobStartedBy, JobStatusListener jobStatusListener)
	{
		super(jobName, jobStartedBy, jobStatusListener);

	}

	@Override
	public void doJob()
	{
		System.out.println("Thread Initiated Successfully");

	}

}
