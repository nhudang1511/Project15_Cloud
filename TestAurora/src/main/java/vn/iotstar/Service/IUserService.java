package vn.iotstar.Service;

import java.util.List;

import javax.inject.Inject;

import vn.iotstar.Dao.IUserDao;
import vn.iotstar.entity.User;

public interface IUserService {

	List<User> findByRole(int isRole);

	void update(User user);

	User findById(int userId);

	List<User> findAll();

	void delete(int userId) throws Exception;

	void insert(User user);


	
}
