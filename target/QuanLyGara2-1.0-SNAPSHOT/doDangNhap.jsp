<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 9:06:25
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.NhanVienDAO"%>
<%@page import="model.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = (String)request.getParameter("username");
    String password = (String)request.getParameter("password");

    NhanVien nv = new NhanVien();
    nv.setUsername(username);
    nv.setPassword(password);

    NhanVienDAO dao = new NhanVienDAO();
    boolean kq = dao.checkLogin(nv);

    if(kq && (nv.getVitri().equalsIgnoreCase("nhan vien ke toan"))){
        session.setAttribute("nhanvienketoan", nv);
        response.sendRedirect("gdNhanVienKeToan.jsp");
    }
    else {
        response.sendRedirect("gdDangNhap.jsp?err=fail");
    }
%>
