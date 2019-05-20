package daos;

import idaos.IDepartmentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Department;

/**
 *
 * @author ASUS
 */
public class DepartmentDAO implements IDepartmentDAO {

    private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Department> getAll() {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM Departments ORDER BY department_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLocation_id(resultSet.getInt(4));
                listDepartment.add(d);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartment;
    }

    @Override
    public List<Department> getById(int id) {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM Departments WHERE id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                //gak usah
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setManager_id(3);
                d.setLocation_id(4);
                listDepartment.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartment;
    }

    @Override
    public List<Department> search(String key) {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM Departments WHERE LOWER(department_id) LIKE (?) OR LOWER(department_name) LIKE (?) ORDER BY department_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLocation_id(resultSet.getInt(4));
                listDepartment.add(d);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listDepartment;
    }

    @Override
    public boolean insert(Department d) {
        boolean result = false;
        String query = "INSERT INTO Departments (department_id, department_name, manager_id, location_id) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, d.getId());
            preparedStatement.setString(2, d.getName());
            preparedStatement.setInt(3, d.getManager_id());
            preparedStatement.setInt(4, d.getLocation_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Department d) {
        boolean result = false;
        String query = "UPDATE Departments SET department_name = ?,manager_id = ?, location_id=? WHERE department_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d.getName());
            preparedStatement.setInt(2, d.getManager_id());
            preparedStatement.setInt(3, d.getLocation_id());
            preparedStatement.setInt(4, d.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM Departments WHERE department_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
