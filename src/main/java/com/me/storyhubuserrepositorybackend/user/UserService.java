package com.me.storyhubuserrepositorybackend.user;

import com.me.storyhubuserrepositorybackend.gender.GenderEntity;
import com.me.storyhubuserrepositorybackend.gender.GenderRepository;
import com.me.storyhubuserrepositorybackend.registration.CreateUserRequest;
import com.me.storyhubuserrepositorybackend.userinfo.UserInfoEntity;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatus;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatusEntity;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
                genderRepository.findByCode(request.getGender().toString()));
        UserEntity userEntity = createUserEntity(
                request,
                userInfo,
                userStatusRepository.findByCode(UserStatus.NEW.toString()));

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
}