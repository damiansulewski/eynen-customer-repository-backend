package com.me.storyhubuserrepositorybackend.contact;

import com.me.storyhubuserrepositorybackend.country.CountryEntity;
import com.me.storyhubuserrepositorybackend.country.CountryRepository;
import com.me.storyhubuserrepositorybackend.user.UserEntity;
import com.me.storyhubuserrepositorybackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public void createContact(CreateContactRequest request) {
        UserEntity user = userRepository.findByUuid(request.getUuid())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by uuid=[%s]",
                                request.getUuid())));

        ContactEntity contact = createContactEntity(
                request,
                countryRepository.findByCode(request.getCountry().toString())
                        .orElseThrow(() ->
                                new RuntimeException(String.format("CountryEntity not found searching by code=[%s]",
                                        request.getCountry()))));
        user.getUserInfo().setContact(contact);
    }

    private ContactEntity createContactEntity(CreateContactRequest request, CountryEntity country) {
        return new ContactEntity(
                request.getMobilePhoneNumber(),
                country);
    }
}
