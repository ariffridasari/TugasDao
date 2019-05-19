/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tools.DBConnection;
import tools.OJDBC;
import models.Job;
import idaos.IJobDAO;

/**
 *
 * @author erik
 */
public class JobDAO implements IJobDAO {

    private Connection connection;

    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Job> getAll() {
        List<Job> listJobs = new ArrayList<Job>();
        String query = "select * from jobs";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                Job j = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
//                listJobs.add(j);
                listJobs.add(new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listJobs;
    }
    
    @Override
    public boolean insert(Job j) {
        boolean result = false;
        String query = "insert into jobs(job_id, job_title, min_salary, max_salary) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getId());
            preparedStatement.setString(2, j.getTitle());
            preparedStatement.setInt(3, j.getMin_Salary());
            preparedStatement.setInt(4, j.getMax_Salary());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean update(Job j) {
        boolean result = false;
        String query = "UPDATE JOBS SET job_title=(?), min_salary=(?),max_salary=(?) WHERE job_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getTitle());
            preparedStatement.setInt(2, j.getMin_Salary());
            preparedStatement.setInt(3, j.getMax_Salary());
            preparedStatement.setString(4, j.getId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        String query = "DELETE FROM JOBS WHERE job_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    
    @Override
    public List<Job> search(String key) {
        List<Job> listJob = new ArrayList<Job>();
        String query ="SELECT * FROM JOBS WHERE job_id LIKE(?) OR job_title LIKE(?) OR min_salary LIKE(?) OR max_salary LIKE(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"%"+key+"%");
            preparedStatement.setString(2,"%"+key+"%");
            preparedStatement.setString(3,"%"+key+"%");
            preparedStatement.setString(4,"%"+key+"%");
            //menampung hasil eksekusi dari database
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j= new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));                
                listJob.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJob;
    }

    @Override
    public List<Job> getByID(String id) {
        List<Job> listJob = new ArrayList<Job>();
        String query ="SELECT * FROM JOBS WHERE job_id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            //menampung hasil eksekusi dari database
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j= new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                               
                listJob.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJob;
    }

}
