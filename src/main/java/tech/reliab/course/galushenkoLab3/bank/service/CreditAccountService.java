package tech.reliab.course.galushenkoLab.bank.service;

import tech.reliab.course.galushenkoLab.bank.entity.CreditAccount;
import tech.reliab.course.galushenkoLab.bank.entity.User;
import tech.reliab.course.galushenkoLab.bank.entity.Bank;
import tech.reliab.course.galushenkoLab.bank.exceptions.CreditExceptions;

import java.util.List;

public interface CreditAccountService {
    CreditAccount createCreditAccount(User user, Bank bank, double loanAmount, int loanTerm);
    CreditAccount getCreditAccountById(int id);
    void updateCreditAccount(CreditAccount account);
    void deleteCreditAccount(int id);
    List<CreditAccount> getAllCreditAccounts();

    // для обработки запроса на получение кредита
    CreditAccount processCreditRequest(User user, double requestedAmount, int loanTerm,
                                       BankService bankService, BankOfficeService officeService,
                                       BankAtmService atmService, PaymentAccountService paymentAccountService) throws CreditExceptions.CreditException;
}
