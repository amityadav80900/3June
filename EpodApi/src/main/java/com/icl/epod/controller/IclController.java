
package com.icl.epod.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icl.epod.model.AddressModel;
import com.icl.epod.model.CarrierModel;
import com.icl.epod.model.ResponseModel;
import com.icl.epod.model.UserModel;
import com.icl.epod.service.IclEpodService;

/**
 * @author Vijendra.y
 *
 */
@RestController
public class IclController {

	@Autowired
	private IclEpodService epodService;		
	private static final Logger logger = Logger.getLogger(IclController.class);	
	
	/**
	 * Add Carrier method
	 *
	 */
	@RequestMapping(value = "/resource-inventory/api/addCarrier", method = RequestMethod.POST, produces = { "application/json", "application/xml"},
			consumes = { "application/json", "application/xml" })
	public ResponseModel addCarrier(@RequestBody CarrierModel model) {
		ResponseModel rm = new ResponseModel();
		try {			
			logger.debug("EpodAPI Controller addCarrier Enter");
			Integer recordVal = epodService.addCarrier(model);
				if (recordVal != null) 
				{
					rm.setSuccess("success");
					rm.setRecordNumber(recordVal);
					rm.setFailure("No Exception");
				}
			logger.debug("EpodAPI Controller addCarrier Exits");
		} catch (Exception e) {			
			logger.error(e.getMessage());
			rm.setFailure("Error while deleting record"+e.getMessage());
			e.printStackTrace();
		}
		return rm;
	}	
	
	
	/**
	 * Add Address method
	 *
	 */	
	@RequestMapping(value = "/resource-inventory/api/addAddress", method = RequestMethod.POST, produces = { "application/json", "application/xml"},
			consumes = { "application/json", "application/xml" })
	public ResponseModel addAddress(@RequestBody AddressModel model) {
		ResponseModel rm = new ResponseModel();
		try {			
			logger.debug("EpodAPI Controller addAddress Enter");
			Integer recordVal = epodService.addAddress(model);
				if (recordVal != null) 
				{
					rm.setSuccess("success");
					rm.setRecordNumber(recordVal);
					rm.setFailure("No Exception");
				}
			logger.debug("EpodAPI Controller addAddress Exits");
		} catch (Exception e) {			
			logger.error(e.getMessage());
			rm.setFailure("Error while deleting record"+e.getMessage());
			e.printStackTrace();
		}
		return rm;
	}	
	
	
}
