package com.me.storyhubuserrepositorybackend.registration;

import com.me.storyhubuserrepositorybackend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("registration")
public class RegistrationController {
    private final UserService userService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("create-user")
    public void createUser(@Valid @RequestBody CreateUserRequest request) {
        userService.createUser(request);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("activate-user")
    public void acceptActivate(@RequestBody ActivateUserRequest request) {
        userService.activateUser(request);
    }
}
