package model;

import java.util.ArrayList;

public class XeDuocSua {
    private int id;
    private String trangThai;
    private NVKiThuat nvKiThuat;
    private ArrayList<XeOto> listXe;
    private ArrayList<DichVuSuDung> listDichVuSD;
    private ArrayList<LinhKienSuDung> listLinhKienSD;

    public XeDuocSua() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NVKiThuat getNvKiThuat() {
        return nvKiThuat;
    }

    public void setNvKiThuat(NVKiThuat nvKiThuat) {
        this.nvKiThuat = nvKiThuat;
    }

    public ArrayList<XeOto> getListXe() {
        return listXe;
    }

    public void setListXe(ArrayList<XeOto> listXe) {
        this.listXe = listXe;
    }

    public ArrayList<DichVuSuDung> getListDichVuSD() {
        return listDichVuSD;
    }

    public void setListDichVuSD(ArrayList<DichVuSuDung> listDichVuSD) {
        this.listDichVuSD = listDichVuSD;
    }

    public ArrayList<LinhKienSuDung> getListLinhKienSD() {
        return listLinhKienSD;
    }

    public void setListLinhKienSD(ArrayList<LinhKienSuDung> listLinhKienSD) {
        this.listLinhKienSD = listLinhKienSD;
    }
}
