package com.me.storyhubuserrepositorybackend.contact;

import com.me.storyhubuserrepositorybackend.country.Country;
import lombok.Getter;

@Getter
public class CreateContactRequest {
    private String uuid;
    private String mobilePhoneNumber;
    private Country country;
}
