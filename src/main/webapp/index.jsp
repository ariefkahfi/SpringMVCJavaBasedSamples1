<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/navbar.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/form.css"/>

    <%--responsive style--%>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/responsive.css"/>
</head>
<body>

    <%@include file="assets/html/navbar.html"%>

    <%--index's content--%>
    <div class="container clearfix">

        <div class="left-container-for-jumbotron">
            <div class="jumbotron-container">
                <h1 class="jumbotron-title title">Home Page</h1>
                <p class="jumbotron-p no-margin">
                    This is an example to show the potential of an offcanvas layout pattern in Bootstrap.
                    Try some responsive-range viewport sizes to see it in action.
                </p>
            </div>
        </div>

        <%@include file="assets/html/right-container.html"%>

        <div class="left-container clearfix">
            <div class="card floating-left util-card-width">
                <h3 class="title card-title">Card Title</h3>
                <div class="card-content">
                    <p class="no-margin">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab praesentium, similique. At atque earum itaque nam quas reprehenderit soluta voluptates.</p>
                </div>
            </div>
            <div class="card floating-left util-card-width">
                <h3 class="title card-title">Card Title</h3>
                <div class="card-content">
                    <p class="no-margin">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab praesentium, similique. At atque earum itaque nam quas reprehenderit soluta voluptates.</p>
                </div>
            </div>
            <div class="card floating-left util-card-width">
                <h3 class="title card-title">Card Title</h3>
                <div class="card-content">
                    <p class="no-margin">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab praesentium, similique. At atque earum itaque nam quas reprehenderit soluta voluptates.</p>
                </div>
            </div>
        </div>

    </div>
    <%--index's content--%>

</body>
</html>
