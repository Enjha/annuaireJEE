<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="person" value="/person/" />
<%@ include file="navBar.jsp" %>
<div class="container">


	<div class="container-title">
		<h1 class="main-title">Modification</h1>
	</div>

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
			<label for="birthDay">Date de naissance :</label>
			<form:input type="date" class="form-control" path="birthDay" />
			<form:errors path="birthDay" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group">
			<label for="website">Website :</label>
			<form:input class="form-control" path="website" />
			<form:errors path="website" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group">
			<label for="ownGroup">Groupe :</label>
			<form:select path="ownGroup" multiple="false" class="form-control">
				<form:option value=""  label="--- Modifier le groupe de l'utilisateur ---" />
				<form:options items="${personGroup}" />
			</form:select>
			<form:errors path="ownGroup" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group" style="text-align: center;">
			<button type="submit" class="buttonDesign">Modifier</button>
		</div>
	</form:form>
	<div style="text-align: left;">
		<a class="buttonDesign" href="${person}">Retour a l'annuaire</a>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>