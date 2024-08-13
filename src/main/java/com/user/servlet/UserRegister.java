package com.user.servlet;

import java.io.IOException;


import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class UserRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			//User u = new User ( fun, em , pa)  set value in User Class  
			User u = new User(fullName, email, password);
			UserDao dao = new UserDao(DBConnect.Connection());

			HttpSession session = req.getSession();
			boolean f = dao.register(u);
			if (f) {
				//System.out.println("register successfully");
				session.setAttribute("message", "<h3 style='color:green'>User registered successfully</h3>");
                 resp.sendRedirect("user_login.jsp");

			} else {
				//System.out.println(" Somthig wrong on server");
				session.setAttribute("message", "<h3 style='color:red'>User not registered due to some error</h3>");
                resp.sendRedirect("signup.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			HttpSession session = req.getSession();
            session.setAttribute("message", "<h3 style='color:red'>Exception Occurred: " + e.getMessage() + "</h3>");
		}

	}

}