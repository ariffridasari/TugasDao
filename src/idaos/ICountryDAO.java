/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Country;

/**
 *
 * @author Arif Fridasari
 */
public interface ICountryDAO {
    public List<Country> getAll();
    public List<Country> getById(String c_id);
    public List<Country> search(String key);
    public boolean insert(Country c);
    public boolean update(Country c);
    public boolean delete(String c_id);
    
}
