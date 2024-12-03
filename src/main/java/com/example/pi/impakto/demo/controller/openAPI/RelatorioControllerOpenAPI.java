package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pi.impakto.demo.dto.relatorio.RelatorioDetailDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioInsertDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioListDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioUpdateDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Relatório")
public interface RelatorioControllerOpenAPI {
    @Operation(summary = "Inserir relatório")
    public ResponseEntity<RelatorioDetailDTO> createRelatorio(RelatorioInsertDTO relatorioInsertDTO
  );

    @Operation(summary = "Pegar relatório pelo id")
    public ResponseEntity<RelatorioDetailDTO> getRelatorioById(Long id
  );

    @Operation(summary = "Listar todos os relatório")
    public List<RelatorioListDTO> getAllRelatorios();

    @Operation(summary = "Atualizar relatório pelo id")
    public ResponseEntity<RelatorioDetailDTO> updateRelatorio(Long id, RelatorioUpdateDTO relatorioUpdateDTO
  );

    @Operation(summary = "Deletar relatório pelo id")
    public ResponseEntity<Void> deleteRelatorio(@PathVariable Long id);

}
