package com.murad.online1.db.entity;

import com.murad.online1.model.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    String surname;
    String username;
    String password;

    @Enumerated(EnumType.STRING)
    Gender gender;

}
