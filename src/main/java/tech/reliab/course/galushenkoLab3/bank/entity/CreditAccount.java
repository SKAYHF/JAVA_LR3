package tech.reliab.course.galushenkoLab.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccount {
    private static int currentId = 1;
    private int id;
    private User user;
    private Bank bank;
    private double loanAmount;
    private double interestRate;
    private int loanTerm; // в месяцах

    public CreditAccount(User user, Bank bank, double loanAmount, int loanTerm) {
        this.id = currentId++;
        this.user = user;
        this.bank = bank;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;

        // Проверка на null для объекта bank
        if (bank != null) {
            this.interestRate = bank.getInterestRate().doubleValue(); // Используем ставку банка
        } else {
            this.interestRate = 0.0; // Если bank == null, устанавливаем ставку в 0
        }
    }
}
