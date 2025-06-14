package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> usersByUsername = new HashMap<>();

    public User registerByEmail(String username, String email, String password) {
        User user = new User(username, email, password);
        usersByUsername.put(username, user);
        return user;
    }

    public User registerByPhone(String username, String phone, String password) {
        User user = new User(username, phone, password, true);
        usersByUsername.put(username, user);
        return user;
    }

    public User registerBySocial(String username, String socialProvider) {
        User user = new User(username, socialProvider);
        usersByUsername.put(username, user);
        return user;
    }

    public void resetPasswordByEmail(String email, String newPassword) {
        for (User user : usersByUsername.values()) {
            if (email.equals(user.getEmail())) {
                user.setPassword(newPassword);
                return;
            }
        }
        throw new IllegalArgumentException("User with email " + email + " not found");
    }

    public void resetPasswordByPhone(String phone, String newPassword) {
        for (User user : usersByUsername.values()) {
            if (phone.equals(user.getPhone())) {
                user.setPassword(newPassword);
                return;
            }
        }
        throw new IllegalArgumentException("User with phone " + phone + " not found");
    }

    public User getUserByUsername(String username) {
        return usersByUsername.get(username);
    }
}
