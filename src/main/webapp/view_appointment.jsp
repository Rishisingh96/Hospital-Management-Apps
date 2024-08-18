<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.Appointmentdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment List</title>
<!-- <!-- Bootstrap CSS -->

	<%@include file="Component/allCSSLink.jsp"%>
	
<!-- Custom CSS -->
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
	border-radius: 8px;
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/bg.jpg");
	height: 30vh; /* Adjusted height for better visual impact */
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

.img-profile {
	max-width: 100%;
	height: auto;
	border-radius: 8px;
}
.pending-badge {
    background-color: yellow;
    color: black;
    padding: 0.5em 1em;
    border-radius: 0.25rem;
}

</style>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<%@include file="Component/navbar.jsp"%>

	<div class="container-fluid backImg p-5">
		<p class="text-center text-white fs-3 mb-0">Welcome to Your
			Appointments</p>
	</div>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success mb-4">Appointment
							List</p>
						<table class="table table-bordered table-hover">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userObj");
								Appointmentdao dao = new Appointmentdao(DBConnect.Connection());
								DoctorDao dao2 = new DoctorDao(DBConnect.Connection());
								List<Appointment> list = dao.getAllAppointmentByLoginUser(user.getId());
								for (Appointment ap : list) {
									Doctor d = dao2.getDoctorsbyId(ap.getDoctorId());
								%>
								<tr>
									<td><%=ap.getFullName()%></td>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppoinDate()%></td>
									<td><%=ap.getDiseases()%></td>
									<td><%=d.getFullName()%></td>
									<td>
										<%
										if ("Pending".equals(ap.getStatus())) {
										%> <span class="pending-badge">Pending</span> <%
 } else {
 %> <span class="badge badge-success"><%=ap.getStatus()%></span> <%
 }
 %>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div
				class="col-md-3 d-flex justify-content-center align-items-center p-3">
				<img alt="Profile Picture" src="img/Rishi.png" class="img-profile">
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
