package com.ms.concesionario.vehiculos.controller.v1;

import com.ms.concesionario.vehiculos.dto.VehicleDTO;
import com.ms.concesionario.vehiculos.model.VehicleEntity;
import com.ms.concesionario.vehiculos.service.IVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vehicle")
public class VehicleControllerV1 {

    private final IVehicleService vehicleService;

    public VehicleControllerV1(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleEntity> create(@RequestBody @Validated VehicleDTO vehicleDTO) {
        return vehicleService.save(vehicleDTO);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<VehicleEntity> edit(@RequestBody @Validated VehicleDTO vehicleDTO,@PathVariable("uuid") String uuid) {
        return this.vehicleService.edit(vehicleDTO,uuid);
    }

    @DeleteMapping("/{status}/{uuid}")
    public ResponseEntity<?> delete(@PathVariable("status") Boolean status,@PathVariable("uuid") String uuid) {
        return this.vehicleService.changeStatus(status,uuid);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable("uuid") String uuid) {
        return this.vehicleService.delete(uuid);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.vehicleService.getAll());
    }

    @GetMapping
    public ResponseEntity<VehicleDTO> getEstructura(){
        return ResponseEntity.ok(new VehicleDTO());
    }
}
