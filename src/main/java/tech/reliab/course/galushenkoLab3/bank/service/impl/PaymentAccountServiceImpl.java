package tech.reliab.course.galushenkoLab.bank.service.impl;

import tech.reliab.course.galushenkoLab.bank.entity.PaymentAccount;
import tech.reliab.course.galushenkoLab.bank.entity.Bank;
import tech.reliab.course.galushenkoLab.bank.entity.User;
import tech.reliab.course.galushenkoLab.bank.service.PaymentAccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private final List<PaymentAccount> accounts = new ArrayList<>();

    // Теперь метод принимает пользователя, банк и начальный баланс
    @Override
    public PaymentAccount createPaymentAccount(User user, Bank bank, double initialBalance) {
        PaymentAccount account = new PaymentAccount(user, bank, initialBalance);
        accounts.add(account);  // Привязка аккаунта к пользователю
        return account;
    }

    @Override
    public PaymentAccount getPaymentAccountById(int id) {
        return accounts.stream().filter(account -> account.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updatePaymentAccount(PaymentAccount account) {
        Optional<PaymentAccount> existingAccount = accounts.stream().filter(a -> a.getId() == account.getId()).findFirst();
        existingAccount.ifPresent(a -> a.setBalance(account.getBalance()));
    }

    @Override
    public void deletePaymentAccount(int id) {
        accounts.removeIf(account -> account.getId() == id);
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccounts() {
        return new ArrayList<>(accounts);
    }
}
