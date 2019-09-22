package com.me.storyhubuserrepositorybackend.country;

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
@Table(schema = "dictionary", name = "country")
public class CountryEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "country_generator")
    @SequenceGenerator(name = "country_generator", sequenceName = "country_id_seq", allocationSize = 1)
    private Long id;

    private String code;
}
