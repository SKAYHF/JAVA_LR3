package tech.reliab.course.galushenkoLab.bank.service.impl;

import tech.reliab.course.galushenkoLab.bank.entity.Bank;
import tech.reliab.course.galushenkoLab.bank.entity.BankOffice;
import tech.reliab.course.galushenkoLab.bank.entity.Employee;
import tech.reliab.course.galushenkoLab.bank.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    // Первый метод для создания сотрудника без указания банка и офиса
    @Override
    public Employee createEmployee(String firstName, String lastName, String position) {
        Employee employee = new Employee(firstName, lastName, position, null, null);
        employees.add(employee);
        return employee;
    }

    // Второй метод для создания сотрудника с указанием банка и офиса
    @Override
    public Employee createEmployee(String firstName, String lastName, String position, Bank bank, BankOffice office) {
        Employee employee = new Employee(firstName, lastName, position, bank, office);
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employees.stream().filter(e -> e.getId() == employee.getId()).findFirst();
        existingEmployee.ifPresent(e -> {
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setPosition(employee.getPosition());
            e.setBank(employee.getBank());  // Обновляем банк
            e.setOffice(employee.getOffice());  // Обновляем офис
        });
    }

    @Override
    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
