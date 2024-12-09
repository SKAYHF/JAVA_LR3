package tech.reliab.course.galushenkoLab.bank.service.impl;

import tech.reliab.course.galushenkoLab.bank.entity.*;
import tech.reliab.course.galushenkoLab.bank.exceptions.CreditExceptions;
import tech.reliab.course.galushenkoLab.bank.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreditAccountServiceImpl implements CreditAccountService {

    private final List<CreditAccount> accounts = new ArrayList<>();

    @Override
    public CreditAccount createCreditAccount(User user, Bank bank, double loanAmount, int loanTerm) {
        CreditAccount account = new CreditAccount(user, bank, loanAmount, loanTerm);
        accounts.add(account);
        return account;
    }

    @Override
    public CreditAccount getCreditAccountById(int id) {
        return accounts.stream().filter(account -> account.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateCreditAccount(CreditAccount account) {
        Optional<CreditAccount> existingAccount = accounts.stream()
                .filter(a -> a.getId() == account.getId())
                .findFirst();
        existingAccount.ifPresent(a -> {
            a.setLoanAmount(account.getLoanAmount());
            a.setLoanTerm(account.getLoanTerm());
        });
    }

    @Override
    public void deleteCreditAccount(int id) {
        accounts.removeIf(account -> account.getId() == id);
    }

    @Override
    public List<CreditAccount> getAllCreditAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public CreditAccount processCreditRequest(User user, double requestedAmount, int loanTerm,
                                              BankService bankService, BankOfficeService officeService,
                                              BankAtmService atmService, PaymentAccountService paymentAccountService)
            throws CreditExceptions.CreditException {
        // 1. Выбор банка
        Bank bestBank = bankService.getAllBanks().stream()
                .sorted((b1, b2) -> {
                    int cmp = Integer.compare(b2.getAtmCount(), b1.getAtmCount());
                    if (cmp == 0) cmp = Integer.compare(b2.getEmployeeCount(), b1.getEmployeeCount());
                    if (cmp == 0) cmp = Integer.compare(b2.getOfficeCount(), b1.getOfficeCount());
                    if (cmp == 0) cmp = b1.getInterestRate().compareTo(b2.getInterestRate());
                    return cmp;
                }).findFirst()
                .orElseThrow(() -> new CreditExceptions.CreditException("No suitable banks found."));

        // 2. Выбор офиса
        BankOffice selectedOffice = officeService.getAllOffices().stream()
                .filter(o -> o.isWorking() && o.getMoneyAmount() >= requestedAmount)
                .findFirst()
                .orElseThrow(() -> new CreditExceptions.OfficeDoesNotSupportLoansException(bestBank.getName()));

        // 3. Проверка сотрудника
        Employee qualifiedEmployee = selectedOffice.getEmployees().stream()
                .filter(e -> "Credit Officer".equalsIgnoreCase(e.getPosition()))
                .findFirst()
                .orElseThrow(() -> new CreditExceptions.NoQualifiedEmployeeException(selectedOffice.getName()));

        // 4. Проверка счета
        boolean hasAccount = user.getPaymentAccounts().stream()
                .anyMatch(pa -> pa.getBank().equals(bestBank));
        if (!hasAccount) {
            PaymentAccount account = paymentAccountService.createPaymentAccount(user, bestBank, 0.0);
            if (account == null) {
                throw new CreditExceptions.BankAccountCreationFailedException(user.getFirstName(), bestBank.getName());
            }
        }

        // 5. Проверка рейтингов
        if (user.getCreditRating() < 5000 && bestBank.getRating() > 50) {
            throw new CreditExceptions.LowCreditRatingException(user.getCreditRating(), 5000);
        }

        // 6. Проверка банкомата
        BankAtm suitableAtm = atmService.getAllAtms().stream()
                .filter(atm -> atm.getOffice().equals(selectedOffice) && atm.getMoneyAmount() >= requestedAmount)
                .findFirst()
                .orElseThrow(() -> new CreditExceptions.InsufficientFundsAtmException(requestedAmount, 0));

        // 7. Создание кредита
        CreditAccount creditAccount = new CreditAccount(user, bestBank, requestedAmount, loanTerm);
        accounts.add(creditAccount);
        return creditAccount;
    }
}
