package models;


public class Department {
    private int id;
    private String name;
    private int manager_id;
    private int location_id;
    
    public Department(){
    }
    
    public Department(int id, String name, int manager_id, int location_id){
        this.id = id;
        this.name = name;
        this.manager_id = manager_id;
        this.location_id = location_id;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getManager_id(){
        return manager_id;
    }
    
    public int getLocation_id(){
        return location_id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setManager_id(int manager_id){
        this.manager_id = manager_id;
    }
    
    public void setLocation_id(int location_id){
        this.location_id = location_id;
    }
}
