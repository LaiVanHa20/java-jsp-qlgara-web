<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 10:19:16
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.LinhKienDAO"%>
<%@page import="model.LinhKien"%>
<%@page import="dao.DichVuDAO"%>
<%@page import="model.DichVu"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String key = (String)request.getParameter("tendichvu");

    DichVuDAO dao = new DichVuDAO();
    LinhKienDAO dao1 = new LinhKienDAO();
    ArrayList<DichVu> listdv1 = dao.searchDichVu(key);
    ArrayList<LinhKien> listlk1 = dao1.searchLinhkien(key);


    if(listdv1.isEmpty() == false || listlk1.isEmpty() == false ){
        session.setAttribute("listdv1", listdv1);
        session.setAttribute("listlk1", listlk1);
        response.sendRedirect("gdTimKiemLinhKienDichVu.jsp");
    }
    else {
        response.sendRedirect("gdTimKiemLinhKienDichVu.jsp?err=fail");
    }
%>