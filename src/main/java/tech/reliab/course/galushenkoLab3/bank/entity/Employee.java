package tech.reliab.course.galushenkoLab.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private static int currentId = 1;
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String position;
    private Bank bank;
    private BankOffice office;
    private double salary;

    // Добавил нужный конструктор для EmployeeServiceImpl
    public Employee(String firstName, String lastName, String position, Bank bank, BankOffice office) {
        this.id = currentId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.bank = bank;
        this.office = office;
        this.salary = 50_000;  // Устанавливаем зарплату по умолчанию
    }
}
