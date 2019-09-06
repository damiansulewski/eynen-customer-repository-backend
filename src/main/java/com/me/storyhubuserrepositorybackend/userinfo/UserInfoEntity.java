package com.me.storyhubuserrepositorybackend.userinfo;

import com.me.storyhubuserrepositorybackend.address.AddressEntity;
import com.me.storyhubuserrepositorybackend.audit.AuditedEntity;
import com.me.storyhubuserrepositorybackend.gender.GenderEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_info")
public class UserInfoEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_generator")
    @SequenceGenerator(name = "user_info_generator", sequenceName = "user_info_id_seq", allocationSize = 1)
    private Long id;

    private String email;
    private String name;
    private String surname;

    @ManyToOne
    private GenderEntity gender;

    @OneToOne(cascade = CascadeType.PERSIST)
    private AddressEntity address;

    public UserInfoEntity(String email, String name, String surname, GenderEntity gender) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }
}
