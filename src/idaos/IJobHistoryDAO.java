/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.JobHistory;

/**
 *
 * @author WINDOWS 10
 */
public interface IJobHistoryDAO {
    
    public List<JobHistory> getAll();
    
    public List<JobHistory> getById(int id);
    
    public List<JobHistory> search(String key);
    
    public boolean insert(JobHistory r);
    
    public boolean update(JobHistory r);
    
    public boolean delete(int id);

    
}
