<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/20/2017
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Admin.Models.Entities.RoleEntity" %>
<% RoleEntity role = (RoleEntity) request.getAttribute("role");%>
<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">Edit Role/Level</h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/role/view">View Roles</a>
            </div>
            <form role="form" id="role_edit" action="${baseUrl}/role/edit/<%=role.getId()%>" method="post">
                <input type="hidden" value="put" name="_method">
                <input type="hidden" value="<%=role.getCompanyId()%>" name="company_id">
                <div class="box-body">
                    <div class="form-group">
                        <label for="role_name">Role Name <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="role_name" name="role_name" value="<%=role.getRoleName()%>" placeholder="Enter role name..">
                    </div>
                    <div class="form-group">
                        <label for="role_description">Role Description</label>
                        <textarea class="form-control" id="role_description" name="role_description" placeholder="Enter role description.."><%=role.getRoleDescription()%></textarea>
                    </div>
                </div>
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Update Role</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
    $("#role_edit").validate({
        rules: {
            role_name: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            role_description: {
                required: true,
                minlength: 5,
                maxlength: 500
            }
        }
    });
</script>