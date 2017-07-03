package com.icl.epod.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.icl.epod.entity.AddressEntity;
import com.icl.epod.entity.CarrierEntity;
import com.icl.epod.entity.UserEntity;
import com.icl.epod.model.AddressModel;
import com.icl.epod.model.CarrierModel;
import com.icl.epod.model.UserModel;

/**
 * @author Vijendra.y
 *
 */
@Component
public class CommonUtils {
	
	/**
	 * This method will convert Carrier Model To Entity.
	 *
	 */
	public CarrierEntity carrierModeToEntity(CarrierModel model) {
		CarrierEntity entity=new CarrierEntity();
		
		if(model.getCompanyName()!=null){
			entity.setCompanyName(model.getCompanyName());
		}
		if(model.getCompanyAssignedCode()!=null){
			entity.setCompanyAssignedCode(model.getCompanyAssignedCode());
		}
		if(model.getFaxNumber()!=null){
			entity.setFaxNumber(model.getFaxNumber());
		}
		if(model.getTelephoneNumber()!=null){
			entity.setTelephoneNumber(model.getTelephoneNumber());
		}
		if(model.getContactFirstName()!=null){
			entity.setContactFirstName(model.getContactFirstName());
		}
		if(model.getContactLastName()!=null){
			entity.setContactLastName(model.getContactLastName());
		}
		if(model.getContactEmail()!=null){
			entity.setContactEmail(model.getContactEmail());
		}
		entity.setCreatedDate(new Date());	
		return entity;
	}
	
	/**
	 * This method will convert Address Model To Entity.
	 *
	 */
	public AddressEntity addressrModeToEntity(AddressModel model) {
		AddressEntity entity=new AddressEntity();
		
		if(model.getAddressLine1()!=null){
			entity.setAddressLine1(model.getAddressLine1());
		}
		if(model.getAddressLine2()!=null){
			entity.setAddressLine2(model.getAddressLine2());
		}
		if(model.getCity()!=null){
			entity.setCity(model.getCity());
		}
		if(model.getCounty()!=null){
			entity.setCounty(model.getCounty());
		}
		if(model.getState()!=null){
			entity.setState(model.getState());
		}
		if(model.getCountry()!=null){
			entity.setCountry(model.getCountry());
		}
		if(model.getZip()!=null){
			entity.setZip(model.getZip());
		}
		entity.setCreatedDate(new Date());		
		return entity;
	}
	
	
	public UserEntity userModeToEntity(UserModel model) {
		UserEntity userEntity = new UserEntity();
		
		
		
		if (model.getUserId() != null) {
			userEntity.setUserId(model.getUserId());
		}
		if (model.getUserName() != null) {
			userEntity.setUserName(model.getUserName());
		}
		if (model.getPassword() != null) {
			userEntity.setPassword(model.getPassword());
		}
		if (model.getFaxNumber() != null) {
			userEntity.setFaxNumber(model.getFaxNumber());
		}
		if (model.getCreateDate() != null) {
			userEntity.setCreateDate(model.getCreateDate());
		}
		if (model.getFirstName() != null) {
			userEntity.setFirstName(model.getFirstName());
		}
		if (model.getLastName() != null) {
			userEntity.setLastName(model.getLastName());
		}
		if (model.getPhoneNumber() != null) {
			userEntity.setPhoneNumber(model.getPhoneNumber());
		}
		if (model.getUpdateDate() != null) {
			userEntity.setUpdateDate(model.getUpdateDate());
		}
		if (model.getCarrierId() != null) {
			userEntity.setCarrierId(model.getCarrierId());
		}
		if (model.getImageId() != null) {
			userEntity.setImageId(model.getImageId());
		}
		if (model.getUserTypeId() != null) {
			userEntity.setUserTypeId(model.getUserTypeId());
		}

		return userEntity;
	}
	
}
	
	

