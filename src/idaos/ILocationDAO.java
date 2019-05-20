package idaos;

import java.util.List;
import models.Location;

public interface ILocationDAO {
    
//    public List<Location> getAll();
//    public List<Location> getById(int id);
//    public List<Location> search(String key) ;
//    public boolean insert(Location l);
//    public boolean update(Location l);
    public List<Location> getData(Object key, boolean isGetById);
    public boolean save(Location r, boolean isInsert);
    public boolean delete(int id);
    
}
