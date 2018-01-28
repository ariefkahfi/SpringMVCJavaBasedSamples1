<%@ page import="com.arief.mvc.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arief.mvc.models.Album" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Album</title>
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
                    <h1 class="jumbotron-title">Album's List</h1>
                    <p class="jumbotron-p no-margin">
                        This is an example to show the potential of an offcanvas layout pattern in Bootstrap.
                        Try some responsive-range viewport sizes to see it in action.
                    </p>
                </div>
            </div>

            <%@include file="../../../assets/html/right-container.html"%>

            <div class="left-container clearfix">
                <h2 class="left-container-title">List Album</h2>

                <div class="left-container-content">

                    <div class="form-wrapper">
                        <form action="${pageContext.servletContext.contextPath}/album/list-album/user" method="get">
                            <div class="form-row clearfix">
                                <label for="user_id" class="form-label">User ID</label>
                                <select name="user_id" id="user_id" class="form-input-left">
                                    <%
                                        List<User> userList = (List<User>)request.getAttribute("listUser");
                                    %>
                                    <%
                                        for(User u : userList){
                                    %>
                                        <option value="<%=u.getUserId()%>">
                                            <%=u.getUserName()%>
                                        </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-row clearfix">
                                <input type="submit" value="Get album"/>
                            </div>
                        </form>
                    </div>

                </div>

                <div class="left-container-content">

                    <%
                        List<Album> usersAlbum = (List<Album>)request.getAttribute("usersAlbum");
                    %>
                    <%
                        if(usersAlbum != null){
                    %>
                        <button class="form-button" onclick="clearTable()">Clear table</button>
                        <table border="2" class="tables">
                            <tr>
                                <td>Album ID</td>
                                <td>Album Name</td>
                            </tr>
                        <%
                            for (Album a : usersAlbum){
                        %>
                            <tr>
                                <td><%=a.getAlbumId()%></td>
                                <td><%=a.getAlbumName()%></td>
                            </tr>
                        <%
                            }
                        %>
                        </table>
                    <%
                        }
                    %>
                </div>

            </div>

        </div>
</body>
    <script src="${pageContext.servletContext.contextPath}/resources/js/list-album.js"></script>
</html>
