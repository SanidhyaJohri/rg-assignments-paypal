package Question6;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {
    public List<Employee> employees;

    public EmployeeCRUD(){
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public Employee getEmployeeById(int id){
        for(Employee employee: this.employees){
            if(employee.getId() == id){
              return employee;
            }
        }
        return null;
    }

    public void updateEmployee(Employee updatedEmployee){
        boolean found = false;
        for(Employee employee: this.employees){
            if (employee.getId() == updatedEmployee.getId()){
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                found = true;
            }
        }
        if (!found) {
            this.addEmployee(updatedEmployee);
        }
    }

    public void deleteEmployee(int id){
        this.employees.removeIf(employee -> employee.getId() == id);
    }
}
