package domain;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {
    String roleName;
    @ManyToMany(mappedBy = "roles")
    Set<Person> people = new HashSet<>();
    @ManyToMany
    @JoinTable( name = "roles-permission" ,joinColumns = {@JoinColumn(name = "role-id")},
            inverseJoinColumns = {@JoinColumn(name = "permission-id")})
    Set<Permission> permissions = new HashSet<>();
}
