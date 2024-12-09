package tech.reliab.course.galushenkoLab.bank.service;

import tech.reliab.course.galushenkoLab.bank.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {
    BankOffice createOffice(String name, String address);
    BankOffice getOfficeById(int id);
    void updateOffice(BankOffice office);
    void deleteOffice(int id);
    List<BankOffice> getAllOffices();
}
