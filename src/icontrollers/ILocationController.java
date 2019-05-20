
package icontrollers;

import java.util.List;
import models.Location;

public interface ILocationController {
    public List<Location> getAll();
    
    public List<Location> getById(String id);
    
    public List<Location> search(String key);
    
    public String insert(String id, String street_address,String postal_code, String city,String  state_province, String country_id);
    
    public String update(String id, String street_address,String postal_code, String city,String  state_province, String country_id);
    
    public String delete(String id);
}
