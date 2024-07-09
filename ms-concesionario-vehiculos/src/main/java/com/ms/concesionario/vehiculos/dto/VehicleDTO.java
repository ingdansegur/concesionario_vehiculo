package com.ms.concesionario.vehiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    @NotBlank
    @NotEmpty
    @Size(min = 5 ,max = 12 ,message = "El largo minimo de la marca es 5 y el maximo 12")
    private String brand;
    @NotBlank
    @NotEmpty
    @Size(min = 5 ,max = 12 ,message = "El largo minimo de la referencia es 5 y el maximo 12")
    private String reference;
    @NotBlank
    @NotEmpty
    @Size(min = 5 ,max = 12 ,message = "El largo minimo del modelo es 5 y el maximo 12")
    private String model;
    @NotBlank(message = "El estado debe estar digilenciado")
    @NotEmpty(message = "El estado debe estar digilenciado")
    private boolean status;
    @NotBlank(message = "La cantidad disponible no debe estar vacio.")
    @NotEmpty(message = "La cantidad disponible no debe estar vacio.")
    @NotNull
    private Long stock;

}
