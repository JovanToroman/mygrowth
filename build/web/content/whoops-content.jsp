<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="bundle.appBundle_en" var="resourceBundle"></fmt:setBundle>
<body>        
    <div class="container">
        <h2>Whoops. Looks like you lost your way. You'll be redirected to our home page before you can add up 13 + 25!</h2>
        <progress value="0" max="5" id="progressBar"></progress>
    </div>
</body>
<script>t1 = window.setTimeout(function () {
        window.location = "./";
    }, 5000);
    var timeleft = 5;
    var downloadTimer = setInterval(function () {
        document.getElementById("progressBar").value = 5 - --timeleft;
        if (timeleft <= 0)
            clearInterval(downloadTimer);
    }, 1000);</script>

