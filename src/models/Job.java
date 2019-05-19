/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
/**
 *
 * @author erik
 */
    public class Job {
        private String id;
        private String title;
        private int min_salary;
        private int max_salary;
        
        public Job () {
        }

    public Job(String id, String title, int min_salary, int max_salary) {
        this.id = id;
        this.title = title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }
        
        
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getMin_Salary(){
        return min_salary;
    }
    
    public int getMax_Salary(){
        return max_salary;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setMin_Salary(int min_salary) {
        this.min_salary = min_salary;
    }
    public void setMax_Salary(int max_salary) {
        this.max_salary = max_salary;
    }
   
    }



