package dao;

import model.KhachHang;
import model.ThanhVien;
import model.XeOto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class XeOtoDAO extends DAO{
    public ArrayList<XeOto> getDSXeTrongHD(String maHoaDon){
        ArrayList<XeOto> kq = null;
        String sql = "{call getDSXeTrongHD(?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, maHoaDon);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (kq == null) kq = new ArrayList<>();
                XeOto xe = new XeOto();
                xe.setId(rs.getInt("id"));
                xe.setBienSo(rs.getString("bienso"));
                xe.setDongXe(rs.getString("dongxe"));
                xe.setHangXe(rs.getString("hangxe"));
                xe.setMoTa(rs.getString("mota"));
                kq.add(xe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
}
