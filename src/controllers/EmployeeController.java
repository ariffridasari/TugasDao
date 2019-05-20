/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import java.util.List;
import models.Employee;

/**
 *
 * @author Sekar Ayu Safitri
 */
public class EmployeeController implements IEmployeeController {

    private IEmployeeDAO irdao;

    public EmployeeController(IEmployeeDAO irdao) {
        this.irdao = irdao;
    }

    @Override
    public List<Employee> getAll() {
        return irdao.getData("", false);
    }

    @Override
    public List<Employee> getById(String id) {
        return irdao.getData(Integer.parseInt(id), true);
    }

    @Override
    public List<Employee> search(String key) {
        return irdao.getData(key, false);
    }

    @Override
    public String insert(String id, String firstName, String lastName, String email, String phone, String hire, String jobId, String salary, String commission, String managerId, String departmentId) {
        String result = "";
        Employee employee = new Employee(Integer.parseInt(id), firstName, lastName, email, phone, hire, jobId, Integer.parseInt(salary), Float.parseFloat(commission), Integer.parseInt(managerId), Integer.parseInt(departmentId));
        if (irdao.save(employee, false)) {
            result = "Data Berhasil diupdate";
        } else {
            result = "Data Gagal diupdate";
        }
        return result;
    }

    @Override
    public String update(String id, String firstName, String lastName, String email, String phone, String hire, String jobId, String salary, String commission, String managerId, String departmentId) {
        String result = "";
        Employee employee = new Employee(Integer.parseInt(id), firstName, lastName, email, phone, hire, jobId, Integer.parseInt(salary), Float.parseFloat(commission), Integer.parseInt(managerId), Integer.parseInt(departmentId));
        if (irdao.save(employee, true)) {
            result = "Data Berhasil disimpan";
        } else {
            result = "Data Gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (irdao.delete(Integer.parseInt(id))) {
            result = "Data Berhasil dihapus";
        } else {
            result = "Data Gagal dihapus";
        }
        return result;
    }

}
