<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/3/2018
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Admin.Models.Entities.CompanyEntity" %>
<%@ page import="java.util.List" %>

<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">View All Pharmacy</h3>
                <%--<a class="btn btn-sm btn-success pull-right" href="${baseUrl}/medicine/add">Add New Medicine</a>--%>
            </div>
            <div class="box-body no-padding">
                <table id="datatable1" class="table table-bordered table-hover">
                    <thead class="bg-green">
                    <tr>
                        <th>SL</th>
                        <th>Name</th>
                        <th>Code</th>
                        <th>Contact Email</th>
                        <th>Mobile No</th>
                        <th>Logo</th>
                        <th>Address</th>
                        <th>Status</th>
                        <th>Created</th>
                        <th>Updated</th>
                        <th width="120px">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for(CompanyEntity companies : (List<CompanyEntity>) request.getAttribute("companies")){
                    %>
                    <tr>
                        <td><%= companies.getRow()%></td>
                        <td><%= companies.getCompanyName()%></td>
                        <td><%= companies.getCompanyCode()%></td>
                        <td><%= companies.getCompanyContactEmail()%></td>
                        <td><%= companies.getCompanyContactMobileNo()%></td>
                        <td><%= companies.getCompanyLogo()%></td>
                        <td><%= companies.getCompanyAddress()%></td>
                        <td>
                            <% if(companies.getCompanyStatus().equals("pending")){%>
                            <label class="label label-warning">Pending</label>
                            <% }else if(companies.getCompanyStatus().equals("approved")){ %>
                            <label class="label label-success">Approved</label>
                            <%}else if(companies.getCompanyStatus().equals("reject")){%>
                            <label class="label label-danger">Rejected</label>
                            <%}%>
                        </td>
                        <td><%= companies.getCreatedAt()%></td>
                        <td><%= companies.getUpdatedAt()%></td>
                        <td>
                            <div class="btn btn-group">
                                <% if(companies.getCompanyStatus().equals("pending")){%>
                                <a href="${baseUrl}/pharmacies/status/<%=companies.getId()%>/1" class="btn btn-xs btn-success">Verified</a>
                                <% }else if(companies.getCompanyStatus().equals("approved")){ %>
                                <a href="${baseUrl}/pharmacies/status/<%=companies.getId()%>/0" class="btn btn-xs btn-danger">Unverified</a>
                                <%}%>
                            </div>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
