package pro.sky.homework211.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework211.model.Employee;
import pro.sky.homework211.service.DepartmentService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/all")
    public Collection<Employee> findAllEmployeeAllDept() {
        return departmentService.findAllEmployeesFromAllDepartments();
    }

    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> findEmployeeDept(@RequestParam("departmentId") int deptId) {
        return departmentService.findAllEmployeesFromDepartment(deptId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmpDeptMinSalary(@RequestParam("departmentId") int deptId) {
        return departmentService.findEmployeeWithMinSalary(deptId);
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmpDeptMaxSalary(@RequestParam("departmentId") int deptId) {
        return departmentService.findEmployeeWithMaxSalary(deptId);
    }

}