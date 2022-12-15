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

import duchien.com.model.Category;
import duchien.com.model.Product;
import duchien.com.model.User;
import duchien.com.service.CategoryService;
import duchien.com.service.ProductService;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/product/category")
public class ProductSeachByCategory extends HttpServlet {
	ProductService productService=new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate_id = req.getParameter("cate_id");
		List<Product> productSeachByCategory = null;
		List<Category> listCategory = null;
		String category_name = null;
		try {
			productSeachByCategory = productService.seachByCategory(Integer.parseInt(cate_id));
			listCategory = cateService.getAll();
			category_name = productSeachByCategory.get(0).getCategory().getName();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(productSeachByCategory.get(0));
		
		//System.out.println();
		req.setAttribute("productSeachByCategory", productSeachByCategory);
		req.setAttribute("listCategory", listCategory);
		
		//Get session username
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			User u=(User) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
		}
		req.setAttribute("category_name", category_name);
		req.setAttribute("category_id", cate_id);
		req.getRequestDispatcher("/view/client/view/productSeachByCategory.jsp").forward(req, resp);
		
		
	}
}
