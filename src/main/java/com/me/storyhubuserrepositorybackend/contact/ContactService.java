package com.me.storyhubuserrepositorybackend.contact;

import com.me.storyhubuserrepositorybackend.phonecountry.PhoneCountryEntity;
import com.me.storyhubuserrepositorybackend.phonecountry.PhoneCountryRepository;
import com.me.storyhubuserrepositorybackend.user.UserEntity;
import com.me.storyhubuserrepositorybackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final UserRepository userRepository;
    private final PhoneCountryRepository phoneCountryRepository;

    @Transactional
    public void createContact(CreateContactRequest request) {
        UserEntity user = userRepository.findByUuid(request.getUuid())
                .orElseThrow(() ->
                        new RuntimeException(String.format("UserEntity not found searching by uuid=[%s]",
                                request.getUuid())));
        ContactEntity contact = createContactEntity(
                request,
                phoneCountryRepository.findByCode(request.getPhoneCountry())
                        .orElseThrow(() ->
                                new RuntimeException(String.format("PhoneCountryEntity not found searching by code=[%s]",
                                        request.getPhoneCountry()))));
        user.getUserInfo().setContact(contact);
    }

    private ContactEntity createContactEntity(CreateContactRequest request, PhoneCountryEntity phoneCountry) {
        return new ContactEntity(
                request.getPhoneNumber(),
                phoneCountry);
    }
}
