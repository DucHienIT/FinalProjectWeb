package duchien.com.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duchien.com.model.CartItem;
import duchien.com.model.Category;
import duchien.com.model.Product;
import duchien.com.model.User;
import duchien.com.service.CartItemService;
import duchien.com.service.CategoryService;
import duchien.com.service.ProductService;
import duchien.com.service.UserService;
import duchien.com.service.impl.CartServiceItemImpl;
import duchien.com.service.impl.CategoryServiceImpl;
import duchien.com.service.impl.ProductServiceImpl;
import duchien.com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns="/admin")
public class welcome extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	UserService userService = new UserServiceImpl();
	CartItemService cartItemService=new CartServiceItemImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj=session.getAttribute("account");
		User user=(User) obj;
		req.setAttribute("username", user.getUsername());
		
		List<Product> proList = null;
		try {
			proList = productService.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> userList = null;
		try {
			userList = userService.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Category> catList = null;
		try {
			catList = cateService.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<CartItem> cartItemList = null;
		try {
			cartItemList = cartItemService.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total user="+userList.size());
		System.out.println("Total product="+proList.size());
		System.out.println("Total category="+catList.size());
		System.out.println("Total cart item="+cartItemList.size());
		
		req.setAttribute("total_user", userList.size());
		req.setAttribute("total_pro", proList.size());
		req.setAttribute("total_cat", catList.size());
		req.setAttribute("total_cart", cartItemList.size());
		
		req.getRequestDispatcher("/view/admin/view/index.jsp").forward(req, resp);
	}

}
