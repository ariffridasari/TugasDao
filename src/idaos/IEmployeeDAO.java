/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Employee;

/**
 *
 * @author Sekar Ayu Safitri
 */
public interface IEmployeeDAO {

    public List<Employee> getData(Object key, boolean isGetById);

    public boolean save(Employee employee, boolean isInsert);

    public boolean delete(int id);
}
