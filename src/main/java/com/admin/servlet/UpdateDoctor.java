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

@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
	        // Retrieve form parameters from the request
	       
	       

	        String fullName = req.getParameter("fullname");
	        String dob = req.getParameter("dob");
	        String qualification = req.getParameter("qualification");
	        String specialist = req.getParameter("spec");
	        String email = req.getParameter("email");
	        String mobNo = req.getParameter("mobno");
	        String password = req.getParameter("password");

	        int id = Integer.parseInt(req.getParameter("id"));
	        
	        System.out.println("ID: " + id);
	        System.out.println("Full Name: " + fullName);

	        // Create a Doctor object and set its properties
	        Doctor d = new Doctor(id, fullName, dob, qualification, specialist, email, mobNo, password);

	      //Initialize DoctorDao and save the doctor details
	        DoctorDao dao = new DoctorDao(DBConnect.Connection());
	        HttpSession session = req.getSession();

	   
	        if (dao.updateDoctor(d)) {
	        	// Set success message in session and redirect
	        	session.setAttribute("succMsg", "Doctor updated successfully.");
	        	resp.sendRedirect("admin/view_doctor.jsp");
	        	System.out.println("Data Update Successfully ");
	        } else {
	        	// Set error message in session and redirect
	        	session.setAttribute("succMsg", "Doctor update Faild.");
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
 