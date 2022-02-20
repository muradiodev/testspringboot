package com.murad.online1.client.internal;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeLogs {

    int id;
    int employeeId;
    LocalDateTime logTime;

}
