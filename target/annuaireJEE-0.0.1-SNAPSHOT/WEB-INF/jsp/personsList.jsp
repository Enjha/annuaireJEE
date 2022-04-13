<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="edit" value="/person/edit" />
<c:url var="findPersons" value="/person/find" />


<div class="container">
    <h1>Person </h1>
    <form action="${findPersons}" method="post">
		<sec:csrfInput/>
		<p>
			<span style="margin-left: 30px;"></span>
				 <input name="name" size="10" />
			<input class="btn btn-info" type="submit" value="Find" />
		</p>
	</form>
    <table class="table table-hover">
        <c:forEach items="${persons}" var="pers">
            <tr>
                <td><a href="${edit}?id=${pers.id}">
                    <c:out value="${pers.firstName}" />
                </a></td>
                <td><i>$<c:out value="${pers.lastName}" /></i></td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a class="btn btn-info" href="${edit}">Créer nouvel utilisateur</a>
    </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>