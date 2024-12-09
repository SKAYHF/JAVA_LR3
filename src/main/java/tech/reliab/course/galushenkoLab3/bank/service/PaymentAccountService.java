package tech.reliab.course.galushenkoLab.bank.service;

import tech.reliab.course.galushenkoLab.bank.entity.PaymentAccount;
import tech.reliab.course.galushenkoLab.bank.entity.Bank;
import tech.reliab.course.galushenkoLab.bank.entity.User;

import java.util.List;

public interface PaymentAccountService {
    // Обновляем сигнатуру метода
    PaymentAccount createPaymentAccount(User user, Bank bank, double initialBalance);

    PaymentAccount getPaymentAccountById(int id);

    void updatePaymentAccount(PaymentAccount account);

    void deletePaymentAccount(int id);

    List<PaymentAccount> getAllPaymentAccounts();
}
