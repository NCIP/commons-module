package edu.wustl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.wustl.common.beans.SessionDataBean;
import edu.wustl.common.domain.LoginDetails;
import edu.wustl.common.domain.MyDomainObject;
import edu.wustl.common.exception.ErrorKey;
import edu.wustl.common.util.global.PasswordManager;
import edu.wustl.dao.connectionmanager.IConnectionManager;
import edu.wustl.dao.daofactory.IDAOFactory;
import edu.wustl.dao.exception.AuditException;
import edu.wustl.dao.exception.DAOException;
import edu.wustl.dao.query.generator.ColumnValueBean;
import edu.wustl.dao.util.HibernateMetaData;
import edu.wustl.dao.util.NamedQueryParam;
import edu.wustl.dao.util.StatementData;

/**
 *
 * @author
 *
 */
public class MyDAOImpl implements DAO, HibernateDAO, IDAOFactory, JDBCDAO, IConnectionManager
{
	/**
	 *
	 */
	public static boolean isTestForFail=false;
	/**
	 *
	 */
	public static boolean identifierList=false;
	/**
	 *
	 */
	public static boolean isTestActivityStatus=false;
	/**
	 *
	 */
	public static boolean returnActivityStatusObj=false;
	/**
	 *
	 */
	public static boolean returnUserPassword=false;

	/**
	 * List to return from retrieve methods.
	 */
	public static List<Object> list;
	/**
	 *
	 */
	public static String object="retObject";
	/**
	 * @return returns dummy list.
	 * @throws DAOException  throw DAOException when isTestForFail=true
	 */
	public static List<Object> getList() throws DAOException
	{
		list= new ArrayList<Object>();
		if(isTestForFail)
		{
			ErrorKey errorKey = ErrorKey.getErrorKey("db.operation.error");
			throw new DAOException(errorKey,new Exception(""),"MyJDAOImpl.java :");
		}
		else if(identifierList)
		{
			list.add(Long.valueOf(1));
			list.add(Long.valueOf(2));
			list.add(Long.valueOf(3));
		}
		else if(isTestActivityStatus)
		{
			list.add("ActivityStatus");
		}
		else
		{
			Object []list1= {"1","John","Enterprise"};
			Object []list2= {"2","Raghu","IBM"};
			Object []list3= {"3","Bame","Enterprise"};
			list.add(list1);
			list.add(list2);
			list.add(list3);
		}
		return (List<Object>)list;
	}
	/**
	 * This method throws the DAOException.
	 * @throws DAOException throw DAOException.
	 */
	public static void throwDaoException() throws DAOException
	{
		if(isTestForFail)
		{
			ErrorKey errorKey = ErrorKey.getErrorKey("db.operation.error");
			throw new DAOException(errorKey,new Exception(""),"MyJDAOImpl.java :");
		}
	}
	/**
	 * This method retrieves the object.
	 * @return object
	 * @throws DAOException throw DAOException.
	 */
	public Object getObject() throws DAOException
	{
		throwDaoException();
		MyDomainObject myDomainObject = new MyDomainObject();
		return myDomainObject;
	}
	/**
	 * This method returns attribute of object.
	 * @return String value
	 * @throws DAOException throw DAOException.
	 */
	public String getObjectAttribute() throws DAOException
	{
		throwDaoException();
		return object;
	}
	/**
	 * @param isDefaultDAOFactory boolean value.
	 */
	public void setIsDefaultDAOFactory(Boolean isDefaultDAOFactory )
	{
		// Empty setIsDefaultDAOFactory method.
	}
	/**
	 * @return Boolean value.
	 */
	public Boolean getIsDefaultDAOFactory()
	{
		return true;
	}
	/**
	 * @throws DAOException throw DAOException.
	 */
	public void closeSession() throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @throws DAOException throw DAOException.
	 */
	public void commit() throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param obj Object to delete.
	 * @throws DAOException throw DAOException.
	 */
	public void delete(Object obj) throws DAOException
	{
		throwDaoException();
		//NOT TO DO ANYTHING.
	}
	/**
	 *
	 * @return returns IConnectionManager object.
	 */
	public IConnectionManager getConnectionManager()
	{
		setConnectionManager(new MyDAOImpl());
		return this.connectionManager;
	}
	/**
	 * @param sessionDataBean SessionDataBean object.
	 * @throws DAOException throw DAOException
	 */
	public void openSession(SessionDataBean sessionDataBean) throws DAOException
	{
		//not to do anything
	}
	/**
	 * @param sourceObjectName Source Object name.
	 * @return List of object.
	 * @throws DAOException throw DAOException.
	 */
	public List<Object> retrieve(String sourceObjectName) throws DAOException
	{
		return (List<Object>)getList();
	}
	/**
	 * @param sourceObjectName Source Object name.
	 * @param selectColumnName List of selectColumn values.
	 * @return List of object.
	 * @throws DAOException throw DAOException.
	 */
	public List<Object> retrieve(String sourceObjectName, String[] selectColumnName)
	throws DAOException
	{
		return (List<Object>)getList();
	}

	/*	public Object retrieve(String sourceObjectName, Long identifier) throws DAOException
	{
		Object obj;
		if(isTestForFail)
		{
			ErrorKey errorKey = ErrorKey.getErrorKey("db.operation.error");
			throw new DAOException(errorKey,new Exception(""),"MyJDAOImpl.java :");
		}
		else if(returnActivityStatusObj)
		{
			MyDomainObject ado= new MyDomainObject();
			ado.setActivityStatus("Active");
			ado.setId(Long.valueOf(1));
			obj=ado;
		}
		else
		{
			obj=getObject();
		}
		return obj;
	}
	 */
	/**
	 * @param sourceObjectName Source Object name.
	 * @param selectColumnName List of selectColumn values.
	 * @param queryWhereClause QueryWhereClause object.
	 * @return List of object.
	 * @throws DAOException throw DAOException.
	 */
	public List<Object> retrieve(String sourceObjectName, String[] selectColumnName,
			QueryWhereClause queryWhereClause) throws DAOException
			{
		List<Object> pass= new ArrayList<Object>();
		if(returnUserPassword)
		{
			//List<Object> pass= new ArrayList<Object>();
			pass.add(PasswordManager.encode("Login123"));
			//return pass;
		}
		else
		{
			//return (List<Object>)getList();
			pass = getList();
		}
		return pass;
			}
	/**
	 * @param sourceObjectName Source Object name.
	 * @param whereColumnName  whereColumnName values.
	 * @param whereColumnValue whereColumnValue object.
	 * @return List of object.
	 * @throws DAOException throw DAOException.
	 */
	public List<Object> retrieve(String sourceObjectName, String whereColumnName,
			Object whereColumnValue) throws DAOException
			{
		// TODO Auto-generated method stub
		return null;
			}
	/**
	 * @param objClass Class.
	 * @param columnName column name.
	 * @param identifier identifier.
	 * @param attributeName attribute name.
	 * @return List object.
	 * @throws DAOException throw DAOException
	 */
	public List retrieveAttribute(Class objClass,String columnName, Long identifier, String attributeName
	) throws DAOException
	{
		List attributte = new ArrayList();
		attributte.add(getObjectAttribute());
		return attributte;
	}
	/**
	 * @throws DAOException throw DAOException
	 */
	public void rollback() throws DAOException
	{
		// TODO Auto-generated method stub

	}
	/**
	 * @param connectionManager IConnectionManager object.
	 */
	public void setConnectionManager(IConnectionManager connectionManager)
	{
		if(isTestForFail)
		{
			this.connectionManager=null;
		}
		else
		{
			this.connectionManager=connectionManager;
		}
	}
	/**
	 * @param obj Object to update.
	 * @throws DAOException throw DAOException.
	 */
	public void update(Object obj) throws DAOException
	{
		throwDaoException();
	}
	/**
	 * @throws DAOException throw DAOException
	 */
	public void buildSessionFactory() throws DAOException
	{
		this.setApplicationName("commonpackagetest");
	}
	/**
	 * @return String value.
	 */
	public String getApplicationName()
	{
		return this.applicationName;
		//return "commonpackagetest";
	}
	/**
	 * @return return String value.
	 */
	public String getConfigurationFile()
	{
		return this.configurationFile;
	}
	/**
	 * @return DAO object.
	 * @throws DAOException throw DAOException
	 */
	public DAO getDAO() throws DAOException
	{
		DAO dao = null;
		try
		{
			dao = (DAO)Class.forName(defaultDAOClassName).newInstance();
			dao.setConnectionManager(getConnectionManager());

		}
		catch (Exception excp )
		{
			ErrorKey errorKey = ErrorKey.getErrorKey("db.operation.error");
			throw new DAOException(errorKey,excp,"DAOFactory.java :");
		}
		return dao;
	}
	/**
	 * @return String object.
	 */
	public String getDefaultDAOClassName()
	{
		return this.defaultDAOClassName;
	}
	/**
	 * @return JDBCDAO object.
	 * @throws DAOException throw DAOException
	 */
	public JDBCDAO getJDBCDAO() throws DAOException
	{
		JDBCDAO dao = null;
		try
		{
			dao = (JDBCDAO)Class.forName(defaultDAOClassName).newInstance();
			dao.setConnectionManager(getConnectionManager());

		}
		catch (Exception excp )
		{
			ErrorKey errorKey = ErrorKey.getErrorKey("db.operation.error");
			throw new DAOException(errorKey,excp,"DAOFactory.java :");
		}
		return dao;
	}
	/**
	 * @return String value.
	 */
	public String getJdbcDAOClassName()
	{
		return this.jdbcDAOClassName;
	}
	/**
	 * @param applicationName application name to set.
	 */
	public void setApplicationName(String applicationName)
	{
		this.applicationName=applicationName;

	}
	/**
	 * @param configurationFile configurationFile to set.
	 */
	public void setConfigurationFile(String configurationFile)
	{
		this.configurationFile=configurationFile;

	}
	/**
	 * @param defaultDAOClassName defaultDAOClassName to set.
	 */
	public void setDefaultDAOClassName(String defaultDAOClassName)
	{
		this.defaultDAOClassName=defaultDAOClassName;

	}
	/**
	 * @param jdbcDAOClassName jdbcDAOClassName to set.
	 */
	public void setJdbcDAOClassName(String jdbcDAOClassName)
	{
		this.jdbcDAOClassName=jdbcDAOClassName;
	}
	/**
	 * @return String value.
	 */
	public String getDateFormatFunction()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String value.
	 */
	public String getDatePattern()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String value.
	 */
	public String getDateTostrFunction()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String value.
	 */
	public String getStrTodateFunction()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String value.
	 */
	public String getTimeFormatFunction()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String value.
	 */
	public String getTimePattern()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param sourceObjectName source object name.
	 * @param selectColumnName select column name.
	 * @param onlyDistinctRows boolean value.
	 * @return List.
	 * @throws DAOException throw DAOException
	 */
	public List<Object> retrieve(String sourceObjectName, String[] selectColumnName,
			boolean onlyDistinctRows) throws DAOException
			{
		// TODO Auto-generated method stub
		return null;
			}
	/**
	 * @param sourceObjectName source object name.
	 * @param selectColumnName select column name.
	 * @param queryWhereClauseImpl QueryWhereClause object.
	 * @param onlyDistinctRows boolean value.
	 * @return List.
	 * @throws DAOException throw DAOException
	 */
	public List<Object> retrieve(String sourceObjectName, String[] selectColumnName,
			QueryWhereClause queryWhereClauseImpl, boolean onlyDistinctRows) throws DAOException
			{
		// TODO Auto-generated method stub
		return null;
			}
	/**
	 * @throws DAOException throw DAOException.
	 */
	public void closeConnection() throws DAOException
	{
		// TODO Auto-generated method stub

	}
	/**
	 * @return Configuration object.
	 */
	public Configuration getConfiguration()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return connection object
	 * @throws DAOException throw DAOException.
	 */
	public Connection getConnection() throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return SessionFactory object.
	 */
	public SessionFactory getSessionFactory()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param cfg Configuration to set.
	 */
	public void setConfiguration(Configuration cfg)
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param sessionFactory SessionFactory object to set.
	 */
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		// TODO Auto-generated method stub
	}
	//////////////////////////////////
	/**
	 * This member will store the Connection Manager name.
	 */
	private String connectionManagerName;

	/**
	 * This member will store the Default DAO class name.
	 * TODO
	 */
	private String defaultDAOClassName;
	/**
	 * This member will store the JDBC DAO class name.
	 * TODO
	 */
	private String jdbcDAOClassName;
	/**
	 * This member will store the name of the application.
	 */
	private String applicationName;
	/**
	 * This member will store the configuration file name.
	 */
	private String configurationFile;

	/**
	 * This member will store the connectionManager instance.
	 */
	private IConnectionManager connectionManager;


	/**
	 * This will store the default setting for DAO factory(true / false).
	 */
	private Boolean isDefaultDAOFactory;
	/**
	 * @param arg0 String argument.
	 * @return List.
	 * @throws DAOException throw DAOException.
	 */
	public List executeQuery(String arg0) throws DAOException
	{
		List<String> innerList= new ArrayList<String>();
		innerList.add("Name");
		innerList.add("Id");
		List<List<String>> list= new ArrayList<List<String>>();
		list.add(innerList);
		return list;
	}
	/**
	 * @return String object.
	 */
	public String getDataSource()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String object.
	 */
	public String getDefaultConnMangrName()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String object.
	 */
	public String getJdbcConnMangrName()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param arg0 String value to set.
	 */
	public void setDataSource(String arg0)
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param arg0 String value to set.
	 */
	public void setDefaultConnMangrName(String arg0)
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param arg0 String value to set.
	 */
	public void setJdbcConnMangrName(String arg0)
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param sourceObjectName source object name.
	 * @param identifier identifier.
	 * @return Object.
	 * @throws DAOException throw DAOException.
	 */
	public Object retrieveById(String sourceObjectName, Long identifier) throws DAOException
	{
		// TODO Auto-generated method stub
		return getObject();
	}
	/**
	 * @param queryName Query name.
	 * @param namedQueryParams Named parameters.
	 * @return List.
	 * @throws DAOException throw DAOException
	 */
	public List executeNamedQuery(String queryName, Map<String, NamedQueryParam> namedQueryParams)
	throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return String value.
	 */
	public String getDataBaseType()
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param databaseProperties databaseProperties to set.
	 */
	public void setDatabaseProperties(DatabaseProperties databaseProperties)
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param tableName Table name.
	 * @throws DAOException throw DAOException.
	 */
	public void deleteTable(String tableName) throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param tableName Table name.
	 * @return ResultSet.
	 * @throws DAOException throw DAOException.
	 */
	public ResultSet getDBMetaDataResultSet(String tableName) throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param query String value.
	 * @return Prepared statement object.
	 * @throws DAOException throw DAOException.
	 */
	public PreparedStatement getPreparedStatement(String query) throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param sql String value.
	 * @return ResultSet.
	 * @throws DAOException throw DAOException.
	 */
	public ResultSet getQueryResultSet(String sql) throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param sourceObjectName Source object name.
	 * @param selectColumnName Select column name.
	 * @param queryWhereClause QuerywhereClause object.
	 * @param onlyDistinctRows boolean value.
	 * @return ResultSet.
	 * @throws DAOException throw DAOException.
	 */
	public ResultSet retrieveResultSet(String sourceObjectName, String[] selectColumnName,
			QueryWhereClause queryWhereClause, boolean onlyDistinctRows) throws DAOException
			{
		// TODO Auto-generated method stub
		return null;
			}
	/**
	 * @param batchSize batch size.
	 * @throws DAOException throw DAOException.
	 */
	public void setBatchSize(int batchSize) throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @return Session object.
	 * @throws DAOException throw DAOException.
	 */
	public Session getSession() throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param sql String value.
	 * @return StatementData.
	 * @throws DAOException throw DAOException.
	 */
	public StatementData executeUpdate(String sql) throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param resultSet ResultSet object
	 * @throws DAOException throw DAOException.
	 */
	public void closeStatement(ResultSet resultSet) throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @throws DAOException throw DAOException.
	 */
	public void batchClose() throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @throws DAOException throw DAOException.
	 */
	public void batchCommit() throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param batchSize batch size.
	 * @param tableName table name.
	 * @param columnSet column set.
	 * @throws DAOException throw DAOException.
	 */
	public void batchInitialize(int batchSize, String tableName, SortedSet<String> columnSet)
	throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param dataMap Map object.
	 * @throws DAOException throw DAOException.
	 */
	public void batchInsert(SortedMap<String, ColumnValueBean> dataMap) throws DAOException
	{
		// TODO Auto-generated method stub
	}
	/**
	 * @param tableName table name.
	 * @param columnValueBeanSet LinkedList object.
	 * @return StatementData.
	 * @throws DAOException throw DAOException.
	 */
	public StatementData executeUpdate(String tableName,
			LinkedList<ColumnValueBean> columnValueBeanSet) throws DAOException
			{
		// TODO Auto-generated method stub
		return null;
			}
	/**
	 * @param query String value.
	 * @param startIndex Start index.
	 * @param maxRecords maximum records.
	 * @param paramValues paramValues.
	 * @return List object.
	 * @throws DAOException throw DAOException.
	 */
	public List executeQuery(String query, Integer startIndex,
			Integer maxRecords, LinkedList paramValues) throws DAOException
			{
		// TODO Auto-generated method stub
		return null;
			}
	/**
	 * @param arg0 Object.
	 * @throws DAOException throw DAOException.
	 */
	public void insert(Object arg0) throws DAOException
	{
		if(isTestForFail)
		{
			throwDaoException();
		}
	}
	/**
	 * @param arg0 String value.
	 * @return StatementData object
	 * @throws DAOException throw DAOException.
	 */
	public StatementData executeUpdateWithGeneratedKey(String arg0) throws DAOException
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @throws DAOException throw DAOException.
	 */
	public void beginTransaction() throws DAOException
	{
		// TODO Auto-generated method stub
	}
	public List executeQuery(String arg0, Integer arg1,
			LinkedList<ColumnValueBean> arg2) throws DAOException 
			{
		// TODO Auto-generated method stub
		return null;
			}
	public void executeUpdate(String arg0,
			LinkedList<LinkedList<ColumnValueBean>> arg1) throws DAOException
			{
		// TODO Auto-generated method stub

			}
	public ResultSet getResultSet(String arg0,
			LinkedList<ColumnValueBean> arg1, Integer arg2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List retrieve(String arg0, String[] arg1, QueryWhereClause arg2,
			LinkedList<ColumnValueBean> arg3) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List retrieve(String arg0, String arg1, Object arg2,
			LinkedList<ColumnValueBean> arg3) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List retrieve(String arg0, String[] arg1, QueryWhereClause arg2,
			LinkedList<ColumnValueBean> arg3, boolean arg4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultSet retrieveResultSet(String arg0, String[] arg1,
			QueryWhereClause arg2, LinkedList<ColumnValueBean> arg3,
			boolean arg4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public void update(Object arg0, Object arg1) throws DAOException
	{
		throwDaoException();
	}
	public List executeQuery(String arg0, Integer arg1, Integer arg2, List arg3)
	throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List executeQuery(String arg0, Integer arg1,
			List<ColumnValueBean> arg2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public StatementData executeUpdate(String arg0, List<ColumnValueBean> arg1)
	throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public void executeUpdate(String arg0,
			List<LinkedList<ColumnValueBean>> arg1) throws DAOException {
		// TODO Auto-generated method stub

	}
	public ResultSet getResultSet(String arg0, List<ColumnValueBean> arg1,
			Integer arg2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List retrieve(String arg0, String[] arg1, QueryWhereClause arg2,
			List<ColumnValueBean> arg3) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List retrieve(String arg0, String[] arg1, QueryWhereClause arg2,
			List<ColumnValueBean> arg3, boolean arg4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public ResultSet retrieveResultSet(String arg0, String[] arg1,
			QueryWhereClause arg2, List<ColumnValueBean> arg3, boolean arg4)
	throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public HibernateMetaData getHibernateMetaData() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setHibernateMetaData(HibernateMetaData arg0) {
		// TODO Auto-generated method stub

	}
	public DatabaseProperties getDatabaseProperties() {
		// TODO Auto-generated method stub
		return null;
	}
	public List executeQuery(String arg0, List<ColumnValueBean> arg1)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List executeParamHQL(String arg0, List<ColumnValueBean> arg1)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public void auditLoginEvents(boolean arg0, LoginDetails arg1)
			throws AuditException {
		// TODO Auto-generated method stub
		
	}
	public List retrieve(String arg0, ColumnValueBean arg1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List retrieve(String arg0, String[] arg1, QueryWhereClause arg2,
			boolean arg3, List<ColumnValueBean> arg4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public List retrieveAttribute(Class arg0, ColumnValueBean arg1, String arg2)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
