package tech.reliab.course.galushenkoLab.bank.service.impl;

import tech.reliab.course.galushenkoLab.bank.entity.User;
import tech.reliab.course.galushenkoLab.bank.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User createUser(String firstName, String lastName, double monthlyIncome) {
        User user = new User(firstName, lastName, monthlyIncome);
        users.add(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> existingUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst();
        existingUser.ifPresent(u -> {
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setMonthlyIncome(user.getMonthlyIncome());
        });
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
