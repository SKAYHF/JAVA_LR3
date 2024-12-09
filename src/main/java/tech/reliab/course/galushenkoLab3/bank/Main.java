package tech.reliab.course.galushenkoLab.bank;

import tech.reliab.course.galushenkoLab.bank.exceptions.CreditExceptions;
import tech.reliab.course.galushenkoLab.bank.entity.*;
import tech.reliab.course.galushenkoLab.bank.service.impl.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Инициализация сервисов
            BankServiceImpl bankService = new BankServiceImpl();
            BankOfficeServiceImpl officeService = new BankOfficeServiceImpl();
            BankAtmServiceImpl atmService = new BankAtmServiceImpl();
            PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
            CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();

            // Создание банка, офиса, банкомата, сотрудников и пользователя
            Bank bank = bankService.createBank("AlphaBank", "Moscow");
            BankOffice office = officeService.createOffice("Alpha Office", "Moscow");
            office.setMoneyAmount(100_000); // Установим сумму денег в офисе

            // Создаем банкомат с привязкой к банку
            BankAtm atm = atmService.createAtm("ATM-1", "Moscow", bank);
            atm.setOffice(office); // Привязываем банкомат к офису

            // Создаем сотрудника и привязываем его к офису
            Employee employee = new Employee("Ivan", "Petrov", "Credit Officer", bank, office);
            office.addEmployee(employee);

            // Создаем пользователя
            User user = new User("John", "Doe", 7000);
            user.setCreditRating(6000);

            // Попытка получить кредит
            CreditAccount creditAccount = creditAccountService.processCreditRequest(
                    user, 10_000, 12, bankService, officeService, atmService, paymentAccountService
            );

            System.out.println("Кредит успешно выдан: " + creditAccount);

        } catch (CreditExceptions.CreditException e) {
            System.err.println("Ошибка при выдаче кредита: " + e.getMessage());
        }
    }
}
