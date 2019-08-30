package com.me.storyhubuserrepositorybackend.registration;

import com.me.storyhubuserrepositorybackend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("registration/step")
public class RegistrationStepController {
    private final UserService userService;

    @PostMapping("create-user")
    public void createUser(@Valid CreateUserRequest request) {
        userService.createUser(request);
    }
}
