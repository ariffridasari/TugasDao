/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employee;

/**
 *
 * @author Sekar Ayu Safitri
 */
public interface IEmployeeController {

    public List<Employee> getAll();

    public List<Employee> getById(String id);

    public List<Employee> search(String key);

    public String insert(String id, String firstName, String lastName, String email, String phone, String hire, String jobId, String salary, String commission, String managerId, String departmentId);

    public String update(String id, String firstName, String lastName, String email, String phone, String hire, String jobId, String salary, String commission, String managerId, String departmentId);

    public String delete(String id);
}
