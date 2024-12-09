package tech.reliab.course.galushenkoLab.bank.service;

import tech.reliab.course.galushenkoLab.bank.entity.Bank;
import tech.reliab.course.galushenkoLab.bank.entity.BankOffice;
import tech.reliab.course.galushenkoLab.bank.entity.Employee;

import java.util.List;

public interface EmployeeService {

    // Существующий метод для создания сотрудника с минимальным количеством параметров
    Employee createEmployee(String firstName, String lastName, String position);

    // Новый метод для создания сотрудника с банком и офисом
    Employee createEmployee(String firstName, String lastName, String position, Bank bank, BankOffice office);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

    List<Employee> getAllEmployees();
}
