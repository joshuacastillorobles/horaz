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
<spring:url value="/update/edit" var="urlFormEdit"></spring:url>
<spring:url value="/update/save" var="urlFormSave"></spring:url>
<spring:url value="includes" var="urlRoot"></spring:url>
</head>
<body>


	<jsp:include page="${urlRoot }/header.jsp"></jsp:include>
	<div class="container theme-showcase" role="main">

		<%--Criteria --%>
		<div class="row">
			<!-- Select by ID -->
			<div class="col-md-3">
				<h5 class="text-success">Select by ID</h5>
				<form:form action="${urlFormEdit }" method="post"
					enctype="multipart/form-data" modelAttribute="addressBook">
					<form:select id="id" items="${addressList }" path="id"
						itemLabel="id" itemValue="id" class="custom-select " />
					<button type="submit"
						class="btn btn-outline-success justify-content-center">Search</button>
				</form:form>
				
			</div>
		</div>
		<%-- Update --%>

		<div class="row">
			<div class="col-md-12 border rounded">
				<c:if test="${message != null}">
					<div class="alert alert-success" role="alert">${message}</div>
			${message = null}
		</c:if>
				<form:form action="${urlFormSave }" method="post"
					enctype="multipart/form-data" modelAttribute="addressBook">
					<h5 class="text-success">Edit Address</h5>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<form:hidden path="id" />
								<label for="username">User Name</label>
								<form:input type="text" class="form-control" path="username"
									id="username" required="required" value="${address.username }" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="companyName">Company Name</label>
								<form:input type="text" class="form-control" path="companyName"
									id="companyName" value="${address.companyName }" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="personName">Person Name</label>
								<form:input type="text" class="form-control" path="personName"
									id="personName" required="required"
									value="${address.personName }" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="phoneNumber">Phone Number</label>
								<form:input type="text" class="form-control" path="phoneNumber"
									id="phoneNumber" required="required"
									value="${address.phoneNumber }" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="addressLine1">Address Line 1</label>
								<form:input type="text" class="form-control" path="addressLine1"
									id="addressLine1" required="required"
									value="${address.addressLine1 }" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="addressLine2">Address Line 2</label>
								<form:input type="text" class="form-control" path="addressLine2"
									id="addressLine2" value="${address.addressLine2 }" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="city">City</label>
								<form:input type="text" class="form-control" path="city"
									id="city" required="required" value="${address.city }" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="stateOrProvinceCode">State or Province Code</label>
								<form:input type="text" class="form-control"
									path="stateOrProvinceCode" id="stateOrProvinceCode"
									value="${address.stateOrProvinceCode }" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="postalCode">Postal Code</label>
								<form:input type="text" class="form-control" path="postalCode"
									id="postalCode" required="required"
									value="${address.postalCode }" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="countryCode">Country Code</label>
								<form:input type="text" class="form-control" path="countryCode"
									id="countryCode" required="required"
									value="${address.countryCode }" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="addressType">Address Type</label>
								<form:input type="text" class="form-control" path="addressType"
									id="addressType" required="required"
									value="${address.addressType }" />
							</div>
						</div>

					</div>

					<button type="submit"
						class="btn btn-outline-success justify-content-center">Save</button>

				</form:form>
			</div>
		</div>
		<div class="row"></div>
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