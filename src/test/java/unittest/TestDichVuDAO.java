package unittest;

import dao.DichVuDAO;
import model.DichVu;
import model.LinhKien;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestDichVuDAO {
    DichVuDAO dichVuDAO = new DichVuDAO();

    @Test
    public void searchDichVu_TestChuan1(){
        String key = "";
        ArrayList<DichVu> list = dichVuDAO.searchDichVu(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(8, list.size());
    }

    @Test
    public void searchDichVu_TestChuan2(){
        String key = "n";
        String tendv = "Sơn xe";
        ArrayList<DichVu> list = dichVuDAO.searchDichVu(key);
        Assert.assertNotNull(list);
        for (int i = 0; i<list.size(); i++){
            Assert.assertTrue(list.get(0).getTen().toLowerCase().equals(tendv.toLowerCase()));
        }
    }

    @Test
    public void searchDichVu_TestChuan3(){
        String key = "sd";
        ArrayList<DichVu> list = dichVuDAO.searchDichVu(key);
        Assert.assertEquals(0, list.size());
    }

}
