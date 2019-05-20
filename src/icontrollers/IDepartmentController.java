package icontrollers;

import java.util.List;
import models.Department;

/**
 *
 * @author ASUS
 */
public interface IDepartmentController {
    /**
     * getAll method untuk mengambil semua data pada tabel Departments
     */
    public List<Department> getAll();
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Departments
     */
    public List<Department> getById(String id);
    
    /**
     * getByID method untuk mendapatkan dan menyeleksi data pada tabel Departments
     */
    public List<Department> search(String key);
    
    /**
     * insert method untuk memasukan data ke dalam tabel Departments
     */
    public String insert(String id, String name, String manager_id, String location_id);
    
    /**
     * insert method untuk mengganti nilai dalam tabel Departments
     */
    public String update(String id, String name, String manager_id, String location_id);
    
    /**
     * insert method untuk menghapus satu baris data sesuai data masukan dalam tabel Departments
     */
    public String delete(String id);
}
