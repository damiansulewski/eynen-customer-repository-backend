package com.me.storyhubuserrepositorybackend.user;

import com.me.storyhubuserrepositorybackend.gender.GenderEntity;
import com.me.storyhubuserrepositorybackend.gender.GenderRepository;
import com.me.storyhubuserrepositorybackend.userinfo.UserInfoEntity;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatus;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatusEntity;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final GenderRepository genderRepository;
    private final UserStatusRepository userStatusRepository;

    @Transactional
    public String createUser(CreateUserRequest request) {
        UserInfoEntity userInfo = createUserInfoEntity(
                request,
                genderRepository.findByCode(request.getGender())
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
        return userEntity.getUuid();
    }

    private UserInfoEntity createUserInfoEntity(CreateUserRequest request, GenderEntity gender) {
        return new UserInfoEntity(
                request.getName(),
                request.getSurname(),
                gender);
    }

    private UserEntity createUserEntity(CreateUserRequest request, UserInfoEntity userInfo, UserStatusEntity userStatus) {
        return new UserEntity(
                request.getEmail(),
                request.getPassword(),
                userInfo,
                userStatus);
    }

    @Transactional
    public void activateUser(String uuid) {
        UserEntity user = userRepository.findByUuid(uuid)
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by uuid=[%s]",
                                uuid)));
        user.setUserStatus(userStatusRepository.findByCode(UserStatus.ACTIVE.toString())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserStatusEntity not found searching by code=[%s]",
                                UserStatus.ACTIVE))));
        user.setActivationDate(LocalDateTime.now());
    }

    public boolean isEmailAlreadyExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public UserCredential getUserCredential(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by email=[%s]",
                                email)));

        return new UserCredential(userEntity.getUuid(),
                userEntity.getEmail(),
                userEntity.getPassword());
    }
}
