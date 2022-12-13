package duchien.com.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import duchien.com.model.User;
import duchien.com.service.UserService;
import duchien.com.service.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/admin/user/list"})
public class UserListController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> userList = null;
		try {
			userList = userService.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-user.jsp");
		dispatcher.forward(req, resp);
	}
	
}
