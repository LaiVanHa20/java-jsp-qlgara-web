package unittest;

import dao.*;
import model.DichVu;
import model.DichVuSuDung;
import model.HoaDon;

import model.LinhKienSuDung;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestHoaDonDAO {
    HoaDonDAO hddao = new HoaDonDAO();
    LinhKienSDDAO linhKienSDDAO = new LinhKienSDDAO();
    DichVuSDDAO dichVuSDDAO = new DichVuSDDAO();

    @Test
    public void searchHoaDon_testChuan1(){
    String maHoaDon = " ";
        HoaDon hoaDon = hddao.searchHoaDon(maHoaDon);
        Assert.assertEquals(null, hoaDon.getMaHoaDon());
    }
    @Test
    public void searchHoaDon_testChuan2(){
        String maHoaDon = "HD001";
        HoaDon hoaDon = hddao.searchHoaDon(maHoaDon);
        Assert.assertEquals(null, hoaDon.getMaHoaDon());
    }
    @Test
    public void searchHoaDon_testChuan3(){
        String maHoaDon = "HD00001";
        float tongTien = 400000;
        HoaDon hoaDon = hddao.searchHoaDon(maHoaDon);
        Assert.assertEquals("HD00001", hoaDon.getMaHoaDon());
        Assert.assertEquals("2022-11-27", String.valueOf(hoaDon.getThoiGian()));
        Assert.assertEquals(Float.valueOf(tongTien), Float.valueOf(hoaDon.getTongTien()));
        Assert.assertEquals("Đã thanh toán", hoaDon.getMoTa());
    }

    @Test
    public void saveHoaDon_testChuan1(){
        ArrayList<DichVuSuDung> listdv = new ArrayList<>();
        ArrayList<LinhKienSuDung> listlk = new ArrayList<>();
        String maHoaDon = "HD00001";
        HoaDon hoaDons = hddao.searchHoaDon(maHoaDon);
        try {
            DAO.con.setAutoCommit(false);
            boolean test = hddao.saveHoaDon(listdv, listlk, hoaDons);
            Assert.assertFalse(test);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
        try{
            DAO.con.rollback();
            DAO.con.setAutoCommit(true);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    }

    @Test
    public void saveHoaDon_testChuan2(){
        String maHoaDon = "HD00001";
        ArrayList<DichVuSuDung> listdv = dichVuSDDAO.getDSDichVuTrongHD(maHoaDon);
        ArrayList<LinhKienSuDung> listlk = linhKienSDDAO.getDSLinhKienTrongHD(maHoaDon);
        HoaDon hoaDons = hddao.searchHoaDon(maHoaDon);
        try {
            DAO.con.setAutoCommit(false);
            boolean test = hddao.saveHoaDon(listdv, listlk, hoaDons);
            Assert.assertTrue(test);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void saveHoaDon_testChuan3(){
        String maHoaDon = "HD00001";
        ArrayList<DichVuSuDung> listdv = dichVuSDDAO.getDSDichVuTrongHD(maHoaDon);
        ArrayList<LinhKienSuDung> listlk = linhKienSDDAO.getDSLinhKienTrongHD(maHoaDon);
        HoaDon hoaDons = hddao.searchHoaDon(maHoaDon);

        DichVuSuDung dvsd = new DichVuSuDung();
        DichVu dv = new DichVu();
        dv.setId(2);
        dvsd.setDichVu(dv);
        dvsd.setSoLuong(1);
        listdv.add(dvsd);
        try {
            DAO.con.setAutoCommit(false);
            boolean test = hddao.saveHoaDon(listdv, listlk, hoaDons);
            Assert.assertTrue(test);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void saveHoaDon_testChuan4(){
        String maHoaDon = "HD00001";
        ArrayList<DichVuSuDung> listdv = dichVuSDDAO.getDSDichVuTrongHD(maHoaDon);
        ArrayList<LinhKienSuDung> listlk = linhKienSDDAO.getDSLinhKienTrongHD(maHoaDon);
        HoaDon hoaDons = hddao.searchHoaDon(maHoaDon);
        listdv.remove(0);
        try {
            DAO.con.setAutoCommit(false);
            boolean test = hddao.saveHoaDon(listdv, listlk, hoaDons);
            Assert.assertTrue(test);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void saveHoaDon_testChuan5(){
        String maHoaDon = "HD00001";
        ArrayList<DichVuSuDung> listdv = dichVuSDDAO.getDSDichVuTrongHD(maHoaDon);
        ArrayList<LinhKienSuDung> listlk = linhKienSDDAO.getDSLinhKienTrongHD(maHoaDon);
        HoaDon hoaDons = hddao.searchHoaDon(maHoaDon);

        listdv.get(0).setSoLuong(4);

        try {
            DAO.con.setAutoCommit(false);
            boolean test = hddao.saveHoaDon(listdv, listlk, hoaDons);
            Assert.assertTrue(test);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            try{
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
