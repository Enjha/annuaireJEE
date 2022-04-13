<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="person" value="/person/" />

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
			<label for="firstName">Prenom:</label>
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
			<label for="ownGroup">Groupe :</label>
			<form:select path="ownGroup" multiple="false" class="form-control">
				<form:option value="" label="--- Modifier le groupe de l'utilisateur ---" />
				<form:options items="${personGroup}" />
			</form:select>
			<form:errors path="ownGroup" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group" style="text-align: center;">
			<button type="submit" class="btn btn-info" window.location = "http://www.example.com/">Soumettre</button>
		</div>
	</form:form>
	<div style="text-align: left;">
		<a class="btn btn-info" href="${person}">Retour a l'annuaire</a>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>