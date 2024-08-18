<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Doctor Dashboard</title>
<%@include file="../Component/allCSSLink.jsp"%>
</head>
<body>
	<c:if test="${empty doctorObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>      <!-- Using JSTL  we Destroy  completely Object after Destroy object you -->
	 
	<%@include file="navbar.jsp"%>

</body>
</html>
