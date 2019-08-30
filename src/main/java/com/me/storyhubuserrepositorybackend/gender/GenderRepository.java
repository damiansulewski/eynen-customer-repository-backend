package com.me.storyhubuserrepositorybackend.gender;

import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<GenderEntity, Long> {
    GenderEntity findByCode(String code);
}
