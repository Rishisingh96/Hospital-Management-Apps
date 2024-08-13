package com.doctor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		DoctorDao dao = null;
		try {
			dao = new DoctorDao(DBConnect.Connection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Doctor d = dao.doctorLogin(email, password);
		if (d != null) {
			session.setAttribute("message", "<h3 style='color:green'>Login successful</h3>");
			session.setAttribute("doctorObj", d);
			resp.sendRedirect("doctor/home.jsp"); // Redirect to admin dashboard (you need to create this page)
		} else {
			session.setAttribute("message", "<h3 style='color:red'>Invalid email or password</h3>");
			resp.sendRedirect("doctor_login.jsp");
		}

	}
}
