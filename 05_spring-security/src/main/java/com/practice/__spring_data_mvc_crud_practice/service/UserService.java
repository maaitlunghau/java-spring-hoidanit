package com.practice.__spring_data_mvc_crud_practice.service;

import com.practice.__spring_data_mvc_crud_practice.model.User;
import com.practice.__spring_data_mvc_crud_practice.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this._userRepository = userRepository;
        this._passwordEncoder = passwordEncoder;
    }

    public Page<User> fetchUsersWithSpec(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (keyword != null && !keyword.trim().isEmpty()) {
            return this._userRepository.findByNameContainingOrEmailContaining(keyword, keyword, pageable);
        }

        return this._userRepository.findAll(pageable);
    }

    public User createUser(User user) {
        String hashedPassword = this._passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return this._userRepository.save(user);
    }

    public Optional<User> findUserById(int id) {
        return this._userRepository.findById(id);
    }

    public User updateUser(User user) {
        if (this._userRepository.existsById(user.getId())) {
            return this._userRepository.save(user);
        }

        return null;
    }

    public void deleteUser(int id) {
        this._userRepository.deleteById(id);
    }
}
