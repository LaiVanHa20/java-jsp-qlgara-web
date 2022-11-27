<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 10:18:45
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.DichVuDAO" %>
<%@page import="model.DichVu" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="model.LinhKien" %>
<%@ page import="dao.LinhKienDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<%
    ArrayList<DichVu> listdv1 = (ArrayList<DichVu>) session.getAttribute("listdv1");
    ArrayList<LinhKien> listlk1 = (ArrayList<LinhKien>) session.getAttribute("listlk1");

%>
<head>
    <meta charset="ISO-8859-1">
    <title>Tìm kiếm hóa đơn</title>
    <%@include file="header.jsp" %>
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
</head>
<body style="background-color: #fff3cd;background-size: 100% 125%">


<div class="container" style="width: 500px;height: 500px;margin-top: 100px">
    <div class="tim_kiem" style="background: #fff" align="center">
        <div class="row">
            <p style="font-size:22px"><b>Tìm kiếm linh kiện dịch vụ</b></p>
        </div>
        <div class="row">
            <form name="timkiemdvlk" action="doSearchLinhKienDichVu.jsp" method="get" class="tiem_kiem_dv_lk">
                <label class="form-label">Nhập tên linh kiện dịch vụ</label>
                <br>
                <input type="text" name="tendichvu" placeholder="...">

                <br>

                <table>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">#ID</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Đơn giá</th>
                        <th scope="col">Thêm</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        int count = 1;
                        if (listdv1 != null) {
                            for (int i = 0; i < listdv1.size(); i++) {
                    %>
                    <tr>

                        <td><%=count++%>
                        </td>
                        <td><%=listdv1.get(i).getId()%>
                        </td>
                        <td><%=listdv1.get(i).getTen()%>
                        </td>
                        <td><i class="fa-solid fa-dollar-sign"></i> <%=Math.round(listdv1.get(i).getDonGia())%>
                        </td>
                        <td>
                            <a href="gdChiTietHoaDon.jsp?action=them&&iddv=<%=listdv1.get(i).getId()%>">Thêm</a></td>
                        <td>
                    </tr>

                    <tr>
                        <td><%=count++%>
                        </td>
                        <td><%=listlk1.get(i).getId()%>
                        </td>
                        <td><%=listlk1.get(i).getTen()%>
                        </td>
                        <td><i class="fa-solid fa-dollar-sign"></i> <%=Math.round(listlk1.get(i).getDonGia())%>
                        </td>
                        <td>
                            <a href="gdChiTietHoaDon.jsp?action=them&&idlk=<%=listlk1.get(i).getId()%>">Thêm</a></td>
                        <td>
                    </tr>
                    <% }
                    }
                    %>
                    </tbody>
                </table>
                <%
                    if (request.getParameter("err") != null && request.getParameter("err").equalsIgnoreCase("fail"))
                %> <h4 style="color: red">Không tìm thấy linh kiện dịch vụ nào!</h4><%
            %>
                <input class="btn btn-primary" style="margin: 20px" type="submit" value="Tìm Kiếm"
                       name="btnTimkiemDVLK">
                <input class="btn btn-success" style="margin: 20px" type="button"
                       onclick="openPage('gdChiTietHoaDon.jsp')" value="Quay Lại">
            </form>
        </div>
    </div>
</div>

</body>
</html>
