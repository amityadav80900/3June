package com.icl.epod.service;

import com.icl.epod.model.AddressModel;
import com.icl.epod.model.CarrierModel;
import com.icl.epod.model.UserModel;

/**
 * @author Vijendra.y
 *
 */
public interface IclEpodService {
	
	Integer addCarrier(CarrierModel model);

	Integer addAddress(AddressModel model);
	
	

}
