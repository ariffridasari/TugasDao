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
import models.JobHistory;
import idaos.IJobHistoryDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author WINDOWS 10
 */
public class JobHistoryDAO implements IJobHistoryDAO {

    private Connection connection;

    public JobHistoryDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<JobHistory> getAll() {
        List<JobHistory> listJobHistory = new ArrayList<JobHistory>();
        String query = "SELECT * FROM JOB_HISTORY";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                JobHistory r = new JobHistory();
                r.setEmployee_id(resultSet.getInt(1));
                r.setStart_date(resultSet.getString(2));
                r.setEnd_date(resultSet.getString(3));
                r.setJob_id(resultSet.getString(4));
                r.setDepartment_id(resultSet.getInt(5));
                listJobHistory.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listJobHistory;
    }

    @Override
    public List<JobHistory> getById(int id) {
        List<JobHistory> listJobhistory = new ArrayList<JobHistory>();
        String query = "SELECT * FROM JOB_HISTORY WHERE EMPLOYEE_ID like (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+id+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                JobHistory r = new JobHistory();
                r.setEmployee_id(resultSet.getInt(1));
                r.setStart_date(resultSet.getString(2));
                r.setEnd_date(resultSet.getString(3));
                r.setJob_id(resultSet.getString(4));
                r.setDepartment_id(resultSet.getInt(5));
                listJobhistory.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJobhistory;

    }

    @Override
    public List<JobHistory> search(String key) {
        List<JobHistory> listJobhistory = new ArrayList<JobHistory>();
        String query = "SELECT * FROM JOB_HISTORY WHERE department_id like (?) OR job_id like (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+key+"%");
            preparedStatement.setString(2, "%"+key+"%");            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                JobHistory r = new JobHistory();
                r.setEmployee_id(resultSet.getInt(1));
                r.setStart_date(resultSet.getString(2));
                r.setEnd_date(resultSet.getString(3));
                r.setJob_id(resultSet.getString(4));
                r.setDepartment_id(resultSet.getInt(5));
                listJobhistory.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJobhistory;
    }

    @Override
    public boolean insert(JobHistory r) {
        boolean result = false;
        String query = "INSERT INTO JOB_HISTORY VALUES(?,?,?,?,?)";
        try {
//            java.util.Date start_date = new java.util.Date();
//            java.sql.Date sqlDate = convert(start_date);
//            java.util.Date EndDate = new java.util.Date();
//            java.sql.Date sqlDates = convert(EndDate);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getEmployee_id());
            preparedStatement.setString(2, r.getStart_date());
            preparedStatement.setString(3, r.getEnd_date());
            preparedStatement.setString(4, r.getJob_id());
            preparedStatement.setInt(5, r.getDepartment_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
//(employee_id, start_date, end_date, job_id, department_id)

    @Override
    public boolean update(JobHistory r) {
       boolean result = false;
        String query = "UPDATE JOB_HISTORY SET START_DATE=?, END_DATE=?, JOB_ID=?, DEPARTMENT_ID=? WHERE EMPLOYEE_ID=?";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getStart_date());
            preparedStatement.setString(2, r.getEnd_date());
            preparedStatement.setString(3, r.getJob_id());
            preparedStatement.setInt(4, r.getDepartment_id());
            preparedStatement.setInt(5, r.getEmployee_id());

            preparedStatement.executeUpdate();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        PreparedStatement st = null;
        String query = "DELETE FROM JOB_HISTORY WHERE EMPLOYEE_ID=?";
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

//    private static java.sql.Date convert(java.util.Date uDate) {
//        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
//        return sDate;
//
//    }

}
