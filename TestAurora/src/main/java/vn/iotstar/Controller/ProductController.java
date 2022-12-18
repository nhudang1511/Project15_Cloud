package vn.iotstar.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vn.iotstar.Service.IProductService;
import vn.iotstar.entity.Product;
import vn.iotstar.util.Constant;
import vn.iotstar.util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin/product", "/admin/product-create", "/admin/product-update",
		"/admin/product-edit", "/admin/product-delete", "/admin/product-reset" })
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	private IProductService productService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng

				// lấy url

				String url = request.getRequestURL().toString();
				Product product = null;
				
				if (url.contains("product-create")) {

					request.getRequestDispatcher("/views/admin/product/add.jsp").forward(request, response);

				} else if (url.contains("product-delete")) {

					delete(request, response);

					product = new Product();

					request.setAttribute("product", product);

				} else if (url.contains("product-edit")) {

					edit(request, response);

				} else if (url.contains("product-reset")) {

					product = new Product();

					request.setAttribute("product", product);

				}
				// gọi hàm findAll để lấy thông tin từ entity

				findAll(request, response);

				request.setAttribute("tag", "pro");

				request.getRequestDispatcher("/views/admin/product/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lấy url

				String url = request.getRequestURL().toString();

				// kiểm tra url rồi chuyển đến hàm tương ứng

				if (url.contains("product-create")) {

					insert(request, response);

				} else if (url.contains("product-update")) {

					update(request, response);

				} else if (url.contains("product-delete")) {

					delete(request, response);

				} else if (url.contains("product-reset")) {

					request.setAttribute("product", new Product());

				}

				// gọi hàm findAll để lấy thông tin từ entity

				findAll(request, response);

				request.getRequestDispatcher("/views/admin/product/list.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");

			// khỏi tạo đối tượng Model

			Product product = new Product();

			// sử dụng BeanUtils để tự lấy các name Field trên form

			// tên field phải trùng với entity

			BeanUtils.populate(product, request.getParameterMap());
			
			// xử lý hình ảnh

			String fileName = product.getName() + System.currentTimeMillis();

			product.setImage(UploadUtils.processUpload("image", request, Constant.DIR + "\\product\\", fileName));
			// gọi hàm insert để thêm dữ liệu

			productService.insert(product);
			request.setAttribute("message", "Đã thêm thành công");

			// thông báo

			
		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<Product> list = productService.findAll();

			// thông báo

			request.setAttribute("products", list);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// khai báo biến userId

			String productId = request.getParameter("productId");

			// khởi tạo DAO

			// gọi hàm insert để thêm dữ liệu

			Product product = productService.findById(Integer.parseInt(productId));

			// thông báo

			request.setAttribute("product", product);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			// lấy dữ liệu trong jsp

			String productId = request.getParameter("productId");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			productService.delete(Integer.parseInt(productId));

			// thông báo

			request.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");

			// lấy dữ liệu từ jsp bằng BeanUtils

			Product product = new Product();

			BeanUtils.populate(product, request.getParameterMap());

			// khởi tạo DAO

			Product oldpro = productService.findById(product.getId());
			
			// xử lý hình ảnh

			if (request.getPart("image").getSize() == 0) {

				product.setImage(oldpro.getImage());

			} else {

				if (oldpro.getImage() != null) {

				// XOA ANH CU DI

				String fileName = oldpro.getImage();

				File file = new File(Constant.DIR + "\\product\\" + fileName);

				if (file.delete()) {

					System.out.println("Đã xóa thành công");

				} else {

					System.out.println(Constant.DIR + "\\product\\" + fileName);

						}
				}

				String fileName = product.getName() + System.currentTimeMillis();

				product.setImage(UploadUtils.processUpload("image", request, Constant.DIR + "\\product\\", fileName));

			}

			// khai báo danh sách và gọi hàm update trong service

			productService.update(product);

			// thông báo

			request.setAttribute("product", product);

			request.setAttribute("message", "Cập nhật thành công!");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
	
}
