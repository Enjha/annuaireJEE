<c:url var="inscription" value="/person/personNew" />
<sec:authorize access="!isAuthenticated()">
    <a class="connectionButton" href="${inscription}" style="margin-right: 150px;">S'inscrire</a>
    <a class="connectionButton" href="${pageContext.request.contextPath}/login">LOG IN</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a class="connectionButton" href="${pageContext.request.contextPath}/logout">LOG OUT</a>
</sec:authorize>

<c:url var="group" value="/group/" />
<c:url var="annuaire" value="/person/" />
<c:url var="home" value="/" />

<div class="menu">
    <div class="containerOnglet">
        <div class="onglet"><a href="${home}">Accueil</a></div>
        <div class="onglet"><a href="${annuaire}">Annuaire</a></div>
        <div class="onglet"><a href="${group}">Groupes</a></div>
    </div>
</div>