package domain;

import base.domain.BaseEntity;
import domain.enumeration.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor

public class Ticket extends BaseEntity {
    City origin;
    City destination;
    @ManyToOne
    Person passenger;
    @Enumerated(value = EnumType.STRING)
    Gender gender;
    LocalDate timeToMove;
//    Clock departureTime;
    Time departureTime;
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long travelId;
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    String ticketId;




}
