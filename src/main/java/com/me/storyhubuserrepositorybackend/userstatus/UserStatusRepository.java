package com.me.storyhubuserrepositorybackend.userstatus;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserStatusRepository extends CrudRepository<UserStatusEntity, Long> {
    Optional<UserStatusEntity> findByCode(String code);
}
