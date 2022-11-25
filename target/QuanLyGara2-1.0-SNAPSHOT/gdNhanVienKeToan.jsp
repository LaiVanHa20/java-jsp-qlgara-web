<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 9:57:06
  To change this template use File | Settings | File Templates.
--%>
<%@page import="model.NhanVien"%>
<%@ page import="model.ThanhVien" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    //lấy id của kế toán
    NhanVien kt = (NhanVien) session.getAttribute("nhanvienketoan");
    if(kt == null){
        response.sendRedirect("doDangNhap.jsp?err=timeout");
    }
    
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <meta charset="ISO-8859-1">
    <%@include file="header.jsp" %>
    <title>Nhan vien ke toan</title>
</head>
<body>
<div class="container" align="center" style="margin-top: 100px">
    <h1>Trang Chủ Nhân Viên Kế Toán</h1>
    <p style="font-size: 30px;color: #4f1e1e"><b><i>Kế toán: <%= kt.getUsername()%></i></b></p>
    <form action="">

        <p><input class="btn btn-success" style="margin: 5px" type="button" onclick="openPage('gdTimKiemHoaDon.jsp')" value="Tìm kiếm hóa đơn">
        <p><input class="btn btn-success" style="margin: 5px" type="button" value="Đăng xuất" onclick="openPage('gdDangNhap.jsp')">
    </form>
</div>

</body>
</html>
