<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/3/2018
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Site.Models.Entities.UserEntity" %>

<% String baseUrl = (String) request.getAttribute("baseUrl");%>
<% String uri1 =(String) request.getAttribute("uri1");%>
<% String uri2 =(String) request.getAttribute("uri2");%>
<% String pageUri = uri1 +"/"+uri2;%>
<% String msgSuccess =(String) request.getAttribute("msg_success");%>
<% String msgError =(String) request.getAttribute("msg_error");%>
<% String pageName = (String) request.getAttribute("pageName"); %>
<%
    HttpSession authSession = request.getSession(false);
    UserEntity auth = (UserEntity) authSession.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <title>${appName}</title>

    <link href="https://fonts.googleapis.com/css?family=PT+Serif:400,400i,700,700ii%7CRoboto:300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic" rel="stylesheet">

    <link rel="stylesheet" href="${assets}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${assets}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${assets}/css/ion.rangeSlider.css">
    <link rel="stylesheet" href="${assets}/css/ion.rangeSlider.skinFlat.css">
    <link rel="stylesheet" href="${assets}/css/jquery.bxslider.css">
    <link rel="stylesheet" href="${assets}/css/jquery.fancybox.css">
    <link rel="stylesheet" href="${assets}/css/flexslider.css">
    <link rel="stylesheet" href="${assets}/css/swiper.css">
    <link rel="stylesheet" href="${assets}/css/swiper.css">
    <link rel="stylesheet" href="${assets}/css/style.css">
    <link rel="stylesheet" href="${assets}/css/media.css">

    <style>
        label.error{color: rgba(255, 0, 0, 0.82) }
    </style>

    <script src="${assets}/js/jquery-1.11.2.min.js"></script>
    <script src="${assets}/js/jquery1.17.0.validate.min.js"></script>
</head>
<body>

<!-- Header - start -->
<%@ include file= "common/header.jsp"%>
<!-- Header - end -->

<!-- Main Content - start -->
<main>
<%
    if(pageName !=null){
        if(!pageName.isEmpty())
        {
            %>

            <% if(msgSuccess !=null){%>
            <div class="container">
            <div class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                <h4><i class="icon fa fa-check"></i> Message!</h4>
                ${msg_success}
            </div>
            </div>
            <% } %>

            <% if(msgError !=null){%>
            <div class="container">
            <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                <h4><i class="icon fa fa-ban"></i> Message!</h4>
                ${msg_error}
            </div>
            </div>
            <% } %>

            <jsp:include page="<%= pageName %>" flush="true"></jsp:include>
            <%
        }
    }
    else
    {
        %>
        <jsp:include page="../errors/404.jsp" />
<%  } %>
</main>
<!-- Main Content - end -->

<!-- Footer - start -->
<%@ include file= "common/footer.jsp"%>
<!-- Footer - end -->

<!-- jQuery plugins/scripts - start -->
<script src="${assets}/js/jquery.bxslider.min.js"></script>
<script src="${assets}/js/fancybox/fancybox.js"></script>
<script src="${assets}/js/fancybox/helpers/jquery.fancybox-thumbs.js"></script>
<script src="${assets}/js/jquery.flexslider-min.js"></script>
<script src="${assets}/js/swiper.jquery.min.js"></script>
<script src="${assets}/js/jquery.waypoints.min.js"></script>
<script src="${assets}/js/progressbar.min.js"></script>
<script src="${assets}/js/ion.rangeSlider.min.js"></script>
<script src="${assets}/js/chosen.jquery.min.js"></script>
<script src="${assets}/js/jQuery.Brazzers-Carousel.js"></script>
<script src="${assets}/js/plugins.js"></script>
<script src="${assets}/js/main.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDhAYvx0GmLyN5hlf6Uv_e9pPvUT3YpozE"></script>
<script src="${assets}/js/gmap.js"></script>
<!-- jQuery plugins/scripts - end -->

</body>
</html>
