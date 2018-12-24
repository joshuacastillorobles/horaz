<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD TEST</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<spring:url value="/" var="index"></spring:url>
<spring:url value="includes" var="urlRoot"></spring:url>
</head>
<body>

	<jsp:include page="${urlRoot }/header.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">
		<!-- Select all -->
		<div class="row">
			<div class="col-md-3">
				<h5 class="text-success">Select All</h5>
				<ul class="list-group">
					<c:forEach items="${addressList}" var="address">
						<li class="list-group-item text-secondary">${address.personName }</li>
					</c:forEach>
				</ul>
			</div>

			<!-- Select by ID -->
			<div class="col-md-3">
				<h5 class="text-success">Select by ID</h5>
				<form:form action="${index }" method="post"
					enctype="multipart/form-data" modelAttribute="addressBook">
					<form:select id="id" items="${addressList }" path="id"
						itemLabel="id" itemValue="id" class="custom-select " />
					<button type="submit"
						class="btn btn-outline-success justify-content-center">Search</button>
				</form:form>
				<c:choose>
					<c:when test="${addressId !=null }">
						<p class="text-uppercase font-weight-bold text-center">${addressId }</p>
					</c:when>
					<c:otherwise>
						<p class="text-uppercase font-weight-bold text-center"></p>
					</c:otherwise>
				</c:choose>
			</div>

			<!-- Select by User Name -->
			<div class="col-md-3">
				<h5 class="text-success">Select by User Name</h5>
				<form:form action="${index }" method="post"
					enctype="multipart/form-data" modelAttribute="addressBook">
					<form:select id="id" items="${usernameList }" path="username"
						class="custom-select " />
					<button type="submit"
						class="btn btn-outline-success justify-content-center">Search</button>
				</form:form>
				<c:choose>
					<c:when test="${listUsername !=null }">
						<c:forEach items="${listUsername }" var="user">
							<p class="text-uppercase font-weight-bold text-center">${user.username }
								- ${user.personName }</p>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-uppercase font-weight-bold text-center"></p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>