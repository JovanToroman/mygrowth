<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${teacher_logged_in != null || migrant_logged_in != null}">
    ${teacher_logged_in = null}
    ${migrant_logged_in = null}
    ${student_view_data_successfully_updated = null}
    ${teacher_view_data_successfully_updated = null}
</c:if>
<jsp:include page="./template/template.jsp">
    <jsp:param name="content" value="login-migrant-content"></jsp:param>
</jsp:include>