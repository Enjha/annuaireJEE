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
    </div>
    <div class="content">
        <p>Pour accéder à l'annuaire des personnes, il suffit de cliquer juste en dessous.</p>
        <a class="annuaireAccess" href="${list}"><span>Annuaire</span></a>
    </div>
    <div class="blabla">
        <h5>Ce site a été créer dans le cadre d'un projet de JEE en Master 1 informatique à Luminy.
        Ce projet avait pour but de gérer à l'aide de la technologie JEE un annuaire de personnes.
        </h5>
        <h6 style="margin-top: 40px;">Voici le cahier des charges de ce projet: </h6>
        <p>
            Lot 1 : présentation.

            Une personne est représentée par un ensemble d'informations : identifiant, nom, prénom, adresse électronique, site WEB, date de naissance et mot de passe.
            Chaque personne est placée dans un groupe. Un groupe est composé de quelques dizaines de personnes (par exemple les étudiants du M1 IDL 2019/2020). Un groupe a donc un nom et un identifiant.
            L'application doit présenter une liste de groupes, une liste de personnes de chaque groupe et une vue détaillée de chaque personne (sauf adresse électronique et date de naissance). Une fonction de recherche doit être offerte.
            L'application doit être fonctionnelle si nous avons plusieurs milliers de personnes et plusieurs centaines de groupes (il faut le montrer).
        </p>
        <p>
            Lot 2 (si le lot 1 est terminé) : authentification et modification.

            L'application doit permettre à chaque personne de modifier sa propre description.
            Les personnes présentes dans l'annuaire peuvent avoir accès à toutes les informations (y compris les adresses électroniques et les dates de naissance).

        </p>
        <p>
            Lot 3 (si le lot 2 est terminé) :

            Il faut prévoir un mécanisme de récupération du mot de passe.
        </p>
    </div>

</div>
</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>

