/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.jobmanager;


// TODO: Auto-generated Javadoc
/**
 * The Interface JobStatusListener.
 *
 * @author nitesh_marwaha
 */
public interface JobStatusListener
{

	/**
	 * Invoked when job status is created.
	 *
	 * @param jobData the job data
	 */
	void jobStatusCreated(JobData jobData);

	/**
	 * Invoked when job status update occurs.
	 *
	 * @param jobData the job data
	 */
	void jobStatusUpdated(JobData jobData);
}
