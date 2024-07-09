package com.ms.concesionario.vehiculos.service;

import com.ms.concesionario.vehiculos.dto.VehicleDTO;
import com.ms.concesionario.vehiculos.model.VehicleEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleService {

    ResponseEntity<VehicleEntity> save(VehicleDTO vehicleDTO);
    ResponseEntity<VehicleEntity> edit(VehicleDTO vehicleDTO, String uuid);
    ResponseEntity<?> delete(String uuid);
    ResponseEntity<VehicleEntity> changeStatus(boolean status, String uuid);
    ResponseEntity<?> getAll();

}
