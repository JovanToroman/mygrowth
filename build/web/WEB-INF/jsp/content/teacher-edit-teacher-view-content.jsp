<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>    
    <form action="./aplikacija" method="POST" id="form-edit-student-view">
        <table class="table" border="0" cellpadding="3" id="table-big-teacher">
            <tbody>
                <tr>
                    <td rowspan="2"><img class="img-profile" src="./resources/profile.jpg"/></td>
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
                    <th id="table-teacher-header-competence">Competence evaluation</th>
                    <th id="table-teacher-header-result">Outcomes to be measured</th>
                    <th>Level</th>
                    <th id="table-teacher-header-note">Note</th>                    
                </tr>
            </thead>
            <tbody id="new-results-container">
                <c:forEach var="comp" items="${student_competences}">
                    <c:set var="counter" value="0" />                    
                    <c:forEach var="result" items="${student_results_evaluation}">                        
                        <c:if test="${result.result.competenceID.competenceName == comp.competenceName}">                            
                            <c:if test="${counter == 0}">
                                <tr id='${result.result.resultName}' class='${comp.competenceName}'>
                                    <td class='${comp.competenceName}' rowspan="${number_of_results_per_competence[comp.competenceName]}">${comp.competenceName}</td>
                                    <td class="res-name">${result.result.resultName}</td>                                
                                    <td style="width: 10%">
                                        <div class="radio"> <!--moguca optimizacija ako nakon stampanja svakog resulta izbacim ga iz kolekcije -->
                                            <label>
                                                <input type="radio" name="radio${result.studentresultsPK.resultID}" ${result.level == 'low' ? 'checked="checked"' : ''} value="low"> Low<br>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="radio${result.studentresultsPK.resultID}" ${result.level == 'medium' ? 'checked="checked"' : ''} value="medium"> Medium<br>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="radio${result.studentresultsPK.resultID}" ${result.level == 'high' ? 'checked="checked"' : ''} value="high"> High
                                            </label>
                                        </div>
                                    </td>
                                    <td><textarea style="height: 100px" class="form-control" name="input${result.studentresultsPK.resultID}" size="160">${result.note}</textarea></td>
                                    <td><input class="btn btn-default" type="button" value="Delete record" onclick="deleteRecordResult(this)" /></td>
                                </tr>
                            </c:if>
                            <c:if test="${counter != 0}">
                                <tr id='${result.result.resultName}'>
                                    <td class="res-name">${result.result.resultName}</td>                                
                                    <td style="width: 10%">Level
                                        <div class="radio"> <!--moguca optimizacija ako nakon stampanja svakog resulta izbacim ga iz kolekcije -->
                                            <label>
                                                <input type="radio" name="radio${result.studentresultsPK.resultID}" ${result.level == 'low' ? 'checked="checked"' : ''} value="low"> Low<br>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="radio${result.studentresultsPK.resultID}" ${result.level == 'medium' ? 'checked="checked"' : ''} value="medium"> Medium<br>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="radio${result.studentresultsPK.resultID}" ${result.level == 'high' ? 'checked="checked"' : ''} value="high"> High
                                            </label>
                                        </div>
                                    </td>
                                    <td>Note: <textarea style="height: 100px" class="form-control" name="input${result.studentresultsPK.resultID}" size="160">${result.note}</textarea></td>
                                    <td><input class="btn btn-default" type="button" value="Delete record" onclick="deleteRecordResult(this)" /></td>
                                </tr>
                            </c:if>
                            <c:set var="counter" value="${count + 1}" />
                        </c:if>
                    </c:forEach>                                                          
                </c:forEach>
                <tr>
                    <td>Select competence name:
                        <select name="Competence" class="combo-box" id="new-competence-name">
                            <option>A responsible attitude towards 
                                health care, personal 
                                and common hygiene</option>
                            <option>Communicational skills 
                                and language knowledge</option>
                            <option>Ability of personal planning
                                during studying</option>
                            <option>Developing an aesthetic
                                dimension and free 
                                art expression</option>
                            <option>Responsible attitude towards environment and development of ecological awareness</option>
                            <option>Use of ICT in school</option>
                            <option>Work in group and active participation in school life</option>
                            <option>Working with data</option>
                            <option>Proactiveness and initiative</option>
                        </select></td>
                    <td>Select new sub-competence name:
                        <select name="Result" class="combo-box" id="new-result-name">
                            <option>Can provide first aid</option>
                            <option>Has knowledge of proper diet</option>
                            <option>Is familiar with how to maintain personal and room hygiene</option>
                            <option>Nourishes a healthy lifestyle</option>
                            <option>Recognizes disease and acknowledges importance of treatment</option>
                        </select></td>
                    <td><input class="btn btn-default" type="button" value="Add new sub-competence" onclick="addFieldResult()" /></td>                    
                </tr>
            </tbody>
        </table>
        <input class="btn btn-default pull-right" id="btn-edit-st-data" type="submit" value="Edit" name="editStudentView" />
        <input type="hidden" id="akcija" name="akcija" value="izmeniNastavnikovPogled" />
    </form>    
</body>
