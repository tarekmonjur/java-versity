<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/7/2018
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>

<section class="container stylization maincont">
    <h1 class="main-ttl"><span>Forgot Password</span></h1>
    <div class="auth-wrap">
        <div class="auth-col">
            <h2>Forgot Password Mail Send.</h2>
            <form method="post" action="${baseUrl}/forgot" class="login">
                <p>
                    <label for="username">E-mail <span class="required">*</span></label><input type="email" name="email" value="${email}" id="username" placeholder="Enter your email..">
                    <span style="margin-left: 120px" class="text-danger">${error_email}</span>
                </p>
                <p class="auth-submit">
                    <input type="submit" value="Login">
                </p>
            </form>
        </div>
    </div>

</section>