<sec:authorize access="!isAuthenticated()">
    <a class="connectionButton" href="${pageContext.request.contextPath}/login">LOG IN</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a class="connectionButton" href="${pageContext.request.contextPath}/logout">LOG OUT</a>
</sec:authorize>
<div class="menu">
    <div class="containerOnglet">
        <div class="onglet"><a href="#">Accueil</a></div>
        <div class="onglet"><a href="#">Personnes</a></div>
        <div class="onglet"><a href="#">Groupes</a></div>
    </div>
</div>