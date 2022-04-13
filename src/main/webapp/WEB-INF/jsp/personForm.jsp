<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<h1>Edit Person</h1>

	<form:form method="POST" modelAttribute="person">

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="form-group">
			<label for="lastName">Nom:</label>
			<form:input class="form-control" path="lastName" />
			<form:errors path="lastName" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group">
			<label for="firstName">Prénom:</label>
			<form:input class="form-control" path="firstName" />
			<form:errors path="firstName" cssClass="alert alert-warning" element="div" />
		</div>
		
		<div class="form-group">
			<label for="email">Email:</label>
			<form:input class="form-control" path="email" />
			<form:errors path="email" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group">
			<label for="website">Website :</label>
			<form:input class="form-control" path="website" />
			<form:errors path="website" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group">
			<label for="password">Mot de passe :</label>
			<form:input class="form-control" path="password" />
			<form:errors path="password" cssClass="alert alert-warning" element="div" />
		</div>

		<div class="form-group">
			<button type="submit" class="btn btn-info">Soumettre</button>
		</div>
	</form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>