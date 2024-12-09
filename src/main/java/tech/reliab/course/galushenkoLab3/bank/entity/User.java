package tech.reliab.course.galushenkoLab.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static int currentId = 1;
    private int id;
    private String firstName;
    private String lastName;
    private double monthlyIncome;

    @Getter
    @Setter
    private int creditRating;

    private List<Bank> banks = new ArrayList<>();
    private List<CreditAccount> creditAccounts = new ArrayList<>();
    private List<PaymentAccount> paymentAccounts = new ArrayList<>();

    public User(String firstName, String lastName, double monthlyIncome) {
        this.id = currentId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlyIncome = monthlyIncome;

        // Инициализируем кредитный рейтинг (например, случайным числом)
        this.creditRating = (int) (Math.random() * 10_000); // Пример: рейтинг от 0 до 10,000
    }
}
