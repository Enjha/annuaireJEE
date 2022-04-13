<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="edit" value="/product/edit" />

<div class="container">
    <h1>Products (bootstrap)</h1>
    <table class="table table-hover">
        <c:forEach items="${products}" var="prod">
            <tr>
                <td><a href="${edit}?id=${prod.number}">
                    <c:out value="${prod.name}" />
                </a></td>
                <td><i>$<c:out value="${prod.price}" /></i></td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a class="btn btn-info" href="${edit}">Create new product</a>
    </p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>