package ru.skypro.dao.employeeDAO;

import ru.skypro.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee findById(Integer id) throws SQLException;

    Integer addNewEmployee(Employee employee);
    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee, int id);
    void deleteEmployee(Employee employee);
}
