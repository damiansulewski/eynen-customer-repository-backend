package com.me.storyhubuserrepositorybackend.user;

import lombok.Getter;

@Getter
public final class LoginUserRequest {
    private String email;
    private String password;
}
