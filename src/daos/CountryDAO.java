/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ICountryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author Arif Fridasari
 */
public class CountryDAO implements ICountryDAO {

    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

//    @Override
//    public List<Country> getAll() {
//        List<Country> listCountry = new ArrayList<Country>();
//        String query = "SELECT * FROM COUNTRIES ORDER BY country_id";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
//                listCountry.add(c);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listCountry;
//    }
//
//    @Override
//    public List<Country> getById(String c_id) {
//        List<Country> listCountry = new ArrayList<Country>();
//        String query = "SELECT * FROM COUNTRIES WHERE country_id=?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, c_id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
//                listCountry.add(c);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listCountry;
//    }
//
//    @Override
//    public List<Country> search(String key) {
//        List<Country> listCountry = new ArrayList<Country>();
//        String query = "SELECT * FROM COUNTRIES WHERE REGEXP_LIKE(country_name,?,'i') OR REGEXP_LIKE(country_id,?,'i') ";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, "%" + key + "%");
//            preparedStatement.setString(2, "%" + key + "%");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
//                listCountry.add(c);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listCountry;
//    }
    @Override
    public List<Country> getData(Object key, boolean isGetById) {
        List<Country> listCountry = new ArrayList<Country>();
        String query = (isGetById)
                ? "SELECT * FROM COUNTRIES WHERE country_id=?"
                : "SELECT * FROM COUNTRIES WHERE REGEXP_LIKE(country_name,?,'i') OR REGEXP_LIKE(country_id,?,'i') OR REGEXP_LIKE(region_id,?,'i')";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (isGetById) {
                preparedStatement.setInt(1, (int) key);
            } else {
                preparedStatement.setString(1, "%" + key.toString() + "%");
                preparedStatement.setString(2, "%" + key.toString() + "%");
                preparedStatement.setString(3, "%" + key.toString() + "%");
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                listCountry.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCountry;
    }
    

//    @Override
//    public boolean insert(Country c) {
//        boolean result = false;
//        String query = "INSERT INTO COUNTRIES (country_id, country_name, region_id) VALUES (?,?,?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, c.getC_id());
//            preparedStatement.setString(2, c.getName());
//            preparedStatement.setInt(3, c.getR_id());
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

//    @Override
//    public boolean update(Country c) {
//        boolean result = false;
//        String query = "UPDATE COUNTRIES SET country_name = ?,region_id=? WHERE country_id=?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, c.getName());
//            preparedStatement.setInt(2, c.getR_id());
//            preparedStatement.setString(3, c.getC_id());
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
    
    @Override
    public boolean save(Country c, boolean isInsert) {
        boolean result = false;
        String query = (isInsert)
                ? "INSERT INTO COUNTRIES (country_name, region_id,country_id) VALUES (?,?,?)"
                : "UPDATE COUNTRIES SET country_name = ?,region_id=? WHERE country_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getName());
            preparedStatement.setInt(2, c.getR_id());
            preparedStatement.setString(3, c.getC_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

    @Override
    public boolean delete(String c_id) {
        boolean result = false;
        String query = "DELETE FROM COUNTRIES WHERE country_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c_id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
