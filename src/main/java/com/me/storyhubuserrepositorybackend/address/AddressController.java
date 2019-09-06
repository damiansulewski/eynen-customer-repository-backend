package com.me.storyhubuserrepositorybackend.address;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("address")
public class AddressController {
    private final AddressService addressService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void createAddress(@RequestBody CreateAddressRequest request) {
        addressService.createAddress(request);
    }
}
