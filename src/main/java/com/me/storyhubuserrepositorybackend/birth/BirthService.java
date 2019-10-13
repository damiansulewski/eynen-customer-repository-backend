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

        upsertBirth(request, user);
    }

    private void upsertBirth(CreateBirthRequest request, UserEntity user) {
        BirthEntity birth;

        if (user.getUserInfo().getBirth() == null) {
            birth = createBirthEntity(request);
            user.getUserInfo().setBirth(birth);
        } else {
            birth = user.getUserInfo().getBirth();
            birth.setDayOfBirth(request.getDayOfBirth());
            birth.setMonthOfBirth(request.getMonthOfBirth());
            birth.setYearOfBirth(request.getYearOfBirth());
        }
    }

    private BirthEntity createBirthEntity(CreateBirthRequest request) {
        return new BirthEntity(
                request.getDayOfBirth(),
                request.getMonthOfBirth(),
                request.getYearOfBirth());
    }
}
