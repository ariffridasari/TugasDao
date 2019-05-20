/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Arif Fridasari
 */
public class Country {
    private String c_id;
    private String name;
    private int r_id;


    public Country() {
    }

    public Country(String c_id, String name, int r_id) {
        this.c_id = c_id;
        this.name = name;
        this.r_id = r_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
