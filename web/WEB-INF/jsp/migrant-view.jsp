<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${migrant_logged_in != null}">
    <jsp:include page="../template/template.jsp">
        <jsp:param name="content" value="migrant-content"></jsp:param>
    </jsp:include>
</c:if>
<c:if test="${migrant_logged_in == null}">
    <jsp:include page="../template/template.jsp">
        <jsp:param name="content" value="login-migrant-bad-content"></jsp:param>
    </jsp:include>
</c:if>

