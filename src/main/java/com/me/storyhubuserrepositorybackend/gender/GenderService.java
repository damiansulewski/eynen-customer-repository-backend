package com.me.storyhubuserrepositorybackend.gender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenderService {
    private final GenderRepository genderRepository;

    public Set<String> getGenderCodes() {
        return genderRepository.findAll()
                .stream()
                .map(GenderEntity::getCode)
                .collect(Collectors.toSet());
    }
}
