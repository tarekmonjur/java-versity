<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/21/2017
  Time: 1:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="Admin.Models.Entities.AdminEntity" %>

<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">Admins List</h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/admin/add">Add Admin</a>
            </div>
            <div class="box-body no-padding">
                <table id="example2" class="table table-bordered table-hover">
                    <thead class="bg-green">
                    <tr>
                        <th>SL</th>
                        <th>Full Name</th>
                        <th>Photo</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>Role/Level</th>
                        <th>Status</th>
                        <th>Created</th>
                        <th>Updated</th>
                        <th width="120px">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% int i=1; for( AdminEntity admin : (List<AdminEntity>) request.getAttribute("admins")){%>
                    <tr>
                        <td><%= i++%></td>
                        <td><%= admin.getFullName()%></td>
                        <td><%= admin.getPhoto()%></td>
                        <td><%= admin.getEmail()%></td>
                        <td><%= admin.getMobileNo()%></td>
                        <td><%= admin.getRoleId()%></td>
                        <td><%= admin.getStatus()%></td>
                        <td><%= admin.getCreatedAt()%></td>
                        <td><%= admin.getUpdatedAt()%></td>
                        <td>
                            <div class="btn btn-group">
                                <a href="${baseUrl}/admin/edit/<%=admin.getId()%>" class="btn btn-xs btn-primary">Edit</a>
                                <a onclick="deleteData('role', '${baseUrl}/admin/delete/<%=admin.getId()%>')" href="#" class="btn btn-xs btn-danger">Delete</a>
                            </div>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
            <div class="box-footer clearfix">
                <span>Total Record is <strong>${totalRow}</strong></span>
                <ul class="pagination pagination-sm no-margin pull-right">
                    <% Integer totalPage = (Integer) request.getAttribute("totalPage");
                        if(totalPage > 0){%>
                    <li><a href="${baseUrl}/admin/view/0">«</a></li>
                    <% for(i=1; i<=totalPage; i++){%>
                    <li><a href="${baseUrl}/admin/view/<%= i%>"><%= i%></a></li>
                    <%}%>
                    <li><a href="${baseUrl}/admin/view/<%= i%>">»</a></li>
                    <%}%>
                </ul>
            </div>
        </div>
    </div>
</div>
