package dao;

import model.DichVu;
import model.DichVuSuDung;
import model.KhachHang;
import model.ThanhVien;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DichVuSDDAO extends DAO {
    public ArrayList<DichVuSuDung> getDSDichVuTrongHD(String maHoaDon) {
        ArrayList<DichVuSuDung> kq = null;
        String sql = "{call getDSDichVuTrongHD(?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, maHoaDon);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (kq == null) kq = new ArrayList<>();
                DichVuSuDung dvsd = new DichVuSuDung();
                dvsd.setSoLuong(rs.getInt("soluong"));
                DichVu dv = new DichVu();
                dv.setId(rs.getInt("id"));
                dv.setTen(rs.getString("ten"));
                dv.setDonGia(rs.getFloat("dongia"));
                dv.setMoTa(rs.getString("mota"));
                dvsd.setDichVu(dv);
                kq.add(dvsd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
}
