package com.me.storyhubuserrepositorybackend.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public Set<String> findAllCodes() {
        return countryRepository.findAll()
                .stream()
                .map(CountryEntity::getCode)
                .collect(Collectors.toSet());
    }
}
