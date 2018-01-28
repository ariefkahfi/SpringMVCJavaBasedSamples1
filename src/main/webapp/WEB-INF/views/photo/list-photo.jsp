<%@ page import="com.arief.mvc.models.Album" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arief.mvc.models.Photo" %>
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
                                <select name="album_id" id="album_id" class="form-input-left">
                                    <%
                                        List<Album> albumList = (List<Album>)request.getAttribute("listAlbum");
                                    %>
                                    <%
                                        for(Album a : albumList){
                                    %>
                                            <option value="<%=a.getAlbumId()%>">
                                                <%=a.getAlbumName()%>
                                            </option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-row">
                                <input type="submit" value="Get Photo" class="form-button form-button-blue"/>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="left-container-content clearfix" id="left-container-content-photos-card">
                    <%
                        List<Photo> photosForAlbum = (List<Photo>)request.getAttribute("photoList");
                    %>
                    <%
                        if(photosForAlbum != null){
                    %>
                            <%
                                for(Photo p  : photosForAlbum){
                            %>
                                    <div class="card">
                                        <span class="card-delete" onclick="deletePhoto('<%=p.getPhotoId()%>')">Delete</span>
                                        <h3 class="card-title title">
                                            <%=p.getPhotoName()%>
                                        </h3>
                                        <img src="<%=p.getPhotoUrl()%>" class="card-image" alt="no image"/>
                                        <div class="card-content">
                                            <div class="card-content-desc">
                                                Photo ID : <%=p.getPhotoId()%>
                                            </div>
                                            <div class="card-content-desc">
                                                Photo Name : <%=p.getPhotoName()%>
                                            </div>
                                        </div>
                                    </div>
                            <%
                                }
                            %>
                    <%
                        }
                    %>
                </div>
            </div>

        </div>
</body>
    <script src="${pageContext.servletContext.contextPath}/resources/js/list-photo.js"></script>
</html>
