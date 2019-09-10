package com.me.storyhubuserrepositorybackend.userinfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long> {
}
