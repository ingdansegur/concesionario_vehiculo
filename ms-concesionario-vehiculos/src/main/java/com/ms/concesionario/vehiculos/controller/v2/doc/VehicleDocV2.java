package com.ms.concesionario.vehiculos.controller.v2.doc;

import com.ms.concesionario.vehiculos.dto.VehicleDTO;
import com.ms.concesionario.vehiculos.model.VehicleEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Vehicle", description = "API expuesta para la manipulacion de vehiculos")
@RequestMapping("/api/v2/vehicle")
public interface VehicleDocV2 {

    @Operation(summary = "Crear vehiculo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                    description = "Vehiculo creado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "400",
                            description = "Error al crear vehiculo", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @PostMapping
    public ResponseEntity<VehicleEntity> create(@RequestBody @Validated VehicleDTO vehicleDTO);
}
