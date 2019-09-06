package com.me.storyhubuserrepositorybackend.address;

import lombok.Getter;

@Getter
public class CreateAddressRequest {
    String uuid;
    String street;
    String houseNumber;
    String apartmentNumber;
    String postCode;
    String city;
    String country;
}
