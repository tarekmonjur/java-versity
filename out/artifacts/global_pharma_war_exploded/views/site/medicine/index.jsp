<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/16/2018
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<% ResultSet medicines = (ResultSet)request.getAttribute("medicines");%>

<section class="container">
    <h1 class="main-ttl"><span>Medicines</span></h1>
    <div class="section-cont">
        <!-- Catalog Topbar - end -->
        <div class="prod-items section-items">
            <%
                while (medicines.next()){
            %>
            <div class="prodlist-i">
                <a class="prodlist-i-img" href="product.html"><!-- NO SPACE --><img src="http://placehold.it/300x311" alt="Adipisci aperiam commodi"><!-- NO SPACE --></a>
                <div class="prodlist-i-cont">
                    <h3><%=medicines.getString("medicine_name")%></h3>
                    <h4>Pharmacy Name: <a href="product.html"><%=medicines.getString("company_name")%></a></h4>
                    <h5>Pharmacy Location : <a href="product.html"><%=medicines.getString("location_name")%></a></h5>
                    <div class="prodlist-i-txt">Pharmacy Address :<%=medicines.getString("company_address")%></div>
                    <div class="prodlist-i-txt">Pharmacy Contact No:<%=medicines.getString("company_contact_mobile_no")%></div>
                    <div class="prodlist-i-action">
                        <p class="prodlist-i-qnt">
                            <input value="1" type="text">
                            <a href="#" class="prodlist-i-plus"><i class="fa fa-angle-up"></i></a>
                            <a href="#" class="prodlist-i-minus"><i class="fa fa-angle-down"></i></a>
                        </p>
                        <p class="prodlist-i-addwrap">
                            <a href="#" class="prodlist-i-add">Add to cart</a>
                        </p>
                        <span class="prodlist-i-price">
							<b>Price: </b>
							<b><%=medicines.getString("medicine_price")%> tk</b>
							<b style="margin-left: 10px"><del style="color: red!important; display: inline!important;font-size: 17px!important;"><%=medicines.getString("medicine_price")%>tk</del></b>
                        </span>
                    </div>
                </div>

                <div class="prodlist-i-props-wrap">
                    <ul class="prodlist-i-props">
                        <li><b>Medicine Code : </b> <%=medicines.getString("medicine_code")%></li>
                        <li><b>Medicine Generic : </b> <%=medicines.getString("medicine_generic")%></li>
                        <li><b>Medicine Type : </b> <%=medicines.getString("medicine_type")%></li>
                        <li><b>Medicine Size : </b> <%=medicines.getString("medicine_size")%></li>
                        <li><b>Medicine Unit : </b> <%=medicines.getString("medicine_unit")%></li>
                        <li><b>Medicine Price : </b> <%=medicines.getString("medicine_price")%></li>
                        <li><b>Medicine Company : </b> <%=medicines.getString("medicine_company_name")%></li>
                    </ul>
                </div>
            </div>
            <%}
                try {
                    medicines.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            %>
        </div>

        <!-- Pagination - start -->
        <ul class="pagi">
            <%--<% Integer totalPage = (Integer) request.getAttribute("totalPage");--%>
            <%--if(totalPage > 0){--%>
                <%--for(i=1; i<=totalPage; i++){%>--%>
                    <%--<li class="active"><a href="${baseUrl}/medicines/<%= i%>"><%= i%></a></li>--%>
                    <%--<li><a href="${baseUrl}/medicines/<%= i%>"><%= i%></a></li>--%>
                <%--<%}--%>
            <%--}%>--%>
        </ul>
        <!-- Pagination - end -->
    </div>
</section>

