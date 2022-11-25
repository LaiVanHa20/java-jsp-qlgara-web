package model;

public class KhachHang extends ThanhVien{
    private String maKH;

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    @Override
    public void setHoTen(String hoTen) {
        super.setHoTen(hoTen);
    }
}
