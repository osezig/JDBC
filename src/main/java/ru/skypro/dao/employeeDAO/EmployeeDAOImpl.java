package ru.skypro.dao.employeeDAO;
import ru.skypro.models.Employee;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.skypro.connection.HibernateSessionFactoryUtil;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Integer addNewEmployee(Employee employee) {
        Integer id;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(employee);
            transaction.commit();
        }
        return id;
    }

    @Override
    public Employee findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
        return session.createQuery("FROM Employee").list();
        }
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
        Transaction transaction = session.beginTransaction();
        employee.setId(id);
        session.update(employee);
        transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        }
    }
}
