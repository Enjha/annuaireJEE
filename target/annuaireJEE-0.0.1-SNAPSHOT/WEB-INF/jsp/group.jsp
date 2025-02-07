<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/group" />
<c:url var="newGroup" value="/group/new" />
<c:url var="findGroups" value="/group/find" />
<c:url var="annuaire" value="/person/" />

<%@ include file="navBar.jsp" %>

<div class="container">
	<div class="container-title">
		<h1 class="main-title">Groupes</h1>
	</div>

	<form action="${findGroups}" method="post">
		<sec:csrfInput/>
		<div style="display: flex; justify-content: space-between; padding: 20px; margin: 20px;">
			<a class="buttonDesign" href="${annuaire}">Voir annuaire</a>
			<select class="selectDesign" id="monselect" name="name">
				<option value=" "> Rechercher un groupe </option>
				<c:forEach items="${groups}" var="groupName">
					<option value="${groupName.name}">${groupName.name}</option>
				</c:forEach>
			</select>
			<input class="buttonDesign" type="submit" value="Find"/>
			<sec:authorize access="hasAnyAuthority('ADMIN')">
				<a class="buttonDesign" href="${newGroup}">Ajouter un groupe</a>
			</sec:authorize>
		</div>
	</form>
	<div style="text-align: right" ><a style="color:grey" href="${list}">Retirer filtres</a> </div>
	<c:forEach items="${groups}" var="group">
		<p>${group.id}:
		<td>
		<c:out value="${group.name}" />
		<c:forEach items="${group.persons}" var="person">
			<ul>
				<li>
					<c:out value="${person.firstName}" /> <c:out value="${person.lastName}" />
				</li>
			</ul>
		</c:forEach>
		</td>
		</p>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
