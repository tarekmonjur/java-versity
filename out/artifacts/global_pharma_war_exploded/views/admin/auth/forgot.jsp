<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/13/2017
  Time: 2:43 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="login-box-body">
    <p class="login-box-msg">Send Password Reset Email.</p>

    <form action="${baseUrl}/admin/forgot" method="post">
        <div class="form-group has-feedback">
            <input type="email" name="email" value="${email}" class="form-control" placeholder="Email">
            <span class="text-danger">${error_email}</span>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="row">
            <div class="col-xs-6 col-xs-offset-6">
                <button type="submit" class="btn btn-primary btn-block btn-flat">Send Reset Mail</button>
            </div>
            <!-- /.col -->
        </div>
    </form>
    <a href="${baseUrl}/admin/login">Login</a><br>

</div>
