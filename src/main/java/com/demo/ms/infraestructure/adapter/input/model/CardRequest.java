package com.demo.ms.infraestructure.adapter.input.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CardRequest {

    @NotBlank(message = "El campo name no puede estar vacio")
    private String name;
    @NotBlank(message = "El campo name no puede estar vacio")
    private String lastname;
    @NotBlank(message = "El campo name no puede estar vacio")
    private String address;
    @NotNull(message = "Debe ingresar un monto inicial")
    private Double amount;

}
