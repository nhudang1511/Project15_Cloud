package vn.iotstar.Service.Impl;

import java.util.List;

import javax.inject.Inject;

import vn.iotstar.Dao.IUserDao;
import vn.iotstar.Service.IUserService;
import vn.iotstar.entity.User;


public class UserServiceImpl implements IUserService {
	@Inject
	IUserDao userDao;
	
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}
	@Override
	public void delete(int userId) throws Exception {

		userDao.delete(userId);

	}
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	@Override
	public User findById(int userId) {
		return userDao.findById(userId);
	}
	@Override
	public void update(User user) {
		userDao.update(user);
		
	}
	@Override
	public List<User> findByRole(int isRole) {
		return userDao.findByRole(isRole);
	}

}
