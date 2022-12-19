package unittest;

import dao.LinhKienSDDAO;
import model.DichVuSuDung;
import model.LinhKienSuDung;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestLinhKienSDDAO {
    LinhKienSDDAO linhKienSDDAO = new LinhKienSDDAO();

    @Test
    public void getDSLinhKienTrongHD_TestChuan1(){
        String maHD = "HD10209";
        ArrayList<LinhKienSuDung> list = linhKienSDDAO.getDSLinhKienTrongHD(maHD);
        Assert.assertNull(list);
    }

    @Test
    public void getDSDichVuTrongHD_TestChuan2(){
        String maHD = "HD00002";
        ArrayList<LinhKienSuDung> list = linhKienSDDAO.getDSLinhKienTrongHD(maHD);
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(8, list.get(0).getLinhKien().getId());
        Assert.assertEquals(2, list.get(0).getSoLuong());
        Assert.assertEquals("Thay dây côn", list.get(0).getLinhKien().getTen());
    }
}
