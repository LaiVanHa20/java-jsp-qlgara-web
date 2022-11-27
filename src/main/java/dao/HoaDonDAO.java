package dao;

import model.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class HoaDonDAO extends DAO{

    public ArrayList<HoaDon> searchHoaDon(String key) {
        ArrayList<HoaDon> result = new ArrayList<HoaDon>();
        String sql = "SELECT * FROM tblhoadon WHERE mahoadon = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt("id"));
                hd.setMaHoaDon(rs.getString("mahoadon"));
                hd.setThoiGian(rs.getDate("thoigian"));
                hd.setTongTien(rs.getFloat("tongtien"));
                hd.setMoTa(rs.getString("mota"));
                result.add(hd);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean saveHoaDon(ArrayList<DichVuSuDung> listdv, ArrayList<LinhKienSuDung> listlk, ArrayList<HoaDon> hoaDons){
        if(listdv.size()==0  && listlk.size()==0) return false;
        boolean kq = false;
        String sqlXoa = "DELETE FROM tbldichvusd dvsd WHERE dvsd.tblXeDuocSuaId = ?";
        String sqlThem = "INSERT INTO tbldichvusd(soluong, tblDichVuId, tblXeDuocSuaId) VALUES(?,?,?)";
        String sqlXoaLK = "DELETE FROM tbllinhkiensd lksd WHERE lksd.tblXeDuocSuaId = ?";
        String sqlThemLK = "INSERT INTO tbllinhkiensd(soluong, tblLinhKienId, tblXeDuocSuaId) VALUES(?,?,?)";
        String sqlUpdateHD = "UPDATE tblhoadon SET thoigian=?, tongtien=?, mota=? WHERE mahoadon=?";
        try{
            con.setAutoCommit(false);
            //xoa het dich vu su dung cu
                ArrayList<XeDuocSua> xeDuocSua = getTTXeDuocSua(hoaDons.get(0).getMaHoaDon());
                int idxeds = xeDuocSua.get(0).getId();
                PreparedStatement psXoa = con.prepareStatement(sqlXoa);
                psXoa.setInt(1, idxeds);
                psXoa.executeUpdate();

            //them lai nhu moi
            for(int i=0; i<listdv.size(); i++){
                int iddv = listdv.get(i).getDichVu().getId();
                int soLuong = listdv.get(i).getSoLuong();
                PreparedStatement psThem = con.prepareStatement(sqlThem);
                psThem.setInt(1, soLuong);
                psThem.setInt(2, iddv);
                psThem.setInt(3, idxeds);
                psThem.executeUpdate();
            }
            //xoa het linh kien su dung cu
            PreparedStatement psXoaLK = con.prepareStatement(sqlXoaLK);
            psXoaLK.setInt(1, idxeds);
            psXoaLK.executeUpdate();

            //them lai nhu moi
            for(int i=0; i<listlk.size(); i++){
                int idlk = listlk.get(i).getLinhKien().getId();
                int soLuongLK = listlk.get(i).getSoLuong();
                PreparedStatement psThemLK = con.prepareStatement(sqlThemLK);
                psThemLK.setInt(1, soLuongLK);
                psThemLK.setInt(2, idlk);
                psThemLK.setInt(3, idxeds);
                psThemLK.executeUpdate();
            }
            //update hoa don
            PreparedStatement psUpdate = con.prepareStatement(sqlUpdateHD);
            psUpdate.setDate(1, (java.sql.Date) hoaDons.get(0).getThoiGian());
            psUpdate.setFloat(2, hoaDons.get(0).getTongTien());
            psUpdate.setString(3, hoaDons.get(0).getMoTa());
            psUpdate.setString(4, hoaDons.get(0).getMaHoaDon());
            psUpdate.executeUpdate();

            con.commit();//cmt dong nay ney chay che do JUnit test
            kq=true;
        }catch(Exception e){
            try{
                con.rollback();//cmt dong nay ney chay che do JUnit test
            }catch(Exception ee){
                kq=false;
                ee.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try{
                con.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            }catch(Exception e){
                kq=false;
                e.printStackTrace();
            }
        }
        return kq;
    }

    public ArrayList<XeDuocSua> getTTXeDuocSua(String maHoaDon){
        ArrayList<XeDuocSua> kq = null;
        String sql = "{call getDSXeTrongHD(?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, maHoaDon);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (kq == null) kq = new ArrayList<>();
                XeDuocSua xeDuocSua = new XeDuocSua();
                xeDuocSua.setId(rs.getInt("idxeduocsua"));
                kq.add(xeDuocSua);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kq;
    }
}
