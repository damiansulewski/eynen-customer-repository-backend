package com.me.storyhubuserrepositorybackend.address;

import com.me.storyhubuserrepositorybackend.user.UserEntity;
import com.me.storyhubuserrepositorybackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final UserRepository userRepository;

    @Transactional
    public void createAddress(CreateAddressRequest request) {
        UserEntity user = userRepository.findByUuid(request.getUuid())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by uuid=[%s]",
                                request.getUuid())));

        AddressEntity address = createAddressEntity(request);
        user.getUserInfo().setAddress(address);
    }

    private AddressEntity createAddressEntity(CreateAddressRequest request) {
        return new AddressEntity(
                request.getStreet(),
                request.getHouseNumber(),
                request.getApartmentNumber(),
                request.getPostCode(),
                request.getCity(),
                request.getCountry());
    }
}
