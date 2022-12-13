package duchien.com.controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import duchien.com.service.CartItemService;
import duchien.com.service.impl.CartServiceItemImpl;
@WebServlet(urlPatterns="/admin/order/delete")
public class OrderDeleteController extends HttpServlet {
	CartItemService cartItemService=new CartServiceItemImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		try {
			cartItemService.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/admin/order/list");

	}

}
