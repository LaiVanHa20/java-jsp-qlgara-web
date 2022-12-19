package unittest;

import dao.XeOtoDAO;
import model.XeOto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestXeOtoDAO {
    XeOtoDAO xeOtoDAO = new XeOtoDAO();

    @Test
    public void getDSXeTrongHD_Testchuan1(){
        String maHD = "HD89202";
        ArrayList<XeOto> list = xeOtoDAO.getXeTrongHD(maHD);
        Assert.assertNull(list);
    }

    @Test
    public void getDSXeTrongHD_Testchuan2(){
        String maHD = "HD00001";
        ArrayList<XeOto> list = xeOtoDAO.getXeTrongHD(maHD);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.get(0).getId());
        Assert.assertEquals("29C-88888", list.get(0).getBienSo());
        Assert.assertEquals("SUV", list.get(0).getDongXe());
        Assert.assertEquals("Toyota", list.get(0).getHangXe());
        Assert.assertEquals(null, list.get(0).getMoTa());
    }
}
