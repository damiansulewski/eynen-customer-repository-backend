package com.me.storyhubuserrepositorybackend.country;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("codes")
    public Set<String> getCountryCodes() {
        return countryService.getCountryCodes();
    }
}
