package dao;

import model.KeToan;
import model.NhanVien;
import model.ThanhVien;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienDAO extends DAO{
    public boolean checkLogin(NhanVien nv){
        boolean kq  = false;
        // check sql injection
        if(nv.getUsername().contains("true")||nv.getUsername().contains("=")||
                nv.getPassword().contains("true")||nv.getPassword().contains("="))
            return false;
        String sql = "{call kiemtraDN(?,?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,nv.getUsername());
            cs.setString(2,nv.getPassword());
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                nv.setVitri(rs.getString("vitri"));
                kq=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            kq=false;
        }

        return kq;
    }

}
