<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="group" value="/group/" />
<c:url var="person" value="/person/" />
<c:url var="edit" value="/person/edit" />
<c:url var="findPersons" value="/person/find" />
<c:url var="personNew" value="/person/personNew" />
<c:url var="forgotPassword" value="/person/forgotPassword" />
<c:url var="show" value="/person/show" />

<%@ include file="navBar.jsp" %>
<div class="container">

    <div class="container-title">
        <h1 class="main-title">Annuaire</h1>

    </div>

    <div style="text-align: center;">
        <form action="${findPersons}" method="post" >
            <sec:csrfInput/>
            <div style="display: flex; justify-content: center; padding: 20px; margin: 20px; gap: 25px;">
                <a class="buttonDesign" style="margin: 20px;" href="${group}">Voir les groupes</a>
                <div style="display: flex; border: 1px #332cf2 solid;padding: 10px; border-radius: 25px;">
                    <input class="inputDesign" style="width:100%;margin-top: 20px;" name="name" size="10" placeholder="ex: Thierry..." />
                    <input class="buttonDesign" type="submit" value="Find" />
                </div>
                <a class="buttonDesign" style="margin: 20px;" href="${personNew}">Creer nouvel utilisateur</a>
            </div>
        </form>
    </div>

    <table class="table table-hover">
        <c:forEach items="${persons}" var="pers">
            <tr>
                <td><a href="${show}?id=${pers.id}">
                    <c:out value="${pers.lastName}" />
                </a></td>
                <td><i><c:out value="${pers.firstName}" /></i></td>
                <td><i><c:out value="${pers.email}" /></i></td>
                <td><i><c:out value="${pers.ownGroup.name}" /></i></td>
                <sec:authorize access="hasAnyAuthority('ADMIN')">
                    <td><a href="${show}?id=${pers.id}"> voir </a></td>
                    <td><a href="${edit}?id=${pers.id}"> modifier </a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>