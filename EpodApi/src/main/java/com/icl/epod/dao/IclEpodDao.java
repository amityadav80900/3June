package com.icl.epod.dao;

import java.io.Serializable;

import com.icl.epod.entity.AddressEntity;
import com.icl.epod.entity.CarrierEntity;
import com.icl.epod.entity.UserEntity;

/**
 * @author Vijendra.y
 *
 */
public interface IclEpodDao {

	Integer addCarrier(CarrierEntity entity);

	Integer addAddress(AddressEntity addressEntity);

	public <T> T fetchByKey(Serializable id, Class<T> entityClass);


	

}
