package pro.sky.homework211.service;

import org.springframework.stereotype.Service;
import pro.sky.homework211.exception.EmployeeAlreadyAddedException;
import pro.sky.homework211.exception.EmployeeNotFoundException;
import pro.sky.homework211.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //                                                      Домашнее задание 2-11. Библиотеки
    Map<String, Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>();
    }

    public String addEmployee(String firstName, String lastName, int salary, int departmentId) {

        String fName = EmployeeInput.checkName(firstName);
        String lName = EmployeeInput.checkName(lastName);

        Employee e = new Employee(fName, lName, salary, departmentId);

        if (employeeBook.containsKey(e.getFullNameAndDepartmentId())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeeBook.put(e.getFullNameAndDepartmentId(), e);
            return "Сотрудник " + fName + " " + lName + " добавлен, отдел номер " + departmentId;
        }
    }

    public String removeEmployee(String firstName, String lastName, int departmentId) {

        String fName = EmployeeInput.checkName(firstName);
        String lName = EmployeeInput.checkName(lastName);

        String fE = fName + lName + departmentId;

        final Optional<Employee> employeeDetected = employeeBook.values().stream()
                .filter(e -> e.getFullNameAndDepartmentId().equals(fE))
                .findAny();

        if (employeeDetected.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            employeeBook.remove(employeeDetected.get().getFullNameAndDepartmentId(), employeeDetected.get());
            return "Сотрудник " + fName + " " + lName + " удален, отдел номер " + departmentId;
        }

    }

    public String findEmployee(String firstName, String lastName, int departmentId) {

        String fName = EmployeeInput.checkName(firstName);
        String lName = EmployeeInput.checkName(lastName);

        String fE = fName + lName + departmentId;

        final Optional<String> employeeDetected = employeeBook.values().stream()
                .filter(e -> e.getFullNameAndDepartmentId().equals(fE))
                .map(s -> "Найден: " + s)
                .findFirst();

        return employeeDetected.orElseThrow(() -> new EmployeeNotFoundException());

    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }

}