<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
    <table class="table" border="0" cellpadding="3" id="table-big-migrant">
        <tbody>
            <tr>
                <td rowspan="2"><img height="100px" src="./${migrant_logged_in.profileImageUrl}"/></td>
                <td>${migrant_logged_in.countryOfOrigin}</td>
            </tr>
            <tr>
                <td>${migrant_logged_in.motherTongue}</td>
            </tr>
        </tbody>
    </table>
    <table class="table" border="0" cellpadding="3" id="table-big-migrant">
        <thead>
            <tr>
                <th width="20%">Competence evaluation</th>
                <th width="25%">Outcomes to be measured</th>
                <th width="20%">Level</th>
                <th>Note</th>                    
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comp" items="${student_competences}"> 
                <c:set var="counter" value="0" /> 
                <c:forEach var="result" items="${student_results_evaluation}" >
                    <c:if test="${result.result.competenceID.competenceName == comp.competenceName}">
                        <c:if test="${counter == 0}">
                            <tr>

                                <td rowspan="${number_of_results_per_competence[comp.competenceName]}">${comp.competenceName}</td>
                                <td>${result.result.resultName}</td>                                
                                <td>${result.level}</td>
                                <td>${result.note}</td>
                            </tr>
                        </c:if>
                        <c:if test="${counter != 0}">
                            <tr>
                                <td>${result.result.resultName}</td>                                
                                <td>${result.level}</td>
                                <td>${result.note}</textarea></td>
                            </tr>
                        </c:if>
                        <c:set var="counter" value="${count + 1}" />
                    </c:if>
                </c:forEach>                                                          
            </c:forEach>
        </tbody>
    </table>
</body>