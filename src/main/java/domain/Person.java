package domain;

import base.domain.BaseEntity;
import domain.enumeration.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {
    String FirstName;
    String lastName;
    String nationalCode;
    String mobileNumber;
    @Column(unique = true)
    String userName;
    String password;
    @ManyToMany
    @JoinTable(name = "person-roles" ,joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "role-id")})
    Set<Role> roles = new HashSet<>();
}
