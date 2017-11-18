<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
    <div class="container">

        <!-- Static navbar -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./">MeGrow</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">                        
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${teacher_logged_in == null || migrant_logged_in == null}">
                            <li><a href="./register-student.jsp"><img id="register-student-img" class="img-login col-md-4" src="./resources/Dari-pashto-register_new_student.png"></a></li>
                            <li><a href="./register-teacher.jsp">Register new teacher</a></li>
                        </c:if>
                        <li><a href="./about.jsp">About</a></li>
                        <li><a href="./contact.jsp">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>

        <!-- Main component for a primary marketing message or call to action -->
        <div class="jumbotron" id="call-to-action">
            <h1>We Grow by Educating Ourselves</h1>
            <p>On their long journey in search of better life, migrants from war-plagued countries go through many challenges. One of them is finding a way to educate themselves while on the go, and having their achievements internationally recognized. We provide a platform to do just that.</p>
            <p>
                <a class="btn btn-lg btn-primary" href="./about.jsp" role="button">Find out more</a>
            </p>
        </div>
    </div>
    <c:if test="${teacher_logged_in != null || migrant_logged_in != null}">
        <a id="logout-link" href="./login-landing.jsp">Logout</a>
    </c:if>    
    <c:if test="${teacher_logged_in != null && migrant_logged_in != null}">
        <h3 class="logged-in-greeting">Hello, ${teacher_logged_in.firstName} ${teacher_logged_in.lastName}</h3>
    </c:if>
    <c:if test="${migrant_logged_in != null && teacher_logged_in == null}">
        <h3 class="logged-in-greeting">Hello, ${migrant_logged_in.firstName} ${migrant_logged_in.lastName}</h3>
    </c:if>
</header>