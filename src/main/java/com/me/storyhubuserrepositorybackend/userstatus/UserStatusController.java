package com.me.storyhubuserrepositorybackend.userstatus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-status")
public class UserStatusController {
    private final UserStatusService userStatusService;

    @GetMapping("codes")
    public Set<String> getUserStatusCodes() {
        return userStatusService.getUserStatusCodes();
    }
}
