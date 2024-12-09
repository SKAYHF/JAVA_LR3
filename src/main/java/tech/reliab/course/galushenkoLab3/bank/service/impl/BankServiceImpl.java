package tech.reliab.course.galushenkoLab.bank.service.impl;

import tech.reliab.course.galushenkoLab.bank.entity.Bank;
import tech.reliab.course.galushenkoLab.bank.service.BankService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankServiceImpl implements BankService {

    private final List<Bank> banks = new ArrayList<>();

    @Override
    public Bank createBank(String name, String address) {
        Bank bank = new Bank(name);
        banks.add(bank);
        return bank;
    }

    @Override
    public Bank getBankById(int id) {
        return banks.stream().filter(bank -> bank.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateBank(Bank bank) {
        Optional<Bank> existingBank = banks.stream().filter(b -> b.getId() == bank.getId()).findFirst();
        existingBank.ifPresent(b -> {
            b.setName(bank.getName());
            b.setOfficeCount(bank.getOfficeCount());
            b.setAtmCount(bank.getAtmCount());
            b.setEmployeeCount(bank.getEmployeeCount());
            b.setUserCount(bank.getUserCount());
            b.setRating(bank.getRating());
            b.setTotalMoney(bank.getTotalMoney());
            b.setInterestRate(bank.getInterestRate());
        });
    }

    @Override
    public void deleteBank(int id) {
        banks.removeIf(bank -> bank.getId() == id);
    }

    @Override
    public List<Bank> getAllBanks() {
        return new ArrayList<>(banks);
    }
}
