package com.ms.concesionario.vehiculos.service.impl;

import com.ms.concesionario.vehiculos.dto.VehicleDTO;
import com.ms.concesionario.vehiculos.model.VehicleEntity;
import com.ms.concesionario.vehiculos.repository.IVehicleRepository;
import com.ms.concesionario.vehiculos.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    private  final IVehicleRepository vehicleRepository;

    @Override
    public ResponseEntity<VehicleEntity> save(VehicleDTO vehicleDTO){
        String uuid = UUID.randomUUID().toString();
        VehicleEntity vehicle = VehicleEntity
                .builder()
                .id(uuid)
                .brand(vehicleDTO.getBrand())
                .model(vehicleDTO.getModel())
                .reference(vehicleDTO.getReference())
                .stock(vehicleDTO.getStock())
                .status(true)
                .build();
        var newUser = this.vehicleRepository.save(vehicle);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newUser);
    }

    @Override
    public ResponseEntity<VehicleEntity> edit(VehicleDTO vehicleDTO, String uuid) {
        Optional<VehicleEntity> oldVehicle = vehicleRepository.findById(uuid);
        if(oldVehicle.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        VehicleEntity vehicle = VehicleEntity
                .builder()
                .id(uuid)
                .brand(vehicleDTO.getBrand())
                .model(vehicleDTO.getModel())
                .reference(vehicleDTO.getReference())
                .stock(vehicleDTO.getStock())
                .status(true)
                .build();
        var newVehicle = this.vehicleRepository.save(vehicle);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newVehicle);
    }

    @Override
    public ResponseEntity<?> delete(String uuid) {
        Optional<VehicleEntity> deleteVehicle = vehicleRepository.findById(uuid);
        if(deleteVehicle.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        vehicleRepository.delete(deleteVehicle.get());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    @Override
    public ResponseEntity<VehicleEntity> changeStatus(boolean status, String uuid) {
        Optional<VehicleEntity> editVehicle = vehicleRepository.findById(uuid);
        if(editVehicle.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        VehicleEntity vehicle = editVehicle.get();
        vehicle.setStatus(status);
        var newVehicle = this.vehicleRepository.save(vehicle);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newVehicle);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<VehicleEntity> listVehicles = vehicleRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listVehicles);
    }
}
