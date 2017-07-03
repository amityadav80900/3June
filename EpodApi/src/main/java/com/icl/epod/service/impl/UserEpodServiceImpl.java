package com.icl.epod.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icl.epod.dao.IclEpodDao;
import com.icl.epod.dao.UserEpodDao;
import com.icl.epod.entity.AddressEntity;
import com.icl.epod.entity.CarrierEntity;
import com.icl.epod.entity.UserEntity;
import com.icl.epod.model.AddressModel;
import com.icl.epod.model.CarrierModel;
import com.icl.epod.model.UserModel;
import com.icl.epod.service.IclEpodService;
import com.icl.epod.service.UserEpodService;
import com.icl.epod.util.CommonUtils;

/**
 * @author Amit.Yadav
 *
 */
@Service
public class UserEpodServiceImpl implements UserEpodService {
	@Autowired
	private UserEpodDao userDao;
	@Autowired
	private CommonUtils commonUtils;
	private static final Logger logger = Logger.getLogger(UserEpodServiceImpl.class);

	@Override
	public Integer saveIclUser(UserModel model) {
		logger.debug("EpodAPI IclEpodServiceImpl saveIclUser  Enter");
		return userDao.saveIclUser(commonUtils.userModeToEntity(model));
	}


	
	     
	    public List<UserModel> findAllUser() {
	        return userDao.findAllUser();
	    }

		@Override
		public UserEntity findById(Integer userId) {
			// TODO Auto-generated method stub
			return userDao.findById(userId);
		}
		

		@Override
		public void deleteAllUsers() {
			// TODO Auto-generated method stub
			userDao.deleteAllUsers();
			
		}

		
		
		@Override
		public void deleteUserById(Integer userId) {
			// TODO Auto-generated method stub
			 userDao.deleteUserById(userId);
			
		}


		@Override
		public UserEntity updateIclUser(UserModel model) {
			/*UserEntity userEntity = userDao.findById(model.getUserId());
			if (userEntity != null) {
				userEntity.setUserName(model.getUserName());
				userEntity.setPassword(model.getPassword());

				userEntity.setFaxNumber(model.getFaxNumber());

				userEntity.setCreateDate(model.getCreateDate());

				userEntity.setFirstName(model.getFirstName());

				userEntity.setLastName(model.getLastName());

				userEntity.setPhoneNumber(model.getPhoneNumber());

				userEntity.setUpdateDate(model.getUpdateDate());

				userEntity.setCarrierId(model.getCarrierId());

				userEntity.setImageId(model.getImageId());

				userEntity.setUserTypeId(model.getUserTypeId());

			}
			return 1;*/
			
			logger.debug("EpodAPI IclEpodServiceImpl saveIclUser  Enter");
			return userDao.updateIclUser(commonUtils.userModeToEntity(model));
		
			
		}


		public boolean isUserExist(UserModel user) {
			//return (userDao.findById(user.getUserId()))!=null;
			
			return userDao.isUserExist(user.getUserId());
		}
		







	    
	 

}
