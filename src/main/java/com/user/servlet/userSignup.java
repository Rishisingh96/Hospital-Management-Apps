//package com.user.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@SuppressWarnings("serial")
//@WebServlet("/register")
//public class userSignup extends HttpServlet {
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        
//        String id = request.getParameter("id");
//        String name = request.getParameter("fullname");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital-management-system", "root", "Rishi@9838");
//            System.out.println("success");
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_dtls VALUES(?,?,?,?)");
//            preparedStatement.setString(1, id);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, email);
//            preparedStatement.setString(4, password);
//
//            int count = preparedStatement.executeUpdate();
//            HttpSession session = request.getSession();
//            if (count > 0) {
//                session.setAttribute("message", "<h3 style='color:green'>User registered successfully</h3>");
//                response.sendRedirect("user_login.jsp");
//            } else {
//                session.setAttribute("message", "<h3 style='color:red'>User not registered due to some error</h3>");
//                response.sendRedirect("signup.jsp");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            HttpSession session = request.getSession();
//            session.setAttribute("message", "<h3 style='color:red'>Exception Occurred: " + e.getMessage() + "</h3>");
//            response.sendRedirect("signup.jsp");
//        }
//    }
//}
