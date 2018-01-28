<%@ page import="com.arief.mvc.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: arief
  Date: 28/01/18
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User Page</title>
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
                    <h1 class="jumbotron-title">User's List</h1>
                    <p class="jumbotron-p no-margin">
                        This is an example to show the potential of an offcanvas layout pattern in Bootstrap.
                        Try some responsive-range viewport sizes to see it in action.
                    </p>
                </div>
            </div>

            <%@include file="../../../assets/html/right-container.html"%>

            <div class="left-container clearfix">
                <h2 class="left-container-title">List User</h2>
                <div class="left-container-content">
                    <table border="2" class="tables">
                        <tr>
                            <td>User's ID</td>
                            <td>User's Name</td>
                        </tr>
                        <%
                            List<User> userList= (List<User>)request.getAttribute("listUser");
                        %>
                        <%
                            for (User u : userList){
                        %>
                            <tr>
                                <td><%=u.getUserId()%></td>
                                <td><%=u.getUserName()%></td>
                            </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>

        </div>
</body>
</html>
