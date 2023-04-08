package ru.skypro;

import ru.skypro.dao.cityDAO.CityDAO;
import ru.skypro.dao.cityDAO.CityDAOImpl;
import ru.skypro.dao.employeeDAO.EmployeeDAO;
import ru.skypro.dao.employeeDAO.EmployeeDAOImpl;

import java.sql.SQLException;

public class Application {
    private static final CityDAO cityDAO = new CityDAOImpl();
    private static final EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    public static void main(String[] args) throws SQLException {
        employeeDAO.addNewEmployee("Kat", "Bad", "w", 66, 1);
        System.out.println(employeeDAO.findById(6));
        System.out.println(employeeDAO.getAllEmployees());
        employeeDAO.updateEmployee(3, "Hot", "Dog", "w", 27, 1);
        employeeDAO.deleteEmployeeById(4);
    }
}
