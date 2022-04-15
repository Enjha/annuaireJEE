<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="home" value="/" />

<div class="container">
	<%@ include file="navBar.jsp" %>

	<div class="container-title">
		<h1 class="main-title">Votre mot de passe a été modifié</h1>
	</div>


	<div style="text-align: center;">
		<a class="buttonDesign" href="${home}">Retour a l'accueil</a>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>