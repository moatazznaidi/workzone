package com.example.demo.Service;
import com.example.demo.Model.tool.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();
        return all;
    }


    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }


}
