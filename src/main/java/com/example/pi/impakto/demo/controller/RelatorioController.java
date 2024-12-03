package com.example.pi.impakto.demo.controller;

import com.example.pi.impakto.demo.controller.openAPI.RelatorioControllerOpenAPI;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioDetailDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioInsertDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioListDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioUpdateDTO;
import com.example.pi.impakto.demo.exception.ResourceNotFoundException;
import com.example.pi.impakto.demo.service.RelatorioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController implements RelatorioControllerOpenAPI{

  @Autowired
  private RelatorioService relatorioService;

  // Criar um novo Relatório
  @PostMapping("/add")
  public ResponseEntity<RelatorioDetailDTO> createRelatorio(
    @RequestBody RelatorioInsertDTO relatorioInsertDTO
  ) {
    RelatorioDetailDTO createdRelatorio = relatorioService.createRelatorio(
      relatorioInsertDTO
    );
    return new ResponseEntity<>(createdRelatorio, HttpStatus.CREATED);
  }

  // Obter um Relatório por ID com detalhes
  @GetMapping("/{id}")
  public ResponseEntity<RelatorioDetailDTO> getRelatorioById(
    @PathVariable Long id
  ) {
      RelatorioDetailDTO relatorio = relatorioService.getRelatorioById(id);
      return ResponseEntity.ok(relatorio);
    
  }

  // Obter todos os Relatórios (listagem simples)
  @GetMapping("/all")
  public List<RelatorioListDTO> getAllRelatorios() {
    return relatorioService.getAllRelatorios();
  }

  // Atualizar um Relatório por ID
  @PutMapping("/update/{id}")
  public ResponseEntity<RelatorioDetailDTO> updateRelatorio(
    @PathVariable Long id,
    @RequestBody RelatorioUpdateDTO relatorioUpdateDTO
  ) {
    try {
      RelatorioDetailDTO updatedRelatorio = relatorioService.updateRelatorio(
        id,
        relatorioUpdateDTO
      );
      return ResponseEntity.ok(updatedRelatorio);
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  // Deletar um Relatório por ID
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteRelatorio(@PathVariable Long id) {
      relatorioService.deleteRelatorio(id);
      return ResponseEntity.noContent().build();
  }
}
