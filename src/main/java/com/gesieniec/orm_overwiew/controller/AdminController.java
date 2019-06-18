package com.gesieniec.orm_overwiew.controller;

import com.gesieniec.orm_overwiew.dto.GroupDto;
import com.gesieniec.orm_overwiew.dto.OrdersDto;
import com.gesieniec.orm_overwiew.dto.ProductDto;
import com.gesieniec.orm_overwiew.dto.RoleDto;
import com.gesieniec.orm_overwiew.dto.UserDto;
import com.gesieniec.orm_overwiew.service.GroupService;
import com.gesieniec.orm_overwiew.service.OrdersService;
import com.gesieniec.orm_overwiew.service.ProductService;
import com.gesieniec.orm_overwiew.service.RoleService;
import com.gesieniec.orm_overwiew.service.UserService;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private UserService userService;
    private ProductService productService;
    private RoleService roleService;
    private GroupService groupService;
    private OrdersService ordersService;

    public AdminController(UserService userService,
                           ProductService productService,
                           RoleService roleService,
                           GroupService groupService,
                           OrdersService ordersService) {
        this.userService = userService;
        this.productService = productService;
        this.roleService = roleService;
        this.groupService = groupService;
        this.ordersService = ordersService;
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
        model.addAttribute("groupDto", new GroupDto());
        return "groups";
    }

    @PostMapping("/add/group")
    public String addGroup(@ModelAttribute GroupDto groupDto){
        groupService.addGroup(groupDto);
        return "redirect:/groups";
    }

    @PostMapping("/delete/group/{groupName}")
    public String deleteGroup(@PathVariable String groupName){
        groupService.deleteGroup(groupName);
        return "redirect:/groups";
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        final List<OrdersDto> allOrders = ordersService.getAllOrders();
        model.addAttribute("orders", allOrders);
        return "orders";
    }

}
