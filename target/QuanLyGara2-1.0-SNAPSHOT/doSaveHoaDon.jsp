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
    ArrayList<XeOto> listxe = (ArrayList<XeOto>) session.getAttribute("dsxe");
    ArrayList<DichVuSuDung> listdv = (ArrayList<DichVuSuDung>) session.getAttribute("dsdv");;
    ArrayList<LinhKienSuDung> listlk = (ArrayList<LinhKienSuDung>) session.getAttribute("dslk");
    ArrayList<HoaDon> hoaDons = (ArrayList<HoaDon>) session.getAttribute("hoadon");
    if((new HoaDonDAO()).saveHoaDon(listdv, listlk, hoaDons)){

%>
<script type="text/javascript">
    alert("Thanh toán thành công!");
</script>
<%
        response.sendRedirect("gdNhanVienKeToan.jsp");
    }else{
%>
<script type="text/javascript">
    alert("Lỗi thanh toán!");
    history.back();
</script>
<%
    }
%>