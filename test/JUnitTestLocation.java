import controllers.LocationController;
import icontrollers.ILocationController;
import java.util.List;
import models.Location;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DBConnection;

public class JUnitTestLocation {
    
    DBConnection connection = new DBConnection();
    ILocationController ilc = new LocationController(connection.getConnection());
    
    public JUnitTestLocation() {
    }
    
    @Test
    public void testGetBYId(){
        List<Location> act = ilc.getById("1");
        Assert.assertNotNull(act);
    }
    public void testGetAll(){
        List<Location> act3 = ilc.getAll();
        Assert.assertNotNull(act3);
    }
    public void testSearch(){
        List<Location> act2 = ilc.search("1");
        Assert.assertNotNull(act2);
    }
    public void testInsert(){
        ilc.insert("111", "1297 las vegas","12945","las vegas","LA","US");
        List<Location> m = ilc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("1297 las vegas", m.get(0).getStreet_address());
        Assert.assertEquals("12945", m.get(0).getPostal_code());
        Assert.assertEquals("las vegas", m.get(0).getCity());
        Assert.assertEquals("LA", m.get(0).getState_province());
        Assert.assertEquals("US", m.get(0).getCountry_id());
    }
    public void testUpdate(){
        ilc.update("111", "1297 Las vegas","12945","Las Vegas","LA","USA");
        List<Location> m = ilc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("1297 Las vegas", m.get(0).getStreet_address());
        Assert.assertEquals("12945", m.get(0).getPostal_code());
        Assert.assertEquals("Las Vegas", m.get(0).getCity());
        Assert.assertEquals("LA", m.get(0).getState_province());
        Assert.assertEquals("US", m.get(0).getCountry_id());
    }
    public void testDelete(){
        ilc.delete("111");
        Assert.assertNull(ilc.getById("111"));
    }

}
