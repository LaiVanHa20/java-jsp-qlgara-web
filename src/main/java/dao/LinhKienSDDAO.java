package dao;

import model.KhachHang;
import model.LinhKien;
import model.LinhKienSuDung;
import model.ThanhVien;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LinhKienSDDAO extends DAO{
    public ArrayList<LinhKienSuDung> getDSLinhKienTrongHD(String maHoaDon){
        ArrayList<LinhKienSuDung> kq = null;
        String sql = "{call getDSLinhKienTrongHD(?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, maHoaDon);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                if(kq == null) kq = new ArrayList<>();
                LinhKienSuDung lksd = new LinhKienSuDung();
                LinhKien lk = new LinhKien();
                lksd.setSoLuong(rs.getInt("soluong"));

                lk.setId(rs.getInt("id"));
                lk.setTen(rs.getString("ten"));
                lk.setDonGia(rs.getFloat("dongia"));
                lk.setMoTa(rs.getString("mota"));
                lksd.setLinhKien(lk);
                kq.add(lksd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
}
