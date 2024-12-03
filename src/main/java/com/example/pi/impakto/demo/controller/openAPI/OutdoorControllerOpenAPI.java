package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import com.example.pi.impakto.demo.dto.outdoor.OutdoorInsertDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorListDTO;
import com.example.pi.impakto.demo.model.Outdoor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Outdoor")
public interface OutdoorControllerOpenAPI {
    @Operation(summary = "Inserir outdoor")
    public Outdoor insertOutdoor(OutdoorInsertDTO outdoorDTO);

    @Operation(summary = "Listar todos os outdoors")
    public List<OutdoorListDTO> getOutdoors();

}
