package com.me.storyhubuserrepositorybackend.userinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-info")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @GetMapping("is-email-already-exists")
    public boolean isEmailAlreadyExists(@RequestParam String email) {
        return userInfoService.isEmailAlreadyExists(email);
    }
}
