/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IJobsController;
import daos.JobDAO;
import java.sql.Connection;
import java.util.List;
import models.Job;
import tools.DBConnection;
import tools.OJDBC;
import idaos.IJobDAO;


/**
 *
 * @author erik
 */
public class JobsController implements IJobsController {
    
    private IJobDAO ijdao;
    
    public JobsController(Connection connection) {
        ijdao = new JobDAO(connection);
    }

    @Override
    public List<Job> getAll() {
        return ijdao.getAll();
    }

    @Override
    public List<Job> getById(String id) {
        return ijdao.getByID(id);
    }

    @Override
    public List<Job> search(String key) {
        return ijdao.search(key);
    }

    @Override
    public String insert(String id, String Title, String Min_Salary, String Max_Salary) {
        String result = " ";
        Job jobs = new Job(id, Title, Integer.parseInt(Min_Salary), Integer.parseInt(Max_Salary));
        if (ijdao.insert(jobs)) {
            result = "Data Berhasil Disimpan";
        }
        else {
            result = "maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String Title, String Min_Salary, String Max_Salary) {
        String result = " ";
        Job jobs = new Job(id, Title, Integer.parseInt(Min_Salary), Integer.parseInt(Max_Salary));
        if (ijdao.update(jobs)) {
            result = "Data Berhasil Diupdate";
        }
        else {
            result = "maaf data gagal Diupdate";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = " ";
        if (ijdao.delete(id)) {
            result = "Data Berhasil Dihapus";
        }
        else {
            result = "maaf data gagal Dihapus";
        }
        return result;
    }
    
}
