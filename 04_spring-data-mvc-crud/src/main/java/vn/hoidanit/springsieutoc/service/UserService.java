package vn.hoidanit.springsieutoc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.springsieutoc.model.User;
import vn.hoidanit.springsieutoc.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchUsers() {
        List<User> userList = this.userRepository.findAll();
        return userList;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }
}
