package com.me.storyhubuserrepositorybackend.userstatus;

import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_status")
public class UserStatusEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_status_generator")
    @SequenceGenerator(name = "user_status_generator", sequenceName = "user_status_id_seq", allocationSize = 1)
    private Long id;

    private String code;
}
