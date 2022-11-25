package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public boolean saveHoaDon(ArrayList<DichVuSuDung> listdv, ArrayList<LinhKienSuDung> listlk, ArrayList<XeOto> listxe){
        if((listdv == null)|| (listdv.size() ==0) || (listlk == null)|| (listlk.size() ==0)) return false;
        boolean kq = false;
        String sqlXoa = "DELETE FROM tbldichvusd dvsd WHERE dvsd.tblXeDuocSuaId = ?";
        String sqlThem = "INSERT INTO tbldichvusd(soluong, tblDichVuId, tblXeDuocSuaId) VALUES(?,?,?)";
        String sqlXoaLK = "DELETE FROM tbllinhkiensd lksd WHERE lksd.tblXeDuocSuaId = ?";
        String sqlThemLK = "INSERT INTO tbllinhkiensd(soluong, tblLinhKienId, tblXeDuocSuaId) VALUES(?,?,?)";
        try{
            con.setAutoCommit(false);
            //xoa het dich vu su dung cu
                int idxeds = listxe.get(0).getId();
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
}
