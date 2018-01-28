<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Photo</title>
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
                    <h1 class="jumbotron-title">Photo's List</h1>
                    <p class="jumbotron-p no-margin">
                        This is an example to show the potential of an offcanvas layout pattern in Bootstrap.
                        Try some responsive-range viewport sizes to see it in action.
                    </p>
                </div>
            </div>

            <%@include file="../../../assets/html/right-container.html"%>

            <div class="left-container clearfix">
                <h2 class="left-container-title">List Photo</h2>
                <div class="left-container-content">
                    <div class="form-wrapper">
                        <form action="${pageContext.servletContext.contextPath}/photo/list-photo/album">
                            <div class="form-row clearfix">
                                <label for="album_id" class="form-label">Album ID</label>
                                <select name="album_name" id="album_id" class="form-input-left">

                                </select>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
</body>
    <script src="${pageContext.servletContext.contextPath}/resources/js/list-photo.js"></script>
</html>
