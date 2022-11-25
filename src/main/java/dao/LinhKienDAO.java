package dao;

import model.DichVu;
import model.LinhKien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LinhKienDAO extends DAO{
    public ArrayList<LinhKien> searchLinhkien(String key) {
        ArrayList<LinhKien> result = new ArrayList<>();
        String sql = "SELECT * FROM tbllinhkien WHERE ten LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+ key +"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                LinhKien lk = new LinhKien();
                lk.setId(rs.getInt("id"));
                lk.setTen(rs.getString("ten"));
                lk.setDonGia(rs.getFloat("dongia"));
                lk.setMoTa(rs.getString("mota"));
                result.add(lk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
