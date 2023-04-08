package ru.skypro.dao.employeeDAO;

import ru.skypro.connection.ApplicationConnection;
import ru.skypro.dao.cityDAO.CityDAO;
import ru.skypro.dao.cityDAO.CityDAOImpl;
import ru.skypro.models.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final ApplicationConnection applicationConnection = new ApplicationConnection();
    private final CityDAO cityDAO = new CityDAOImpl();

    @Override
    public void addNewEmployee(String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException {
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement
                             ("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES (?,?,?,?,?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.executeUpdate();
        }
    }

    @Override
    public Employee findById(Integer id) throws SQLException {
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement("SELECT * FROM employee WHERE id=(?)")) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return new Employee(
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("gender"),
                    resultSet.getInt("age"),
                    cityDAO.findById(resultSet.getInt("city_id")));
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement("SELECT * FROM employee")) {
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        cityDAO.findById(resultSet.getInt("city_id"))));
            }
            return employees;
        }
    }

    @Override
    public void updateEmployee(Integer id, String firstName, String lastName, String gender, Integer age, Integer cityId) throws SQLException {
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement
                             ("UPDATE employee SET first_name = ?, last_name = ?, gender = ?, age = ?, city_id = ? WHERE id = (?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, cityId);
            statement.setInt(6, id);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteEmployeeById(Integer id) throws SQLException {
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement
                             ("DELETE FROM employee WHERE id =(?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
