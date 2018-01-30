<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/13/2017
  Time: 1:35 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>

    <form action="${baseUrl}/admin/login" method="post">
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
        <div class="row">
            <div class="col-xs-8">
                <div class="checkbox icheck">
                    <label>
                        <input type="checkbox"> Remember Me
                    </label>
                </div>
            </div>
            <!-- /.col -->
            <div class="col-xs-4">
                <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
            </div>
            <!-- /.col -->
        </div>
    </form>
    <a href="${baseUrl}/admin/forgot">I forgot my password</a><br>

</div>