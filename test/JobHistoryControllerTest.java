/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import models.JobHistory;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DBConnection;
import icontrollers.IJobHistoryController;

/**
 *
 * @author WINDOWS 10
 */
public class JobHistoryControllerTest {
    
    DBConnection connection = new DBConnection();
    IJobHistoryController irc = new JobHistoryController(connection.getConnection());
    
    public JobHistoryControllerTest() {
    }

    /**
     * Test of getAll method, of class JobHistoryController.
     */
    @Test
    public void testGetAll() {
        List<JobHistory> joball = irc.getAll();
        assertNotNull(joball);
    }

    /**
     * Test of getById method, of class JobHistoryController.
     */
    @Test
    public void testGetById() {
        List<JobHistory> jobh = irc.getById(110);
        assertNotNull(jobh);
    }

    /**
     * Test of search method, of class JobHistoryController.
     */
    @Test
    public void testSearch() {
        List<JobHistory> jobhs = irc.search("50");
        assertNotNull(jobhs);
    }

    /**
     * Test of insert method, of class JobHistoryController.
     */
    @Test
    public void testInsert() {
        irc.insert(133, "10-10-1999", "11-12-1998", "IT_PROG", 110);
        List<JobHistory> m = irc.getById(111);
        Assert.assertEquals(111, m.get(0).getEmployee_id());
        Assert.assertEquals("11-12-1998", m.get(0).getStart_date());
        Assert.assertEquals("11-12-1998", m.get(0).getEnd_date());
        Assert.assertEquals("IT_PROG", m.get(0).getJob_id());
        Assert.assertEquals("110", m.get(0).getDepartment_id());
    }

    /**
     * Test of update method, of class JobHistoryController.
     */
    @Test
    public void testUpdate() {
        irc.update(111, "11-03-2001","09-09-2002", "IT_PROG", 110);
        List<JobHistory> m = irc.getById(111);
        Assert.assertEquals(111, m.get(0).getEmployee_id());
        Assert.assertEquals("11-03-2001", m.get(0).getStart_date());
        Assert.assertEquals("09-09-2002", m.get(0).getEnd_date());
        Assert.assertEquals("IT_PROG", m.get(0).getJob_id());
        Assert.assertEquals(110, m.get(0).getDepartment_id());
    }

    /**
     * Test of delete method, of class JobHistoryController.
     */
    @Test
    public void testDelete() {
        irc.delete(113);
        assertNotNull(irc);
    }
    
}
