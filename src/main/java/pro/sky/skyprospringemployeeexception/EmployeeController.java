package pro.sky.skyprospringemployeeexception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.addEmployee(firstName,lastName);
        return "Сотрудник " + firstName + " " + lastName + " добавлен.";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.removeEmployee(firstName,lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален.";
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }
}