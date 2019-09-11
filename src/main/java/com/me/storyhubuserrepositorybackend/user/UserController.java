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
    public String createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("activate")
    public void activateUser(@RequestParam("uuid") String uuid) {
        userService.activateUser(uuid);
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
