package com.me.storyhubuserrepositorybackend.phonecountry;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("phone-country")
public class PhoneCountryController {
    private final PhoneCountryService phoneCountryService;

    @GetMapping("codes")
    public Set<String> getPhoneCountryCodes() {
        return phoneCountryService.getPhoneCountryCodes();
    }
}
