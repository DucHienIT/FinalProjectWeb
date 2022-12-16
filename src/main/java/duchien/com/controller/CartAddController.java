package duchien.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duchien.com.model.CartItem;
import duchien.com.model.Product;
import duchien.com.service.ProductService;
import duchien.com.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/member/cart/add" }) // ?pId=123
public class CartAddController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pId");
		String quantity= req.getParameter("quantity");
		Product product = null;
		try {
			product = productService.get(Integer.parseInt(pId));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		if (obj == null) {
			Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
			map.put(cartItem.getProduct().getId(), cartItem);
			httpSession.setAttribute("cart", map);
		} else {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;

			CartItem existedCartItem = map.get(Integer.valueOf(pId));

			if (existedCartItem == null) {
				map.put(product.getId(), cartItem);
			} else {
				existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
			}

			httpSession.setAttribute("cart", map);
		}
		
		resp.sendRedirect(req.getContextPath() + "/member/cart");
	}
}