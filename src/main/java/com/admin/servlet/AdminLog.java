package com.admin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.entity.User;

@WebServlet("/admin")
public class AdminLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Assuming admin credentials are hardcoded for demonstration purposes
		String adminEmail = "rishi@gmail.com";
		String adminPassword = "12345";

		HttpSession session = request.getSession();
		if (email.equals(adminEmail) && password.equals(adminPassword)) {
			session.setAttribute("message", "<h3 style='color:green'>Login successful</h3>");
			session.setAttribute("adminObj",new User());
			response.sendRedirect("admin/index.jsp"); // Redirect to admin dashboard (you need to create this page)
		} else {
			session.setAttribute("message", "<h3 style='color:red'>Invalid email or password</h3>");
			response.sendRedirect("admin_login.jsp");
		}
	}
}
