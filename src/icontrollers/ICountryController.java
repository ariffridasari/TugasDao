/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Country;

/**
 *
 * @author Arif Fridasari
 */
public interface ICountryController {
    public List<Country> getAll();
    public List<Country> getById(String c_id);
    public List<Country> search(String key);
    public String insert (String c_id, String name, String r_id);
    public String update (String c_id, String name, String r_id);
    public String delete(String c_id);
}
