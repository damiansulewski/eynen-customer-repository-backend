package com.me.storyhubuserrepositorybackend.contact;

import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import com.me.storyhubuserrepositorybackend.phonecountry.PhoneCountryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "contact")
public class ContactEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_generator")
    @SequenceGenerator(name = "contact_generator", sequenceName = "contact_id_seq", allocationSize = 1)
    private Long id;

    private String phoneNumber;

    @ManyToOne
    private PhoneCountryEntity phoneCountry;

    public ContactEntity(String phoneNumber, PhoneCountryEntity phoneCountry) {
        this.phoneNumber = phoneNumber;
        this.phoneCountry = phoneCountry;
    }
}
