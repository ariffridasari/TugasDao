/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.JobHistory;
/**
 *
 * @author WINDOWS 10
 */
public interface IJobHistoryController {
    
    public List<JobHistory> getAll();
    
    public List<JobHistory> getById(int id);
    
    public List<JobHistory> search (String key);
    
    public String insert (int employee_id, String start_date, String end_date, String job_id, int department_id);
    
    public String update (int employee_id, String start_date, String end_date, String job_id, int department_id);
    
    public String delete (int id);
    
}
