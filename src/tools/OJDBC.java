package tools;

import daos.RegionDAO;
import daos.DepartmentDAO;
import idaos.IDepartmentDAO;
import idaos.IRegionDAO;
import tools.DBConnection;
import models.Region;
import models.Department;

/**
 *
 * @author ASUS
 */
public class OJDBC {

    public static void main(String[] args) {
        //Manual Test DB
        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());

        //Test Model
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId() + " " + region.getName());
//
//        Region r = new Region(1, "Region New");
//        System.out.println(r.getId() + " " + r.getName());
        
        //test insert
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        Region region1 = new Region(31,"My Region");
//        System.out.println(irdao.insert(region1));
//        
//        //test         
//        for (Region region2 : irdao.getAll()) {
//            System.out.println(region2.getId());
//            System.out.println(region2.getName());
//        }
        
        //test insert
        IDepartmentDAO iddao = new DepartmentDAO(connection.getConnection());
//        Department d = new Department(7,"Apalah",103,1700);
//        System.out.println(iddao.insert(d));
        
//        //Update
//        Department d1 = new Department(99, "Trainee",98,97);
//        System.out.println(iddao.update(d1));
//        //Delete
//        System.out.println(iddao.delete(99));
//        //Search
//        System.out.println(iddao.search("ai"));

        for (Department d : iddao.search("7")) {
            System.out.println(d.getId());
            System.out.println(d.getName());
            System.out.println(d.getManager_id());
            System.out.println(d.getLocation_id());
        }
        
    }

}
