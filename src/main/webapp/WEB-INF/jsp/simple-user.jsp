<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="login" value="/simple-user/login" />
<c:url var="logout" value="/simple-user/logout" />
<c:url var="show" value="/simple-user/show" />

<div class="container">
    <h1>Simple User</h1>

    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert">
            <c:out value="${message}" />
        </div>
    </c:if>

    <p>
        name :
        <c:out value="${simpleUser.name}" default="no name" />
        | <a href="${show}">Show</a> | <a href="${login}">Login</a> |
        <a href="${logout}">Logout</a>
    </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>