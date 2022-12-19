package unittest;

import dao.KhachHangDAO;
import model.ThanhVien;
import model.XeOto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestKhachHangDAO {
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    @Test
    public void getDSXeTrongHD_Testchuan1(){
        String maHD = "HD89202";
        ArrayList<ThanhVien> list = khachHangDAO.getKhachHangTrongHD(maHD);
        Assert.assertNull(list);
    }

    @Test
    public void getDSXeTrongHD_Testchuan2(){
        String maHD = "HD00001";
        ArrayList<ThanhVien> list = khachHangDAO.getKhachHangTrongHD(maHD);
        Assert.assertNotNull(list);
        Assert.assertEquals("Nguyễn Văn Mạnh", list.get(0).getHoTen());
        Assert.assertEquals("Hà Đông Hà Nội", list.get(0).getDiaChi());
        Assert.assertEquals("0346323789", list.get(0).getSdt());
        Assert.assertEquals(null, list.get(0).getGhichu());
    }
}
