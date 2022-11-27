<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 10:19:00
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String maHoaDon = (String)request.getParameter("mahoadon");

    HoaDonDAO dao = new HoaDonDAO();
    ArrayList<HoaDon> searchHoaDon = dao.searchHoaDon(maHoaDon);

    ArrayList<ThanhVien> listkh = (new KhachHangDAO()).getKhachHangTrongHD(maHoaDon);
    ArrayList<XeOto> listxe = (new XeOtoDAO()).getDSXeTrongHD(maHoaDon);
    ArrayList<DichVuSuDung> listdv = (new DichVuSDDAO()).getDSDichVuTrongHD(maHoaDon);
    ArrayList<LinhKienSuDung> listlk = (new LinhKienSDDAO()).getDSLinhKienTrongHD(maHoaDon);

    if(searchHoaDon.isEmpty() == false ){
        session.setAttribute("dskhachhang", listkh);
        session.setAttribute("dsxe", listxe);
        session.setAttribute("dsdv", listdv);
        session.setAttribute("dslk", listlk);
        session.setAttribute("hoadon", searchHoaDon);
        response.sendRedirect("gdChiTietHoaDon.jsp");
    }
    else {
        response.sendRedirect("gdTimKiemHoaDon.jsp?err=fail");
    }
%>