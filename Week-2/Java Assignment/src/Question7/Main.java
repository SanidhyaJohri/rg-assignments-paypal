package Question7;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // Add Employee
        Employee newEmployee = new Employee(1, "John Doe", "IT");
        employeeJDBC.addEmployee(newEmployee);
        newEmployee = new Employee(2, "John Poe", "HR");
        employeeJDBC.addEmployee(newEmployee);


        // Get Employee by ID
        Employee retrievedEmployee = employeeJDBC.getEmployeeById(1);
        System.out.println("Retrieved Employee: " + retrievedEmployee);

        // Update Employee
        retrievedEmployee.setName("John Doe Updated");
        employeeJDBC.updateEmployee(retrievedEmployee);

        // Delete Employee
        employeeJDBC.deleteEmployee(1);

        // Get All Employees
        List<Employee> allEmployees = employeeJDBC.getAllEmployees();
        System.out.println("All Employees:");
        for (Employee emp : allEmployees) {
            System.out.println(emp);
        }
    }
}
