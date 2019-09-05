package com.me.storyhubuserrepositorybackend.gender;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("dictionary/gender")
public class GenderController {
    private final GenderService genderService;

    @GetMapping("code")
    public Set<String> findAllCodes() {
        return genderService.findAllCodes();
    }
}