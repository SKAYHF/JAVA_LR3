package tech.reliab.course.galushenkoLab.bank.service.impl;

import tech.reliab.course.galushenkoLab.bank.entity.BankOffice;
import tech.reliab.course.galushenkoLab.bank.service.BankOfficeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankOfficeServiceImpl implements BankOfficeService {

    private final List<BankOffice> offices = new ArrayList<>();

    @Override
    public BankOffice createOffice(String name, String address) {
        BankOffice office = new BankOffice(name, address);
        offices.add(office);
        return office;
    }

    @Override
    public BankOffice getOfficeById(int id) {
        return offices.stream().filter(office -> office.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateOffice(BankOffice office) {
        Optional<BankOffice> existingOffice = offices.stream().filter(o -> o.getId() == office.getId()).findFirst();
        existingOffice.ifPresent(o -> {
            o.setName(office.getName());
            o.setAddress(office.getAddress());
            o.setWorking(office.isWorking());
            o.setCanHostAtm(office.isCanHostAtm());
        });
    }

    @Override
    public void deleteOffice(int id) {
        offices.removeIf(office -> office.getId() == id);
    }

    @Override
    public List<BankOffice> getAllOffices() {
        return new ArrayList<>(offices);
    }
}
