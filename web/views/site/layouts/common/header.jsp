<%--
  Created by IntelliJ IDEA.
  User: Tarek Monjur
  Date: 1/3/2018
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="Site.Models.Entities.LocationEntity" %>
<%@ page import="Site.Models.Entities.PharmacyEntity" %>

<%
List<PharmacyEntity> pharmacies = (List<PharmacyEntity>) request.getAttribute("pharmacies");
Integer locationId = (Integer) request.getAttribute("locationId");
Integer pharmacyId = (Integer) request.getAttribute("pharmacyId");
String medicineName = (String) request.getAttribute("medicineName");
%>
<header class="header">

    <!-- Topbar - start -->
    <div class="header_top">
        <div class="container">
            <ul class="contactinfo nav nav-pills">
                <li>
                    <i class='fa fa-phone'></i> ${appMobileNumber}
                </li>
                <li>
                    <i class="fa fa-envelope"></i> ${appEmailAddress}
                </li>
            </ul>
            <!-- Social links -->
            <ul class="social-icons nav navbar-nav">
                <li>
                    <a href="http://facebook.com" rel="nofollow" target="_blank">
                        <i class="fa fa-facebook"></i>
                    </a>
                </li>
                <li>
                    <a href="http://google.com" rel="nofollow" target="_blank">
                        <i class="fa fa-google-plus"></i>
                    </a>
                </li>
                <li>
                    <a href="http://twitter.com" rel="nofollow" target="_blank">
                        <i class="fa fa-twitter"></i>
                    </a>
                </li>
                <li>
                    <a href="http://vk.com" rel="nofollow" target="_blank">
                        <i class="fa fa-vk"></i>
                    </a>
                </li>
                <li>
                    <a href="http://instagram.com" rel="nofollow" target="_blank">
                        <i class="fa fa-instagram"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!-- Topbar - end -->

    <!-- Logo, Shop-menu - start -->
    <div class="header-middle">
        <div class="container header-middle-cont">
            <div class="row">
                <div class="col-md-2">
                    <div class="toplogo">
                        <a href="index.html">
                            <img src="${assets}/img/logo.png" alt="${appName}">
                        </a>
                    </div>
                </div>
                <div class="col-md-8">
                    <form action="${baseUrl}/medicines" method="get">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="location">Select Location</label>
                                <select name="location" class="custom-input" id="location">
                                    <option value="0">--- All Location --</option>
                                    <% for(LocationEntity location : (List<LocationEntity>) request.getAttribute("locations")){%>
                                    <option value="<%=location.getId()%>" <% if(locationId !=null && locationId == location.getId()) {%> selected <%}%> ><%= location.getLocationName()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="custom-label" for="pharmacy">Choose Pharmacy</label>
                                <select name="pharmacy" class="custom-input" id="pharmacy">
                                    <option value="0">--- All Pharmacy --</option>
                                    <% for(PharmacyEntity pharmacy : pharmacies){%>
                                    <option value="<%=pharmacy.getId()%>" <% if(pharmacyId !=null && pharmacy.getId() == pharmacyId){%> selected <%}%> ><%= pharmacy.getCompanyName()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="form-group">
                                <label class="custom-label" for="medicine_name">Which Medicine You Need ?</label>
                                <input type="text" class="custom-input" id="medicine_name" name="medicine_name" value="<%=(medicineName !=null)?medicineName:""%>" placeholder="Search your medicine...">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label class="custom-label"></label>
                            <button type="submit" name="search" value="medicine" class="btn custom-btn">Search Medicine</button>
                        </div>
                    </form>
                </div>

                <div class="col-md-2 text-right">
                    <div class="h-cart" style="margin-top: 30%">
                        <a href="cart.html" style="font-size: 18px; color: #8fc849">
                            <i class="fa fa-shopping-cart"></i>
                            <span class="shop-menu-ttl">Cart</span>
                            (<b>0</b>)
                        </a>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- Logo, Shop-menu - end -->

    <!-- Topmenu - start -->
    <div class="header-bottom">
        <div class="container-fluid" style="padding: 0px!important;">
            <nav class="topmenu">
                <!-- Main menu - start -->
                <button type="button" class="mainmenu-btn">Menu</button>

                <ul class="mainmenu">
                    <li>
                        <a href="${baseUrl}/home" class="<% if(uri1.equals("home")){ %> active <% }%>">Home</a>
                    </li>
                    <li>
                        <a href="${baseUrl}/pharmacy" class="<% if(uri1.equals("pharmacy")){ %> active <% }%>">Pharmacy</a>
                    </li>
                    <li>
                        <a href="${baseUrl}/medicines" class="<% if(uri1.equals("medicines")){ %> active <% }%>">Medicine</a>
                    </li>
                    <li>
                        <a href="${baseUrl}/registration" class="<% if(uri1.equals("registration")){ %> active <% }%>">Pharmacy Registration</a>
                    </li>
                    <% if(auth !=null){%>
                    <li>
                        <a href="${baseUrl}/logout" class="<% if(uri1.equals("logout")){ %> active <% }%>">Logout</a>
                    </li>
                    <li class="pull-right">
                        <div class="pull-left">
                            <img src="${assets}/img/user.png" width="39px" style="padding-top: 1px; border-radius: 50px">
                        </div>
                        <div class="pull-left" style="padding:11px; color: #fff">
                            <a href="${baseUrl}/dashboard">
                                <%= auth.getFirstName().toUpperCase()%> <%= auth.getLastName().toUpperCase()%>
                            </a>
                        </div>
                    </li>
                    <%}else{%>
                    <li>
                        <a href="${baseUrl}/signup" class="<% if(uri1.equals("signup")){ %> active <% }%>">Signup</a>
                    </li>
                    <li>
                        <a href="${baseUrl}/login" class="<% if(uri1.equals("login")){ %> active <% }%>">Login</a>
                    </li>
                    <%}%>
                </ul>
                <!-- Main menu - end -->
            </nav>
        </div>
    </div>
    <!-- Topmenu - end -->

</header>
