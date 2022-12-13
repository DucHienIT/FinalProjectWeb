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

import duchien.com.model.Category;
import duchien.com.service.CategoryService;
import duchien.com.service.ProductService;
import duchien.com.service.impl.CategoryServiceImpl;


@WebServlet(urlPatterns="/category/detail")
public class CategoryDetailControllder extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category cat = null;
		try {
			cat = categoryService.get(Integer.parseInt(id));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("category", cat);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/view/category-detail.jsp");
		dispatcher.forward(req, resp);
	}

}
