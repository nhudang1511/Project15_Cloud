package vn.iotstar.Controller;

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
import vn.iotstar.entity.Category;


@MultipartConfig
@WebServlet(urlPatterns = { "/admin/category", "/admin/category-create", "/admin/category-update",
		"/admin/category-edit", "/admin/category-delete", "/admin/category-reset" })
public class CategoryController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String url = request.getRequestURL().toString();
				Category category = null;
				
				if (url.contains("category-create")) {

					request.getRequestDispatcher("/views/admin/category/add.jsp").forward(request, response);

				} else if (url.contains("category-delete")) {

					delete(request, response);

					category = new Category();

					request.setAttribute("category", category);

				} else if (url.contains("category-edit")) {

					edit(request, response);

				} else if (url.contains("category-reset")) {

					category = new Category();

					request.setAttribute("category", category);

				}
				

				findAll(request, response);

				request.setAttribute("tag", "cate");

				request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

				String url = request.getRequestURL().toString();

				
				if (url.contains("category-create")) {

					insert(request, response);

				} else if (url.contains("category-update")) {

					update(request, response);

				} else if (url.contains("category-delete")) {

					delete(request, response);

				} else if (url.contains("category-reset")) {

					request.setAttribute("category", new Category());

				}

				

				findAll(request, response);

				request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");

			

			Category category = new Category();


			BeanUtils.populate(category, request.getParameterMap());
			
			categoryService.insert(category);
			request.setAttribute("message", "Thêm thành công");

	

			
		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {


			List<Category> list = categoryService.findAll();

	
			request.setAttribute("categorys", list);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			

			String categoryId = request.getParameter("categoryId");

			

			Category category = categoryService.findById(Integer.parseInt(categoryId));

			

			request.setAttribute("category", category);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {


			String categoryId = request.getParameter("categoryId");

			

			categoryService.delete(Integer.parseInt(categoryId));


			request.setAttribute("message", "Xóa thành công ");

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

			

			Category category = new Category();

			BeanUtils.populate(category, request.getParameterMap());

			

			Category oldcate = categoryService.findById(category.getId());

		
			categoryService.update(category);

		

			request.setAttribute("category", category);

			request.setAttribute("message", "Cập nhật thành công!");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}
}
