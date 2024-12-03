package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import com.example.pi.impakto.demo.dto.agendamento.AgendamentoInsertDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoListDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoUpdateDTO;
import com.example.pi.impakto.demo.exception.AgendamentoNotFoundException;
import com.example.pi.impakto.demo.model.Agendamento;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Agendamento")
public interface AgendamentoControllerOpenAPI {
    @Operation(summary = "Inserir agendamento")
    Agendamento insertAgendamento(AgendamentoInsertDTO agendamentoDTO);

    @Operation(summary = "Listar todos agendamentos")
    List<AgendamentoListDTO> listAgendamentos();

    @Operation(summary = "Pegar agendamento pelo id")
    AgendamentoListDTO getAgendamentoById(Long id) throws AgendamentoNotFoundException;

    @Operation(summary = "Atualizar agendamento")
    Agendamento update(Long id, AgendamentoUpdateDTO agendamentoAtualizado) throws AgendamentoNotFoundException;

    @Operation(summary = "Deletar agendamento pelo ID")
    void deleteAgendamentoById(Long id) throws AgendamentoNotFoundException;

}
