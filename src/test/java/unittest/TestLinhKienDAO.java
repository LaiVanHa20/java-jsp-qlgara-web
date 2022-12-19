package unittest;

import dao.LinhKienDAO;
import model.LinhKien;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestLinhKienDAO {
    LinhKienDAO linhKienDAO = new LinhKienDAO();

    @Test
    public void searchLinhkien_TestChuan1(){
        String key = "";
        ArrayList<LinhKien> list = linhKienDAO.searchLinhkien(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(10, list.size());
    }

    @Test
    public void searchLinhkien_TestChuan2(){
        String key = "n";
        String tenlk = "Thay dây côn";
        ArrayList<LinhKien> list = linhKienDAO.searchLinhkien(key);
        Assert.assertNotNull(list);
        for (int i = 0; i<list.size(); i++){
            Assert.assertTrue(list.get(5).getTen().toLowerCase().equals(tenlk.toLowerCase()));
        }
    }
    @Test
    public void searchLinhkien_TestChuan3(){
        String key = "sd";
        ArrayList<LinhKien> list = linhKienDAO.searchLinhkien(key);
        Assert.assertEquals(0, list.size());
    }
}
