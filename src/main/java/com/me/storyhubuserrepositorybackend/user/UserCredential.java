package com.me.storyhubuserrepositorybackend.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCredential {
    private String uuid;
    private String email;
    private String password;
}
