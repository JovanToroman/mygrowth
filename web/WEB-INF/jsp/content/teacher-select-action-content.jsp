<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>    
    <form class="indent-left" action="./aplikacija" method="POST">
        <div class="radio">
            <label>
                <input type="radio" name="teacherChooseAction" value="editStudentView" checked="checked"> Edit student view<br>
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="teacherChooseAction" value="editTeacherView"> Edit teacher view<br>
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="teacherChooseAction" value="teacherView"> Teacher view
            </label>
        </div>
        <input class="btn btn-default" type="submit" value="Choose action" />
        <input type="hidden" id="akcija" name="akcija" value="editStudentView" />
    </form>
    <div>
        <c:if test="${student_view_data_successfully_updated != null}">            
            <c:if test="${student_view_data_successfully_updated == true}">
                <h4 class="success-info">Student view has been updated!</h4>
            </c:if>
            <c:if test="${student_view_data_successfully_updated == false}">
                <h4 class="error-info">There was a problem updating student view.</h4>
            </c:if>
            <c:set var="student_view_data_successfully_updated" value="${null}"/>
    </c:if>
    <c:if test="${teacher_view_data_successfully_updated != null}">            
        <c:if test="${teacher_view_data_successfully_updated == true}">
            <h4 class="success-info">Teacher view has been updated!</h4>
        </c:if>
        <c:if test="${teacher_view_data_successfully_updated == false}">
            <h4 class="error-info">There was a problem updating teacher view.</h4>
        </c:if>
        <c:set var="teacher_view_data_successfully_updated" value="${null}"/>
</c:if>
</div>
<script>
    $('input[name="teacherChooseAction"]').click(function () { /*this puts the selected r.b. value into a hidden input field*/
        $('#akcija').val(this.value);
    });
</script>
</body>