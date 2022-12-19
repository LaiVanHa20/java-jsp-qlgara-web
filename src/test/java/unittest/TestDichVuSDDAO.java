package unittest;

import dao.DichVuSDDAO;
import model.DichVuSuDung;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestDichVuSDDAO {
    DichVuSDDAO dichVuSDDAO = new DichVuSDDAO();

    @Test
    public void getDSDichVuTrongHD_TestChuan1(){
        String maHD = "HD10209";
        ArrayList<DichVuSuDung> list = dichVuSDDAO.getDSDichVuTrongHD(maHD);
        Assert.assertNull(list);
    }

    @Test
    public void getDSDichVuTrongHD_TestChuan2(){
        String maHD = "HD00002";
        ArrayList<DichVuSuDung> list = dichVuSDDAO.getDSDichVuTrongHD(maHD);
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(4, list.get(0).getDichVu().getId());
        Assert.assertEquals(1, list.get(0).getSoLuong());
        Assert.assertEquals("Thay dầu máy", list.get(0).getDichVu().getTen());
    }
}
