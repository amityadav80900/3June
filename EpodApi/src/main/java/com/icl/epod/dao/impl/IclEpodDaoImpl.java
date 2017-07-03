package com.icl.epod.dao.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icl.epod.dao.IclEpodDao;
import com.icl.epod.entity.AddressEntity;
import com.icl.epod.entity.CarrierEntity;
import com.icl.epod.entity.UserEntity;
import com.icl.epod.model.AddressModel;
import com.icl.epod.util.HibernateUtil;

/**
 * @author Vijendra.y
 *
 */

@Repository
public class IclEpodDaoImpl implements IclEpodDao {

	@Autowired
	private HibernateUtil hibernateUtil;
	private static final Logger logger = Logger.getLogger(IclEpodDaoImpl.class);

	@Override
	public Integer addCarrier(CarrierEntity entity) {
		logger.debug("EpodAPI IclEpodDaoImpl addCarrier  Enter");
		return (Integer) hibernateUtil.create(entity);
	}

	@Override
	public Integer addAddress(AddressEntity entity) {
		logger.debug("EpodAPI IclEpodDaoImpl addAddress  Enter");
		return (Integer) hibernateUtil.create(entity);
	}

	/**
	 * Generic Method for fetch by key
	 *
	 */
	@Override
	public <T> T fetchByKey(Serializable id, Class<T> entityClass) {
		logger.debug("EpodAPI IclEpodDaoImpl fetchByKey  Enter");
		return hibernateUtil.fetchById(id, entityClass);
	}

}
