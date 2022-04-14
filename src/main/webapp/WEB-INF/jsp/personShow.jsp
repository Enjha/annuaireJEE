<%@ include file="/WEB-INF/jsp/header.jsp"%>
<c:url var="annuaire" value="/person/" />

<div class="container">
	<%@ include file="navBar.jsp" %>

	<div class="container-title">
		<h1 class="main-title"><c:out value="${person.lastName}"/> <c:out value="${person.firstName}"/></h1>
	</div>

	<div style="text-align: center;">
		<h3>Date de naissance :</h3> <h5><fmt:formatDate type = "date" value = "${person.birthDay}"/></h5><br/>
		<h3>Email :</h3> <h5><c:out value="${person.email}" /></h5><br/>
		<h3>Site Web :</h3> <h5><c:out value="${person.website}" /></h5><br/>
		<h3>Groupe :</h3> <h5><c:out value="${person.ownGroup.name}" /></h5><br/>
	</div>

	<div style="text-align: center;">
		<a class="buttonDesign" href="${annuaire}">Retour a l'annuaire</a>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>