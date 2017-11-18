<%@page import="constants.WebConstants"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
    <table class="table" border="0" cellpadding="3" id="table-big-migrant">
        <tbody>
            <tr>
                <td rowspan="2"><img height="100px" src="${migrant_logged_in.profileImageUrl}"/></td>
                <td>${migrant_logged_in.countryOfOrigin}</td>
            </tr>
            <tr>
                <td>${migrant_logged_in.motherTongue}</td>
            </tr>
        <c:forEach var="subj" items="${student_subjects}">
            <tr>
                <td><img height="100px" src="./resources/${subj.subject.imageUrl}"/></td>
                <td><img height="100px" src="./resources/${subj.level}.png"/></td>
            </tr>
        </c:forEach>            
        </tbody>
    </table>
</body>