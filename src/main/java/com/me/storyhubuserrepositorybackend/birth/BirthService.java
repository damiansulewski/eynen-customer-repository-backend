package com.me.storyhubuserrepositorybackend.birth;

import com.me.storyhubuserrepositorybackend.user.UserEntity;
import com.me.storyhubuserrepositorybackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BirthService {
    private final UserRepository userRepository;

    @Transactional
    public void createBirth(CreateBirthRequest request) {
        UserEntity user = userRepository.findByUuid(request.getUuid())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by uuid=[%s]",
                                request.getUuid())));

        BirthEntity birth = createBirthEntity(request);
        user.getUserInfo().setBirth(birth);
    }

    private BirthEntity createBirthEntity(CreateBirthRequest request) {
        return new BirthEntity(
                request.getDayOfBirth(),
                request.getMonthOfBirth(),
                request.getYearOfBirth());
    }
}
