package com.me.storyhubuserrepositorybackend.birth;

import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "birth")
public class BirthEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "birth_generator")
    @SequenceGenerator(name = "birth_generator", sequenceName = "birth_id_seq", allocationSize = 1)
    private Long id;

    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;

    public BirthEntity(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }
}
