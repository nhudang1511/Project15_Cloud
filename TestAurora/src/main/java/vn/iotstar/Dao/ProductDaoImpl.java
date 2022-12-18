package vn.iotstar.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.JPAConfig.JpaConfig;
import vn.iotstar.entity.Product;


public class ProductDaoImpl implements IProductDao{

	@Override
	public void insert(Product product) {

		EntityManager enma = JpaConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(product);

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
	public void update(Product product) {

		EntityManager enma = JpaConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(product);

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
	public void delete(int pid) throws Exception {

		EntityManager enma = JpaConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			Product product = enma.find(Product.class, pid);

			if (product != null) {

				enma.remove(product);

			} else {

				throw new Exception("Không tìm thấy sản phẩm");

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
	public Product findById(int productId) {

		EntityManager enma = JpaConfig.getEntityManager();

		Product product = enma.find(Product.class, productId);

		return product;

	}

	@Override
	public List<Product> findAll() {

		EntityManager enma = JpaConfig.getEntityManager();

		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);

		return query.getResultList();

	}

	@Override
	public List<Product> findAll(int page, int pagesize) {

		EntityManager enma = JpaConfig.getEntityManager();

		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);

		query.setFirstResult(page * pagesize);

		query.setMaxResults(pagesize);

		return query.getResultList();

	}

	@Override
	public List<Product> findByProductname(String proname) {

		EntityManager enma = JpaConfig.getEntityManager();

		String jpql = "SELECT p FROM Product p WHERE p.name like :proname";

		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);

		query.setParameter("proname", "%" + proname + "%");

		return query.getResultList();

	}

	@Override
	public int count() {

		EntityManager enma = JpaConfig.getEntityManager();

		String jpql = "SELECT count(p) FROM Product p";

		Query query = enma.createQuery(jpql);

		return ((Long) query.getSingleResult()).intValue();

	}
}
