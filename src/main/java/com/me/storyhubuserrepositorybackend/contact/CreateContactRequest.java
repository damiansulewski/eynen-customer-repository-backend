package com.me.storyhubuserrepositorybackend.contact;

import lombok.Getter;

@Getter
public class CreateContactRequest {
    private String uuid;
    private String phoneNumber;
    private String phoneCountry;
}
