/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author Arif Fridasari
 */
public class RegionDAO implements IRegionDAO {

    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }
    
      /**
         * getData("", false) -->  GET ALL
         * getData(key, false) -->  SEARCH
         * getData(key, true) -->  GET BY ID
         * 
         */

//    @Override
//    public List<Region> getAll() {
//        List<Region> listRegion = new ArrayList<Region>();
//        String query = "SELECT * FROM REGIONS ORDER BY region_id";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                listRegion.add(r);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listRegion;
//    }
//
//    @Override
//    public List<Region> getById(int id) {
//        List<Region> listRegion = new ArrayList<Region>(id);
//        String query = "SELECT * FROM REGIONS WHERE region_id = ? ";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                listRegion.add(r);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listRegion;
//    }
//
//    @Override
//    public List<Region> search(String key) {
//        List<Region> listRegion = new ArrayList<Region>();
//        String query = "SELECT * FROM REGIONS WHERE REGEXP_LIKE(region_name,?,'i') OR REGEXP_LIKE(region_id,?,'i')";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, key);
//            preparedStatement.setString(2, key);
////            preparedStatement.setString(2, "%" + key + "%");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                listRegion.add(r);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listRegion;
//    }
//    @Override
//    public boolean insert(Region r) {
//        boolean result = false;
//        String query = "INSERT INTO REGIONS (region_id, region_name) VALUES (?,?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, r.getId());
//            preparedStatement.setString(2, r.getName());
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public boolean update(Region r) {
//        boolean result = false;
//        String query = "UPDATE REGIONS SET region_name=? WHERE region_id=?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, r.getName());
//            preparedStatement.setInt(2, r.getId());
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
    @Override
    public List<Region> getData(Object key, boolean isGetById) {
        List<Region> listRegion = new ArrayList <Region>();
        String query = (isGetById)
                ? "SELECT * FROM REGIONS WHERE region_id = ? "
                : "SELECT * FROM REGIONS WHERE region_id LIKE ? OR region_name LIKE ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (isGetById) {
                preparedStatement.setInt(1, (int) key);
            } else {
                preparedStatement.setString(1, "%" + key.toString() + "%");
                preparedStatement.setString(2, "%" + key.toString() + "%");
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegion;
    }

    @Override
    public boolean save(Region r, boolean isInsert) {
        boolean result = false;
        String query = (isInsert)
                ? "INSERT INTO REGIONS (region_name, region_id) VALUES (?,?)"
                : "UPDATE REGIONS SET region_name=? WHERE region_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getName());
            preparedStatement.setInt(2, r.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM REGIONS WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
        }
        return result;
    }

}
