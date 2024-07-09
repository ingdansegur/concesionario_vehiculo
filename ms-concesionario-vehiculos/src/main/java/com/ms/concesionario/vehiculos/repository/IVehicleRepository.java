package com.ms.concesionario.vehiculos.repository;

import com.ms.concesionario.vehiculos.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository<VehicleEntity,String> {
}
