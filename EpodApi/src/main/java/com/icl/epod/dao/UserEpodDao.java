package com.icl.epod.dao;

import java.util.List;

import com.icl.epod.entity.UserEntity;
import com.icl.epod.model.UserModel;

/**
 * @author Amit.Yadav
 *
 */
public interface UserEpodDao {

	Integer saveIclUser(UserEntity userModeToEntity);

	UserEntity findById(Integer id);

	List<UserModel> findAllUser();

	void deleteUserById(Integer id);

	void deleteAllUsers();

	UserEntity updateIclUser(UserEntity userModeToEntity);

	boolean isUserExist(UserModel user);

	boolean isUserExist(Integer userId);

}
