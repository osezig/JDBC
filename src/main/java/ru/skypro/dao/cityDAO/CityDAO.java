package ru.skypro.dao.cityDAO;

import ru.skypro.models.City;

import java.sql.SQLException;

public interface CityDAO {
    City findById(Integer id) throws SQLException;
}
