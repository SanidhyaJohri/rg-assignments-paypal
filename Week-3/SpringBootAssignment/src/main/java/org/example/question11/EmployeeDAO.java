package org.example.question11;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee read(int id);
    void update(Employee employee);
    void delete(int id);
    List<Employee> findAll();
}
