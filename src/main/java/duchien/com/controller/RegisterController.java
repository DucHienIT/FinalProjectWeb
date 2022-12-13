package duchien.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duchien.com.service.UserService;
import duchien.com.service.impl.UserServiceImpl;
import duchien.com.tools.SendMail;
import duchien.com.util.Constant;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/admin");
					return;
				}
			}
		}

		req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		UserService service = new UserServiceImpl();
		String alertMsg = "";

		try {
			if (service.checkExistEmail(email)) {
				alertMsg = "Email already exist!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
				return;
			}
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (service.checkExistUsername(username)) {
				alertMsg = "Username already exist!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
				return;
			}
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean isSuccess = false;
		try {
			isSuccess = service.register(username, password, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (isSuccess) {
			SendMail sm= new SendMail();
			sm.sendMail(email, "UNIFY", "Welcome to UNIFY. Please Login to use service. Thanks !");
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
		}
	}

}
