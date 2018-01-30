<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 12/17/2017
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Admin.Models.Entities.MedicineEntity" %>
<%@ page import="java.util.List" %>

<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">View Medicine List</h3>
                <a class="btn btn-sm btn-success pull-right" href="${baseUrl}/medicine/add">Add New Medicine</a>
            </div>
            <div class="box-body no-padding">
                <table id="datatable2" class="table table-bordered table-hover">
                    <thead class="bg-green">
                        <tr>
                            <th>SL</th>
                            <th>Name</th>
                            <th>Code</th>
                            <th>Photo</th>
                            <th>Generic</th>
                            <th>Company</th>
                            <th>Type</th>
                            <th>Size</th>
                            <th>Unit</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th>Created</th>
                            <th>Updated</th>
                            <th width="120px">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        int i =1;
                        for(MedicineEntity medicine : (List<MedicineEntity>) request.getAttribute("medicines")){
                    %>
                        <tr>
                            <td><%= i++%></td>
                            <td><%= medicine.getMedicineName()%></td>
                            <td><%= medicine.getMedicineCode()%></td>
                            <td><%= medicine.getMedicinePhoto()%></td>
                            <td><%= medicine.getMedicineGeneric()%></td>
                            <td><%= medicine.getMedicineCompanyName()%></td>
                            <td><%= medicine.getMedicineType()%></td>
                            <td><%= medicine.getMedicineSize()%></td>
                            <td><%= medicine.getMedicineUnit()%></td>
                            <td><%= medicine.getMedicinePrice()%></td>
                            <td><%= medicine.getMedicineStatus()%></td>
                            <td><%= medicine.getCreatedAt()%></td>
                            <td><%= medicine.getUpdatedAt()%></td>
                            <td>
                                <div class="btn btn-group">
                                    <a href="${baseUrl}/medicine/edit/<%=medicine.getId()%>" class="btn btn-xs btn-primary">Edit</a>
                                    <a onclick="deleteData('role', '${baseUrl}/medicine/delete/<%=medicine.getId()%>')" href="#" class="btn btn-xs btn-danger">Delete</a>
                                </div>
                            </td>
                        </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
            <div class="box-footer clearfix">
                <span>Total Record is <strong>${totalRow}</strong></span>
                <ul class="pagination pagination-sm no-margin pull-right">
                    <% Integer totalPage = (Integer) request.getAttribute("totalPage");
                        if(totalPage > 0){%>
                    <li><a href="${baseUrl}/medicine/view/0">«</a></li>
                    <% for(i=1; i<=totalPage; i++){%>
                    <li><a href="${baseUrl}/medicine/view/<%= i%>"><%= i%></a></li>
                    <%}%>
                    <li><a href="${baseUrl}/medicine/view/<%= i%>">»</a></li>
                    <%}%>
                </ul>
            </div>
        </div>
    </div>
</div>

