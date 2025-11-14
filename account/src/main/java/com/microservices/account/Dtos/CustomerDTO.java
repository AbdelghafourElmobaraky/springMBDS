package com.microservices.account.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}