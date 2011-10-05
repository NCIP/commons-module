package edu.wustl.common.jobmanager;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.jobmanager.JobManager;


public class TestJobManager extends CommonBaseTestCase
{

	public void testJobManager()
	{
		JobStatusListener jobStatusListener =new DefaultJobStatusListner();
		JobManager jobmanager=JobManager.getInstance();
		jobmanager.start();


		DummyJob dummyJob=new DummyJob("test", "1", jobStatusListener);
		JobData jobData=new JobData("test", "1", jobStatusListener);
		jobmanager.addJob(dummyJob);
		System.out.println("successfull");
//		try
//		{
////			Thread.sleep(4000);
//		}
//		catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
		Object[] keys= new Object[]{"LOG_FILE_KEY","NO_OF_RECORDS_PROCESSED","NO_OF_FAILED_RECORDS","NO_OF_TOTAL_RECORDS","JOB_STATUS_KEY","TIME_TAKEN_KEY",};
		Object[] values=new Object[]{"abc.zip","3","4","45","InProgress","231"};

//		jobStatusListener.jobStatusUpdated(jobData);
		jobData.updateJobStatus(keys, values, "Completed");
		jobmanager.shutdownJobManager();
	}
}
