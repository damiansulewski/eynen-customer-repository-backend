package com.me.storyhubuserrepositorybackend.birth;

import lombok.Getter;

@Getter
public class CreateBirthRequest {
    private String uuid;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
}
