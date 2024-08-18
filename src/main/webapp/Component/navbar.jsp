<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-success">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <i class="fas fa-clinic-medical"></i> Medical Home
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                <c:if test="${empty userObj}">
                    <li class="nav-item">
                        <a class="nav-link active" href="admin_login.jsp">ADMIN</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="doctor_login.jsp">DOCTOR</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="user_appointment.jsp">APPOINTMENT</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="user_login.jsp">USER</a>
                    </li>
                </c:if>

                <c:if test="${not empty userObj}">
                    <li class="nav-item">
                        <a class="nav-link active" href="user_appointment.jsp">APPOINTMENT</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="view_appointment.jsp">VIEW APPOINTMENT</a>
                    </li>

                    <div class="btn-group">
                        <button type="button" class="btn btn-danger dropdown-toggle d-flex align-items-center"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa-solid fa-user-large me-2"></i> ${userObj.fullName}
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li>
                                <a class="dropdown-item" href="changePass.jsp">
                                    <i class="fas fa-key"></i> Change Password
                                </a>
                            </li>
                            <li><hr class="dropdown-divider"></li>
                            <li>
                                <a class="dropdown-item text-danger" href="userLogout">
                                    <i class="fas fa-sign-out-alt"></i> Logout
                                </a>
                            </li>
                        </ul>
                    </div>
                </c:if>

            </ul>
        </div>
    </div>
</nav>



<%-- <nav class="navbar navbar-expand-lg navbar-light bg-success">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fas fa-clinic-medical"></i> Medical Home</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

				<!-- 
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="admin_login.jsp">ADMIN</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="doctor_login.jsp">DOCTOR</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_appointment.jsp">APPOINTMENT</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_login.jsp">USER</a></li> -->


				<c:if test="${empty userObj }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="admin_login.jsp">ADMIN</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="doctor_login.jsp">DOCTOR</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_appointment.jsp">APPOINTMENT</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_login.jsp">USER</a></li>
				</c:if>


				<c:if test="${not empty userObj }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_appointment.jsp">APPOINTMENT</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="user_appointment.jsp"> VIEW
							APPOINTMENT</a></li>

					<!-- Example single danger button -->
					<div class="btn-group">
						<button type="button" class="btn btn-danger dropdown-toggle"
							data-bs-toggle="dropdown" aria-expanded="false">
							<i class="fa-solid fa-user-large"></i> ${userObj.fullName}</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="changePass.jsp">changePassword</a></li>
							<li><a class="dropdown-item" href="userLogout">Logout</a></li>
						</ul>
					</div>
					
				</c:if>

			</ul>
		</div>
	</div>
</nav> --%>