<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="group" value="/group/" />
<c:url var="person" value="/person/" />
<c:url var="edit" value="/person/edit" />
<c:url var="findPersons" value="/person/find" />
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
                <sec:authorize access="hasAnyAuthority('ADMIN')">
                    <td><a href="${show}?id=${pers.id}"> voir </a></td>
                    <td><a href="${edit}?id=${pers.id}"> modifier </a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
    <div id="pagination">

        <c:url value="${person}" var="prev">
            <c:param name="page" value="${page-1}"/>
        </c:url>
        <c:if test="${page > 1}">
            <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
        </c:if>

        <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
            <c:choose>
                <c:when test="${page == i.index}">
                    <span>${i.index}</span>
                </c:when>
                <c:otherwise>
                    <c:url value="${person}" var="url">
                        <c:param name="page" value="${i.index}"/>
                    </c:url>
                    <a href='<c:out value="${url}" />'>${i.index}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:url value="${person}" var="next">
            <c:param name="page" value="${page + 1}"/>
        </c:url>
        <c:if test="${page + 1 <= maxPages}">
            <a href='<c:out value="${next}" />' class="pn next">Next</a>
        </c:if>
    </div>

    <p style="text-align: center; justify-content: center; display: flex; gap: 30px;">
        <a class="buttonDesign" href="${personNew}">Creer nouvel utilisateur</a>
        <a class="buttonDesign" href="${group}">Voir les groupes</a>
    </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>