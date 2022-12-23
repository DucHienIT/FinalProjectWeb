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
import duchien.com.model.Type;
import duchien.com.model.User;
import duchien.com.service.CategoryService;
import duchien.com.service.ProductService;
import duchien.com.service.TypeService;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.ProductServiceImpl;
import duchien.com.service.impl.TypeServiceImpl;
@WebServlet(urlPatterns="/product/type")
public class ProductSeachByType extends HttpServlet {
	ProductService productService=new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	TypeService typeService = new TypeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type_id = req.getParameter("type_id");
		List<Product> productSeachByType = null;
		List<Category> listCategory = null;
		List<Type> listType = null;
		String type_name = null;
		try {
			productSeachByType = productService.seachByType(Integer.parseInt(type_id));
			listCategory = cateService.getAll();
			type_name = productSeachByType.get(0).getType().getName();
			listType = typeService.getAll();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(productSeachByCategory.get(0));
		
		//System.out.println();
		req.setAttribute("listType", listType);
		req.setAttribute("productSeachByType", productSeachByType);
		req.setAttribute("listCategory", listCategory);
		
		//Get session username
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			User u=(User) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
		}
		req.setAttribute("type_name", type_name);
		req.setAttribute("type_id", type_id);
		req.getRequestDispatcher("/view/client/view/productSeachByType.jsp").forward(req, resp);
		
		
	}
}
