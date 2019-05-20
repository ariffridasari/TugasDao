
import models.Region;
import controllers.RegionController;
import icontrollers.IRegionController;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DBConnection;
import java.util.ArrayList;



/**
 *
 * @author ASUS
 */
public class JUnitTestRegion {

    DBConnection connection = new DBConnection();
    IRegionController irc = new RegionController(connection.getConnection());

    public JUnitTestRegion() {
    }

    @Test
    public void testGetById() {
        List<Region> act = irc.getById("1");
        Assert.assertNotNull(act);
    }

    public void testGetAll() {
        List<Region> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }
    
     @Test
    public void testSearch() {
        List<Region> act2 = irc.search("1");
        Assert.assertNotNull(act2);
    }

    public void testInsert() {
        irc.insert("111", "NamaSaya");
        List<Region> m = irc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("NamaSaya", m.get(0).getId());
    }
    
    public void testUpdate() {
        irc.insert("111", "NamaSayaIni");
        List<Region> m = irc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("NamaSayaIni", m.get(0).getName());
    }
    public void testDelete() {
        irc.delete("111");
        List<Region> m = irc.getById("111");
        assertNull(irc.getById("111"));
    }
    
}
