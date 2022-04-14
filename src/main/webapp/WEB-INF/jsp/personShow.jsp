<%@ include file="/WEB-INF/jsp/header.jsp"%>
<c:url var="annuaire" value="/person/" />

<div class="container">
	<h1>En savoir un peu plus...</h1>

	<p>Nom : <c:out value="${person.lastName}" /></p>
	<p>Prenom : <c:out value="${person.firstName}" /></p>
	<p>Date de naissance : <c:out value="${person.birthDay}" /></p>
	<p>Email : <c:out value="${person.email}" /></p>
	<p>Site web : <c:out value="${person.website}" /></p>
	<p>Groupe : <c:out value="${person.ownGroup.name}" /></p>


	<p style="text-align: right;">
		<a class="btn btn-info" href="${annuaire}">Voir annuaire</a>
	</p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>