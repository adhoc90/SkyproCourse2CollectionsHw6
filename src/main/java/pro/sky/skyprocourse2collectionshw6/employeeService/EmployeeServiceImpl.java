package pro.sky.skyprocourse2collectionshw6.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.skyprocourse2collectionshw6.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprocourse2collectionshw6.exception.EmployeeNotFoundException;
import pro.sky.skyprocourse2collectionshw6.exception.EmployeeStorageIsFullException;
import pro.sky.skyprocourse2collectionshw6.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>(List.of());
    private final int MAX_COUNT_OF_PEOPLE = 5;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }

        if (employees.size() >= MAX_COUNT_OF_PEOPLE) {
            throw new EmployeeStorageIsFullException("Список сотрудников заполнен, нельзя добавить нового");
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника в списке нет");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public Collection<Employee> showEmployeeList() {
        return Collections.unmodifiableList(employees);
    }
}
