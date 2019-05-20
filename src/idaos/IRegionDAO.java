package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author ASUS
 */
public interface IRegionDAO {
    /**
     * getAll method untuk mengambil semua data pada tabel Regions
     */
    public List<Region> getAll();
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Regions
     */
    public List<Region> getById(int id);
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Regions
     */
    public List<Region> search(String key);
    
    /**
     * insert method untuk memasukan data ke dalam tabel Regions
     */
    public boolean insert(Region r);
    
    /**
     * insert method untuk mengganti nilai dalam tabel Regions
     */
    public boolean update(Region r);
    
    /**
     * insert method untuk menghapus satu baris data sesuai data masukan dalam tabel Regions
     */
    public boolean delete(int id);
    
}
