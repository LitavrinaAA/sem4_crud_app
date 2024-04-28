package ru.litavrina.first_crud_app.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.litavrina.first_crud_app.model.User;
import ru.litavrina.first_crud_app.service.UserService;


import java.util.List;

@Log
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("Обработка запроса на получение всех users");
        return "user-list";

    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        log.info("Вызов формы создания пользователя");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        log.info("Пользователь сохранен!");
        return "redirect:/users";
    }


    @GetMapping("/user-update/{id}")
    public String updateUserById(User user) {
        log.info("Форма обновления пользователя");
        return "user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateById(user);
        log.info("Пользователь обновлен по id");
        return "redirect:/users";
    }
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        System.out.println("deleting ...");
        userService.deleteById(id);
        log.info("Пользователь удален!");
        return "redirect:/users";
    }
}
