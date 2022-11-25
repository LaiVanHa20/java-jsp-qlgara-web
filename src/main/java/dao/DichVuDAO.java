package dao;

import model.DichVu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DichVuDAO extends DAO{
    public ArrayList<DichVu> searchDichVu(String key) {
        ArrayList<DichVu> result = new ArrayList<DichVu>();
        String sql = "SELECT * FROM tbldichvu WHERE ten LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+ key +"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                DichVu dv = new DichVu();
                dv.setId(rs.getInt("id"));
                dv.setTen(rs.getString("ten"));
                dv.setDonGia(rs.getFloat("dongia"));
                dv.setMoTa(rs.getString("mota"));
                result.add(dv);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
