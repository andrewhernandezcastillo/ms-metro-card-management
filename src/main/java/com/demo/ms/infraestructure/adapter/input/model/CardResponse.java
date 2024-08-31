package com.demo.ms.infraestructure.adapter.input.model;

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
public class CardResponse {

    private String hashCode;
    private String name;
    private Double amount;

}
