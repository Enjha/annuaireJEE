<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="group" value="/group/" />
<c:url var="person" value="/person/" />
<c:url var="edit" value="/person/edit" />
<c:url var="findPersons" value="/person/find" />
<c:url var="personNew" value="/person/personNew" />
<c:url var="forgetPassword" value="/person/forgetPassword" />
<c:url var="show" value="/person/show" />

<%@ include file="navBar.jsp" %>
<div class="container">
    <%@ include file="navBar.jsp" %>

    <div class="container-title">
        <h1 class="main-title">Annuaire</h1>
    </div>
    <h1> CECI EST UN TEST </h1>
    <form action="#">
        <table>
            <tr>
                <td colspan="2"><a href="${forgetPassword}">Forgot Password</a></td>
            </tr>
        </table>
    </form>
    </body>
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

    <div style="text-align: right" ><a style="color:grey" href="${list}">Trier par groupes</a> </div>
    <table class="table table-hover">
        <c:forEach items="${persons}" var="pers">
            <tr>
                <td><a href="${show}?id=${pers.id}">
                    <c:out value="${pers.lastName}" />
                </a></td>
                <td><i><c:out value="${pers.firstName}" /></i></td>
                <td><i><c:out value="${pers.email}" /></i></td>
                <sec:authorize access="hasAnyAuthority('ADMIN')">
                    <td><a href="${show}?id=${pers.id}"> voir </a></td>
                    <td><a href="${edit}?id=${pers.id}"> modifier </a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>

    <p style="text-align: center; justify-content: center; display: flex; gap: 30px;">
        <a class="buttonDesign" href="${personNew}">Creer nouvel utilisateur</a>
        <a class="buttonDesign" href="${group}">Voir les groupes</a>
    </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>