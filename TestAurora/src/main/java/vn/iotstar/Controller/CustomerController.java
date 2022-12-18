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

import vn.iotstar.Service.ICategoryService;
import vn.iotstar.Service.IUserService;
import vn.iotstar.entity.User;
import vn.iotstar.util.Constant;
import vn.iotstar.util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin-customer", "/admin-customer/create", "/admin-customer/update",
		"/admin-customer/edit", "/admin-customer/delete", "/admin-customer/reset"})
public class CustomerController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		User customer = null;
		if(url.contains("create"))
		{
			req.getRequestDispatcher("/views/admin/customer/add.jsp").forward(req, resp);
		}
		else if(url.contains("delete")) {
			delete(req,resp);
			customer = new User();
			req.setAttribute("customer", customer);
		} else if (url.contains("edit")) {
		      edit(req, resp);
		}

		else if (url.contains("reset")) {
			customer = new User();
			req.setAttribute("customer", customer);

		}
		findAll(req,resp);
		req.getRequestDispatcher("/views/admin/customer/list.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("create"))
		{
			insert(req,resp);
		}
		else if(url.contains("delete"))
		{
			delete(req, resp);
		}
		else if (url.contains("update")) {
			update(req, resp);
		}
		else if (url.contains("reset")) {

			req.setAttribute("customer", new User());

		}
		findAll(req,resp);
		req.getRequestDispatcher("/views/admin/customer/list.jsp").forward(req, resp);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			User user = new User();
			
			BeanUtils.populate(user, request.getParameterMap());

			String fileName = user.getEmail() + System.currentTimeMillis();
			user.setImage(UploadUtils.processUpload("image", request, Constant.DIR + "\\customer\\", fileName));
		
			userService.insert(user);

			request.setAttribute("message", "Thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {


			String userId = request.getParameter("userId");
			
			userService.delete(Integer.parseInt(userId));

			request.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}

	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			
			String userId = request.getParameter("userId");
			
			User customer = userService.findById(Integer.parseInt(userId));

			request.setAttribute("customer", customer);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}

	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			List<User> list = userService.findAll();

			request.setAttribute("customers", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
	protected void findbyRole(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		try {
			
			List<User> list = userService.findByRole(3);
		
			request.setAttribute("customers", list);
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
			User customer = new User();
			BeanUtils.populate(customer, request.getParameterMap());
			
			User oldcate = userService.findById(customer.getId());
		
			if (request.getPart("image").getSize() == 0) {
				customer.setImage(oldcate.getImage());
			} else {
				if (oldcate.getImage() != null) {
					// XOA ANH CU DI
					String fileName = oldcate.getImage();
					File file = new File(Constant.DIR + "\\customer\\" + fileName);
					if (file.delete()) {
						System.out.println("cập nhật thành công");
					} else {
						System.out.println(Constant.DIR + "\\customer\\" + fileName);
					}
				}
				String fileName = customer.getEmail() + System.currentTimeMillis();
				customer.setImage(
						UploadUtils.processUpload("image", request, Constant.DIR + "\\customer\\", fileName));
			
			}
			userService.update(customer);
			// thÃ´ng bÃ¡o
			request.setAttribute("customer",customer);
			request.setAttribute("message", "cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
