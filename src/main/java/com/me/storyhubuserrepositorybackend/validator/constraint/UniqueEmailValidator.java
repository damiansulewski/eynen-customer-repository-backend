package com.me.storyhubuserrepositorybackend.validator.constraint;

import com.me.storyhubuserrepositorybackend.userinfo.UserInfoService;
import com.me.storyhubuserrepositorybackend.validator.annotation.ValidUniqueEmail;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<ValidUniqueEmail, String> {
    private final UserInfoService userInfoService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userInfoService.isEmailAlreadyExists(value);
    }
}
