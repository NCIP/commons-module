/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.util;

import edu.wustl.common.CommonBaseTestCase;


public class XMLPropertyHandlerTestCase extends CommonBaseTestCase
{
	public void testGetValue()
	{
		String value=XMLPropertyHandler.getValue("server.port");
		assertEquals("8080", value);
	}
}
