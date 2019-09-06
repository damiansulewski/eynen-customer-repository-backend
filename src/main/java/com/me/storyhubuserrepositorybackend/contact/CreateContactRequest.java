package com.me.storyhubuserrepositorybackend.contact;

import com.me.storyhubuserrepositorybackend.country.Country;
import lombok.Getter;

@Getter
public class CreateContactRequest {
    String uuid;
    String mobilePhoneNumber;
    Country country;
}
