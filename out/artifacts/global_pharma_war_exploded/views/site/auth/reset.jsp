<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/7/2018
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>

<section class="container stylization maincont">
    <h1 class="main-ttl"><span>Reset Password</span></h1>
    <div class="auth-wrap">
        <div class="auth-col">
            <form method="post" action="${baseUrl}/reset/${token}" class="login">
                <input type="hidden" value="${token}" name="token">
                <p>
                    <label for="username">E-mail <span class="required">*</span></label><input type="email" name="email" value="${email}" id="username" placeholder="Enter email..">
                    <span style="margin-left: 120px" class="text-danger">${error_email}</span>
                </p>
                <p>
                    <label for="password">New Password <span class="required">*</span></label><input type="password" name="password" id="password" placeholder="Enter new password..">
                    <span style="margin-left: 120px" class="text-danger">${error_password}</span>
                </p>
                <p>
                    <label for="retype_password">Retype New Password <span class="required">*</span></label><input type="password" name="retype_password" id="retype_password" placeholder="Enter retype new password..">
                    <span style="margin-left: 120px" class="text-danger">${error_retype}</span>
                </p>
                <p class="auth-submit">
                    <input type="submit" value="Login">
                </p>
            </form>
        </div>
    </div>

</section>
