function addField() {
    var table = document.getElementById("table-big-migrant");
    var subjectName = document.getElementById("new-subject-name").value; //adds new subject to be evaluated
    console.log('naziv' + subjectName);
    var duplicate = false;
    for (var i = 0, row; row = table.rows[i]; i++) {
        if (row.id === subjectName) {
            duplicate = true;
        }
    }
    if (!duplicate) {
        $('#new-subjects-container').append('<tr id="' + subjectName + '">'
                + '<td>' + subjectName + '</td>'
                + '<td>Evaluation: <input type="text" name="input' + subjectName + '" value="" size="160" class="form-control"/></td>'
                + '<td>Level'
                + '<div class="radio">'
                + '<label>'
                + '<input type="radio" name="radio' + subjectName + '" value="low"> Low<br>'
                + '</label>'
                + '</div>'
                + '<div class="radio">'
                + '<label>'
                + '<input type="radio" name="radio' + subjectName + '" value="medium"> Medium<br>'
                + '</label>'
                + '</div>'
                + '<div class="radio">'
                + '<label>'
                + '<input type="radio" name="radio' + subjectName + '" value="high"> High'
                + '</label>'
                + '</div>'
                + '</td>'
                + '<td>Select file to upload:'
                + '<div class="file-upload">'
                + '<input class="btn btn-default" type="file" name="subjectImage' + subjectName + '" id="fileChooser' + subjectName + '"/><br/><br/>'
                + '</div>'
                + '</td>'
                + '<td><button class="btn btn-default" type="button" onclick=removeSubject(this)>Remove this subject</button></td>'
                + '</tr>'
                );
    } else {
        alert('That subject already exists!');
    }
}

function addFieldResult() {
    var table = document.getElementById("table-big-migrant");
    var competenceName = document.getElementById("new-competence-name").value;
    var resultName = document.getElementById("new-result-name").value;
    console.log('competence: ' + competenceName);
    var duplicate = false;
    for (var i = 0, row; row = table.rows[i]; i++) {
        console.log(row.id);
        if (row.id === resultName) {
            duplicate = true;
        }
    }
    if (!duplicate) {
        var x = document.getElementsByClassName(competenceName);
        var trCompetence = x[0];
        var tdCompetence = x[1];
        console.log(x);
        if (x.length === 0) {
            console.log('usao u if');
            $('#new-results-container').append('<tr id="' + resultName + '" class="' + competenceName + '" >'
                    + '<td class="' + competenceName + '" >' + competenceName + '</td>'
                    + '<td class="res-name">' + resultName + '</td>'
                    + '<td>'
                    + '<div class="radio">'
                    + '<label>'
                    + '<input type="radio" name="radio' + resultName + '" value="low"> Low<br>'
                    + '</label>'
                    + '</div>'
                    + '<div class="radio">'
                    + '<label>'
                    + '<input type="radio" name="radio' + resultName + '" value="medium"> Medium<br>'
                    + '</label>'
                    + '</div>'
                    + '<div class="radio">'
                    + '<label>'
                    + '<input type="radio" name="radio' + resultName + '" value="high"> High'
                    + '</label>'
                    + '</div>'
                    + '</td>'
                    + '<td><textarea class="form-control" name="input' + resultName + '" size="160"></textarea></td>'
                    + '<td><input class="btn btn-default" type="button" value="Delete record" onclick="deleteRecordResult(this)" /></td>'
                    + '</tr>');
            var x = document.getElementsByClassName(competenceName);
            var trCompetence = x[0];
            var tdCompetence = x[1];
        } else {
            tdCompetence.rowSpan = tdCompetence.rowSpan + 1;
            $('<tr id="' + resultName + '" class="res-name">'
                    + '<td>' + resultName + '</td>'
                    + '<td>Level'
                    + '<div class="radio">'
                    + '<label>'
                    + '<input type="radio" name="newradio' + resultName + '" value="low"> Low<br>'
                    + '</label>'
                    + '</div>'
                    + '<div class="radio">'
                    + '<label>'
                    + '<input type="radio" name="newradio' + resultName + '" value="medium"> Medium<br>'
                    + '</label>'
                    + '</div>'
                    + '<div class="radio">'
                    + '<label>'
                    + '<input type="radio" name="newradio' + resultName + '" value="high"> High<br>'
                    + '</label>'
                    + '</div>'
                    + '</td>'
                    + '<td>Note: <textarea class="form-control" name="newinput' + resultName + '_' + competenceName + '" size="160"></textarea></td>'
                    + '<td><input class="btn btn-default" type="button" value="Remove sub-competence" onclick="removeResult(this)" /></td>'
                    + '</tr>').insertAfter(trCompetence);
        }

    } else {
        alert('That subject already exists!');
    }
}

function removeSubject(s) {
    var i = s.parentNode.parentNode.rowIndex;
    document.getElementById("table-big-migrant").deleteRow(i);
}

function removeResult(s) {
    var competenceName = document.getElementById("new-competence-name").value;
    var x = document.getElementsByClassName(competenceName);
    var tdCompetence = x[1];
    tdCompetence.rowSpan = tdCompetence.rowSpan - 1;
    var i = s.parentNode.parentNode.rowIndex;
    document.getElementById("table-big-migrant").deleteRow(i);
}

function deleteRecordSubject(subject) {
    var i = subject.parentNode.parentNode.rowIndex;
    console.log(i);
    var x = document.getElementsByClassName("subj-name");
    var subjName = x[i - 2].innerHTML;
    $('#form-student').append('<input type="hidden" id="akcija" name="delete' + subjName + '" />');
    document.getElementById("table-big-migrant").deleteRow(i);
}

function deleteRecordResult(result) {
    var i = result.parentNode.parentNode.rowIndex;
    console.log(i);
    var x = document.getElementsByClassName("res-name");
    var resName = x[i - 1].innerHTML;
    console.log(resName);
    $('#form-edit-student-view').append('<input type="hidden" id="akcija" name="delete' + resName + '" />');
    document.getElementById("table-big-migrant").deleteRow(i);
    var competenceName = document.getElementById("new-competence-name").value;
    var x = document.getElementsByClassName(competenceName);
    var tdCompetence = x[1];
    tdCompetence.rowSpan = tdCompetence.rowSpan - 1;
}

$(document).ready(function () {
    $('#characterLeft').text('140 characters left');
    $('#message').keydown(function () {
        var max = 140;
        var len = $(this).val().length;
        if (len >= max) {
            $('#characterLeft').text('You have reached the limit');
            $('#characterLeft').addClass('red');
            $('#btnSubmit').addClass('disabled');
        } else {
            var ch = max - len;
            $('#characterLeft').text(ch + ' characters left');
            $('#btnSubmit').removeClass('disabled');
            $('#characterLeft').removeClass('red');
        }
    });
});

function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function validateName(name, lastName) {
    if (name.length > 1 && lastName.length > 1) {
        return true;
    }
    return false;
}

function validate() { /*email validation*/
    $("#result").text("");
    var email = $("#email-input").val();
    var name = $("#first-name").val();
    var lastName = $("#last-name").val();
    if (validateEmail(email) && validateName(name, lastName)) {
        $("#contact-form").submit();
    } else {
        $("#result").text("Email not valid or name is too short");
        $("#result").css("color", "red");
    }
    return false;
}

$("#registration-submit").bind("click", validate);


