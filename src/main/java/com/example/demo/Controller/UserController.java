package com.example.demo.Controller;

import com.example.demo.Model.Project;
import com.example.demo.Model.tool.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser() {

        List all= userService.getAllUser();
        return all;
    }
    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return  userService.getUser(id); }
}
