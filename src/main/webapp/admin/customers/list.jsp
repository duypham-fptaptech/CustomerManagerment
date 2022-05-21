<%@ page import="com.example.customermanagement.entity.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 5/14/2022
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> listCustomer = (List<Customer>)request.getAttribute("listCustomer");
%>
<html>
<jsp:include page="../includes/head.jsp"></jsp:include>
<head>
    <title>List customer</title>
</head>
<body>
<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">
        <jsp:include page="../includes/navba.jsp"></jsp:include>
        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <jsp:include page="../includes/sidebar.jsp"></jsp:include>
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">
                        <!-- Main-body start -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- Page-header start -->
                                <div class="page-body">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <!-- Basic Form Inputs card start -->
                                            <div class="card">
                                                <h1>List student</h1>
                                                <div class="pcoded-search">
                                                    <div class="col-sm-3">
                                                        <span class="searchbar-toggle"></span>
                                                        <div class="pcoded-search-box ">
                                                            <input type="text" placeholder="Search">
                                                            <span class="search-icon"><i class="ti-search"
                                                                                         aria-hidden="true"></i></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <a class="col-sm-3" href="/admin/customers/create">Create new customer</a>
                                                <div class="card-block table-border-style">
                                                    <div class="table-responsive">
                                                        <table class="table">
                                                            <thead>
                                                            <tr>
                                                                <th>id</th>
                                                                <th>Full name</th>
                                                                <th>Phone number</th>
                                                                <th>Images</th>
                                                                <th>Date of birth</th>
                                                                <th>Status</th>
                                                                <th>Action</th>
                                                            </tr>
                                                            </thead>
                                                            <ta>
                                                                    <%
                                                        for (Customer st : listCustomer) {
                                                    %>
                                                                <tr>
                                                                    <th scope="row"><%=st.getId()%>
                                                                    </th>
                                                                    <td><%=st.getName()%>
                                                                    </td>
                                                                    <td><%=st.getPhone()%>
                                                                    </td>
                                                                    <td><%=st.getImage()%>
                                                                    </td>
                                                                    <td><%=st.getJoinedAt()%>
                                                                    </td>
                                                                    <td><%=st.getStatus()%>
                                                                    </td>
                                                                    <td>
                                                                        <a href="/admin/customers/detail?id=<%=st.getId()%>"><i
                                                                                class="fa-solid fa-circle-info"></i></a>
                                                                        <a href="/admin/customers/edit?id=<%=st.getId()%>"><i
                                                                                class="fa-solid fa-pen-to-square"></i></a>
                                                                        <a href="/admin/customers/delete?id=<%=st.getId()%>"
                                                                           onclick="confirm('Are you sure?')"><i class="fa-solid fa-trash"></i></a>
                                                                    </td>
                                                                </tr>
                                                                    <%}
%>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>