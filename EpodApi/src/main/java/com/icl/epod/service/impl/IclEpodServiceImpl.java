package com.icl.epod.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icl.epod.dao.IclEpodDao;
import com.icl.epod.entity.AddressEntity;
import com.icl.epod.entity.CarrierEntity;
import com.icl.epod.model.AddressModel;
import com.icl.epod.model.CarrierModel;
import com.icl.epod.model.UserModel;
import com.icl.epod.service.IclEpodService;
import com.icl.epod.util.CommonUtils;

/**
 * @author Vijendra.y
 *
 */
@Service
public class IclEpodServiceImpl implements IclEpodService {
	@Autowired
	private IclEpodDao epodDao;
	@Autowired
	private CommonUtils commonUtils;
	private static final Logger logger = Logger.getLogger(IclEpodServiceImpl.class);

	@Override
	public Integer addCarrier(CarrierModel model) {
		logger.debug("EpodAPI IclEpodServiceImpl addCarrier  Enter");
		CarrierEntity carrierEntity = null;
		if (model != null) {
			AddressEntity addressEntity = null;
			if (model.getAddressId() != null) {
				addressEntity = epodDao.fetchByKey(Integer.parseInt(model.getAddressId()),AddressEntity.class);
			}
			carrierEntity = commonUtils.carrierModeToEntity(model);
			carrierEntity.setAddressEntity(addressEntity);
		}
		return epodDao.addCarrier(carrierEntity);
	}

	@Override
	public Integer addAddress(AddressModel model) {
		logger.debug("EpodAPI IclEpodServiceImpl addAddress  Enter");
		AddressEntity addressEntity = null;
		if (model != null) {				
				addressEntity = commonUtils.addressrModeToEntity(model);			
		}
		return epodDao.addAddress(addressEntity);
	}
	
}
