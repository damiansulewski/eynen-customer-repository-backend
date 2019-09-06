package com.me.storyhubuserrepositorybackend.contact;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("contact")
public class ContactController {
    private final ContactService contactService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void createAddress(@RequestBody CreateContactRequest request) {
        contactService.createContact(request);
    }
}
