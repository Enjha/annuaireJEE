<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="home" value="/" />

<div class="container">
	<%@ include file="navBar.jsp" %>

	<div class="container-title">
		<h1 class="main-title">Modifier mot de passe</h1>
	</div>

	<form:form method="POST" modelAttribute="person">

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

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
			<label for="password">Mot de passe :</label>
			<form:input type="password" class="form-control" path="password" />
			<form:errors path="password" cssClass="alert alert-warning" element="div" />
		</div>

		<div class="form-group" style="text-align: center;">
			<button type="submit" class="buttonDesign" >Modifier Mot de passe</button>
		</div>
	</form:form>
	<div style="text-align: left;">
		<a class="buttonDesign" href="${home}">Retour a l'accueil</a>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>