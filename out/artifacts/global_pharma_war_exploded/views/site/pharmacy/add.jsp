<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/8/2018
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="Site.Models.Entities.LocationEntity" %>

<section class="container maincont">
    <h1 class="main-ttl"><span>Pharmacy Registration</span></h1>

    <div class="auth-wrap">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h6 style="border: 1px solid #aff3b4; padding: 5px;">After registration authority verify the pharmacy, then pharmacy access admin panel by pharmacy email and password to ${baseUrl}/admin</h6>
                <br>
                <form action="${baseUrl}/registration" method="post" id="pharmacy_add">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="companyName">Pharmacy Name</label>
                                <input type="text" class="custom-input" id="companyName" value="${companyName}" name="companyName" placeholder="Enter Pharmacy Name..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="companyCode">Pharmacy Code</label>
                                <input type="text" class="custom-input" id="companyCode" value="${companyCode}" name="companyCode" placeholder="Enter Pharmacy Code..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="companyContactEmail">Pharmacy Contact Email Address</label>
                                <input type="text" class="custom-input" id="companyContactEmail" value="${companyContactEmail}" name="companyContactEmail" placeholder="Enter Pharmacy Contact Email..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="companyContactMobileNo">Pharmacy Contact Mobile No</label>
                                <input type="text" class="custom-input" id="companyContactMobileNo" value="${companyContactMobileNo}" name="companyContactMobileNo" placeholder="Enter Pharmacy Contact Mobile No..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="password">Password <small class="text-primary">( Its for admin panel login. )</small></label>
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
                                <label class="custom-label" for="location">Pharmacy Location</label>
                                <select class="custom-input" name="location" id="location">
                                    <option value="">--- Select Location ---</option>
                                    <% for(LocationEntity location : (List<LocationEntity>) request.getAttribute("locations")){%>
                                    <option value="<%=location.getId()%>"><%= location.getLocationName()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="companyLogo">Profile Picture</label>
                                <input type="file" id="companyLogo" name="companyLogo">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="custom-label" for="pharmacyAddress">Pharmacy Address</label>
                                <textarea name="pharmacyAddress" class="custom-input" id="pharmacyAddress" style="min-height: 50px"></textarea>
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

<script>
    $("#pharmacy_add").validate({
        rules: {
            companyName: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            companyCode: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            companyContactEmail: {
                required: true,
                email: true,
                minlength: 2,
                maxlength: 50
            },
            companyContactMobileNo: {
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
            location: {
                required: true
            },
            pharmacyAddress: {
                required: true,
                minlength: 6,
                maxlength: 100,
            },
            companyLogo: {
                required: true,
                extension: "jpeg|jpg|png"
            }
        }
    });
</script>