<%@ include file="/WEB-INF/jsp/header.jsp"%>
<c:url var="annuaire" value="/person/" />

<div class="container">
	<%@ include file="navBar.jsp" %>

	<div class="container-title">
		<h1 class="main-title"><c:out value="${person.lastName}"/> <c:out value="${person.firstName}"/></h1>
	</div>

	<p>Date de naissance : <c:out value="${person.birthDay}" /></p>
	<p>Email : <c:out value="${person.email}" /></p>
	<p>Site web : <c:out value="${person.website}" /></p>
	<p>Groupe : <c:out value="${person.ownGroup.name}" /></p>


	<p style="text-align: left;">
		<a class="btn btn-info" href="${annuaire}">Retour a l'annuaire</a>
	</p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>