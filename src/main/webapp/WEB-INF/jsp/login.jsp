<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="navBar.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="forgotPassword" value="/person/forgotPassword"/>

<div class="containerPannel">
    <div class="login-panel">
        <div class="title-panel">
            <h1>Se connecter</h1>
        </div>

        <form:form method="POST" action="${pageContext.request.contextPath}/login">
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
            <div class="fields-panel">
                <div class="field">
                    <label>Email utilisateur :</label>
                    <input class="fieldDesign" name="username"/>
                    <form:errors path="username" cssClass="alert alert-warning" element="div"/>
                </div>
                <div class="field">
                    <label>Mot de passe :</label>
                    <input type="password" class="fieldDesign" name="password"/>
                    <form:errors path="password" cssClass="alert alert-warning" element="div"/>
                </div>
            </div>
            <div class="button-panel">
                <button type="submit" class="buttonDesign" value="Login">Se connecter</button>
            </div>
            <div class="forget-password">
                <a href="${pageContext.request.contextPath}/person/forgotPassword">Forgot Password</a>
            </div>
        </form:form>

    </div>
</div>