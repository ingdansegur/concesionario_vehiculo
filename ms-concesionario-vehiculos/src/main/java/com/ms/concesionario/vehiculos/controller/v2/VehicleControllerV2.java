package com.ms.concesionario.vehiculos.controller.v2;

import com.ms.concesionario.vehiculos.controller.v2.doc.VehicleDocV2;
import com.ms.concesionario.vehiculos.dto.VehicleDTO;
import com.ms.concesionario.vehiculos.model.VehicleEntity;
import com.ms.concesionario.vehiculos.repository.IVehicleRepository;
import com.ms.concesionario.vehiculos.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class VehicleControllerV2 implements VehicleDocV2 {

    private final IVehicleService vehicleService;

    @Override
    public ResponseEntity<VehicleEntity> create(VehicleDTO vehicleDTO) {
        return this.vehicleService.save(vehicleDTO);
    }
}
