<%@ page import="com.example.customermanagement.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 5/14/2022
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<html>
<jsp:include page="../includes/head.jsp"></jsp:include>
<head>
    <title>Create new customer</title>
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
                                                <div class="card-block">
                                                    <h1>Student detail</h1>
                                                    <a href="/admin/customers/list">Back to list</a> &nbsp;
                                                    <a href="/admin/customers/create">Create new customer</a>
                                                    <div class="form-group row">
                                                        <div class="col-sm-4">
                                                            <div class="form-control form-control-round">
                                                                Id: <%=customer.getId()%>
                                                            </div>
                                                            <div class="form-control form-control-round">
                                                                Fullname: <%=customer.getName()%>
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
    </div>
</div>

<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>