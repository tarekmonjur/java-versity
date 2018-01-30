<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/13/2017
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="login-box-body">
    <p class="login-box-msg">Reset your password.</p>

    <form action="${baseUrl}/admin/reset/${token}" method="post">
        <input type="hidden" value="${token}" name="token">
        <div class="form-group has-feedback">
            <input type="email" name="email" value="${email}" class="form-control" placeholder="Email">
            <span class="text-danger">${error_email}</span>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" name="password" class="form-control" placeholder="Password">
            <span class="text-danger">${error_password}</span>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" name="retype_password" class="form-control" placeholder="Retype Password">
            <span class="text-danger">${error_retype}</span>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="row">
            <div class="col-xs-6 col-xs-offset-6">
                <button type="submit" class="btn btn-primary btn-block btn-flat">Reset Password</button>
            </div>
        </div>
    </form>
    <a href="${baseUrl}/admin/login">Login</a><br>
    <a href="${baseUrl}/admin/forgot">I forgot my password</a><br>

</div>
