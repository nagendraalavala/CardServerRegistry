package com.card.Server.Controller.User;


import com.card.Server.Service.User.UserService;
import com.card.Server.types.User.UserDTO;
import com.card.Server.types.User.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/host")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PostMapping("/user/sign-up")
    public Object createNewUser( @Valid @RequestBody UserDTO userDTO)
    {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/user/")
    public List<UserResponse> findAllUers()
    {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public Object findUserById(@PathVariable Long id)
    {
        return userService.findUserById(id);
    }
}