<%--
  Created by IntelliJ IDEA.
  User: LAI VAN HA
  Date: 0003/03/11
  Time: 10:18:15
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.*" %>
<%@page import="model.*" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<%
    ArrayList<ThanhVien> listkh = (ArrayList<ThanhVien>) session.getAttribute("dskhachhang");
    ArrayList<XeOto> listxe = (ArrayList<XeOto>) session.getAttribute("dsxe");
    ArrayList<DichVuSuDung> listdv = null;
    ArrayList<LinhKienSuDung> listlk = null;
//Kiem tra cach trang nay bi goi
    String action = request.getParameter("action");
    if ((action == null) || (action.trim().length() == 0)) {//goi tu trang tim kiem hoa don

        listdv = (ArrayList<DichVuSuDung>) session.getAttribute("dsdv");
        listlk = (ArrayList<LinhKienSuDung>) session.getAttribute("dslk");
    } else if (action.equalsIgnoreCase("them")) { // goi tu trang tim kiem linh kien dich vu
        listdv = (ArrayList<DichVuSuDung>) session.getAttribute("dsdv");
        listlk = (ArrayList<LinhKienSuDung>) session.getAttribute("dslk");

        ArrayList<DichVu> listdv1 = (ArrayList<DichVu>) session.getAttribute("listdv1");
        ArrayList<LinhKien> listlk1 = (ArrayList<LinhKien>) session.getAttribute("listlk1");
        if (request.getParameter("iddv") != null) {
            boolean daTonTai = false;
            for (DichVuSuDung dv : listdv) {
                if (dv.getDichVu().getId() == Integer.parseInt(request.getParameter("iddv"))) {
                    daTonTai = true;
                    break;
                }
            }
            if (!daTonTai) {
                //them dvdsd vao hoa don
                for (DichVu dv : listdv1) {
                    if (dv.getId() == Integer.parseInt(request.getParameter("iddv"))) {
                        DichVuSuDung dichVuSuDung = new DichVuSuDung();
                        dichVuSuDung.setDichVu(dv);
                        dichVuSuDung.setSoLuong(1);
                        listdv.add(dichVuSuDung);
                    }
                }
                session.setAttribute("dsdv", listdv);
            }
        }

        if (request.getParameter("idlk") != null) {
            boolean daTonTai1 = false;
            for (LinhKienSuDung lk : listlk) {
                if (lk.getLinhKien().getId() == Integer.parseInt(request.getParameter("idlk"))) {
                    daTonTai1 = true;
                    break;
                }
            }
            if (!daTonTai1) {
                //them lkdsd vao hoa don
                for (LinhKien lk : listlk1) {
                    if (lk.getId() == Integer.parseInt(request.getParameter("idlk"))) {
                        LinhKienSuDung linhKienSuDung = new LinhKienSuDung();
                        linhKienSuDung.setLinhKien(lk);
                        linhKienSuDung.setSoLuong(1);
                        listlk.add(linhKienSuDung);
                    }
                }
                session.setAttribute("dslk", listlk);
            }
        }

    } else if (action.equalsIgnoreCase("sua")) { //goi tu chinh no, de sua so luong
        int soLuong = Integer.parseInt(request.getParameter("soluong"));
        listdv = (ArrayList<DichVuSuDung>) session.getAttribute("dsdv");
        listlk = (ArrayList<LinhKienSuDung>) session.getAttribute("dslk");
        if (request.getParameter("iddv") != null) {
            for (DichVuSuDung dv : listdv) {
                if (dv.getDichVu().getId() == Integer.parseInt(request.getParameter("iddv"))) {
                    dv.setSoLuong(soLuong);
                    session.setAttribute("dsdv", listdv);
                    break;
                }
            }
        }
        if (request.getParameter("idlk") != null) {
            for (LinhKienSuDung lk : listlk) {
                if (lk.getLinhKien().getId() == Integer.parseInt(request.getParameter("idlk"))) {
                    lk.setSoLuong(soLuong);
                    session.setAttribute("dslk", listlk);
                    break;
                }
            }
        }

    } else if (action.equalsIgnoreCase("xoa")) { // goi tu chinh no, de xoa
        listdv = (ArrayList<DichVuSuDung>) session.getAttribute("dsdv");
        listlk = (ArrayList<LinhKienSuDung>) session.getAttribute("dslk");
        if (request.getParameter("iddv") != null) {
            int iddv = Integer.parseInt(request.getParameter("iddv"));
            for (int i = 0; i < listdv.size(); i++) {
                if (listdv.get(i).getDichVu().getId() == iddv) {
                    listdv.remove(listdv.get(i));
                    session.setAttribute("dsdv", listdv);
                    break;
                }
            }
        }
        if (request.getParameter("idlk") != null) {
            int idlk = Integer.parseInt(request.getParameter("idlk"));
            for (int i = 0; i < listlk.size(); i++) {
                if (listlk.get(i).getLinhKien().getId() == idlk) {
                    listlk.remove(listlk.get(i));
                    session.setAttribute("dslk", listlk);
                    break;
                }
            }
        }
    }
%>

<head>
    <meta charset="ISO-8859-1">
    <%@include file="header.jsp" %>
    <title>Hóa đơn chi tiết</title>
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
</head>

<body>
<div class="container" align="center" style="margin-top: 50px">
    <div class="row">
        <h1>Chi tiết hóa đơn</h1>
    </div>
    <div class="row">
        <table>
            <h4>Thông Tin Khách Hàng</h4>
            <tr>
                <th scope="col">Mã khách hàng</th>
                <th scope="col">Tên</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Mô tả</th>
            </tr>
            </thead>

            <%
                if (listkh != null) {
                    for (int i = 0; i < listkh.size(); i++) {
            %>
            <tbody>

            <tr>
                <td><%= i + 1 %>
                </td>
                <td><%=listkh.get(i).getHoTen()%>
                </td>
                <td><%=listkh.get(i).getDiaChi()%>
                </td>
                <td><%=listkh.get(i).getSdt()%>
                </td>
                <td><%=(listkh.get(i).getGhichu() != null) ? listkh.get(i).getGhichu() : " "%>
                </td>
            </tr>
            </tbody>
            <% }
            }
            %>
        </table>

        <table>
            <h4>Thông tin Xe Ô Tô</h4>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">#ID</th>
                <th scope="col">Biển số</th>
                <th scope="col">Dòng xe</th>
                <th scope="col">Hãng xe</th>
                <th scope="col">Mô tả</th>
            </tr>
            </thead>
            <%
                if (listxe != null) {
                    for (int i = 0; i < listxe.size(); i++) {
            %>
            <tbody>

            <tr>

                <td><%=i + 1%>
                </td>
                <td><%=listxe.get(i).getId()%>
                </td>
                <td><%=listxe.get(i).getBienSo()%>
                </td>
                <td><%=listxe.get(i).getDongXe()%>
                </td>
                <td><%=listxe.get(i).getHangXe()%>
                </td>
                <td><%=(listxe.get(i).getMoTa() != null) ? listxe.get(i).getMoTa() : " " %>
                </td>
            </tr>
            </tbody>
            <% }
            }
            %>
        </table>

        <table>
            <h4>Danh Sách Linh Kiện Dịch Vụ</h4>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">#ID</th>
                <th scope="col">Tên</th>
                <th scope="col">Đơn giá</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Thành tiền</th>
                <th scope="col">Xóa<i class='fas fa-trash-alt'></i></th>
            </tr>
            </thead>

            <tbody>
                <%
                int count = 1;
                float tongTien = 0;
                    if (listdv != null) {
                        for (int i = 0; i < listdv.size(); i++) {
                %>
            <tr>

                <td><%=count++%>
                </td>
                <td><%=listdv.get(i).getDichVu().getId()%>
                </td>
                <td><%=listdv.get(i).getDichVu().getTen()%>
                </td>
                <td><i class="fa-solid fa-dollar-sign"></i> <%=Math.round(listdv.get(i).getDichVu().getDonGia())%>
                </td>
                <td>
                    <form name="nhapsoluong"
                          action="gdChiTietHoaDon.jsp?action=sua&&iddv=<%=listdv.get(i).getDichVu().getId()%>"
                          method="post" class="nhap_so_luong">
                        <input type="number" name="soluong" placeholder="<%=listdv.get(i).getSoLuong()%>">
                        <button type="submit">Lưu</button>
                    </form>

                </td>
                <td>
                    <%
                        float thanhTien1 = listdv.get(i).getDichVu().getDonGia() * listdv.get(i).getSoLuong();
                        tongTien += thanhTien1;
                    %>
                    <%=String.valueOf(Math.round(thanhTien1))%>
                </td>
                <td>
                    <a href="gdChiTietHoaDon.jsp?action=xoa&&iddv=<%=listdv.get(i).getDichVu().getId()%>"
                       onclick="return confirm('Bạn muốn xóa dịch vụ này?');">Xóa</a>
                </td>

            </tr>
                <% }
                }
                %>

                <%
                    if (listlk != null) {
                        for (int i = 0; i < listlk.size(); i++) {
                %>
            <tr>

                <td><%=count++%>
                </td>
                <td><%=listlk.get(i).getLinhKien().getId()%>
                </td>
                <td><%=listlk.get(i).getLinhKien().getTen()%>
                </td>
                <td><i class="fa-solid fa-dollar-sign"></i> <%=Math.round(listlk.get(i).getLinhKien().getDonGia())%>
                </td>
                <td>
                    <form name="nhapsoluong"
                          action="gdChiTietHoaDon.jsp?action=sua&&idlk=<%=listlk.get(i).getLinhKien().getId()%>"
                          method="post" class="nhap_so_luong">
                        <input type="number" name="soluong" placeholder="<%=listlk.get(i).getSoLuong()%>">
                        <button type="submit">Lưu</button>
                    </form>
                </td>
                <td>
                    <%
                        float thanhTien = listlk.get(i).getLinhKien().getDonGia() * listlk.get(i).getSoLuong();
                        tongTien += thanhTien;
                    %>
                    <%=Math.round(thanhTien)%>
                </td>
                <td>
                    <a href="gdChiTietHoaDon.jsp?action=xoa&&idlk=<%=listlk.get(i).getLinhKien().getId()%>"
                       onclick="return confirm('Bạn muốn xóa linh kiện này?');">Xóa</a>
                </td>


            </tr>
                <% }
                }
                %>
            <thead>

            <tr>
                <th scope="col" style="background-color: yellow;">Tổng tiền: <%=Math.round(tongTien)%></th>

            </tr>
            </thead>
            </tbody>

        </table>

    </div>
</div>
<div class="container-fluid" align="center">
    <form action="gdChiTietHoaDon.jsp" method="post">
        <input class="btn btn-success" type="button" onclick="openPage('gdTimKiemHoaDon.jsp')" value="Quay lại"
               style="width: 200px">
        <input class="btn btn-success" type="button" onclick="openPage('gdTimKiemLinhKienDichVu.jsp')"
               value="Thêm mới" style="width: 200px">
        <input class="btn btn-primary" style="margin: 20px" type="button" onclick="openPage('doSaveHoaDon.jsp')"
               value="Thanh toán" name="btnThanhToan">
    </form>
</div>
</body>

</html>
