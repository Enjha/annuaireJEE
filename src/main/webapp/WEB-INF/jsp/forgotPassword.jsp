<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<%@ include file="navBar.jsp" %>

	<div class="container-title">
		<h1 class="main-title">Forgot Password</h1>
	</div>

	<form action="forgotPassword" method="post">
		<table>
			<tr>

				<td colspan="2"><input type="text" name="email"> </td>
			</tr>

			<tr>
				<td><input type="Submit" value="Reset Password">  </td>
				<td><input type="reset" value="Cancel">  </td>
			</tr>

		</table>
	</form>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>