package com.me.storyhubuserrepositorybackend.userinfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long> {
    Optional<UserInfoEntity> findByEmail(String email);
}
