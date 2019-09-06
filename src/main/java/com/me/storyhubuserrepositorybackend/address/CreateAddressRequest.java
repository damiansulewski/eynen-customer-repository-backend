package com.me.storyhubuserrepositorybackend.address;

import com.me.storyhubuserrepositorybackend.country.Country;
import lombok.Getter;

@Getter
public class CreateAddressRequest {
    String uuid;
    String street;
    String houseNumber;
    String apartmentNumber;
    String postCode;
    String city;
    Country country;
}
