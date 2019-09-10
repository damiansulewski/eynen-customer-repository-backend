package com.me.storyhubuserrepositorybackend.phonecountry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhoneCountryService {
    private final PhoneCountryRepository phoneCountryRepository;

    public Set<String> getPhoneCountryCodes() {
        return phoneCountryRepository.findAll()
                .stream()
                .map(PhoneCountryEntity::getCode)
                .collect(Collectors.toSet());
    }
}
