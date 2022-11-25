package dao;

import model.KhachHang;
import model.ThanhVien;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachHangDAO extends DAO{
    public ArrayList<ThanhVien> getKhachHangTrongHD(String maHoaDon){
        ArrayList<ThanhVien> kq = null;
        String sql = "{call getKhachHangTrongHD(?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, maHoaDon);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                if(kq == null) kq = new ArrayList<>();
                //KhachHang kh = new KhachHang();
                ThanhVien tv = new ThanhVien();
                //kh.setMaKH(rs.getString("makhachhang"));

                tv.setHoTen(rs.getString("hoten"));
                tv.setDiaChi(rs.getString("diachi"));
                tv.setSdt(rs.getString("sdt"));
                tv.setGhichu(rs.getString("ghichu"));
                kq.add(tv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static void main(String[] args) {
        KhachHangDAO kh = new KhachHangDAO();
        ArrayList<ThanhVien> list = new KhachHangDAO().getKhachHangTrongHD("HD00001");

        for(ThanhVien x : list){
            System.out.println(x.getHoTen());
            System.out.println(x.getDiaChi());
            System.out.println(x.getSdt());
        }
    }
}
