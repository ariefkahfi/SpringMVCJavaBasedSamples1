<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Album</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/navbar.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/form.css"/>

    <%--responsive style--%>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/responsive.css"/>
</head>
<body>
    <%@include file="../../../assets/html/navbar.html"%>

    <%--form-album's content--%>
        <div class="container clearfix">

            <div class="left-container-for-jumbotron">
                <div class="jumbotron-container">
                    <h1 class="jumbotron-title">Album's Form</h1>
                    <p class="jumbotron-p no-margin">
                        This is an example to show the potential of an offcanvas layout pattern in Bootstrap.
                        Try some responsive-range viewport sizes to see it in action.
                    </p>
                </div>
            </div>

            <%@include file="../../../assets/html/right-container.html"%>

            <div class="left-container clearfix">
                <h2 class="left-container-title">Ini Halaman Form Album</h2>
                <div class="left-container-content">
                    <div class="form-wrapper">
                        <form action="${pageContext.servletContext.contextPath}/album/form-album" method="POST">
                            <div class="form-row clearfix">
                                <label for="album_id" class="form-label">Album ID</label>
                                <input type="text" name="album_id" class="form-input form-input-left" id="album_id"/>
                            </div>

                            <div class="form-row clearfix">
                                <label for="album_name" class="form-label">Album Name</label>
                                <input type="text" name="album_name" id="album_name" class="form-input form-input-left"/>
                            </div>

                            <div class="form-row clearfix">
                                <label for="album_user_id" class="form-label">Album's User</label>
                                <select name="album_user_id" id="album_user_id" class="form-input-left">

                                </select>
                            </div>

                            <div class="form-row clearfix">
                                <input type="submit" value="Submit Data" class="form-button form-button-blue"/>
                            </div>

                        </form>
                    </div>
                </div>
            </div>

        </div>
    <%--form-album's content--%>

</body>
</html>
