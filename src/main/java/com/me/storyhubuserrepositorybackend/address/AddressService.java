package com.me.storyhubuserrepositorybackend.address;

import com.me.storyhubuserrepositorybackend.country.CountryEntity;
import com.me.storyhubuserrepositorybackend.country.CountryRepository;
import com.me.storyhubuserrepositorybackend.user.UserEntity;
import com.me.storyhubuserrepositorybackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public void createAddress(CreateAddressRequest request) {
        UserEntity user = userRepository.findByUuid(request.getUuid())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by uuid=[%s]",
                                request.getUuid())));

        upsertAddress(request, user);
    }

    private void upsertAddress(CreateAddressRequest request, UserEntity user) {
        AddressEntity address;

        if (user.getUserInfo().getAddress() == null) {
            address = createAddressEntity(
                    request,
                    findCountry(request.getCountry()));
            user.getUserInfo().setAddress(address);
        } else {
            address = user.getUserInfo().getAddress();
            address.setStreet(request.getStreet());
            address.setHouseNumber(request.getHouseNumber());
            address.setApartmentNumber(request.getApartmentNumber());
            address.setPostCode(request.getPostCode());
            address.setCity(request.getCity());
            address.setCountry(findCountry(request.getCountry()));
        }
    }

    private AddressEntity createAddressEntity(CreateAddressRequest request, CountryEntity country) {
        return new AddressEntity(
                request.getStreet(),
                request.getHouseNumber(),
                request.getApartmentNumber(),
                request.getPostCode(),
                request.getCity(),
                country);
    }

    private CountryEntity findCountry(String country) {
        return countryRepository.findByCode(country)
                .orElseThrow(() ->
                        new RuntimeException(String.format("CountryEntity not found searching by code=[%s]",
                                country)));
    }
}
