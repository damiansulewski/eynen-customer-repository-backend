package com.me.storyhubuserrepositorybackend.user;

import lombok.Getter;

@Getter
public final class CreateUserRequest {
    private String name;
    private String surname;
    private String email;
    private String gender;
    private String password;
}
