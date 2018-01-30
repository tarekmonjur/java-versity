<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/19/2017
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Admin.Models.Entities.RoleEntity" %>
<%@ page import="java.util.List" %>

<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">Roles/Levels List</h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/role/add">Add Role</a>
            </div>
            <div class="box-body no-padding">
                <table id="example2" class="table table-bordered table-hover">
                    <thead class="bg-green">
                    <tr>
                        <th>SL</th>
                        <th>Role Name</th>
                        <th>Role Description</th>
                        <th>Created</th>
                        <th>Updated</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% int i=1; for(RoleEntity role: (List<RoleEntity>) request.getAttribute("roles")){%>
                    <tr>
                        <td><%= i++%></td>
                        <td><%= role.getRoleName()%></td>
                        <td><%= role.getRoleDescription()%></td>
                        <td><%= role.getCreatedAt()%></td>
                        <td><%= role.getUpdatedAt()%></td>
                        <td>
                            <div class="btn btn-group">
                                <a href="${baseUrl}/role/edit/<%=role.getId()%>" class="btn btn-xs btn-primary">Edit</a>
                                <a onclick="deleteData('role', '${baseUrl}/role/delete/<%=role.getId()%>')" href="#" class="btn btn-xs btn-danger">Delete</a>
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
                        <li><a href="${baseUrl}/role/view/0">«</a></li>
                            <% for(i=1; i<=totalPage; i++){%>
                                <li><a href="${baseUrl}/role/view/<%= i%>"><%= i%></a></li>
                            <%}%>
                        <li><a href="${baseUrl}/role/view/<%= i%>">»</a></li>
                    <%}%>
                </ul>
            </div>
        </div>
    </div>
</div>

