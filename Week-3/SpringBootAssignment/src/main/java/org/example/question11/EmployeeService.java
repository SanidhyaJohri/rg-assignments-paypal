package org.example.question11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAOImpl employeeDAO;

    public void createEmployee(Employee employee) {
        employeeDAO.create(employee);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.read(id);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
}
