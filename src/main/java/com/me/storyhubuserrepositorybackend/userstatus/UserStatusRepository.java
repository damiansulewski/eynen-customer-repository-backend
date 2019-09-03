package com.me.storyhubuserrepositorybackend.userstatus;

import org.springframework.data.repository.CrudRepository;

public interface UserStatusRepository extends CrudRepository<UserStatusEntity, Long> {
    UserStatusEntity findByCode(String code);
}
