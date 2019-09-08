package com.me.storyhubuserrepositorybackend.registration;

import com.me.storyhubuserrepositorybackend.gender.Gender;
import lombok.Getter;

@Getter
public final class CreateUserRequest {
    private String name;
    private String surname;
    private String email;
    private Gender gender;
    private String password;
    private String confirmPassword;
}
