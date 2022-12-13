package duchien.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duchien.com.model.Category;
import duchien.com.model.Product;
import duchien.com.model.User;
import duchien.com.service.CategoryService;
import duchien.com.service.ProductService;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns="/product/detail")
public class ProductDetailController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = null;
		try {
			product = productService.get(Integer.parseInt(id));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Category> categories = null;
		try {
			categories = categoryService.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("categories", categories);

		req.setAttribute("product", product);
		
		//Get session username
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			User u=(User) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/product-detail.jsp");
		dispatcher.forward(req, resp);
	}

}
