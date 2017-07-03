package com.icl.epod.service;

import com.icl.epod.entity.UserEntity;
import com.icl.epod.model.UserModel;

/**
 * @author Amit.Yadav
 *
 */
public interface UserEpodService {

	Integer saveIclUser(UserModel model);

	void deleteAllUsers();

	void deleteUserById(Integer userId);

	UserEntity updateIclUser(UserModel model);

	UserEntity findById(Integer userId);

	boolean isUserExist(UserModel model);

	

}
