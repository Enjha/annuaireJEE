<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="function" value="/functions.js" />

<div class="container">
        <script src="${function}"></script>
        <h1>Simple stack calculator (rest application)</h1>
        <p>
                <button onclick="show();">Show</button>
                <input id="input" size="10" />
                <button onclick="put();">put</button>
                <span> | </span>
                <button onclick="add();">+</button>
                <span> | </span>
                <button onclick="sub();">-</button>
                <span> </span> <span style="color: blue;" id="message"></span>
        </p>
        <p id="numbers"></p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>