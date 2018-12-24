<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="urlRoot" />

<div class="conteiner">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<ul class="nav">
			<li class="nav-item"><a class="nav-link active"
				href="${urlRoot }">Selects</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${urlRoot }update">Update</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${urlRoot }create">Create</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${urlRoot }address">Delete</a></li>
		</ul>
	</nav>
</div>