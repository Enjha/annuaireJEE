<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/group" />
<c:url var="newGroup" value="/group/new" />
<c:url var="findGroups" value="/group/find" />
<c:url var="annuaire" value="/person/" />


<div class="container">
	<h1>Groupes</h1>
	<form action="${findGroups}" method="post">
		<sec:csrfInput/>
		<p style="text-align: center;">
			<a class="btn btn-info" href="${newGroup}">Ajouter un groupe</a>
			<span style="margin-left: 30px;"></span>
			<select id="monselect" name="name">
				<option value=" "> Rechercher un groupe </option>
				<c:forEach items="${groups}" var="groupName">
					<option value="${groupName.name}">${groupName.name}</option>
				</c:forEach>
			</select>
			<input class="btn btn-info" type="submit" value="Find"/>
		</p>
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
	<p style="text-align: right;">
		<a class="btn btn-info" href="${annuaire}">Voir annuaire</a>
	</p>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
