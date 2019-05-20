/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;
/**
 *
 * @author ASUS
 */
public interface IRegionController {
    /**
     * getAll method untuk mengambil semua data pada tabel Regions
     */
    public List<Region> getAll();
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Regions
     */
    public List<Region> getById(String id);
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Regions
     */
    public List<Region> search(String key);
    
    /**
     * insert method untuk memasukan data ke dalam tabel Regions
     */
    public String insert(String id, String name);
    
    /**
     * insert method untuk mengganti nilai dalam tabel Regions
     */
    public String update(String id, String name);
    
    /**
     * insert method untuk menghapus satu baris data sesuai data masukan dalam tabel Regions
     */
    public String delete(String id);
    
}
