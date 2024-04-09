package pro.sky.homework211.service;

import pro.sky.homework211.model.Employee;

import java.util.Collection;

public interface DepartmentService {

    Collection<Employee> findAllEmployeesFromAllDepartments();

    Collection<Employee> findAllEmployeesFromDepartment(int departmentId);

    Employee findEmployeeWithMinSalary(int departmentId);

    Employee findEmployeeWithMaxSalary(int departmentId);

}