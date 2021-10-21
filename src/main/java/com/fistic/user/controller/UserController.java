package com.fistic.user.controller;

import com.fistic.user.entity.User;
import com.fistic.user.model.ResponseTemplateVO;
import com.fistic.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController.");
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment method of UserController.");
        return userService.getUserWithDepartment(userId);
    }
}
