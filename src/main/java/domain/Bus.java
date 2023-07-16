package domain;

import base.domain.BaseEntity;
import domain.enumeration.BusType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Bus extends BaseEntity {
    int capacity;
    int busNumber;
    @Enumerated(value = EnumType.STRING)
    BusType busType;
}
