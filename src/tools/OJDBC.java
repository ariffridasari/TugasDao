/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDAO;
import java.sql.Connection;
import java.sql.SQLException;

import daos.RegionDAO;
import idaos.ICountryDAO;
import idaos.IRegionDAO;
import models.Region;
import idaos.IRegionDAO;
import models.Country;
import models.Region;

/**
 *
 * @author Arif Fridasari
 */
public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());

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
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        for (Region region : irdao.search("Su")) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
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
        ICountryDAO icdao = new CountryDAO(connection.getConnection());
        for (Country country : icdao.search("ar")) {
            System.out.println(country.getC_id());
            System.out.println(country.getName());
            System.out.println(country.getR_id());
        }
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
    }

}
