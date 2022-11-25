package model;

import java.util.ArrayList;
import java.util.Date;

public class HoaDon {
    private int id;
    private String maHoaDon;
    private Date thoiGian;
    private float tongTien;
    private String moTa;
    private KhachHang khachHang;
    private ArrayList<XeDuocSua> listXeDuocSua;

    public HoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public ArrayList<XeDuocSua> getListXeDuocSua() {
        return listXeDuocSua;
    }

    public void setListXeDuocSua(ArrayList<XeDuocSua> listXeDuocSua) {
        this.listXeDuocSua = listXeDuocSua;
    }
}
