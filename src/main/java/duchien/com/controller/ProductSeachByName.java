package duchien.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duchien.com.model.Product;
import duchien.com.model.User;
import duchien.com.service.ProductService;
import duchien.com.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/product/seach")
public class ProductSeachByName extends HttpServlet {
	ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		List<Product> productSeachByName = null;
		try {
			productSeachByName = productService.seachByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("productSeachByName", productSeachByName);
		
		//Get session username
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			User u=(User) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
		}
		
		req.getRequestDispatcher("/view/client/view/product-seach-by-name.jsp").forward(req, resp);
		
		
	}
}