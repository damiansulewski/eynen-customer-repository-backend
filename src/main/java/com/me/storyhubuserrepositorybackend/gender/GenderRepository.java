package com.me.storyhubuserrepositorybackend.gender;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
    Optional<GenderEntity> findByCode(String code);
}
