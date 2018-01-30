<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/11/2017
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String baseUrl = (String) request.getAttribute("baseUrl");%>
<% String pageUri =(String) request.getAttribute("pageUri");%>
<% String msgSuccess =(String) request.getAttribute("msg_success");%>
<% String msgError =(String) request.getAttribute("msg_error");%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${appName} | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${assets}bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${assets}bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${assets}bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${assets}css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${assets}plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <style>
        .login-page{
            background-image: url("${assets}images/login_bg.jpg") !important;
            background-size: cover;
        }
    </style>
</head>
<body class="hold-transition login-page">
<div class="login-box" style="margin: 0% auto!important; padding-top: 80px!important;">
    <div class="login-logo">
        <a href="${baseUrl}/admin" style="color: #fff"><b>${appName}</b></a>
    </div>

    <% if(msgSuccess !=null){%>
    <div class="alert alert-success alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <h4><i class="icon fa fa-check"></i> Message!</h4>
        ${msg_success}
    </div>
    <% } %>

    <% if(msgError !=null){%>
    <div class="alert alert-danger alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <h4><i class="icon fa fa-ban"></i> Message!</h4>
        ${msg_error}
    </div>
    <% } %>

    <%
        String pageName = (String) request.getAttribute("pageName");
        if(pageName !=null){
            if(!pageName.isEmpty()){
    %>
                <jsp:include page="<%= pageName %>" flush="true"></jsp:include>
    <%
            }
        }
    %>
</div>

<!-- jQuery 3 -->
<script src="${assets}bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${assets}bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${assets}plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>

