package edu.wustl.common.util;

import java.util.ArrayList;
import java.util.List;

import edu.wustl.common.CommonBaseTestCase;
import edu.wustl.common.util.logger.Logger;
import edu.wustl.dao.MyDAOImpl;
import edu.wustl.common.util.ExportReport;


public class ExportReportTestCase extends CommonBaseTestCase
{
	private static org.apache.log4j.Logger logger = Logger.getLogger(ExportReportTestCase.class);
	String path=System.getProperty("user.dir")+System.getProperty("file.separator");
	String csvFileName=path+"exportReport.csv";
	
	public void testWriteData()
	{
		try
		{
			ExportReport exportReport= new ExportReport(csvFileName);
			exportReport.writeData(getList(), ",");
			exportReport.closeFile();
			logger.debug("Data exported successfully at:"+csvFileName);
			assertTrue("Data exported successfully.", true);
		}
		catch (Exception exception)
		{
			fail("Fail t oexport data.");
			exception.printStackTrace();
		}
	}

	public void testWriteDataToZip()
	{
		MyDAOImpl.isTestForFail=false;
		String zipFileName= path+"exportReport.zip";
		List<String> mainEntityIdsList= new ArrayList<String>();
		mainEntityIdsList.add("Name");
		try
		{
			ExportReport exportReport= new ExportReport(path,csvFileName,zipFileName);
			exportReport.writeDataToZip(getList(), ",",mainEntityIdsList);
			exportReport.closeFile();
			logger.debug("Data exported successfully at:"+path);
			assertTrue("Data exported successfully at:"+path, true);
		}
		catch (Exception exception)
		{
			fail("Fail t oexport data.");
			exception.printStackTrace();
		}
	}
	List<List<String>>  getList()
	{
		List<List<String>> list= new ArrayList<List<String>>();
		List<String> list1=new ArrayList<String>();
		list1.add("Emp id");
		list1.add("First Name");
		list1.add("Last Name");

		List<String> list2=new ArrayList<String>();
		list2.add("1");
		list2.add("Abhijit");
		list2.add("Naik");

		List<String> list3=new ArrayList<String>();
		list3.add("1");
		list3.add("Kalpana");
		list3.add("Thakur");

		List<String> list4=new ArrayList<String>();
		list4.add("1");
		list4.add("Prashant");
		list4.add("Bandal");

		List<String> list5=new ArrayList<String>();
		list5.add("1");
		list5.add("Deepti");
		list5.add("Shelar");

		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		list.add(list5);
		return list;
	}
}
