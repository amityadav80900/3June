package com.icl.epod.dao.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icl.epod.dao.UserEpodDao;
import com.icl.epod.entity.UserEntity;
import com.icl.epod.model.UserModel;
import com.icl.epod.util.HibernateUtil;

/**
 * @author Vijendra.y
 *
 */

@Repository
public class UserEpodDaoImpl implements UserEpodDao {

	@Autowired
	private HibernateUtil hibernateUtil;
	private static final Logger logger = Logger.getLogger(UserEpodDaoImpl.class);

	@Override
	public Integer saveIclUser(UserEntity userModeToEntity) {
		logger.debug("epodapi iclepoddaoimpl saveicluser  enter");
		// return (Integer) hibernateUtil.create(userModeToEntity);
		return (Integer) hibernateUtil.create(userModeToEntity);
	}

	@Override
	public void deleteUserById(Integer userId) {
		// TODO Auto-generated method stub

		hibernateUtil.delete(userId, UserEntity.class);

	}

	@Override
	public List<UserModel> findAllUser() {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchAll(UserEntity.class);
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		hibernateUtil.deleteAllUser();

	}

	@Override
	public UserEntity updateIclUser(UserEntity userModeToEntity) {
		logger.debug("epodapi iclepoddaoimpl saveicluser  enter");
		// return (Integer) hibernateUtil.create(userModeToEntity);
		return (UserEntity) hibernateUtil.update(userModeToEntity);
	}

	@Override
	public UserEntity findById(Integer userId) {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchById(userId, UserEntity.class);
	}

	@Override
	public boolean isUserExist(Integer userId) {
		
		//System.out.println("UseId"+" "+user.getUserId());
		// TODO Auto-generated method stub
		System.out.println();
		return (boolean) hibernateUtil.fetchUserById(userId, UserEntity.class);
	}

	@Override
	public boolean isUserExist(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}
}
