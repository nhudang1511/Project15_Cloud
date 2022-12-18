package vn.iotstar.Dao;

import java.util.List;

import vn.iotstar.entity.Product;

public interface IProductDao {

	int count();

	List<Product> findByProductname(String proname);

	List<Product> findAll(int page, int pagesize);

	List<Product> findAll();

	Product findById(int productId);

	void delete(int pid) throws Exception;

	void update(Product product);

	void insert(Product product);

}
