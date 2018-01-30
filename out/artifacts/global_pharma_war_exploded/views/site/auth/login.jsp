<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/4/2018
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>

<section class="container stylization maincont">
    <h1 class="main-ttl"><span>User Login</span></h1>
    <div class="auth-wrap">
        <div class="auth-col">
            <h2>Login</h2>
            <form method="post" action="${baseUrl}/login" class="login">
                <p>
                    <label for="username">E-mail <span class="required">*</span></label><input type="email" name="email" value="${email}" id="username" placeholder="Enter your email..">
                    <span style="margin-left: 120px" class="text-danger">${error_email}</span>
                </p>
                <p>
                    <label for="password">Password <span class="required">*</span></label><input type="password" name="password" id="password" placeholder="Enter your password..">
                    <span style="margin-left: 120px" class="text-danger">${error_password}</span>
                </p>
                <p class="auth-submit">
                    <input type="submit" value="Login">
                    <input type="checkbox" id="rememberme" name="remember" value="1">
                    <label for="rememberme">Remember me</label>
                </p>
                <p class="auth-lost_password">
                    <a href="${baseUrl}/forgot">Lost your password?</a>
                </p>
            </form>
        </div>
    </div>

</section>

