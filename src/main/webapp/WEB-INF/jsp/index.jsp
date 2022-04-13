<%@ include file="header.jsp" %>
<c:url var="list" value="/person"/>
<body>
<div class="main">
    <div>
        <sec:authorize access="!isAuthenticated()">
            <a class="connectionButton" href="/login">LOG IN</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a class="connectionButton" href="/logout">LOG OUT</a>
        </sec:authorize>
    </div>

    <div class="container">
        <h1 class="main-title">Annuaire de personnes - JEE</h1>
        <p>
            Message is
            <c:out value="${message}"/>
        </p>
        <p>
            <a href="${list}">Annuaire</a>
        </p>
    </div>

</div>
</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>

