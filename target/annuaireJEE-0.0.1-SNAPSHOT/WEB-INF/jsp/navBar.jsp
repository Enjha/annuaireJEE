<sec:authorize access="!isAuthenticated()">
    <a class="connectionButton" href="${pageContext.request.contextPath}/login">LOG IN</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a class="connectionButton" href="${pageContext.request.contextPath}/logout">LOG OUT</a>
</sec:authorize>

<c:url var="group" value="/group/" />
<c:url var="person" value="/person/" />
<c:url var="home" value="/" />

<div class="menu">
    <div class="containerOnglet">
        <div class="onglet"><a href="${home}">Accueil</a></div>
        <div class="onglet"><a href="${person}">Personnes</a></div>
        <div class="onglet"><a href="${group}">Groupes</a></div>
    </div>
</div>