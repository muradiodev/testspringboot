package com.murad.online1.model.dto;

import com.murad.online1.db.entity.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    int idEmployee;
    String name;
    String surname;
    String username;
    Address address;

}
