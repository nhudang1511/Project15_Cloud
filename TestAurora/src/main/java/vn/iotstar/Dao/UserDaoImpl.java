package vn.iotstar.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.JPAConfig.JpaConfig;
import vn.iotstar.entity.User;

public class UserDaoImpl implements IUserDao {
	@Override
	public void insert(User user) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	@Override
	public void delete(int id) throws Exception {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User user = enma.find(User.class, id);

			if (user != null) {
				enma.remove(user);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	@Override
	public List<User> findAll()
	{
		EntityManager enma = JpaConfig.getEntityManager();

		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);

		return query.getResultList();
	}
	@Override
	public User findById(int userId) {

		EntityManager enma = JpaConfig.getEntityManager();

		User user = enma.find(User.class, userId);

		return user;

	}
	@Override
	public void update(User user) {
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	@Override
	public List<User> findByRole(int isRole) {

		EntityManager enma = JpaConfig.getEntityManager();

		String jpql = "select u from User u where u.isRole like :isRole";

		Query query = enma.createQuery(jpql, User.class);

		query.setParameter("isRole", isRole);

		return query.getResultList();

	}
}
