<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="group" value="/group/" />
<c:url var="person" value="/person/" />
<c:url var="edit" value="/person/edit" />
<c:url var="findPersons" value="/person/find" />


<div class="container">
    <h1>Person </h1>
    <div style="text-align: center;">
        <form action="${findPersons}" method="post" >
            <sec:csrfInput/>
            <p>
                <span style="margin-left: 30px;"></span>
                <input name="name" size="10" />
                <input class="btn btn-info" type="submit" value="Find" />
            </p>

        </form>
    </div>
    <div style="text-align: right" ><a style="color:grey" href="${person}">Retirer filtres</a> </div>
    <table class="table table-hover">
        <c:forEach items="${persons}" var="pers">
            <tr>
                <td><a href="${edit}?id=${pers.id}">
                    <c:out value="${pers.firstName}" />
                </a></td>
                <td><i><c:out value="${pers.lastName}" /></i></td>
                <td><i><c:out value="${pers.email}" /></i></td>
                <td><i><c:out value="${pers.birthDay}" /></i></td>
                <td><i><c:out value="${pers.ownGroup.name}" /></i></td>
            </tr>
        </c:forEach>
    </table>
    <p style="text-align: center;">
        <a class="btn btn-info" href="${edit}">Creer nouvel utilisateur</a>
        <a class="btn btn-info" href="${group}">Voir les groupes</a>
    </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>