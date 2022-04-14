<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="group" value="/group/" />
<c:url var="person" value="/person/" />
<c:url var="edit" value="/person/edit" />
<c:url var="edit" value="/person/edit" />
<c:url var="personNew" value="/person/personNew" />
<c:url var="show" value="/person/show" />

<%@ include file="navBar.jsp" %>
<div class="container">
    <%@ include file="navBar.jsp" %>

    <div class="container-title">
        <h1 class="main-title">Annuaire</h1>
    </div>
    <div style="text-align: center;">
        <form action="${findPersons}" method="post" >
            <sec:csrfInput/>
            <p>
                <span style="margin-left: 30px;"></span>
                <input class="inputDesign" name="name" size="10" placeholder="ex: Thierry..."/>
                <input class="buttonDesign" type="submit" value="Find" />
            </p>

        </form>
    </div>
    <div style="text-align: right" ><a style="color:grey" href="${person}">Retirer filtres</a> </div>
    <table class="table table-hover">
        <c:forEach items="${persons}" var="pers">
            <tr>
                <td><a href="${show}?id=${pers.id}">
                    <c:out value="${pers.firstName}" />
                </a></td>
                <td><i><c:out value="${pers.lastName}" /></i></td>
                <td><i><c:out value="${pers.email}" /></i></td>
                <td><i type="date" pattern="yyyy-mm-dd" ><c:out value="${pers.birthDay}"/></i></td>
                <td><i><c:out value="${pers.ownGroup.name}" /></i></td>
            </tr>
        </c:forEach>
    </table>
    <p style="text-align: center; justify-content: center; display: flex; gap: 30px;">
        <a class="buttonDesign" href="${personNew}">Creer nouvel utilisateur</a>
        <a class="buttonDesign" href="${group}">Voir les groupes</a>
    </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>