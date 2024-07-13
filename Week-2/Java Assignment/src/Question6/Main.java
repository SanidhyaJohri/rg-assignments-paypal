package Question6;

class Main{
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Create (Add Employee)
        crud.addEmployee(new Employee(1, "John Doe", "IT"));
        crud.addEmployee(new Employee(2, "Jane Smith", "HR"));

        // Read (Get Employee by ID)
        Employee employee = crud.getEmployeeById(1);
        System.out.println("Found Employee: " + employee);

        // Update (Update Employee)
        Employee updatedEmployee = new Employee(1, "John Doe Updated", "IT");
        crud.updateEmployee(updatedEmployee);
        System.out.println("Updated Employee: " + crud.getEmployeeById(1));

        // Delete (Delete Employee)
        crud.deleteEmployee(2);
        System.out.println("Remaining Employees after deletion:");
        for (Employee emp : crud.employees) {
            System.out.println(emp);
        }
    }
}
