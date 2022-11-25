package unittest;

import dao.HoaDonDAO;
import model.HoaDon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestHoaDonDAO {
    HoaDonDAO hddao = new HoaDonDAO();
    @Test
    public void searchHoaDon_testChuan1(){
    String maHoaDon = " ";
        ArrayList<HoaDon> list = hddao.searchHoaDon(maHoaDon);
        Assert.assertNull(list);
    }
    @Test
    public void searchHoaDon_testChuan2(){
        String maHoaDon = "HD001";
        ArrayList<HoaDon> list = hddao.searchHoaDon(maHoaDon);
        Assert.assertNull(list);
    }
    @Test
    public void searchHoaDon_testChuan3(){
        String maHoaDon = "HD00001";
        ArrayList<HoaDon> list = hddao.searchHoaDon(maHoaDon);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("HD00001", list.get(0).getMaHoaDon());
        Assert.assertEquals("2022-07-09", String.valueOf(list.get(0).getThoiGian()));
        Assert.assertEquals( 5000000.0, list.get(0).getTongTien());
        Assert.assertEquals("", list.get(0).getMoTa());
    }
}
