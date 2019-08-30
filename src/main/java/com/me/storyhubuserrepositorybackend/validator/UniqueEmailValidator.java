package com.me.storyhubuserrepositorybackend.validator;

import com.me.storyhubuserrepositorybackend.userinfo.UserInfoService;
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
