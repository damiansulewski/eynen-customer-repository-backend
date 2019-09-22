package com.me.storyhubuserrepositorybackend.gender;

import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@Audited
@Entity
@NoArgsConstructor
@Table(schema = "dictionary", name = "gender")
public class GenderEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gender_generator")
    @SequenceGenerator(name = "gender_generator", sequenceName = "gender_id_seq", allocationSize = 1)
    private Long id;

    private String code;
}
