package edu.wustl.dao.test;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import edu.wustl.common.util.logger.Logger;
import edu.wustl.dao.JDBCDAO;
import edu.wustl.dao.QueryWhereClause;
import edu.wustl.dao.condition.EqualClause;
import edu.wustl.dao.condition.INClause;
import edu.wustl.dao.condition.NotEqualClause;
import edu.wustl.dao.condition.NotNullClause;
import edu.wustl.dao.condition.NullClause;
import edu.wustl.dao.daofactory.IDAOFactory;
import edu.wustl.dao.exception.DAOException;
import edu.wustl.dao.query.generator.ColumnValueBean;
import edu.wustl.dao.query.generator.DBTypes;

/**
 * @author kalpana_thakur
 *
 */
public class JDBCTestCasesForCatissue extends BaseTestCase
{
	/**
	 * Logger.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(JDBCTestCasesForCatissue.class);

	/**
	 * DAO instance.
	 */
	private JDBCDAO jdbcDAO;

	{
		setJDBCDAO();
	}

	/**
	 * This method will be called to set the Default DAO.
	 */
	public void setJDBCDAO()
	{
		IDAOFactory daoFactory = daoConfigFactory.getInstance().getDAOFactory("caTissuecore");
		try
		{
			jdbcDAO = daoFactory.getJDBCDAO();
		}
		catch (DAOException e)
		{
			logger.fatal(e.getLogMessage());
		}
	}


	/**
	 * This test will assert that DAO instance is not null.
	 */
	@Test
	public void testJDBCDAOInstance()
	{
		assertNotNull("DAO Object is null",jdbcDAO);
	}


	 void fetch(String sql)
	 {
		 JDBCDAO jdbcDAO= null;

			try
			{

			 jdbcDAO = daoConfigFactory.getInstance().getDAOFactory("caTissuecore").getJDBCDAO();
			 jdbcDAO.openSession(null);

			 ResultSet rs = jdbcDAO.getQueryResultSet(sql);

			 while(rs.next())
			 {
				 System.out.println("rs.getInt(1)  :4 :"+rs.getInt(1) );
			 }
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
			finally
			{
				try
				{
					jdbcDAO.closeSession();
				}
				catch (DAOException e)
				{
						e.printStackTrace();
				}
			}
	 }

	 /**
	 * This test will assert the execution of query.
	 */
	@Test
	public void testExecuteUpdateJDBC()
	{
		try
		{
			jdbcDAO.openSession(null);
			StringBuffer strbuff = new StringBuffer();
			strbuff.append("update test_user set EMAIL_ADDRESS ='abc@per.co.in'" +
					" where FIRST_NAME = 'Srikanth'");
			jdbcDAO.executeUpdate(strbuff.toString());

		//	jdbcDAO.closeSession();
		}
		catch(Exception exp)
		{
			 exp.printStackTrace();
			assertFalse("Failed while inserting object Mysql :", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}
	}

	/**
	 * This test will assert the execution of query.
	 */
	@Test
	public void testResultSet()
	{
		try
		{
			jdbcDAO.openSession(null);
			StringBuffer strbuff = new StringBuffer();
			strbuff.append("select IDENTIFIER from test_user");

			ResultSet rsSet = jdbcDAO.getQueryResultSet(strbuff.toString());

			while(rsSet.next())
			{
				Long identifier = Long.valueOf(rsSet.getObject(1).toString());
				System.out.println("Identifier :"+identifier);
				String sql = "select FIRST_NAME from test_user where IDENTIFIER ="+identifier;
				ResultSet newRS = jdbcDAO.getQueryResultSet(sql);
				if(newRS.next())
					System.out.println(" Name:::"+newRS.getObject(1));

			}

			jdbcDAO.commit();
		//	jdbcDAO.closeSession();
		}
		catch(Exception exp)
		{
			 exp.printStackTrace();
			assertFalse("Failed while inserting object Mysql :", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}
	}

	/**
	 * This test will assert that all the objects are retrieved successfully.
	 */
	@Test
	public void testCaseRetriveAllObjectsJDBC()
	{
	  try
	  {
		  jdbcDAO.openSession(null);
		  List list = jdbcDAO.retrieve("test_user",null,null,false);
	  	 // jdbcDAO.closeSession();
	  	  assertNotNull(list);

	  }
	  catch(Exception exp)
	  {
		  assertFalse("Failed while retrieving object :", true);
	  }
	  finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}
	}

	/**
	 * This test will assert that the object with requested
	 * column will be retrieved successfully.
	 */
	@Test
	public void testCaseRetriveObjectJDBC()
	{
	  try
	  {
		jdbcDAO.openSession(null);
		QueryWhereClause queryWhereClause = new QueryWhereClause("test_user");
		queryWhereClause.addCondition(new EqualClause("IDENTIFIER" , Long.valueOf(1)));
	    List<Object> list = jdbcDAO.retrieve("test_user",null ,queryWhereClause,false);

	 //   jdbcDAO.closeSession();
	  	assertNotNull("No objects retrieved",list);
		//assertTrue("No object retrieved ::",!list.isEmpty());
	  }
	  catch(Exception exp)
	  {
		  assertFalse("Failed while retrieving object ::", true);
	  }
	  finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}
	}


	/**
	 * This test will assert that requested columns of the objects are
	 * retrieved successfully.
	 */
	@Test
	public void testCaseRetrieveObjectColumnsJDBC()
	{
	  try
	  {
		String[] selectColumnName = {"IDENTIFIER","FIRST_NAME","LAST_NAME","EMAIL_ADDRESS"};
		jdbcDAO.openSession(null);
	    List<Object> list = jdbcDAO.retrieve("test_user", selectColumnName,null,false);
	  //  jdbcDAO.closeSession();

	    assertNotNull("No object retrieved ::",list);
	//	assertTrue("No object retrieved ::",!list.isEmpty());
	  }
	  catch(Exception exp)
	  {
		  assertFalse("Failed while retrieving object ::", true);
	  }
	  finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}
	}

	/**
	 * This test will assert that only distinct rows
	 * retrieved successfully.
	 */
	@Test
	public void testCaseRetrieveOnlyDistinctRowsJDBC()
	{
		try
		  {
			String[] selectColumnName = {"IDENTIFIER","FIRST_NAME","LAST_NAME","EMAIL_ADDRESS"};
			jdbcDAO.openSession(null);
		    List<Object> list = jdbcDAO.retrieve("test_user", selectColumnName,null,true);
		   // jdbcDAO.closeSession();

		    assertNotNull("No object retrieved ::",list);
	//		assertTrue("No object retrieved ::",!list.isEmpty());
		  }
		  catch(Exception exp)
		  {
			  assertFalse("Failed while retrieving object ::", true);
		  }
		  finally
			{
				try
				{
					jdbcDAO.closeSession();
				}
				catch (DAOException e)
				{

					e.printStackTrace();
				}
			}

	}


	/**
	 * This test will assert that objects retrieved successfully
	 * when where clause holds in condition.
	 */
	@Test
	public void testRetriveInConditionJDBC()
	{
		try
		{
			String sourceObjectName = "test_user";
			Object [] colValues = {Long.valueOf(1),Long.valueOf(2)};
			String[] selectColumnName = null;

			QueryWhereClause queryWhereClause = new QueryWhereClause(sourceObjectName);
			queryWhereClause.addCondition(new INClause("IDENTIFIER",colValues,sourceObjectName)).
			orOpr().addCondition(new INClause("FIRST_NAME","JOHN,abhijit",sourceObjectName));


			jdbcDAO.openSession(null);
			List<Object> list = jdbcDAO.retrieve(sourceObjectName, selectColumnName,queryWhereClause,false);
			//jdbcDAO.closeSession();
			assertNotNull("No value retrieved :",list);

		}
		catch(Exception exp)
		{
			assertFalse("Failed while retrieving object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}

	}

	/**
	 * This test will assert that objects retrieved successfully
	 * when where clause holds not null condition.
	 */
	@Test
	public void testRetriveIsNotNullConditionJDBC()
	{
		try
		{
			String sourceObjectName = "test_user";
			String[] selectColumnName = null;

			QueryWhereClause queryWhereClause = new QueryWhereClause(sourceObjectName);
			queryWhereClause.addCondition(new NotNullClause("IDENTIFIER",sourceObjectName)).orOpr().
			addCondition(new NotNullClause("LAST_NAME",sourceObjectName));

			jdbcDAO.openSession(null);
			List<Object> list = jdbcDAO.retrieve(sourceObjectName, selectColumnName,queryWhereClause,false);
			//jdbcDAO.closeSession();

			assertNotNull("No value retrieved :" + list);
			assertTrue("No object retrieved ::",list.size() > 0);

		}
		catch(Exception exp)
		{
			assertFalse("Failed while retrieving object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}
	}

	/**
	 * This test will assert that objects retrieved successfully
	 * when where clause holds is null condition.
	 */
	@Test
	public void testRetriveIsNullConditionJDBC()
	{
		try
		{
			String sourceObjectName = "test_user";
			String[] selectColumnName = null;

			QueryWhereClause queryWhereClause = new QueryWhereClause(sourceObjectName);
			queryWhereClause.addCondition(new NullClause("LAST_NAME",sourceObjectName)).orOpr().
			addCondition(new NotEqualClause("IDENTIFIER",
					Long.valueOf("1"),sourceObjectName));

			jdbcDAO.openSession(null);
			List<Object> list = jdbcDAO.retrieve(sourceObjectName,
					selectColumnName,queryWhereClause,false);
			//jdbcDAO.closeSession();

			assertNotNull("No object retrieved ::",list);

		}
		catch(Exception exp)
		{
			assertFalse("Failed while retrieving object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			} 
			catch (DAOException e)
			{
		
				e.printStackTrace();
			}
		}

	}

	/**
	 * This test will assert that objects retrieved successfully
	 * when where clause holds is not equal condition.
	 */
	@Test
	public void testRetriveNotEqualConditionJDBC()
	{
		try
		{
			String sourceObjectName = "test_user";
			String[] selectColumnName = null;

			QueryWhereClause queryWhereClause = new QueryWhereClause(sourceObjectName);
			queryWhereClause.addCondition(new NotEqualClause("IDENTIFIER",
					Long.valueOf("1"),sourceObjectName)).andOpr().
					addCondition(new NotEqualClause("LAST_NAME",
					"NAIK",sourceObjectName));

			jdbcDAO.openSession(null);
			List<Object> list = jdbcDAO.retrieve(sourceObjectName, selectColumnName,queryWhereClause,false);
			//jdbcDAO.closeSession();

			assertNotNull("No object retrieved ::",list);

		}
		catch(Exception exp)
		{
			assertFalse("Failed while retrieving object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			} 
			catch (DAOException e)
			{
		
				e.printStackTrace();
			}
		}

	}


	/**
	 * This test will assert that objects retrieved successfully with given column value
	 * Having equal (=)condition.
	 */
	@Test
	public void testRetriveEqualConditionJDBC()
	{
		try
		{
			String sourceObjectName = "test_user";
			String[] selectColumnName = null;

			QueryWhereClause queryWhereClause = new QueryWhereClause(sourceObjectName);
			queryWhereClause.addCondition(new EqualClause("LAST_NAME","NAIK",sourceObjectName));

			jdbcDAO.openSession(null);
			List<Object> list = jdbcDAO.retrieve(sourceObjectName, selectColumnName,queryWhereClause,false);
			//jdbcDAO.closeSession();

			assertNotNull("No object retrieved ::",list);
		
		}
		catch(Exception exp)
		{
			assertFalse("Failed while retrieving object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			} 
			catch (DAOException e)
			{
		
				e.printStackTrace();
			}
		}

	}
	
	

	@Test
	public void testBatchInsert() throws DAOException
	{
		try
		{

			jdbcDAO.openSession(null);
			TreeSet<String> columnSet = new TreeSet<String>();
			columnSet.add("identifier");
			columnSet.add("first_name");
			columnSet.add("second_name");
			columnSet.add("age");
			columnSet.add("address_id");
			columnSet.add("account_id");
			columnSet.add("birth_date");
			columnSet.add("isAvailable");

			jdbcDAO.batchInitialize(5, "person", columnSet);

			for(int i = 1 ; i<7;i++)
			{

				SortedMap<String, ColumnValueBean> dataMap = new TreeMap<String, ColumnValueBean>();
				String firstName = "JOHN"+i;
				String secondName = "REBER"+i;

				ColumnValueBean colValueBean = new ColumnValueBean("identifier",
						i,DBTypes.INTEGER);
				dataMap.put("identifier", colValueBean);

				ColumnValueBean first_name = new ColumnValueBean(firstName,DBTypes.STRING);
				dataMap.put("first_name", first_name);

				ColumnValueBean second_name = new ColumnValueBean(secondName,DBTypes.STRING);
				dataMap.put("second_name", second_name);

				ColumnValueBean age = new ColumnValueBean("age",
						i,DBTypes.INTEGER);
				dataMap.put("age", age);

				ColumnValueBean address_id = new ColumnValueBean(i,DBTypes.INTEGER);
				dataMap.put("address_id", address_id);

				ColumnValueBean account_id = new ColumnValueBean(i,DBTypes.INTEGER);
				dataMap.put("account_id", account_id);

				Date date = new Date(new java.util.Date().getTime());

				ColumnValueBean birth_date = new ColumnValueBean(date,DBTypes.DATE);
				dataMap.put("birth_date", birth_date);

				ColumnValueBean isAvailable = new ColumnValueBean(true,DBTypes.BOOLEAN);
				dataMap.put("isAvailable", isAvailable);

				jdbcDAO.batchInsert(dataMap);

			}
			jdbcDAO.batchCommit();
			jdbcDAO.batchClose();


		}
		catch(Exception exp)
		{
			assertFalse("Failed while updating object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}
	}

	@Test
	public void testExecuteUpdate()
	{

		try
		{
			jdbcDAO.openSession(null);
			LinkedList<ColumnValueBean> list = insertData(10000,"kalpana","thakur",1);

			String sql = "insert into person (identifier,first_name,second_name,age,address_id,account_id,birth_date,isAvailable )" +
			" values (?,?,?,?,?,?,?,? )";
			jdbcDAO.executeUpdate(sql, list);
			jdbcDAO.commit();
		}
		catch(Exception exp)
		{
			assertFalse("Failed while updating object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}

	}

	@Test
	public void testExecuteUpdateforPreparedStatement()
	{

		try
		{
			jdbcDAO.openSession(null);

			LinkedList<LinkedList<ColumnValueBean>> allbeans = new LinkedList<LinkedList<ColumnValueBean>>();
			
			for(int i=45; i<=50 ;i++)
			{
				
				LinkedList<ColumnValueBean> list = insertData(i,"kalpana","thakur",i);
				allbeans.add(list);
			}
			String sql = "insert into person (identifier,first_name,second_name,age,address_id,account_id,birth_date,isAvailable )" +
			" values (?,?,?,?,?,?,?,? )";
			jdbcDAO.executeUpdate(sql, allbeans);
			jdbcDAO.commit();
		}
		catch(Exception exp)
		{
			assertFalse("Failed while updating object ::", true);
			exp.printStackTrace();
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}

	}

	@Test
	public void testExecuteUpdateforMaliciousData()
	{

		try
		{
			jdbcDAO.openSession(null);

			LinkedList<LinkedList<ColumnValueBean>> allbeans = new LinkedList<LinkedList<ColumnValueBean>>();

			for(int i=51; i<=53 ;i++)
			{

				LinkedList<ColumnValueBean> list = insertData(i,"kalpana'delete","thakur;abc",i);
				allbeans.add(list);
			}
			String sql = "insert into person (identifier,first_name,second_name,age,address_id,account_id,birth_date,isAvailable )" +
			" values (?,?,?,?,?,?,?,? )";
			jdbcDAO.executeUpdate(sql, allbeans);
			jdbcDAO.commit();
		}
		catch(Exception exp)
		{
			assertFalse("Failed while updating object ::", false);
			exp.printStackTrace();
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}

	}



	private LinkedList<ColumnValueBean> insertData(int identifier,String firstName,String lastName,int i) {
		LinkedList<ColumnValueBean> list = new LinkedList<ColumnValueBean>();

		ColumnValueBean colValueBean = new ColumnValueBean("identifier",
				identifier+1,DBTypes.INTEGER);
		list.add(colValueBean);

		ColumnValueBean first_name = new ColumnValueBean("first_name",
				firstName+1,DBTypes.STRING);
		list.add(first_name);

		ColumnValueBean second_name = new ColumnValueBean("second_name",
				lastName+1,DBTypes.STRING);
		list.add(second_name);

		ColumnValueBean age = new ColumnValueBean("age",
				1,DBTypes.INTEGER);
		list.add(age);

		ColumnValueBean address_id = new ColumnValueBean("address_id",
				1,DBTypes.INTEGER);
		list.add(address_id);

		ColumnValueBean account_id = new ColumnValueBean("account_id",
				1,DBTypes.INTEGER);
		list.add(account_id);

		Date date = new Date(new java.util.Date().getTime());
		ColumnValueBean birth_date = new ColumnValueBean("birth_date",
				date,DBTypes.DATE);
		list.add(birth_date);

		ColumnValueBean isAvailable = new ColumnValueBean("isAvailable",
				true,DBTypes.BOOLEAN);
		list.add(isAvailable);
		return list;
	}

	@Test
	public void testMultipleTransaction()
	{

		try
		{
			jdbcDAO.openSession(null);


			for(int counter = 10; counter < 13; counter++ )
			{
				//jdbcDAO.openTransaction();
				LinkedList<ColumnValueBean> list = insertData(counter,"sri"+counter,"adiga"+counter,1);

				String insertSql = "insert into person (identifier,first_name,second_name,age,address_id,account_id,birth_date,isAvailable )" +
				" values (?,?,?,?,?,?,?,? )";
				jdbcDAO.executeUpdate(insertSql, list);
				jdbcDAO.commit();

				//jdbcDAO.openTransaction();
				String sql = "update person set first_name = 'naik"+counter+"' where identifier = "+counter;
				jdbcDAO.executeUpdate(sql);
				jdbcDAO.commit();

			}

		}
		catch(Exception exp)
		{
			assertFalse("Failed while updating object ::", true);
		}
		finally
		{
			try
			{
				jdbcDAO.closeSession();
			}
			catch (DAOException e)
			{

				e.printStackTrace();
			}
		}

	}

	@Test
    public void testCaseExecuteQueryWithFixedResultSize()
    {

          try
          {

                jdbcDAO.openSession(null);
                String sql = "select IDENTIFIER from test_user";
                List list = jdbcDAO.executeQuery(sql,0,2,null);
                assertEquals(true, list.size()==2);
          }
          catch(Exception exp)
          {
                assertFalse("Problem while executing query ::", true);
          }
          finally
          {
                try
                {
                	jdbcDAO.closeSession();
                }
                catch (DAOException e)
                {
                      e.printStackTrace();
                }

          }

    }
	@Test
    public void testCaseExecuteQueryforMaliciousCode()
    {

          try
          {
                jdbcDAO.openSession(null);
                String sql = "select FIRST_NAME, IDENTIFIER from test_user where IDENTIFIER = ? ";
                ColumnValueBean colValueBean = new ColumnValueBean("IDENTIFIER",Long.valueOf(2),DBTypes.INTEGER);

                LinkedList<ColumnValueBean> beans = new LinkedList<ColumnValueBean>();
                beans.add(colValueBean);
                List list = jdbcDAO.executeQuery(sql,null,beans);
               // assertEquals(true, list.size()==1);

          }
          catch(Exception exp)
          {
        	  	exp.printStackTrace();
                assertFalse("Problem while executing query ::", true);
          }
          finally
          {
                try
                {
                	jdbcDAO.closeSession();
                }
                catch (DAOException e)
                {
                      e.printStackTrace();
                }

          }

    }
	
	@Test
    public void testCaseExecuteQueryWithPreparedStmt()
    {

          try
          {
                jdbcDAO.openSession(null);
                String sql = "select FIRST_NAME, IDENTIFIER from test_user where FIRST_NAME = ? ";
                ColumnValueBean colValueBean = new ColumnValueBean("IDENTIFIER","sri--",DBTypes.STRING);

                LinkedList<ColumnValueBean> beans = new LinkedList<ColumnValueBean>();
                beans.add(colValueBean);
                List list = jdbcDAO.executeQuery(sql,null,beans);
                System.out.println("list Size : : : "+list.size());

          }
          catch(Exception exp)
          {
        	  	exp.printStackTrace();
                assertFalse("Problem while executing query ::", false);
          }
          finally
          {
                try
                {
                	jdbcDAO.closeSession();
                }
                catch (DAOException e)
                {
                      e.printStackTrace();
                }

          }

    }
	
	@Test
    public void testCaseDeleteTable()
    {

          try
          {
        	  jdbcDAO.openSession(null);
              jdbcDAO.deleteTable("temp_table");
              jdbcDAO.commit();


          }
          catch(Exception exp)
          {
        	  	exp.printStackTrace();
                assertFalse("Problem while executing query ::", true);
          }
          finally
          {
                try
                {
                	jdbcDAO.closeSession();
                }
                catch (DAOException e)
                {
                      e.printStackTrace();
                }

          }

    }


}
