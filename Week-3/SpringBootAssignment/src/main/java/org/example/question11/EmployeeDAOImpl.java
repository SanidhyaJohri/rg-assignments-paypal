package org.example.question11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getDepartment());
    }

    @Override
    public Employee read(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }
}
