package com.me.storyhubuserrepositorybackend.registration;

import com.me.storyhubuserrepositorybackend.gender.Gender;
import com.me.storyhubuserrepositorybackend.validator.ValidPassword;
import com.me.storyhubuserrepositorybackend.validator.ValidUniqueEmail;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CreateUserRequest {
    @NotNull
    @Length(min = 2, max = 50)
    private String name;

    @NotNull
    @Length(min = 2, max = 50)
    private String surname;

    @NotNull
    @ValidUniqueEmail
    @Length(min = 4, max = 250)
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
    private String email;

    @NotNull
    private Gender gender;

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    @ValidPassword
    private String confirmPassword;
}
