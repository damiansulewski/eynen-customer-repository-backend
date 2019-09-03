package com.me.storyhubuserrepositorybackend.userstatus;

import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_status")
public class UserStatusEntity extends AuditedEntity {
    @Id
    private Long id;

    private String code;
}
