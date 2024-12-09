package tech.reliab.course.galushenkoLab.bank.service;

import tech.reliab.course.galushenkoLab.bank.entity.User;

import java.util.List;

public interface UserService {
    User createUser(String firstName, String lastName, double monthlyIncome);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}
