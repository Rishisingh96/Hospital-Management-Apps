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
<style>
.paint-card {
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	padding: 20px;
}

.form-label {
	font-weight: bold;
}

.alert-custom {
	border-radius: 8px;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card paint-card">
					<div class="card-header bg-light">
						<h3 class="text-center">Edit Doctor Details</h3>
					</div>
					<div class="card-body">
						<c:if test="${not empty errorMsg}">
							<div class="alert alert-danger alert-custom" role="alert">
								${errorMsg}
								<c:remove var="errorMsg" scope="session" />
							</div>
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="alert alert-success alert-custom" role="alert">
								${succMsg}
								<c:remove var="succMsg" scope="session" />
							</div>
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DoctorDao dao2 = new DoctorDao(DBConnect.Connection());
						Doctor d = dao2.getDoctorsbyId(id);
						%>

						<form action="../updateDoctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									name="fullname" class="form-control" required
									value="<%=d.getFullName()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									name="dob" class="form-control" required
									value="<%=d.getDob()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" name="qualification" class="form-control" required
									value="<%=d.getQualification()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									class="form-select" required>
									<option value="<%=d.getSpecialist()%>"><%=d.getSpecialist()%></option>
									<%
									SpecialistDao dao = new SpecialistDao(DBConnect.Connection());
									List<Specalist> list = dao.getAllSpecalists();
									for (Specalist s : list) {
									%>
									<option value="<%=s.getSpecialistName()%>"><%=s.getSpecialistName()%></option>
									<%
									}
									%>
								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									name="email" class="form-control" required
									value="<%=d.getEmail()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Mobile No</label> <input type="text"
									name="mobno" class="form-control" required
									value="<%=d.getMobNo()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input type="text"
									name="password" class="form-control" required
									value="<%=d.getPassword()%>">
							</div>

							<input type="hidden" name="id" value="<%=d.getId()%>">
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>