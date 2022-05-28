<%@ page import="com.example.customermanagement.entity.Account" %>
<!DOCTYPE html>
<%
    Account account = (Account) request.getAttribute("account");
    if (account == null) {
        account = new Account();
    }
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"
          content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

    <!-- title -->
    <title>Contact</title>
    <jsp:include page="../includes/head.jsp"></jsp:include>
    <jsp:include page="../includes/navba.jsp"></jsp:include>
    <style>
        .error_code {
            color: #0d0d0d;
            font-size: 14px;
            border-top: 2px solid red;
            background: #f5f5f5;
            padding: 23px 30px 18px;
            margin-bottom: 50px;
        }

        .error_code ul {
            margin-left: 20px;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="app-content">
    <!--====== Section 2 ======-->
    <div class="u-s-p-b-60">

        <!--====== Section Intro ======-->
        <div class="section__intro u-s-m-b-60">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section__text-wrap">
                            <h1 class="section__heading u-c-secondary">CREATE AN ACCOUNT</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Section Intro ======-->


        <!--====== Section Content ======-->
        <div class="section__content">
            <div class="container">
                <div class="row row--center">
                    <div class="col-lg-6 col-md-8 u-s-m-b-30">
                        <div class="l-f-o">
                            <div class="l-f-o__pad-box">
                                <h1 class="gl-h1">PERSONAL INFORMATION</h1>
                                <form method="post" action="/register" class="l-f-o__form">
                                    <div class="u-s-m-b-30">
                                        <%
                                            if(account.getListErrors().size() > 0){
                                        %>
                                        <h6 class="error_code">

                                            Please enter information below
                                            <ul>
                                                <%for (int i = 0; i < account.getListErrors().size(); i++) {
                                                %>
                                                <li><%=account.getListErrors().get(i)%></li>
                                                <%
                                                    }%>
                                            </ul>
                                        </h6>
                                        <%}%>

                                        <label class="gl-label">Username *</label>

                                        <input class="input-text input-text--primary-style" type="text" value="<%=account.getUsername()%>"
                                               name="username" placeholder="Please enter username"></div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label">Email *</label>

                                        <input class="input-text input-text--primary-style" type="text" value="<%=account.getEmail()%>"
                                               name="email" placeholder="Please enter email"></div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" >Password *</label>

                                        <input class="input-text input-text--primary-style" type="password"
                                               name="password" placeholder="Please enter password"></div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label">Confirm password *</label>

                                        <input class="input-text input-text--primary-style" type="password"
                                               name="confirmPassword" placeholder="Please enter confirm password"></div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label">Phone *</label>

                                        <input class="input-text input-text--primary-style" type="text" value="<%=account.getEmail()%>"
                                               name="phone" placeholder="Please enter phone"></div>
                                    <div class="u-s-m-b-15">

                                        <button class="btn btn--e-transparent-brand-b-2" type="submit">CREATE</button>
                                        <a class="btn btn--e-transparent-brand-b-2" href="/login">Login</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Section Content ======-->
    </div>
    <!--====== End - Section 2 ======-->
</div>
<!--====== End - App Content ======-->
<!-- end contact form -->
<!-- end copyright -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
<!-- jquery -->
<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>