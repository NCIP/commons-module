
package edu.wustl.common.datahandler;

import java.util.ArrayList;
import java.util.List;
import edu.wustl.common.beans.NameValueBean;
import edu.wustl.common.util.global.Constants;
/**
 * This is TestDataHandler class.
 * @author
 *
 */
public class TestDataHandler
{
	/**
	 * This is the main method.
	 * @param args Arguments pass to the main.
	 * @throws Exception throw Exception
	 */
	public static void main(String[] args) throws Exception
	{
		DataHandlerParameter parameter = new DataHandlerParameter();
		parameter.setProperty(ParametersEnum.BUFFERSIZE, 4); // optional
		parameter.setProperty(ParametersEnum.DELIMITER, Constants.DELIMETER); // optional

		List<Object> values = new ArrayList<Object>();
		values.add("aaaaa");
		values.add(1);
		values.add(5L);
		values.add(new NameValueBean("name", "value"));
		values.add("eeeee");
		values.add("fffff");
		AbstractDataHandler handler = DataHandlerFactory.getDataHandler(HandlerTypeEnum.CSV,
				parameter, "F:/Export_Home/abc.csv");
		handler.openFile();
		handler.appendData(values);
		handler.appendData(values);
		handler.appendData(values);
		handler.appendData(values);
		handler.appendData(values);
		handler.appendData(values);
		handler.closeFile();
		//System.out.println("DONE.........");
	}

}
