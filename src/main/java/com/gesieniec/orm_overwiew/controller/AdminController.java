package com.gesieniec.orm_overwiew.controller;

import com.gesieniec.orm_overwiew.dto.UserDto;
import com.gesieniec.orm_overwiew.service.UserService;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/panel")
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {

        final List<UserDto> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

}
