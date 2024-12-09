package tech.reliab.course.galushenkoLab.bank.service.impl;

import tech.reliab.course.galushenkoLab.bank.entity.Bank;
import tech.reliab.course.galushenkoLab.bank.entity.BankAtm;
import tech.reliab.course.galushenkoLab.bank.service.BankAtmService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankAtmServiceImpl implements BankAtmService {

    private final List<BankAtm> atms = new ArrayList<>();

    // Обновленный метод для создания банкомата с привязкой к банку
    @Override
    public BankAtm createAtm(String name, String address, Bank bank) {
        BankAtm atm = new BankAtm(name, address, bank);
        atms.add(atm); // Сохраняем банкомат в списке
        return atm;
    }

    @Override
    public BankAtm getAtmById(int id) {
        return atms.stream().filter(atm -> atm.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateAtm(BankAtm atm) {
        Optional<BankAtm> existingAtm = atms.stream().filter(a -> a.getId() == atm.getId()).findFirst();
        existingAtm.ifPresent(a -> {
            a.setName(atm.getName());
            a.setAddress(atm.getAddress());
            a.setWorking(atm.isWorking());
            a.setCanWithdraw(atm.isCanWithdraw());
            a.setCanDeposit(atm.isCanDeposit());
        });
    }

    @Override
    public void deleteAtm(int id) {
        atms.removeIf(atm -> atm.getId() == id);
    }

    @Override
    public List<BankAtm> getAllAtms() {
        return new ArrayList<>(atms);
    }
}
