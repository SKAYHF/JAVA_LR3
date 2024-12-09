package tech.reliab.course.galushenkoLab.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private static int currentId = 1;
    private int id;
    private String name;
    private int officeCount;
    private int atmCount;
    private int employeeCount;
    private int userCount;
    private byte rating;
    private BigDecimal totalMoney;
    private BigDecimal interestRate;

    // Основной конструктор с инициализацией имени
    public Bank(String name) {
        this.id = currentId++;
        this.name = name;
        initializeDefaults();
    }

    // Метод инициализации значений по умолчанию
    private void initializeDefaults() {
        // Если нет имени, задаем значение "BankName Default"
        if (this.name == null) {
            this.name = "BankName Default";
        }
        // Если количество офисов не задано, устанавливаем 1
        this.officeCount = this.officeCount != 0 ? this.officeCount : 1;
        // Если количество банкоматов не задано, устанавливаем 2
        this.atmCount = this.atmCount != 0 ? this.atmCount : 2;
        // Генерация случайного рейтинга от 0 до 100, если не задан
        this.rating = this.rating != 0 ? this.rating : (byte) (Math.random() * 101);
        // Генерация случайного количества денег, если не задано
        this.totalMoney = this.totalMoney != null ? this.totalMoney : new BigDecimal(Math.random() * 1_000_000);
        // Генерация процентной ставки, если не задана
        this.interestRate = this.interestRate != null ? this.interestRate : new BigDecimal(Math.random() * 20);
    }
}
