package duchien.com.controller.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import duchien.com.model.Category;
import duchien.com.model.User;
import duchien.com.service.CategoryService;
import duchien.com.service.UserService;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/edit" })
public class CategoryeEditController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category category = null;
		try {
			category = cateService.get(Integer.parseInt(id));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("category", category);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/category/edit-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Category category = new Category();
		category.setId(Integer.parseInt(req.getParameter("id")));
		category.setName(req.getParameter("name"));
		try {
			cateService.edit(category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/category/list");

	}
}
