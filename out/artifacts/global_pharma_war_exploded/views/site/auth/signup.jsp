<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/4/2018
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>

<section class="container maincont">
    <h1 class="main-ttl"><span>Registration</span></h1>
    <div class="auth-wrap">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <form action="${baseUrl}/signup" method="post" id="signup" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="firstName">First Name</label>
                                <input type="text" class="custom-input" id="firstName" value="${firstName}" name="firstName" placeholder="Enter First Name..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="lastName">Last Name</label>
                                <input type="text" class="custom-input" id="lastName" value="${lastName}" name="lastName" placeholder="Enter Last Name..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="email">Email Address</label>
                                <input type="text" class="custom-input" id="email" value="${email}" name="email" placeholder="Enter Email Address..">
                                <label class="text-danger">${error_email}</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="mobile_no">Mobile No</label>
                                <input type="text" class="custom-input" id="mobile_no" value="${mobileNo}" name="mobile_no" placeholder="Enter Mobile No..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="password">Password</label>
                                <input type="password" class="custom-input" id="password" name="password" placeholder="Enter Password...">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="retype_password">Retype Password</label>
                                <input type="password" class="custom-input" id="retype_password" name="retype_password" placeholder="Enter Retype Password...">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="male">Gender</label><br>
                                Male :
                                <input type="radio" id="male" name="gender" value="male">
                                Female :
                                <input type="radio" id="female" name="gender" value="female">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="photo">Profile Picture</label>
                                <input type="file" id="photo" name="photo">
                            </div>
                        </div>
                    </div>

                    <div class="row" style="margin-top: 20px">
                        <label class="custom-label"></label>
                        <button type="submit" class="btn custom-btn" style="padding: 10px 20px">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<style>
    #gender-error{position: absolute;
        bottom: 0px;
        left: 14px;
        display: none;}
</style>
<script>
    $("#signup").validate({
        rules: {
            firstName: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            lastName: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            email: {
                required: true,
                email: true,
                minlength: 2,
                maxlength: 50
            },
            mobile_no: {
                required: true,
                minlength: 11,
                maxlength: 11
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 20
            },
            retype_password: {
                required: true,
                minlength: 6,
                maxlength: 20,
                equalTo: "#password"
            },
            gender: {
                required: true
            },
//            photo: {
//                extension: "jpeg|jpg|png"
//            }
        }
    });
</script>
