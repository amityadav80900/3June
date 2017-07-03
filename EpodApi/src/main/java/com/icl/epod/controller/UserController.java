
package com.icl.epod.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icl.epod.entity.UserEntity;
import com.icl.epod.model.AddressModel;
import com.icl.epod.model.CarrierModel;
import com.icl.epod.model.ResponseModel;
import com.icl.epod.model.UserModel;

import com.icl.epod.service.UserEpodService;

/**
 * @author Amit.Yadav
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserEpodService userService;
	private static final Logger logger = Logger.getLogger(UserController.class);

	// ----- Create New User method-----

	@RequestMapping(value = "/resource-inventory/api/v1/saveIclUser", method = RequestMethod.POST, produces = {
			"application/json", "application/xml" }, consumes = { "application/json", "application/xml" })
	public ResponseModel createIclUser(@RequestBody UserModel model) {

		ResponseModel rm = new ResponseModel();
		try {
			logger.debug("EpodAPI Controller saveIclUser Enter");

			System.out.println(model.getUserId());
			UserEntity userExits = userService.findById(model.getUserId());
			System.out.println(userExits);
			if (userExits != null) {
				System.out.println("inside...");
				rm.setSuccess("User Already Register..");
				rm.setRecordNumber(model.getUserId());
				rm.setFailure("No Exception");
				System.out.println("User Already Register..");
			}
			
			/*boolean userExist=userService.isUserExist(model);
			if (userExist) {
	            System.out.println("A User with name " + model.getUserId() + " already exist");
	            rm.setSuccess("User Already Register..");
				rm.setRecordNumber(model.getUserId());
				rm.setFailure("No Exception");
				System.out.println("User Already Register..");
	       
	        }*/
			else {
				Integer recordVal = userService.saveIclUser(model);
				if (recordVal != null) {
					rm.setSuccess("success");
					rm.setRecordNumber(recordVal);
					rm.setFailure("No Exception");
				}
				logger.debug("EpodAPI Controller saveIclUser Exits");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			rm.setFailure("Error while deleting record" + e.getMessage());
			e.printStackTrace();
		}
		return rm;
	}

	// ----- Update method-----

	@RequestMapping(value = "/resource-inventory/api/v1/updateIclUser", method = RequestMethod.PUT, produces = {
			"application/json", "application/xml" }, consumes = { "application/json", "application/xml" })
	public ResponseModel updateIclUser(@RequestBody UserModel model) {

		ResponseModel rm = new ResponseModel();
		try {
			logger.debug("EpodAPI Controller saveIclUser Enter");
			UserEntity user = userService.updateIclUser(model);
			Integer recordVal = user.getUserId();
			if (recordVal != null) {
				rm.setSuccess("Record Updated SuccessFully..");
				rm.setRecordNumber(recordVal);
				rm.setFailure("No Exception");
			}
			logger.debug("EpodAPI Controller saveIclUser Exits");
		} catch (Exception e) {
			logger.error(e.getMessage());
			rm.setFailure("Error while deleting record" + e.getMessage());
			e.printStackTrace();
		}
		return rm;
	}

	// ------------------- Delete a User
	// --------------------------------------------------------

	@RequestMapping(value = "/resource-inventory/api/v1/deleteIclUser/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<UserEntity> deleteUser(@PathVariable("userId") Integer userId) {
		System.out.println("Fetching & Deleting User with id " + userId);

		UserEntity user = userService.findById(userId);
		if (user == null) {
			System.out.println("Unable to delete. User with id " + userId + " not found");
			return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(userId);
		System.out.println("User with userId " + userId + "Delted Successfully..");
		return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);

	}

	// ------------------- Delete All Users
	// --------------------------------------------------------

	@RequestMapping(value = "/resource-inventory/api/v1/deleteIclUser/", method = RequestMethod.DELETE)
	public ResponseEntity<UserEntity> deleteAllUsers() {
		System.out.println("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
	}
}
