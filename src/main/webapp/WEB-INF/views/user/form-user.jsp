<%--
  Created by IntelliJ IDEA.
  User: arief
  Date: 28/01/18
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form User Page</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/navbar.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/form.css"/>

    <%--responsive style--%>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/responsive.css"/>
</head>
<body>
        <%@include file="../../../assets/html/navbar.html"%>

        <div class="container clearfix">

            <div class="left-container-for-jumbotron">
                <div class="jumbotron-container">
                    <h1 class="jumbotron-title">User's Form</h1>
                    <p class="jumbotron-p no-margin">
                        This is an example to show the potential of an offcanvas layout pattern in Bootstrap.
                        Try some responsive-range viewport sizes to see it in action.
                    </p>
                </div>
            </div>

            <%@include file="../../../assets/html/right-container.html"%>

            <div class="left-container clearfix">
                <h2 class="left-container-title">Ini Halaman Form User</h2>
                <div class="left-container-content">
                    <div class="form-wrapper">
                        <form action="${pageContext.servletContext.contextPath}/user/form-user" method="POST">

                            <div class="form-row clearfix">
                                <label for="user_id" class="form-label">User ID</label>
                                <input type="text" name="user_id" id="user_id" class="form-input form-input-left"/>
                            </div>

                            <div class="form-row clearfix">
                                <label for="user_name" class="form-label">User Name</label>
                                <input type="text" name="user_name" id="user_name" class="form-input form-input-left"/>
                            </div>

                            <div class="form-row clearfix">
                                <input type="submit" value="Submit Data" class="form-button form-button-blue"/>
                            </div>

                        </form>
                    </div>
                </div>
            </div>

        </div>
</body>
</html>
