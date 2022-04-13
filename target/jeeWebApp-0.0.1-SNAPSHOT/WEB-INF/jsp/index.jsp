<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/course/list" />

<div class="container">
	<h1>Spring boot application</h1>
	<p>
		Message is
		<c:out value="${message}" />
	</p>
	<p>
		<a href="${list}">Course</a>
	</p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
