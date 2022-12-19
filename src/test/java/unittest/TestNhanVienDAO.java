package unittest;

import dao.NhanVienDAO;
import model.NhanVien;
import org.junit.Assert;
import org.junit.Test;

public class TestNhanVienDAO {
    NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @Test
    public void checkLogin_Testchuan1(){
        String username = "";
        String password = "";
        NhanVien nv = new NhanVien();
        nv.setUsername(username);
        nv.setPassword(password);
        boolean test = nhanVienDAO.checkLogin(nv);
        Assert.assertEquals(false, test);
    }

    @Test
    public void checkLogin_Testchuan2(){
        String username = "jdsaufk";
        String password = "123";
        NhanVien nv = new NhanVien();
        nv.setUsername(username);
        nv.setPassword(password);
        boolean test = nhanVienDAO.checkLogin(nv);
        Assert.assertEquals(false, test);
    }

    @Test
    public void checkLogin_Testchuan3(){
        String username = "ha2703";
        String password = "123";
        NhanVien nv = new NhanVien();
        nv.setUsername(username);
        nv.setPassword(password);
        boolean test = nhanVienDAO.checkLogin(nv);
        Assert.assertEquals(false, test);
    }

    @Test
    public void checkLogin_Testchuan4(){
        String username = "ha2703";
        String password = "123456";
        NhanVien nv = new NhanVien();
        nv.setUsername(username);
        nv.setPassword(password);
        boolean test = nhanVienDAO.checkLogin(nv);
        Assert.assertEquals(true, test);
    }
}
