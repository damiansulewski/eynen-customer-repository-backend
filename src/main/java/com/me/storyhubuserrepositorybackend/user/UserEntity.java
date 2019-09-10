package com.me.storyhubuserrepositorybackend.user;

import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import com.me.storyhubuserrepositorybackend.userinfo.UserInfoEntity;
import com.me.storyhubuserrepositorybackend.userstatus.UserStatusEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class UserEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    private String uuid;
    private String email;
    private String password;
    private LocalDateTime registrationDate;
    private LocalDateTime activationDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private UserInfoEntity userInfo;

    @ManyToOne
    private UserStatusEntity userStatus;

    UserEntity(String email, String password, UserInfoEntity userInfo, UserStatusEntity userStatus) {
        this.uuid = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.userStatus = userStatus;
        this.registrationDate = LocalDateTime.now();
        this.userInfo = userInfo;
    }
}
