package com.me.storyhubuserrepositorybackend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("create")
    public void createUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("activate")
    public void activateUser(@RequestBody ActivateUserRequest request) {
        userService.activateUser(request);
    }

    @GetMapping("is-email-already-exists")
    public boolean isEmailAlreadyExists(@RequestParam String email) {
        return userService.isEmailAlreadyExists(email);
    }

    @PostMapping("login")
    public boolean loginUser(@RequestBody LoginUserRequest request) {
        return userService.loginUser(request);
    }
}
