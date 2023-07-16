package domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Costumer extends Person {
}
