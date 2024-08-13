package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		UserDao dao = null;
		try {
			dao = new UserDao(DBConnect.Connection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = dao.login(email, password);
		
		if (user != null) {
			session.setAttribute("message", "<h3 style='color:green'>Login successful</h3>");
			session.setAttribute("userObj",user);
			response.sendRedirect("index.jsp"); // Redirect to admin dashboard (you need to create this page)
		} else {
			session.setAttribute("message", "<h3 style='color:red'>Invalid email or password</h3>");
			response.sendRedirect("user_login.jsp");
		}
	}

}
