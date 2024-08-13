package com.admin.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

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
            
            System.out.println(fullName);
            // Create a Doctor object and set its properties
            Doctor d = new Doctor(fullName, dob, qualification, specialist, email ,mobNo,password);
            

            // Initialize DoctorDao and save the doctor details
            DoctorDao dao = new DoctorDao(DBConnect.Connection());
            HttpSession session = req.getSession();
            
            System.out.println("Data Save suffefully ");
            //boolean success = dao.addDoctor(doctor);

            if (dao.registerDoctor(d)) {	
                // Set success message in session and redirect
            	session.setAttribute("succMsg", "Doctor added successfully.");
                resp.sendRedirect("admin/doctor.jsp");
            } else {
                // Set error message in session and redirect
            	session.setAttribute("succMsg", "Doctor added Faild.");
                resp.sendRedirect("admin/doctor.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("errorMsg", "An error occurred: " + e.getMessage());
            resp.sendRedirect("admin/doctor.jsp");
        }
    }
}
