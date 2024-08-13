<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../Component/allCSSLink.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	padding: 20px;
}

.table th, .table td {
	vertical-align: middle;
}

.btn-custom {
	margin-right: 5px;
}

.card-header {
	background-color: #f8f9fa;
	border-bottom: 1px solid #dee2e6;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-header">
						<h3 class="text-center">Doctor Details</h3>
					</div>
					<div class="card-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								DoctorDao dao2 = new DoctorDao(DBConnect.Connection());
								List<Doctor> list2 = dao2.getAllDoctors();
								for (Doctor d : list2) {
								%>
								<tr>
									<td><%=d.getFullName()%></td>
									<td><%=d.getDob()%></td>
									<td><%=d.getQualification()%></td>
									<td><%=d.getSpecialist()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getMobNo()%></td>
									<td><a href="edit_doctor.jsp?id=<%=d.getId()%>"
										class="btn btn-sm btn-primary btn-custom">Edit</a> 
										<a href="../deleteDoctor?id=<%=d.getId() %>"
										class="btn btn-sm btn-danger btn-custom">Delete</a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
</html>