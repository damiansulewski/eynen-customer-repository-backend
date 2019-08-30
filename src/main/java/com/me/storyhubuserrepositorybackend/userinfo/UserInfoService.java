package com.me.storyhubuserrepositorybackend.userinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public boolean isEmailAlreadyExists(String email) {
        return userInfoRepository.findByEmail(email).isEmpty();
    }
}
