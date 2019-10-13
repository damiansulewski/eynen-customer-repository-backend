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

        upsertContact(request, user);
    }

    private void upsertContact(CreateContactRequest request, UserEntity user) {
        ContactEntity contact;

        if (user.getUserInfo().getContact() == null) {
            contact = createContactEntity(
                    request,
                    findPhoneCountry(request.getPhoneCountry()));
            user.getUserInfo().setContact(contact);
        } else {
            contact = user.getUserInfo().getContact();
            contact.setPhoneCountry(findPhoneCountry(request.getPhoneCountry()));
            contact.setPhoneNumber(request.getPhoneNumber());
        }
    }

    private ContactEntity createContactEntity(CreateContactRequest request, PhoneCountryEntity phoneCountry) {
        return new ContactEntity(
                request.getPhoneNumber(),
                phoneCountry);
    }

    private PhoneCountryEntity findPhoneCountry(String phoneCountry) {
        return phoneCountryRepository.findByCode(phoneCountry)
                .orElseThrow(() ->
                        new RuntimeException(String.format("PhoneCountryEntity not found searching by code=[%s]",
                                phoneCountry)));
    }
}
