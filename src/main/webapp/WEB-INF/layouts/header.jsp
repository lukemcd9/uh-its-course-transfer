<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/" />">
                <img src="<c:url value="/resources/images/seal.jpg" />" alt="">
            </a>
            <a class="navbar-brand uh-nav-app-name" href="<c:url value="/" />">
                Course Transfer
            </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/" />">
                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/faq" />">
                        <span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span> Help
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/glossary" />">
                        <span class="glyphicon glyphicon-list" aria-hidden="true"></span> Glossary
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/contact" />">
                        <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Contact
                    </a>
                </li>
                <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <li>
                        <a href="<c:url value="/admin" />">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Admin
                        </a>
                    </li>
                </security:authorize>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
