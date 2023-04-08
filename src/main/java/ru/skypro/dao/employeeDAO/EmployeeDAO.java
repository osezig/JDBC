package ru.skypro.dao.employeeDAO;

import ru.skypro.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee findById(Integer id) throws SQLException;

    void addNewEmployee(String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException;

    List<Employee> getAllEmployees()throws SQLException;

    void updateEmployee(Integer id, String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException;

    void deleteEmployeeById(Integer id) throws SQLException;
}
