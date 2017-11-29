<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
    <!-- Problem when trying to modify data for the second time - it reports a bean validation error -->    
    <form action="./aplikacija" method="POST" enctype="multipart/form-data" id="form-student">
        <table class="table" border="0" cellpadding="3" id="table-big-migrant">
            <tbody id="new-subjects-container">
                <tr>
                    <td rowspan="2"><img class="img-profile" src="${migrant_logged_in.profileImageUrl}"/></td>
                    <td>${migrant_logged_in.countryOfOrigin}</td>
                </tr>
                <tr>
                    <td>${migrant_logged_in.motherTongue}</td>
                </tr>                                
                <c:forEach var="subj" items="${student_subjects}"> 
                    <tr>
                        <td class="subj-name">${subj.studentsubjectsPK.subjectName}</td>
                        <td>Evaluation: <textarea class="form-control" name="input${subj.studentsubjectsPK.subjectName}" size="160">${subj.evaluation}</textarea></td>
                        <td>Level
                            <div class="radio">
                                <label>
                                    <input type="radio" name="radio${subj.studentsubjectsPK.subjectName}" ${subj.level == 'low' ? 'checked="checked"' : ''} value="low"> Low<br>
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="radio${subj.studentsubjectsPK.subjectName}" ${subj.level == 'medium' ? 'checked="checked"' : ''} value="medium"> Medium<br>
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="radio${subj.studentsubjectsPK.subjectName}" ${subj.level == 'high' ? 'checked="checked"' : ''} value="high"> High
                                </label>
                            </div>
                        </td>
                        <td><input class="btn btn-default" type="button" value="Delete record" onclick="deleteRecordSubject(this)" /></td>
                    </tr>                     
                </c:forEach>
                <tr>
                    <td>Enter new subject name: </td>
                    <td><input type="text" class="new-field-name" id="new-subject-name"/></td>
                    <td><input class="btn btn-default" type="button" value="Add new subject" onclick="addField()" /></td>                    
                </tr>
            </tbody>
        </table>
        <input class="btn btn-default pull-right col-sm-3 btn-edit-st-teach-data" type="submit" value="Edit" name="editStudentView" />
        <input type="hidden" id="akcija" name="akcija" value="izmeniStudentovPogled" />
    </form>    
</body>
