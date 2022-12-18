package vn.iotstar.Service.Impl;

import java.util.List;

import javax.inject.Inject;

import vn.iotstar.Dao.IProductDao;
import vn.iotstar.Service.IProductService;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;

public class ProductServiceImpl implements IProductService{

	@Inject
	private IProductDao productDao;
	
	@Override
	public void insert(Product product) {

		productDao.insert(product);

	}

	@Override
	public void update(Product product) {

		productDao.update(product);

	}

	@Override
	public void delete(int pid) throws Exception {

		productDao.delete(pid);

	}

	@Override
	public Product findById(int pid) {

		return productDao.findById(pid);

	}

	@Override
	public List<Product> findAll() {

		return productDao.findAll();

	}

	@Override
	public List<Product> findByProductname(String pname) {

		return productDao.findByProductname(pname);

	}

	@Override
	public List<Product> findAll(int page, int pagesize) {

		return productDao.findAll(page, pagesize);

	}

	@Override
	public int count() {

		return productDao.count();

	}
}
