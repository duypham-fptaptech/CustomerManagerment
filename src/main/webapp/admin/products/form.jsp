<%@ page import="com.example.customermanagement.entity.Product" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.customermanagement.entity.Category" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 5/14/2022
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    List<Category> categories = (List<Category>) request.getAttribute("category");
    if (categories == null){
        categories = new ArrayList<>();
    }
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
<script src="https://cdn.ckeditor.com/4.19.0/standard/ckeditor.js"></script>
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
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
                                                    <form action="<%=url%>" method="post" name="product-form">
                                                        <div class="form-group row">
                                                            <div class="col-sm-7">
                                                                <input type="text" name="name"
                                                                       placeholder="Please enter full name"
                                                                       class="form-control"
                                                                       value="<%=product.getName()%>">
                                                                <%if (errors.containsKey("name")) {%>
                                                                <span class="text-danger">* <%=errors.get("name")%></span>
                                                                <%}%>
                                                            </div>
                                                            <div class="col-sm-5">
                                                                <input type="text" name="price"
                                                                       placeholder="Please enter price"
                                                                       class="form-control"
                                                                       value="<%=product.getPrice()%>">
                                                                <%if (errors.containsKey("price")) {%>
                                                                <span class="text-danger">* <%=errors.get("price")%></span>
                                                                <%}%>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-5">
                                                                <select name="categoryId" class="form-control">
                                                                    <option value="0">Tat ca</option>
                                                                    <%
                                                                        for (int i = 0; i < categories.size(); i++) {
                                                                    %>
                                                                    <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                                                                    <%}%>
                                                                </select>
                                                            </div>
                                                            <div class="col-sm-7">
                                                                <input type="text" name="description"
                                                                       placeholder="Please enter description"
                                                                       class="form-control"
                                                                       value="<%=product.getDescription()%>">
                                                                <%if (errors.containsKey("description")) {%>
                                                                <span class="text-danger">* <%=errors.get("description")%></span>
                                                                <%}%>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <strong><label>Image</label></strong>
                                                            <input type="hidden" class="form-control" id="hello" name="image">
                                                            <button type="button" id="upload_widgetn" class="btn btn-sm btn-primary">Chọn ảnh</button>
                                                            <img id="preview-image" style="display: none" src="" alt="" class="img-bordered mt-2" width="200px">
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-12" >
                                                                <textarea id="editor1" name="detail"><%=product.getDetail()%></textarea>
                                                                <%if (errors.containsKey("detail")) {%>
                                                                <span class="text-danger">* <%=errors.get("detail")%></span>
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
<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'duypdth',
            uploadPreset: 'zyt6qk4h'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                console.log('Done! Here is the image info: ', result.info.secure_url);
                document.forms['product-form']['image'].value = result.info.secure_url;
                document.getElementById('preview-image').src = result.info.secure_url;
                document.getElementById('preview-image').style.display = "inline-block";
            }
        }
    )
    document.getElementById("upload_widgetn").addEventListener("click", function () {
        myWidget.open();
    }, false);
</script>
<script>
    CKEDITOR.replace('editor1');
</script>

<%--<script>--%>
<%--    document.addEventListener('DOMContentLoaded', function (){--%>
<%--        $('#summernote').summernote();--%>
<%--        var myWidget = cloudinary.createUploadWidget({--%>
<%--                cloudName: 'duypdth',--%>
<%--                uploadPreset: 'zyt6qk4h'}, (error, result) => {--%>
<%--                if (!error && result && result.event === "success") {--%>
<%--                    console.log('Done! Here is the image info: ', result.info.secure_url);--%>
<%--                    document.forms['product-form']['image'].value = result.info.secure_url;--%>
<%--                    document.getElementById('preview-image').src = result.info.secure_url;--%>
<%--                    document.getElementById('preview-image').style.display = "block";--%>
<%--                }--%>
<%--            }--%>
<%--        )--%>

<%--        document.getElementById("upload_widget").addEventListener("click", function(){--%>
<%--            myWidget.open();--%>
<%--        }, false);--%>
<%--    })--%>
<%--</script>--%>
<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>