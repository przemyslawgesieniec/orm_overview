package com.gesieniec.orm_overwiew.controller;

import com.gesieniec.orm_overwiew.dto.GroupDto;
import com.gesieniec.orm_overwiew.dto.ProductDto;
import com.gesieniec.orm_overwiew.dto.RoleDto;
import com.gesieniec.orm_overwiew.dto.UserDto;
import com.gesieniec.orm_overwiew.service.GroupService;
import com.gesieniec.orm_overwiew.service.ProductService;
import com.gesieniec.orm_overwiew.service.RoleService;
import com.gesieniec.orm_overwiew.service.UserService;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private UserService userService;
    private ProductService productService;
    private RoleService roleService;
    private GroupService groupService;

    public AdminController(UserService userService,
                           ProductService productService,
                           RoleService roleService,
                           GroupService groupService) {
        this.userService = userService;
        this.productService = productService;
        this.roleService = roleService;
        this.groupService = groupService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {

        final List<UserDto> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {

        final List<ProductDto> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "products";
    }

    @GetMapping("/roles")
    public String getAllRoles(Model model) {

        final List<RoleDto> allRoles = roleService.getAllRoles();
        model.addAttribute("roles", allRoles);
        return "roles";
    }

    @GetMapping("/groups")
    public String getAllGroups(Model model) {

        final List<GroupDto> allGroups = groupService.getAllGroups();
        model.addAttribute("groups", allGroups);
        return "groups";
    }

}
