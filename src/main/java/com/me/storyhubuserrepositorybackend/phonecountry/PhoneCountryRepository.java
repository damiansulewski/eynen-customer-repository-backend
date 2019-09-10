package com.me.storyhubuserrepositorybackend.phonecountry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneCountryRepository extends JpaRepository<PhoneCountryEntity, Long> {
    Optional<PhoneCountryEntity> findByCode(String code);
}
