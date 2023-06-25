package pro.sky.skyprocourse2collectionshw6.employeeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocourse2collectionshw6.employeeService.EmployeeService;
import pro.sky.skyprocourse2collectionshw6.model.Employee;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee createEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/list")
    public Collection<Employee> showEmployeeList() {
        return employeeService.showEmployeeList();
    }
}