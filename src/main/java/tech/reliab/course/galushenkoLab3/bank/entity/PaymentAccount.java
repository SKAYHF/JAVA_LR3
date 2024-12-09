package tech.reliab.course.galushenkoLab.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccount {
    private static int currentId = 1;
    private int id;
    private User user;
    private Bank bank;
    private double balance = 0;

    public PaymentAccount(User user, Bank bank, double initialBalance) {
        this.id = currentId++;
        this.user = user;
        this.bank = bank;
        this.balance = initialBalance;
    }
}
