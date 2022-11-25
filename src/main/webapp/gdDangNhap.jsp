<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 9:12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" >
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
</head>
<body style="background-color: #0d6efd;background-size: 100% 125%">
<%
    if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("timeout")){
        %> <h4>Hết phiên làm việc, hãy đăng nhập lại!</h4><%
    }else if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("fail")){
        %> <h4 style="color: red">Sai tên đăng nhập/mật khẩu!</h4><%
    }
%>
<div class="container" style="width: 300px;height: 500px;margin-top: 100px">
    <div class="login" style="background: #fff" align="center">
        <div class="login_main">
            <div class="row" align="center">
                <div class="col" align="center">
                    <img alt="PTIT" src="img/logo_ptit2.png" align="center" >
                </div>
            </div>
            <div class="row">
                <p style="font-size: 30px">Đăng nhập</p>
                <p style="font-size:25px"><b>Quản lý gara</b></p>
            </div>
            <div class="row">
                <div class="col">
                    <form name="dangnhap" action="doDangNhap.jsp" method="post" class="login_main_form">
                        <label  class="form-label">Username</label>
                        <br>
                        <input type="text" name="username" placeholder="Nhập tài khoản...">
                        <br>
                        <label  class="form-label">Password</label>
                        <br>
                        <input type="password" name="password" placeholder="Nhập mật khẩu...">
                        <br>
                        <input type="submit" name="btnDangNhap" value="Đăng nhập" style="margin: 20px" class="btn btn-danger">
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
