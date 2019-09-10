package com.me.storyhubuserrepositorybackend.userstatus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserStatusService {
    private final UserStatusRepository userStatusRepository;

    public Set<String> getUserStatusCodes() {
        return userStatusRepository.findAll()
                .stream()
                .map(UserStatusEntity::getCode)
                .collect(Collectors.toSet());
    }
}
