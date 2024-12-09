package tech.reliab.course.galushenkoLab.bank.service;

import tech.reliab.course.galushenkoLab.bank.entity.Bank;

import java.util.List;

public interface BankService {
    Bank createBank(String name, String address);
    Bank getBankById(int id);
    void updateBank(Bank bank);
    void deleteBank(int id);
    List<Bank> getAllBanks();
}
