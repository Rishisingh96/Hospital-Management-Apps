<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Appointment</title>
<%@include file="Component/allCSSLink.jsp"%>
<style type="text/css">
    .paint-card {
        box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.4);
        border-radius: 8px;
    }

    .backImg {
        background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)), url("img/bg.jpg");
        height: 20vh;
        width: 100%;
        background-size: cover;
        background-repeat: no-repeat;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .backImg p {
        font-size: 2.5rem;
        color: #fff;
        font-weight: bold;
    }

    .form-label {
        font-weight: bold;
        color: #555;
    }

    .form-control, .form-select {
        border-radius: 5px;
        box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
    }

    .btn-success {
        background-color: #28a745;
        border: none;
        padding: 10px 20px;
        font-size: 1.1rem;
        border-radius: 5px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .btn-success:hover {
        background-color: #218838;
    }

    .img-half {
        width: 100%;
        height: auto;
        margin-bottom: 20px;
        border-radius: 8px;
    }
</style>
</head>
<body>
    <%@include file="Component/allCSSLink.jsp"%>
    <%@include file="Component/navbar.jsp"%>
    
    <div class="container-fluid backImg">
        <p>User Appointment</p>
    </div>
    
    <div class="container my-5">
        <div class="row">
            <div class="col-md-6 p-5">
                <img src="img/Rishi.png" class="img-half" alt="Image 1">
         
            </div>

            <div class="col-md-6">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="text-center fs-3">User Appointment Form</p>

                        <c:if test="${not empty errorMsg}">
                            <p class="fs-4 text-center text-danger">${errorMsg}</p>
                            <c:remove var="errorMsg" scope="session" />
                        </c:if>
                        <c:if test="${not empty succMsg}">
                            <p class="fs-4 text-center text-success">${succMsg}</p>
                            <c:remove var="succMsg" scope="session" />
                        </c:if>

                        <form class="row g-3" action="appAppointment" method="post">
                            <input type="hidden" name="userid" value="${userObj.id }">

                            <div class="col-md-6">
                                <label for="inputFullName" class="form-label">Full Name</label>
                                <input required type="text" class="form-control" name="fullname" id="inputFullName">
                            </div>

                            <div class="col-md-6">
                                <label for="inputGender" class="form-label">Gender</label>
                                <select class="form-select" name="gender" id="inputGender" required>
                                    <option value="boy">Boy</option>
                                    <option value="girl">Girl</option>
                                </select>
                            </div>

                            <div class="col-md-6">
                                <label for="inputAge" class="form-label">Age</label>
                                <input required type="number" class="form-control" name="age" id="inputAge">
                            </div>

                            <div class="col-md-6">
                                <label for="inputAppointmentDate" class="form-label">Appointment Date</label>
                                <input required type="date" class="form-control" name="appoint_date" id="inputAppointmentDate">
                            </div>

                            <div class="col-md-6">
                                <label for="inputEmail" class="form-label">Email</label>
                                <input required type="email" class="form-control" name="email" id="inputEmail">
                            </div>

                            <div class="col-md-6">
                                <label for="inputPhone" class="form-label">Phone No</label>
                                <input maxlength="10" required type="number" class="form-control" name="phno" id="inputPhone">
                            </div>

                            <div class="col-md-6">
                                <label for="inputDiseases" class="form-label">Diseases</label>
                                <input required type="text" class="form-control" name="diseases" id="inputDiseases">
                            </div>

                            <div class="col-md-6">
                                <label for="inputDoctor" class="form-label">Doctor</label>
                                <select required class="form-select" name="doct" id="inputDoctor">
                                    <option value="">--Select--</option>
                                    <%
                                    DoctorDao dao = new DoctorDao(DBConnect.Connection());
                                    List<Doctor> list = dao.getAllDoctors();
                                    for (Doctor d : list) {
                                    %>
                                    <option value="<%=d.getId()%>"><%=d.getFullName()%> (<%=d.getSpecialist()%>)</option>
                                    <%
                                    }
                                    %>
                                </select>
                            </div>

                            <div class="col-md-12">
                                <label for="inputAddress" class="form-label">Full Address</label>
                                <textarea required name="address" class="form-control" rows="3" id="inputAddress"></textarea>
                            </div>

                            <c:if test="${empty userObj }">
                                <a href="user_login.jsp" class="col-md-6 offset-md-3 btn btn-success text-center">Submit</a>
                            </c:if>

                            <c:if test="${not empty userObj }">
                                <button class="col-md-6 offset-md-3 btn btn-success text-center">Submit</button>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="Component/footer.jsp"%>
</body>
</html>
