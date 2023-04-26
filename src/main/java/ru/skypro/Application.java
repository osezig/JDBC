package ru.skypro;

import ru.skypro.dao.cityDAO.CityDAO;
import ru.skypro.dao.cityDAO.CityDAOImpl;
import ru.skypro.dao.employeeDAO.EmployeeDAO;
import ru.skypro.dao.employeeDAO.EmployeeDAOImpl;
import ru.skypro.models.Employee;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        Employee employee = new Employee("Ky", "Ky", "w", 2, 1 );
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.getAllEmployees().forEach(System.out::println);
        Integer employeeId = employeeDAO.addNewEmployee(employee);
        System.out.println(employeeDAO.getAllEmployees());
        System.out.println(employeeDAO.findById(6));
        employeeDAO.updateEmployee(employee, employeeId);
        employeeDAO.deleteEmployee(employeeDAO.findById(employeeId));
    }
}
