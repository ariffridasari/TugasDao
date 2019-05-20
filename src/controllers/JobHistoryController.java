/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobHistoryDAO;
import java.sql.Connection;
import java.util.List;
import models.JobHistory;
import icontrollers.IJobHistoryController;
import idaos.IJobHistoryDAO;
import java.util.Date;

/**
 *
 * @author WINDOWS 10
 */
public class JobHistoryController implements IJobHistoryController {

    private IJobHistoryDAO irdao;

    public JobHistoryController(Connection connection) {
        irdao = new JobHistoryDAO(connection);
    }

    @Override
    public List<JobHistory> getAll() {
        return irdao.getAll();
    }

    @Override
    public List<JobHistory> getById(int id) {
        return irdao.getById(id);
    }

    @Override
    public List<JobHistory> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(int employee_id, String start_date, String end_date, String job_id, int department_id) {
        String result = "";
        JobHistory jobhistory = new JobHistory(employee_id, start_date, end_date, job_id, department_id);
        if (irdao.insert(jobhistory)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(int employee_id, String start_date, String end_date, String job_id, int department_id) {
        String result = "";
        JobHistory jobhistory = new JobHistory(employee_id, start_date, end_date, job_id, department_id);
        if (irdao.update(jobhistory)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }


@Override
    public String delete(int employee_id) {
    String result = "";
    if (irdao.delete(employee_id)) {
   result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
}

}
    
    

