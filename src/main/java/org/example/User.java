package org.example;

public class User {
    private String email;
    private String phone;
    private String socialProvider;
    private String name;
    private String password;

    // Конструктор для регистрации по email
    public User(String username, String email, String password) {
        this.name = username;
        this.email = email;
        this.password = password;
    }

    // Конструктор для регистрации по телефону
    public User(String username, String phone, String password, boolean byPhone) {
        this.name = username;
        this.phone = phone;
        this.password = password;
    }

    // Конструктор для регистрации через соцсеть
    public User(String username, String socialProvider) {
        this.name = username;
        this.socialProvider = socialProvider;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSocialProvider() {
        return socialProvider;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



