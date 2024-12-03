package com.example.pi.impakto.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pi.impakto.demo.dto.agendamento.AgendamentoInsertDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoListDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoUpdateDTO;
import com.example.pi.impakto.demo.exception.AgendamentoNotFoundException;

import com.example.pi.impakto.demo.model.Agendamento;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Outdoor;
import com.example.pi.impakto.demo.repository.AgendamentoRepository;
import com.example.pi.impakto.demo.repository.ClienteRepository;
import com.example.pi.impakto.demo.repository.OutdoorRepository;
import com.example.pi.impakto.demo.service.converters.AgendamentoDTOConverters;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private OutdoorRepository outdoorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Agendamento insertAgendamento(AgendamentoInsertDTO agendamentoDTO) {
        Outdoor outdoor = outdoorRepository.findById(agendamentoDTO.getIdOutdoor())
                .orElseThrow(() -> new EntityNotFoundException("Outdoor não encontrado"));

        Cliente cliente = clienteRepository.findById(agendamentoDTO.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Agendamento agendamentoModel = AgendamentoDTOConverters.agendamentoInsertDTOToModel(agendamentoDTO, outdoor,
                cliente);
        return agendamentoRepository.save(agendamentoModel);
    }

    public List<AgendamentoListDTO> listAgendamentos() {
        List<AgendamentoListDTO> agendamentosDTO = new ArrayList<>();
        List<Agendamento> agendamentosModel = agendamentoRepository.findAll();

        for (int i = 0; i < agendamentosModel.size(); i++) {
            Agendamento agendamentoModel = agendamentosModel.get(i);
            AgendamentoListDTO agendamentoDTO = AgendamentoDTOConverters.agendamentoListModelToDTO(agendamentoModel);
            agendamentosDTO.add(agendamentoDTO);
        }

        return agendamentosDTO;
    }

    public AgendamentoListDTO findAgendamentoById(Long id) throws AgendamentoNotFoundException {
        Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(id);

        if (optionalAgendamento.isEmpty()) {
            throw new AgendamentoNotFoundException("Agendamento não econtrado com o id " + id);
        }
        return AgendamentoDTOConverters.agendamentoListModelToDTO(optionalAgendamento.get());
    }

    public Agendamento updateAgendamentoById(Long idAgendamento, AgendamentoUpdateDTO agendamentoDTO)
        throws AgendamentoNotFoundException {

    Agendamento agendamentoExistente = agendamentoRepository.findById(idAgendamento)
            .orElseThrow(() -> new AgendamentoNotFoundException("Agendamento não encontrado."));

    Cliente cliente = null;
    if (agendamentoDTO.getIdCliente() != null) {
        cliente = clienteRepository.findById(agendamentoDTO.getIdCliente())
                .orElseThrow(() -> new AgendamentoNotFoundException("Cliente não encontrado."));
    }

    Outdoor outdoor = null;
    if (agendamentoDTO.getIdOutdoor() != null) {
        outdoor = outdoorRepository.findById(agendamentoDTO.getIdOutdoor())
                .orElseThrow(() -> new AgendamentoNotFoundException("Outdoor não encontrado."));
    }

    // Atualiza apenas os campos não nulos do DTO.
    if (agendamentoDTO.getTitulo() != null) {
        agendamentoExistente.setTitulo(agendamentoDTO.getTitulo());
    }
    if (cliente != null) {
        agendamentoExistente.setCliente(cliente);
    }
    if (outdoor != null) {
        agendamentoExistente.setOutdoor(outdoor);
    }
    if (agendamentoDTO.getData() != null) {
        agendamentoExistente.setData(agendamentoDTO.getData());
    }
    if (agendamentoDTO.getHora() != null) {
        agendamentoExistente.setHora(agendamentoDTO.getHora());
    }

    return agendamentoRepository.save(agendamentoExistente);
}


    public Agendamento findByCliente(Cliente cliente) throws AgendamentoNotFoundException {
        Optional<Agendamento> opCont = agendamentoRepository.findByCliente(cliente);

        if (opCont.isEmpty()) {
            throw new AgendamentoNotFoundException("Agendamento não encontrado");
        }

        Agendamento agendamento = opCont.get();
        return agendamento;
    }

    public void deleteAgendamentoById(Long id) throws AgendamentoNotFoundException {
        if (!agendamentoRepository.existsById(id)) {
            throw new AgendamentoNotFoundException(
                    "O agendamento com o id " + id + " não existe, portanto, não pode ser deletado");
        }
        agendamentoRepository.deleteById(id);
    }

    public Agendamento updateTituloAgendamentoById(Long id, String newTitulo) throws AgendamentoNotFoundException {
        Optional<Agendamento> opAgendamento = agendamentoRepository.findById(id);

        if (opAgendamento.isEmpty()) {
            throw new AgendamentoNotFoundException("Agendamento não encontrado com o id: " + id);
        }

        Agendamento agendamento = opAgendamento.get();
        agendamento.setTitulo(newTitulo);

        return agendamentoRepository.save(agendamento);
    }

}