package duchien.com.controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import duchien.com.service.UserService;
import duchien.com.service.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/admin/user/delete"})
public class UserDeleteController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			userService.delete(Integer.parseInt(id));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath() + "/admin/user/list");
	}
}
