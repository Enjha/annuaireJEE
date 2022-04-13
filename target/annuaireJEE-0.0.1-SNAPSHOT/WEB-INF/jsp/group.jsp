<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/group/list" />
<c:url var="newGroup" value="/group/new" />
<c:url var="findGroups" value="/group/find" />


<div class="container">
	<h1>Groupes</h1>
	<form action="${findGroups}" method="post">
		<sec:csrfInput/>
		<p>
			<a class="btn btn-info" href="${newGroup}">New group</a> <span
				style="margin-left: 30px;"></span>
				 <input name="name" size="10" />
			<input class="btn btn-info" type="submit" value="Find" />
		</p>
	</form>
	<c:forEach items="${groups}" var="group">
		<p>${group.id}:
			<c:out value="${group.name}" />
		</p>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
