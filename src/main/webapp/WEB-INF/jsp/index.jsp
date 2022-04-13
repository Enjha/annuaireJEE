<%@ include file="header.jsp" %>
<c:url var="list" value="/person"/>
<body>
<div class="main">
    <div class="connection-button">
        <sec:authorize access="!isAuthenticated()">
            <a class="connectionButton" href="${pageContext.request.contextPath}/login">LOG IN</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a class="connectionButton" href="${pageContext.request.contextPath}/logout">LOG OUT</a>
        </sec:authorize>
    </div>

    <div class="container-title">
        <h1 class="main-title"><c:out value="${message}"/></h1>
        <div class="content">
            <p>Pour accéder à l'annuaire des personnes, il suffit de cliquer juste en dessous.</p>
            <a class="access-annuaire" href="${list}">Annuaire</a>
        </div>
    </div>

</div>
</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>

