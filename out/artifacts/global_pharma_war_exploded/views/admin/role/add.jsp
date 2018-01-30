<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/19/2017
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>

<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">Add New Role/Level </h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/role/view">View Roles</a>
            </div>
            <form role="form" id="role_add" action="${baseUrl}/role/add" method="post">
                <div class="box-body">
                    <div class="form-group">
                        <label for="role_name">Role Name <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="role_name" name="role_name" placeholder="Enter role name..">
                    </div>
                    <div class="form-group">
                        <label for="role_description">Role Description</label>
                        <textarea class="form-control" id="role_description" name="role_description" placeholder="Enter role description.."></textarea>
                    </div>
                </div>
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Create Role</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $("#role_add").validate({
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
