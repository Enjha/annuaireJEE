<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="forgotPassword" value="/person/forgotPassword" />

<div class="container">
  <div class="container-title">
    <h1 class="main-title">Se connecter</h1>
  </div>

  <form:form method="POST" action="${pageContext.request.contextPath}/login">

    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <div class="form-group">
      <label>Email utilisateur :</label>
      <input class="form-control" name="username"  />
      <form:errors path="username" cssClass="alert alert-warning" element="div" />
    </div>
    <div class="form-group">
      <label>Mot de passe :</label>
      <input type="password" class="form-control" name="password"  />
      <form:errors path="password" cssClass="alert alert-warning" element="div" />
    </div>

    <div class="form-group" style="text-align: left;">
      <button type="submit" class="buttonDesign" value="Login">Se connecter</button><br/>
      <a href="${pageContext.request.contextPath}/person/forgotPassword">Forgot Password</a>
    </div>
  </form:form>

</div>
