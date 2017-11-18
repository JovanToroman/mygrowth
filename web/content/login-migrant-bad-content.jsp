<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="bundle.appBundle_en" var="resourceBundle"></fmt:setBundle>
    <body>
        <div class="container">
            <form class="form-signin" action="./aplikacija" method="POST">
                <h2 class="form-signin-heading"><fmt:message key="login.label.migrantcode" bundle="${resourceBundle}"></fmt:message></h2>
                <label for="inputPassword" class="sr-only">Student code</label>
                <input type="password" name="inputSifraMigranta" id="inputPassword" class="form-control" placeholder="Student code" required>        
                <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.button.login" bundle="${resourceBundle}"></fmt:message></button>
            <input type="hidden" name="akcija" value="prijaviSeMigrant" />
        </form>
            <h4 class="error-info">The data you entered doesn't match any student record.</h4>
    </div>
    
</body>