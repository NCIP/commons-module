/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.util;

import java.util.ArrayList;
import java.util.List;

import edu.wustl.common.idgenerator.KeySequenceGenerator;
import edu.wustl.common.util.global.CommonServiceLocator;
import edu.wustl.common.util.logger.Logger;
import edu.wustl.dao.DAO;
import edu.wustl.dao.daofactory.DAOConfigFactory;
import edu.wustl.dao.daofactory.IDAOFactory;
import edu.wustl.dao.exception.DAOException;
import edu.wustl.dao.query.generator.ColumnValueBean;

/**
 * @author shital_lawhale, suhas_khot
 *
 */
public final class KeySequenceGeneratorUtil
{/*
* Static instance of the id generator.
*/

	private static final Logger LOGGER = Logger.getCommonLogger(KeySequenceGeneratorUtil.class);

	private static KeySequenceGeneratorUtil keySeqGenerator;

	/**
	 * Private constructor used for making this class singleton
	 */
	private KeySequenceGeneratorUtil()
	{
	}

	/**
	 * Returns the instance of the KeySequenceIdGenerator class.
	 * @return keySeqGenerator singleton instance of the KeySequenceIdGenerator.
	 */
	public static synchronized KeySequenceGeneratorUtil getInstance()
	{
		if (keySeqGenerator == null)
		{
			keySeqGenerator = new KeySequenceGeneratorUtil();
		}
		return keySeqGenerator;
	}

	/**
	 * @return next available id
	 * @throws DAOException
	 * @throws Exception any exception occurred
	 */
	@SuppressWarnings("unchecked")
	public static synchronized Long getNextUniqeId(final String key, final String type)
			throws DAOException
	{
		Long nextAvailableId = null;
		DAO dao = null;
		try
		{
			KeySequenceGenerator keySeqObject = new KeySequenceGenerator();
			final List<ColumnValueBean> columnValueBeans = new ArrayList<ColumnValueBean>();
			columnValueBeans.add(new ColumnValueBean(key));
			columnValueBeans.add(new ColumnValueBean(type));
			final String appName = CommonServiceLocator.getInstance().getAppName();
			final IDAOFactory daoFactory = DAOConfigFactory.getInstance().getDAOFactory(appName);
			dao = daoFactory.getDAO();
			dao.openSession(null);
			final List<KeySequenceGenerator> list = dao.executeQuery("from "
					+ KeySequenceGenerator.class.getName() + " where keyValue = ? and keyType = ?",
					columnValueBeans);
			if (list.isEmpty())
			{
				nextAvailableId = Long.valueOf(1);
				keySeqObject.setKeySequenceId(Long.valueOf(2).toString());
				keySeqObject.setKeyValue(key);
				keySeqObject.setKeyType(type);
				dao.insert(keySeqObject);
			}
			else
			{
				keySeqObject = list.get(0);
				nextAvailableId = Long.valueOf(keySeqObject.getKeySequenceId());
				keySeqObject.setKeySequenceId(Long.valueOf(nextAvailableId + 1).toString());
				dao.update(keySeqObject);
			}
			dao.commit();
		}
		catch (DAOException e)
		{
			LOGGER.info("KeySequenceGenerator ::", e);
			throw new DAOException(null, e, e.getMsgValues());
		}
		finally
		{
			dao.closeSession();
		}
		return nextAvailableId;
	}

}
