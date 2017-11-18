<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>MeGrow - Track Education While in Migration</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="An App for Tracking Migrants' Education Achievements as They Travel Through Different Countries">
        <meta name="author" content="Jovan Toroman">
        <link rel="icon" href="./resources/favicon.ico">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link type="text/css" rel="stylesheet" href="./css/style.css"/>

        <script src="./resources/script.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <jsp:include page="../jsp/content/${param.content}.jsp"></jsp:include>
            </div>
            <script>window.jQuery || document.write('<script src="../resources/jquery.min.js"><\/script>')</script>
            <script src="./resources/bootstrap.min.js"></script>
        </body>
    <%@include file="footer.jsp"%>
</html>

