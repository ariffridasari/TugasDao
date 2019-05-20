package controllers;

import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.sql.Connection;
import java.util.List;
import models.Location;

public class LocationController implements ILocationController {

    private ILocationDAO ildao;

    public LocationController(Connection connection) {
        ildao = new LocationDAO(connection);
    }

    @Override
    public List<Location> getAll() {
        return ildao.getData("", false);
    }

    @Override
    public List<Location> getById(String id) {
        return ildao.getData(Integer.parseInt(id),true);
    }

    @Override
    public List<Location> search(String key) {
        return ildao.getData(key, false);
    }

    @Override
    public String insert(String id, String street_address, String postal_code, String city, String state_province, String country_id) {
        String result = "";
        Location location = new Location(Integer.parseInt(id), street_address, postal_code, city, state_province, country_id);
        if (ildao.save(location,true)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String street_address, String postal_code, String city, String state_province, String country_id) {
        String result = "";
        Location location = new Location(Integer.parseInt(id), street_address, postal_code, city, state_province, country_id);
        if (ildao.save(location,false)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (ildao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
}
