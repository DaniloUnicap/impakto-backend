package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.dto.agendamento.AgendamentoInsertDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoListDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoUpdateDTO;
import com.example.pi.impakto.demo.model.Agendamento;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Outdoor;

public class AgendamentoDTOConverters {
    public static Agendamento agendamentoInsertDTOToModel(AgendamentoInsertDTO agendamentoDTO, Outdoor outdoor, Cliente cliente) {
        Agendamento agendamentoModel = new Agendamento();
        agendamentoModel.setTitulo(agendamentoDTO.getTitulo());
        agendamentoModel.setOutdoor(outdoor);
        // agendamentoModel.setGeolocalizacaoAgendado(agendamentoDTO.getGeolocalizacaoAgendado());
        agendamentoModel.setCliente(cliente);
        agendamentoModel.setData(agendamentoDTO.getData());
        agendamentoModel.setHora(agendamentoDTO.getHora());
        agendamentoModel.setLocal(agendamentoDTO.getLocal());

        return agendamentoModel;
    }

    public static AgendamentoListDTO agendamentoListModelToDTO(Agendamento agendamentoModel) {
        AgendamentoListDTO agendamentoDTO = new AgendamentoListDTO();
        agendamentoDTO.setTitulo(agendamentoModel.getTitulo());
        agendamentoDTO.setOutdoor(agendamentoModel.getOutdoor());
        // agendamentoDTO.setGeolocalizacaoAgendado(agendamentoModel.getGeolocalizacaoAgendado());
        agendamentoDTO.setCliente(agendamentoModel.getCliente());
        agendamentoDTO.setData(agendamentoModel.getData());
        agendamentoDTO.setHora(agendamentoModel.getHora());
        agendamentoDTO.setId(agendamentoModel.getId());

        return agendamentoDTO;
    }

    public static Agendamento agendamentoUpdateDTOToModel(AgendamentoUpdateDTO agendamentoDTO, Cliente cliente, Outdoor outdoor) {
        Agendamento agendamentoModel = new Agendamento();
        agendamentoModel.setTitulo(agendamentoDTO.getTitulo());
        agendamentoModel.setCliente(cliente);
        agendamentoModel.setOutdoor(outdoor);
        agendamentoModel.setData(agendamentoDTO.getData());
        agendamentoModel.setHora(agendamentoDTO.getHora());;

        return agendamentoModel;
    }
}
