package duchien.com.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import duchien.com.model.Receipt;
import duchien.com.service.CartItemService;
import duchien.com.service.CartService;
import duchien.com.service.ReceiptService;
import duchien.com.service.UserService;
import duchien.com.service.impl.CartServiceImpl;
import duchien.com.service.impl.CartServiceItemImpl;
import duchien.com.service.impl.ReceiptServiceImpl;
import duchien.com.service.impl.UserServiceImpl;
import duchien.com.tools.SendMail;
import duchien.com.util.RandomUUID;

@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartServiceItemImpl();
	ReceiptService receiptService = new ReceiptServiceImpl();
	
	long time = System.currentTimeMillis();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("account");
		User buyer = (User) obj;
		Cart cart = new Cart();
		Receipt receipt = new Receipt();
		
		
		cart.setBuyer(buyer);
		cart.setBuyDate(new java.sql.Date(time));
		cart.setId(RandomUUID.getRandomID());
		
		receipt.setAddress(req.getParameter("address"));
		receipt.setSdt(req.getParameter("sdt"));
		receipt.setCart(cart);
		receipt.setBuyer(buyer);
		
		
		try {
			cartService.insert(cart);
			receiptService.insert(receipt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			// ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;

			for (CartItem cartItem : map.values()) {
				cartItem.setCart(cart);
				cartItem.setId(RandomUUID.getRandomID());

				try {
					cartItemService.insert(cartItem);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		session.removeAttribute("cart");
		resp.sendRedirect(req.getContextPath());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
