/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.DepartmentController;
import icontrollers.IDepartmentController;
import java.util.List;
import models.Department;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DBConnection;

/**
 *
 * @author ASUS
 */
public class JUnitTestDepartment {
    
        DBConnection connection = new DBConnection();
    IDepartmentController irc = new DepartmentController(connection.getConnection());

    public JUnitTestDepartment() {
    }

    @Test
    public void testGetById() {
        List<Department> act = irc.getById("1");
        Assert.assertNotNull(act);
    }

    public void testGetAll() {
        List<Department> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }
    
     @Test
    public void testSearch() {
        List<Department> act2 = irc.search("1");
        Assert.assertNotNull(act2);
    }

    public void testInsert() {
        irc.insert("111", "NamaSaya","110","1700");
        List<Department> m = irc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("NamaSaya", m.get(0).getId());
    }
    
    public void testUpdate() {
        irc.insert("111", "NamaSayaItu","110","1700");
        List<Department> m = irc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("NamaSayaIni", m.get(0).getName());
    }
    public void testDelete() {
        irc.delete("7");
        List<Department> m = irc.getById("111");
        assertNull(irc.getById("111"));
    }
}
