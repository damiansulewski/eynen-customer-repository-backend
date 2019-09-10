package com.me.storyhubuserrepositorybackend.phonecountry;

import com.me.storyhubuserrepositorybackend.country.CountryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "dictionary", name = "phone_country")
public class PhoneCountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_country_generator")
    @SequenceGenerator(name = "phone_country_generator", sequenceName = "phone_country_id_seq", allocationSize = 1)
    private Long id;

    private String code;
    private String diallingCode;

    @ManyToOne
    private CountryEntity country;
}
