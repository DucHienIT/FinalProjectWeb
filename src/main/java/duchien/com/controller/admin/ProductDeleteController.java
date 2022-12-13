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
import duchien.com.service.ProductService;
import duchien.com.service.UserService;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.ProductServiceImpl;
import duchien.com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/product/delete" })
public class ProductDeleteController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			productService.delete(Integer.parseInt(id));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath() + "/admin/product/list");
	}

}
