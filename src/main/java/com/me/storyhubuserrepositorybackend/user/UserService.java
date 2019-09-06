package com.me.storyhubuserrepositorybackend.user;

import com.me.storyhubuserrepositorybackend.gender.GenderEntity;
import com.me.storyhubuserrepositorybackend.gender.GenderRepository;
import com.me.storyhubuserrepositorybackend.registration.ActivateUserRequest;
import com.me.storyhubuserrepositorybackend.registration.CreateUserRequest;
import com.me.storyhubuserrepositorybackend.userinfo.UserInfoEntity;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatus;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatusEntity;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final GenderRepository genderRepository;
    private final UserStatusRepository userStatusRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void createUser(CreateUserRequest request) {
        UserInfoEntity userInfo = createUserInfoEntity(
                request,
                genderRepository.findByCode(request.getGender().toString())
                        .orElseThrow(() ->
                                new RuntimeException(String.format("GenderEntity not found searching by code=[%s]",
                                        request.getGender()))));
        UserEntity userEntity = createUserEntity(
                request,
                userInfo,
                userStatusRepository.findByCode(UserStatus.NEW.toString())
                        .orElseThrow(() ->
                                new RuntimeException(String.format("UserStatusEntity not found searching by code=[%s]",
                                        UserStatus.NEW))));

        userRepository.save(userEntity);
    }

    private UserInfoEntity createUserInfoEntity(CreateUserRequest request, GenderEntity gender) {
        return new UserInfoEntity(
                request.getEmail(),
                request.getName(),
                request.getSurname(),
                gender);
    }

    private UserEntity createUserEntity(CreateUserRequest request, UserInfoEntity userInfo, UserStatusEntity userStatus) {
        return new UserEntity(
                bCryptPasswordEncoder.encode(request.getPassword()),
                userInfo,
                userStatus);
    }

    @Transactional
    public void activateUser(ActivateUserRequest request) {
        UserEntity user = userRepository.findByUuid(request.getUuid())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by uuid=[%s]",
                                request.getUuid())));

        user.setUserStatus(userStatusRepository.findByCode(UserStatus.ACTIVE.toString())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserStatusEntity not found searching by code=[%s]",
                                UserStatus.ACTIVE))));
        user.setActivationDate(LocalDateTime.now());
    }
}
