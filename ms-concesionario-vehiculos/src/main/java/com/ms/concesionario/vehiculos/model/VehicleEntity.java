package com.ms.concesionario.vehiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="vehicle")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VehicleEntity {

    @Id
    private String id;
    private String brand;
    private String reference;
    private String model;
    private boolean status;
    private Long stock;

}
