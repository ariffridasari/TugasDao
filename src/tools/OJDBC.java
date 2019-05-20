package tools;

import daos.CountryDAO;
import daos.RegionDAO;
import daos.DepartmentDAO;
import idaos.ICountryDAO;
import idaos.IDepartmentDAO;
import idaos.IRegionDAO;
import models.Country;
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
//        IDepartmentDAO iddao = new DepartmentDAO(connection.getConnection());
//        Department d = new Department(7,"Apalah",103,1700);
//        System.out.println(iddao.insert(d));
        
//        //Update
//        Department d1 = new Department(99, "Trainee",98,97);
//        System.out.println(iddao.update(d1));
//        //Delete
//        System.out.println(iddao.delete(99));
//        //Search
//        System.out.println(iddao.search("ai"));

//        for (Department d : iddao.search("7")) {
//            System.out.println(d.getId());
//            System.out.println(d.getName());
//            System.out.println(d.getManager_id());
//            System.out.println(d.getLocation_id());
//        }
        
        
         /**
         * Tabel REGIONS
         */
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId() + " " + region.getName());
//
//        Region r = new Region(1, "My Region");
//        System.out.println(r.getId() + " " + r.getName());
        /**
         * GET ALL REGIONS
         */
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        for (Region region : irdao.getAll()) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
        /**
         * GET BY ID REGIONS
         */
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        for (Region region : irdao.getById(2)) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
        /**
         * INSERT REGIONS
         */
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        Region region = new Region(32,"Jogjaku");
//        System.out.println(irdao.insert(region));
        /**
         * DELETE REGIONS
         */
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        System.out.println(irdao.delete(31));
        /**
         * UPDATE REGIONS
         */
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        Region region = new Region(31,"Surabaya");
//        System.out.println(irdao.update(region));
        /**
         * SEARCH REGIONS
         */
<<<<<<< HEAD
        RegionDAO irdao = new RegionDAO(connection.getConnection());
        for (Region region : irdao.getData(1, true)) {
            System.out.println(region.getId());
            System.out.println(region.getName());
        }
        
        /**
         * getData("", false) -->  GET ALL
         * getData(key, false) -->  SEARCH
         * getData(key, true) -->  GET BY ID
         * 
         */
        
        
=======
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        for (Region region : irdao.search("su")) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
>>>>>>> origin/master
        /**
         * TABEL COUNTRIES
         */
//        Country country = new Country();
//        country.setC_id("SM");
//        country.setR_id(0);
//        country.setName("Semarang");
//        System.out.println(country.getC_id() + " " + country.getName() + " " + country.getR_id());
//        
//        Country c = new Country("SM",0,"Semarang");
//        System.out.println(country.getC_id() + " " + country.getName() + " " + country.getR_id());
        /**
         * GET ALL COUNTRY
         */
//        ICountryDAO icdao = new CountryDAO(connection.getConnection());
//        for (Country country : icdao.getAll()) {
//            System.out.println(country.getC_id());
//            System.out.println(country.getName());
//            System.out.println(country.getR_id());
//        }
        /**
         * GET BY ID COUNTRY
         */
//        ICountryDAO icdao = new CountryDAO(connection.getConnection());
//        for (Country country : icdao.getById("AR")) {
//            System.out.println(country.getC_id());
//            System.out.println(country.getName());
//            System.out.println(country.getR_id());
//        }
        /**
         * SEARCH COUNTRY
         */
//        ICountryDAO icdao = new CountryDAO(connection.getConnection());
//        for (Country country : icdao.search("Ar")) {
//            System.out.println(country.getC_id());
//            System.out.println(country.getName());
//            System.out.println(country.getR_id());
//        }
        /**
         * INSERT COUNTRY
         */
//        ICountryDAO icdao = new  CountryDAO(connection.getConnection());
//        Country country = new Country("BA","Bawen",32);
//        System.out.println(icdao.insert(country));
        /**
         * UPDATE COUNTRY
         */
//        ICountryDAO icdao = new  CountryDAO(connection.getConnection());
//        Country country = new Country("BA","Bawen City",32);
//        System.out.println(icdao.update(country));
        /**
         * DELETE COUNTRY
         */
//        ICountryDAO icdao = new  CountryDAO(connection.getConnection());
//        System.out.println(icdao.delete("BA"));
     
//// Test model Job History
//        JobHistory jobhistory = new JobHistory();
//        jobhistory.setEmployee_id(102);
//        jobhistory.setJob_id("66");
//        System.out.println(jobhistory.getEmployee_id() + " " + jobhistory.getJob_id());
//        try {
//            Date start = new SimpleDateFormat("MM-dd-yyyy").parse("10-22-2017");
//            Date  end = new SimpleDateFormat("MM-dd-yyyy").parse("09-10-2002");
//            JobHistory r = new JobHistory(102, start, end, "IT_PROGS", 27);
//            System.out.println(r.getEmployee_id() + " " + r.getStart_date()+" "+ r.getEnd_date()+" "+r.getJob_id()+" "+r.getDepartment_id());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//Test DAO update Job History
//        IJobHistoryDAO ijob = new JobHistoryDAO(connection.getConnection());
//        try {
////            Date start = new SimpleDateFormat("MM-dd-yyyy").parse("10-22-2001");
////            Date  end = new SimpleDateFormat("MM-dd-yyyy").parse("09-10-2000");
//            JobHistory r = new JobHistory(107, "11-03-2001","09-09-2002", "IT_PROG", 110);
//
//        System.out.println(ijob.update(r));
//            
//        } catch (Exception e) {
//        }

////Test DAO getALL Job History
//        IJobHistoryDAO irdao = new JobHistoryDAO(connection.getConnection());
//        for (JobHistory jobhistory : irdao.getAll()) {
//            System.out.println(jobhistory.getEmployee_id());
//            System.out.println(jobhistory.getStart_date());
//            System.out.println(jobhistory.getEnd_date());
//            System.out.println(jobhistory.getJob_id());
//            System.out.println(jobhistory.getDepartment_id());
//        }
//Test DAO Insert Job History
//        IJobHistoryDAO ijob = new JobHistoryDAO(connection.getConnection());
//        
//        try {
//        JobHistory r = new JobHistory(133, "10-10-1997", "11-12-1998", "IT_PROG", 110);
//        System.out.println(ijob.insert(r));
//           
//        } catch (Exception e) {
//        }

//Test DAO Search Job History
//        IJobHistoryDAO ijob = new JobHistoryDAO(connection.getConnection());
//        for (JobHistory jobhistory : ijob.search("50")) {
//            System.out.println(jobhistory.getEmployee_id());
//            System.out.println(jobhistory.getStart_date());
//            System.out.println(jobhistory.getEnd_date());
//            System.out.println(jobhistory.getJob_id());
//            System.out.println(jobhistory.getDepartment_id());
//            
//        }
        
    //Test DAO Delete Job History
//        IJobHistoryDAO jobHistory = new JobHistoryDAO(connection.getConnection());
//        jobHistory.delete(100);
//    }
//Test DAO getByID Job History
//        IJobHistoryDAO ijob = new JobHistoryDAO(connection.getConnection());
//        for (JobHistory jobhistory : ijob.getById(122)) {
//            System.out.println(jobhistory.getEmployee_id());
//            System.out.println(jobhistory.getStart_date());
//            System.out.println(jobhistory.getEnd_date());
//            System.out.println(jobhistory.getJob_id());
//            System.out.println(jobhistory.getDepartment_id());
//            
//        }

//Test Controller insert Job History
//        IJobHistoryController ijc = new JobHistoryController(connection.getConnection());
//        ijc.insert(id, name);

//Test Controller delete Job History
//        IJobHistoryController ijc = new JobHistoryController(connection.getConnection());
//        ijc.delete("133");
    }   
    }


