<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/11/2017
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Admin.Models.Entities.AdminEntity" %>

<% String baseUrl = (String) request.getAttribute("baseUrl");%>
<% String uri1 =(String) request.getAttribute("uri1");%>
<% String uri2 =(String) request.getAttribute("uri2");%>
<% String pageUri = uri1 +"/"+uri2;%>
<% String msgSuccess =(String) request.getAttribute("msg_success");%>
<% String msgError =(String) request.getAttribute("msg_error");%>
<%
    HttpSession authSession = request.getSession(false);
    AdminEntity auth = (AdminEntity) authSession.getAttribute("admin");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keyword" content="medicine">
    <meta name="description" content="">
    <meta name="author" content="TarekMonjur">
    <title>Global Pharma</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${assets}bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${assets}bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${assets}bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${assets}css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${assets}css/skins/_all-skins.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${assets}bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="${assets}bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="${assets}bower_components/bootstrap-daterangepicker/daterangepicker.css">
    <!-- Confirm Js -->
    <link rel="stylesheet" href="${assets}plugins/confirm/jquery-confirm.min.css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    <style>
        label.error{color: rgba(255, 0, 0, 0.82) }
    </style>

    <!-- jQuery 3 -->
    <script src="${assets}bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${assets}js/jquery1.17.0.validate.min.js"></script>

</head>
<!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
<!-- the fixed layout is not compatible with sidebar-mini -->
<body class="hold-transition skin-green fixed sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <!-------------- top header ---------------->
    <%@ include file= "common/header.jsp"%>
    <!-- =============================================== -->

    <!--------- Left side sidebar -------------->
    <%@ include file="common/sidebar.jsp"%>
    <!-- =============================================== -->

    <!-- Content Wrapper. Contains page content -->
    <% String pageName = (String) request.getAttribute("pageName"); %>
    <div class="content-wrapper">
        <%
            if(pageName !=null){
                if(!pageName.isEmpty()){
                %>
                <section class="content">
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

                    <jsp:include page="<%= pageName %>" flush="true"></jsp:include>
                </section>
                <%
                }
            }else{
                %>
                <jsp:include page="../errors/404.jsp" />
        <%  } %>

    </div>

    <!-------------- bottom footer --------------->
    <%@ include file="common/footer.jsp"%>
    <!-- =============================================== -->
</div>
<!-- ./wrapper -->


<!-- Bootstrap 3.3.7 -->
<script src="${assets}bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="${assets}bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- DataTables -->
<script src="${assets}bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${assets}bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- bootstrap datepicker -->
<script src="${assets}bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- SlimScroll -->
<script src="${assets}bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${assets}bower_components/fastclick/lib/fastclick.js"></script>
<!-- Confirm Js -->
<script src="${assets}plugins/confirm/jquery-confirm.min.js"></script>
<!-- AdminLTE App -->
<script src="${assets}js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${assets}js/demo.js"></script>

<script>

    function deleteData(msg, url){
        $.confirm({
            theme: 'bootstrap',
            type: 'red',
            icon: 'fa fa-warning',
            title: 'Are you sure delete this '+msg+' ?',
            content: '<h5>You will not be able to recover this imaginary data!</h5>',
            draggable: true,
            alignMiddle: true,
            animation: 'rotateXR',
            closeAnimation: 'rotateXR',
            buttons: {
                confirm: {
                    text: 'Yes, delete it.',
                    btnClass: 'btn-danger',
                    keys: ['enter', 'y'],
                    action: function () {
                        window.location.href =url;
                    }
                },
                cancel: {
                    text: 'Cancel delete.',
                    btnClass: 'btn-green',
                    keys: ['esc', 'n'],
                }
            }
        });
        return false;
    }

    $(function () {
        $('#datatable1').DataTable();
        $('#datatable2').DataTable({
            'paging'      : false,
            'lengthChange': false,
            'searching'   : true,
            'ordering'    : true,
            'info'        : false,
            'autoWidth'   : false
        });

        //Date picker
        $('.datepicker').datepicker({
            autoclose: true,
            format: "yyyy-mm-dd"
        });

//            $('.timepicker').timepicker();

        $('.select2').select2();

        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
            checkboxClass: 'icheckbox_minimal-red',
            radioClass   : 'iradio_minimal-red'
        })
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass   : 'iradio_flat-green'
        })
    });
</script>
</body>
</html>

