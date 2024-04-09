package pro.sky.homework211.service;

import pro.sky.homework211.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    String addEmployee(String firstName, String lastName, int salary, int departmentId);

    String findEmployee(String firstName, String lastName, int departmentId);

    String removeEmployee(String firstName, String lastName, int departmentId);

    Collection<Employee> findAll();

}