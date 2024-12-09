package tech.reliab.course.galushenkoLab.bank.service;

import tech.reliab.course.galushenkoLab.bank.entity.BankAtm;
import tech.reliab.course.galushenkoLab.bank.entity.Bank;

import java.util.List;

public interface BankAtmService {
    // Обновленный метод для создания банкомата с привязкой к банку
    BankAtm createAtm(String name, String address, Bank bank);

    BankAtm getAtmById(int id);

    void updateAtm(BankAtm bankAtm);

    void deleteAtm(int id);

    List<BankAtm> getAllAtms();
}
