package com.me.storyhubuserrepositorybackend.address;

import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import com.me.storyhubuserrepositorybackend.country.CountryEntity;
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
@Table(name = "address")
public class AddressEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "address_generator")
    @SequenceGenerator(name = "address_generator", sequenceName = "address_id_seq", allocationSize = 1)
    private Long id;

    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;

    @ManyToOne
    private CountryEntity country;

    AddressEntity(String street, String houseNumber, String apartmentNumber, String postCode, String city, CountryEntity country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }
}
