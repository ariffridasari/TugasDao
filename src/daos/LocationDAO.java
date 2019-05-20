package daos;

import idaos.ILocationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Location;

public class LocationDAO implements ILocationDAO {
    private Connection connection;
    
    public LocationDAO(Connection connection){
        this.connection=connection;
    }

    @Override
    public List<Location> getAll() {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                l.setId(resultSet.getInt(1));
                l.setStreet_address(resultSet.getString(2));
                l.setPostal_code(resultSet.getString(3));
                l.setCity(resultSet.getString(4));
                l.setState_province(resultSet.getString(5));
                l.setCountry_id(resultSet.getString(6));
                listLocation.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listLocation;
    }

    @Override
    public List<Location> getById(int id) {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS WHERE location_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
               listLocation.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listLocation;
    }

    @Override
    public List<Location> search(String key) {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS WHERE location_id LIKE (?) OR street_address LIKE (?) OR postal_code LIKE (?)"
                + "OR city LIKE (?) OR state_province LIKE (?) OR country_id LIKE (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            preparedStatement.setString(3, "%" + key + "%");
            preparedStatement.setString(4, "%" + key + "%");
            preparedStatement.setString(5, "%" + key + "%");
            preparedStatement.setString(6, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)
                        , resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                listLocation.add(l);
            }
        } catch (Exception e) { 
            e.getStackTrace();
        }
        return listLocation;
    }

    @Override
    public boolean insert(Location l) {
        boolean result = false;
        String query = "INSERT INTO LOCATIONS(location_id, street_address, postal_code, city, state_province, country_id) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, l.getId());
            preparedStatement.setString(2, l.getStreet_address());
            preparedStatement.setString(3, l.getPostal_code());
            preparedStatement.setString(4, l.getCity());
            preparedStatement.setString(5, l.getState_province());
            preparedStatement.setString(6, l.getCountry_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Location l) {
        boolean result = false;
        String query = "UPDATE LOCATIONS SET street_address=?, postal_code=?, city=?, state_province=?, country_id=? WHERE location_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, l.getStreet_address());
            preparedStatement.setString(2, l.getPostal_code());
            preparedStatement.setString(3, l.getCity());
            preparedStatement.setString(4, l.getState_province());
            preparedStatement.setString(5, l.getCountry_id());
            preparedStatement.setInt(6, l.getId());
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
        String query = "DELETE FROM LOCATIONS WHERE location_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
