package com.admin.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
		        // Retrieve form parameters from the request
		        int id = Integer.parseInt(req.getParameter("id"));
		        
		        System.out.println("ID:Deleted " + id);
		       

		      //Initialize DoctorDao and save the doctor details
		        DoctorDao dao = new DoctorDao(DBConnect.Connection());
		        HttpSession session = req.getSession();

		   
		        if (dao.deleteDoctor(id)) {
		        	// Set success message in session and redirect
		        	session.setAttribute("succMsg", "Doctor Delete successfully.");
		        	resp.sendRedirect("admin/view_doctor.jsp");
		        	System.out.println("DataDelete Successfully ");
		        } else {
		        	// Set error message in session and redirect
		        	session.setAttribute("succMsg", "Something wrong on server");
		        	resp.sendRedirect("admin/view_doctor.jsp");
		        }

		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		        req.getSession().setAttribute("errorMsg", "An error occurred: " + e.getMessage());
		        resp.sendRedirect("admin/view_doctor.jsp");
		    } catch (Exception e) {
		        e.printStackTrace();
		        req.getSession().setAttribute("errorMsg", "An error occurred: " + e.getMessage());
		        resp.sendRedirect("admin/view_doctor.jsp");
		    }
		}
}
