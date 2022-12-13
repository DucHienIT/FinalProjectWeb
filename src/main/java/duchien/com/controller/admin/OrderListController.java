package duchien.com.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duchien.com.model.Cart;
import duchien.com.model.User;
import duchien.com.model.CartItem;
import duchien.com.service.CartItemService;
import duchien.com.service.CartService;
import duchien.com.service.UserService;
import duchien.com.service.impl.CartServiceImpl;
import duchien.com.service.impl.CartServiceItemImpl;
import duchien.com.service.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/admin/order/list"})
public class OrderListController extends HttpServlet {
	CartItemService cartItemService=new CartServiceItemImpl();
	CartService cartService=new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<CartItem> listCartItem = null;
	try {
		listCartItem = cartItemService.getAll();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("listCartItem", listCartItem);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-order.jsp");
	dispatcher.forward(req, resp);
	}
	
}
