package pro.sky.skyprocourse2collectionshw6.employeeService;

import pro.sky.skyprocourse2collectionshw6.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> showEmployeeList();
}

