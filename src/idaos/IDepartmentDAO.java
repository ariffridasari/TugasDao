package idaos;

import java.util.List;
import models.Department;

/**
 *
 * @author ASUS
 */
public interface IDepartmentDAO {
     /**
     * getAll method untuk mengambil semua data pada tabel Departments
     */
    public List<Department> getAll();
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Departments
     */
    public List<Department> getById(int id);
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Departments
     */
    public List<Department> search(String key);
    
    /**
     * insert method untuk memasukan data ke dalam tabel Departments
     */
    public boolean insert(Department r);
    
    /**
     * insert method untuk mengganti nilai dalam tabel Departments
     */
    public boolean update(Department r);
    
    /**
     * insert method untuk menghapus satu baris data sesuai data masukan dalam tabel Departments
     */
    public boolean delete(int id);
}
