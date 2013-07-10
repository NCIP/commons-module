/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

/*
 * Created on Jun 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package edu.wustl.common.util;

import edu.wustl.common.test.BaseTestCase;

/**
 * @author kapil_kaveeshwar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CVSTagReaderTestCase extends BaseTestCase
{

	/**
	 * Constructer.
	 */
	public CVSTagReaderTestCase()
	{
		super("CVSTagReaderTestCase");
	}

	/**
	 * Test the reading tag.
	 */
	public void testReadTagPositive()
	{
		CVSTagReader cvsTagReader = new CVSTagReader();
		String tag = cvsTagReader.readTag("Testdata/ApplicationVersionInfo.txt");
		assertEquals("Test_tag", tag);
	}

	/**
	 * Test file not found read tag.
	 */
	public void testReadTagFileNotFound()
	{
		CVSTagReader cvsTagReader = new CVSTagReader();
		String tag = cvsTagReader.readTag("ApplicationVersionInfo1.txt");
		assertEquals(null, tag);
	}

	/**
	 * Test reading of wrong pattern.
	 */
	public void testReadTagWrongPattern()
	{
		CVSTagReader cvsTagReader = new CVSTagReader();
		String tag = cvsTagReader.readTag("Testdata/ApplicationVersionInfo2.txt");
		assertEquals(null, tag);
	}
}