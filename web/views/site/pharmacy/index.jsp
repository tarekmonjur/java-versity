<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/8/2018
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Site.Models.Entities.PharmacyEntity" %>
<%@ page import="java.util.List" %>
<% List<PharmacyEntity> pharmacies = (List<PharmacyEntity>) request.getAttribute("pharmacies"); %>

<section class="container">
    <h1 class="main-ttl"><span>Pharmacy</span></h1>
    <div class="section-cont">
        <!-- Catalog Topbar - end -->
        <div class="prod-items section-items">
            <%
                for(PharmacyEntity company : pharmacies){
            %>
            <div class="prodlist-i">
                <a class="prodlist-i-img" href="product.html"><!-- NO SPACE --><img src="http://placehold.it/300x311" alt="Adipisci aperiam commodi"><!-- NO SPACE --></a>
                <div class="prodlist-i-cont">
                    <h3><%=company.getCompanyName()%></h3>
                    <h4>Pharmacy Code: <a href="product.html"><%=company.getCompanyCode()%></a></h4>
                    <h5>Pharmacy Email : <a href="product.html"><%=company.getCompanyContactEmail()%></a></h5>
                    <div class="prodlist-i-txt">Pharmacy Contact No:<%=company.getCompanyContactMobileNo()%></div>
                    <div class="prodlist-i-txt">Pharmacy Address :<%=company.getCompanyAddress()%></div>
                </div>
            </div>
            <%}%>
        </div>
    </div>
</section>
