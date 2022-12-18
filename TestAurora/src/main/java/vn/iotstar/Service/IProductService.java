package vn.iotstar.Service;

import java.util.List;

import vn.iotstar.entity.Product;

public interface IProductService {

	int count();

	List<Product> findAll(int page, int pagesize);

	List<Product> findByProductname(String pname);

	List<Product> findAll();

	Product findById(int pid);

	void delete(int pid) throws Exception;

	void update(Product product);

	void insert(Product product);

}
