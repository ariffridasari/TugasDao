/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.List;
import models.Region;

/**
 *
 * @author Arif Fridasari
 */
public class RegionController implements IRegionController{

    private IRegionDAO irdao;

    public RegionController(Connection connection) {
        irdao = new RegionDAO(connection);
    }

    @Override
    public List<Region> getAll() {
        return irdao.getData("", false);
    }

    @Override
    public List<Region> getById(String id) {
        return irdao.getData(Integer.parseInt(id),true);
    }

    @Override
    public List<Region> search(String key) {
        return irdao.getData(key,false);
    }

    @Override
    public String insert(String id, String name) {
        String result = "";
        Region region = new Region(Integer.parseInt(id),name);
        if (irdao.save(region,true)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String name) {
        String result = "";
        Region region = new Region(Integer.parseInt(id), name);
        if (irdao.save(region,false)) {
            result = "Data berhasil diperbarui";   
        } else {
            result = "Maaf data gagal diperbarui";
        }
        return result;
    }

    @Override
    public String delete(String id) {
    String result = "";
        if (irdao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else{
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
}
