<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sideuseruser panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${assets}images/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%=auth.getFirstName().toUpperCase()+' '+auth.getLastName().toUpperCase()%></p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>
            <li>
                <a href="${baseUrl}/admin/home">
                    <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                </a>
            </li>
            <% if(auth.getAdminType().equals("owner")){%>
            <li class="<% if(uri1.equals("pharmacies")){ %> active <% }%>">
                <a href="${baseUrl}/pharmacies/view">
                    <i class="fa fa-share"></i> <span>Pharmacies</span>
                    <span class="pull-right-container">
                    </span>
                </a>
            </li>
            <%}%>
            <li class="treeview <% if(uri1.equals("medicine")){ %> active <% }%>">
                <a href="#">
                    <i class="fa fa-share"></i> <span>Medicines</span>
                    <span class="pull-right-container">
                    <i class="fa fa-angle-right pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class="<% if(pageUri.equals("medicine/add")){ %> active <% }%>"><a href="${baseUrl}/medicine/add"><i class="fa fa-circle-o"></i> Add Medicine</a></li>
                    <li class="<% if(pageUri.equals("medicine/view")){ %> active <% }%>"><a href="${baseUrl}/medicine/view"><i class="fa fa-circle-o"></i> View Medicine</a></li>
                </ul>
            </li>
            <% if(auth.getAdminType().equals("owner")){%>
            <li class="treeview">
                <a href="${baseUrl}/users">
                    <i class="fa fa-share"></i> <span>Users</span>
                    <span class="pull-right-container">
                    </span>
                </a>
            </li>
            <%}%>
            <li>
                <a href="${baseUrl}/orders">
                    <i class="fa fa-share"></i> <span>Orders</span>
                    <span class="pull-right-container">
                    </span>
                </a>
            </li>
            <li class="treeview <% if(uri1.equals("role")){ %> active <% }%>">
                <a href="#">
                    <i class="fa fa-share"></i> <span>Roles</span>
                    <span class="pull-right-container">
                    <i class="fa fa-angle-right pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class="<% if(pageUri.equals("role/add")){ %> active <% }%>"><a href="${baseUrl}/role/add"><i class="fa fa-circle-o"></i> Add Role</a></li>
                    <li class="<% if(pageUri.equals("role/view")){ %> active <% }%>"><a href="${baseUrl}/role/view"><i class="fa fa-circle-o"></i> View Role</a></li>
                </ul>
            </li>
            <li class="treeview <% if(uri1.equals("admin")){ %> active <% }%>">
                <a href="#">
                    <i class="fa fa-share"></i> <span>Admins</span>
                    <span class="pull-right-container">
                    <i class="fa fa-angle-right pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class="<% if(pageUri.equals("admin/add")){ %> active <% }%>"><a href="${baseUrl}/admin/add"><i class="fa fa-circle-o"></i> Add Admin</a></li>
                    <li class="<% if(pageUri.equals("admin/view")){ %> active <% }%>"><a href="${baseUrl}/admin/view"><i class="fa fa-circle-o"></i> View Admin</a></li>
                </ul>
            </li>
            <li>
                <a href="${baseUrl}/admin/settings">
                    <i class="fa fa-share"></i> <span>Settings</span>
                    <span class="pull-right-container">
                    </span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
