<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 10:17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" >
    <title>Tìm kiếm hóa đơn</title>
    <%@include file="header.jsp" %>
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
</head>
<body style="background-color: #fff3cd;background-size: 100% 125%">

<%
    if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("fail"))
        %> <h4 style="color: red">Sai mã hóa đơn!</h4><%
%>
<div class="container" style="width: 500px;height: 500px;margin-top: 100px">
    <div class="tim_kiem" style="background: #fff" align="center">
        <div class="tiem_kiem_main">
            <div class="row">
                <p style="font-size:22px"><b>Tìm kiếm hóa đơn theo mã</b></p>
            </div>
            <div class="row">
                <div class="col">
                    <form name="timkiemHD" action="doSearchHoaDon.jsp" method="post" class="tiem_kiem_main">
                        <label  class="form-label">Nhập mã hóa đơn</label>
                        <br>
                        <input type="text" name="mahoadon" placeholder="Nhập mã hóa đơn...">
                        <br>
                        <input class="btn btn-primary" style="margin: 20px" type="submit" value="Tìm Kiếm" name="btnTimkiemHD">
                        <input class="btn btn-success" style="margin: 20px" type="button" onclick="openPage('gdNhanVienKeToan.jsp')" value="Quay Lại">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

