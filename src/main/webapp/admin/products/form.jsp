<%@ page import="com.example.customermanagement.entity.Product" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 5/14/2022
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    int action = (int) request.getAttribute("action");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    String url = "/admin/products/create";
    if (action == 2) {
        url = "/admin/products/edit";
    }
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<html>
<jsp:include page="../includes/head.jsp"></jsp:include>
<head>
    <title>Create new product</title>
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
                                    <%
                                        if (errors != null && errors.size() > 0) {
                                    %>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="callout callout-danger">
                                                <h5>Please fix error below</h5>
                                                <ul>
                                                    <%
                                                        for (String msg : errors.values()) {
                                                    %>
                                                    <li class="text-danger"><%=msg%>
                                                    </li>
                                                    <%
                                                        }
                                                    %>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <%}%>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <!-- Basic Form Inputs card start -->
                                            <div class="card">
                                                <div class="card-block">
                                                    <h1>Create product</h1>
                                                    <a href="/admin/products/list">Back to list</a>
                                                    <form action="<%=url%>" method="post">
                                                        <div class="form-group row">
                                                            <div class="col-sm-5">
                                                                <input type="text" name="id"
                                                                       placeholder="Please enter id"
                                                                       class="form-control form-control-round"
                                                                       value="<%=product.getId()%>" <%=action == 2 ? "readonly":""%>>
                                                                <%if (errors.containsKey("id")) {%>
                                                                <span class="text-danger">* <%=errors.get("id")%></span>
                                                                <%}%>
                                                            </div>
                                                            <div class="col-sm-7">
                                                                <input type="text" name="name"
                                                                       placeholder="Please enter full name"
                                                                       class="form-control form-control-round"
                                                                       value="<%=product.getName()%>">
                                                                <%if (errors.containsKey("name")) {%>
                                                                <span class="text-danger">* <%=errors.get("name")%></span>
                                                                <%}%>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-7">
                                                                <input type="text" name="image"
                                                                       placeholder="Please enter image"
                                                                       class="form-control form-control-round"
                                                                       name="phone" value="<%=product.getImage()%>">
                                                                <%if (errors.containsKey("image")) {%>
                                                                <span class="text-danger">* <%=errors.get("image")%></span>
                                                                <%}%>
                                                            </div>
                                                            <div class="col-sm-5">
                                                                <input type="text" name="price"
                                                                       placeholder="Please enter price"
                                                                       class="form-control form-control-round"
                                                                       value="<%=product.getPrice()%>">
                                                                <%if (errors.containsKey("price")) {%>
                                                                <span class="text-danger">* <%=errors.get("price")%></span>
                                                                <%}%>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-4">
                                                                <input type="text" name="quantity"
                                                                       placeholder="Please enter quantity"
                                                                       class="form-control form-control-round"
                                                                       data-target="#reservationdate"
                                                                       value="<%=product.getQuantity()%>">
                                                                <%if (errors.containsKey("quantity")) {%>
                                                                <span class="text-danger">* <%=errors.get("quantity")%></span>
                                                                <%}%>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <input type="submit" class="btn btn-info btn-round"
                                                                   value="Submit">
                                                            <input type="reset" class="btn btn-info btn-round"
                                                                   value="Reset">
                                                        </div>
                                                    </form>
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