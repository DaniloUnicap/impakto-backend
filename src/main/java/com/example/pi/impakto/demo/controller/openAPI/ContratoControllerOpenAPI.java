package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pi.impakto.demo.dto.contrato.ContratoInsertDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoListDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoUpdateDTO;
import com.example.pi.impakto.demo.dto.contrato.GetContratoDTO;
import com.example.pi.impakto.demo.exception.ContratoNotFoundException;
import com.example.pi.impakto.demo.model.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Contrato")
public interface ContratoControllerOpenAPI {
    @Operation(summary = "Inserir contrato")
    public void inserContrato(ContratoInsertDTO contrato);

    @Operation(summary = "Listar todos os contratos")
    public List<ContratoListDTO> listAllContratosHandler();

    @Operation(summary = "Pegar contrato pelo id")
    public GetContratoDTO getContratoById(Long id) throws ContratoNotFoundException;

    @Operation(summary = "Atualizar contrato")
    public void updateOutdoorById(@PathVariable("id") Long id, @RequestBody ContratoUpdateDTO novoContrato);

    @Operation(summary = "Deletar contrato pelo ID")
    public void deteleContrato(Long id);

    // @Operation(summary = "Atualizar contrato por cliente")
    // public void updateOutdoorByCliente(Cliente cliente, ContratoUpdateDTO novoContrato);

    @Operation(summary = "Pegar contrato por cliente")
    public GetContratoDTO getContratoByCliente(@RequestBody Cliente cliente);

}
