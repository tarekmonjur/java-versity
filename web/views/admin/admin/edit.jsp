<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/21/2017
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Admin.Models.Entities.AdminEntity" %>
<% AdminEntity admin = (AdminEntity) request.getAttribute("admin");%>
<%@ page import="Admin.Models.Entities.RoleEntity" %>
<%@ page import="java.util.List" %>
<% List<RoleEntity> roles = (List<RoleEntity>) request.getAttribute("roles");%>

<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">Edit Admin </h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/admin/view">View Admins</a>
            </div>
            <form role="form" id="admin_add" action="${baseUrl}/admin/edit/<%=admin.getId()%>" method="post">
                <div class="box-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="first_name">First Name <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="first_name" name="first_name" value="<%=admin.getFirstName()%>" placeholder="Enter first name..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="last_name">Last Name <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="last_name" name="last_name" value="<%=admin.getLastName()%>" placeholder="Enter last name..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="email">Email Address <span class="text-danger">*</span></label>
                                <input type="email" class="form-control" id="email" name="email" value="<%=admin.getEmail()%>" placeholder="Enter email address..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="mobile_no">Mobile No <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" id="mobile_no" name="mobile_no" value="<%=admin.getMobileNo()%>" placeholder="Enter mobile no..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="password">Password <small class="text-danger">(please empty this field, if you don't want to change password.)</small></label>
                                <input type="text" class="form-control" id="password" name="password" placeholder="Enter password..">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="retype_password">Retype Password</label>
                                <input type="text" class="form-control" id="retype_password" name="retype_password" placeholder="Enter retype password..">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="role_id">Admin Role <span class="text-danger">*</span></label>
                                <select class="form-control" name="role_id" id="role_id">
                                    <option value="">-- Select Role --</option>
                                    <% for(RoleEntity role : roles){%>
                                    <option value="<%=role.getId()%>" <%if(role.getId() == admin.getRoleId()){%> selected <%}%> ><%= role.getRoleName()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="photo">Photo <small class="text-danger">(please skip this, if you don't want to change photo.)</small></label>
                                <input type="file" class="form-control" id="photo" name="photo">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Update Admin</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $("#admin_add").validate({
        rules: {
            first_name: {
                required: true,
                minlength: 2,
                maxlength: 10
            },
            last_name: {
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
                minlength: 6,
                maxlength: 20
            },
            retype_password: {
                minlength: 6,
                maxlength: 20,
                equalTo: "#password"
            },
            role_id: {
                required: true
            }
        }
    });
</script>
