package com.practice.__spring_security_practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.__spring_security_practice.models.User;
import com.practice.__spring_security_practice.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this._userRepository = userRepository;
        this._passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return this._userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return this._userRepository.findById(id);
    }

    public void createUser(User user) {
        if (user == null)
            return;

        String hashedPassword = this._passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        this._userRepository.save(user);
    }

    public void updateUser(User user) {
        if (user == null)
            return;

        this._userRepository.save(user);
    }

    public void deleteUser(int id) {
        if (id <= 0)
            return;

        this._userRepository.deleteById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return this._userRepository.findByEmail(email);
    }
}
