package com.demo.ms.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long id;
    private String hashCode;
    private String name;
    private String lastname;
    private String address;
    private Double amount;

}
