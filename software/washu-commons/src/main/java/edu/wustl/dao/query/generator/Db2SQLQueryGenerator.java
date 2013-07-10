/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.dao.query.generator;

/**
 * This class meant for DB2.
 * @author kalpana_thakur
 *
 */
public class Db2SQLQueryGenerator extends AbstractQueryGenerator
{


	/**
	 * @param colValBean : bean having column name value and type.
	 * @return object : value of the column as per the type
	  */
	protected Object fetchColumnValue(ColumnValueBean colValBean)
	{

		Object value;
		switch(colValBean.getColumnType())
		{
//			case DBTypes.DATE :
//			    value = "to_date ( '"+colValBean.getColumnValue()+"','yyyy-mm-dd')";
//				break;
//
//			case DBTypes.NUMBER :
//			case DBTypes.INTEGER :
//				value = colValBean.getColumnValue();
//				break ;

			default :
				value = "'"+colValBean.getColumnValue()+"'";
				break;

		}
		return value;
	}

}
