package vn.iotstar.Dao;

import java.util.List;

import vn.iotstar.entity.User;

public interface IUserDao {

	List<User> findByRole(int isRole);

	void update(User user);

	User findById(int userId);

	List<User> findAll();

	void delete(int id) throws Exception;

	void insert(User user);

}
