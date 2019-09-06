package com.me.storyhubuserrepositorybackend.birth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("birth")
public class BirthController {
    private final BirthService birthService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void createAddress(@RequestBody CreateBirthRequest request) {
        birthService.createBirth(request);
    }
}
