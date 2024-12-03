package com.example.pi.impakto.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pi.impakto.demo.dto.contrato.ContratoInsertDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoListDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoUpdateDTO;
import com.example.pi.impakto.demo.dto.contrato.GetContratoDTO;
import com.example.pi.impakto.demo.exception.ContratoNotFoundException;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Contrato;
import com.example.pi.impakto.demo.model.Outdoor;
import com.example.pi.impakto.demo.repository.ClienteRepository;
import com.example.pi.impakto.demo.repository.ContratoRepository;
import com.example.pi.impakto.demo.repository.OutdoorRepository;
import com.example.pi.impakto.demo.service.converters.ContratoDTOConverters;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContratoSevice {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private OutdoorRepository outdoorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void insertContrato(ContratoInsertDTO contrato) {
         Outdoor outdoor = outdoorRepository.findById(contrato.getIdOutdoor())
                .orElseThrow(() -> new EntityNotFoundException("Outdoor não encontrado"));

        Cliente cliente = clienteRepository.findById(contrato.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Contrato contratoModel = ContratoDTOConverters.ContratoInsertDTOModel(contrato, cliente, outdoor);
        contratoRepository.save(contratoModel);
    }

    public void deleteById(Long id) throws ContratoNotFoundException {
        Optional<Contrato> opCont = contratoRepository.findById(id);

        if (opCont.isEmpty()) {
            throw new ContratoNotFoundException("Contrato não encontrado");
        }
        Contrato contrato = opCont.get();
        contratoRepository.delete(contrato);
    }

    public List<ContratoListDTO> listContratos() {
        List<ContratoListDTO> contratosDTO = new ArrayList<>();
        List<Contrato> contratosModel = contratoRepository.findAll();

        for (int i = 0; i < contratosModel.size(); i++) {
            Contrato contratoModel = contratosModel.get(i);
            ContratoListDTO contratoDTO = ContratoDTOConverters.contratoListDTOToModel(contratoModel);
            contratosDTO.add(contratoDTO);
        }
        return contratosDTO;
    }

    public GetContratoDTO getById(Long id) throws ContratoNotFoundException {
        Optional<Contrato> opCont = contratoRepository.findById(id);

        if (opCont.isEmpty()) {
            throw new ContratoNotFoundException("Contrato não encontrado");
        }

        Contrato contrato = opCont.get();
        return new GetContratoDTO(
                contrato.getCliente(),
                contrato.getOutdoor(),
                contrato.getData(),
                contrato.getAssinaturaDigital(),
                contrato.getPrazo());
    }

    public GetContratoDTO getByCliente(Cliente cliente) throws ContratoNotFoundException {
        Optional<Contrato> opCont = contratoRepository.findByCliente(cliente);

        if (opCont.isEmpty()) {
            throw new ContratoNotFoundException("Contrato não encontrado");
        }

        Contrato contrato = opCont.get();
        return new GetContratoDTO(
                contrato.getCliente(),
                contrato.getOutdoor(),
                contrato.getData(),
                contrato.getAssinaturaDigital(),
                contrato.getPrazo());
    }

    public void updateById(Long idContrato, ContratoUpdateDTO novoContrato) throws ContratoNotFoundException {
        Outdoor outdoor = outdoorRepository.findById(novoContrato.getIdOutdoor())
                .orElseThrow(() -> new EntityNotFoundException("Outdoor não encontrado"));

        Cliente cliente = clienteRepository.findById(novoContrato.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Optional<Contrato> opCont = contratoRepository.findById(idContrato);

        if (opCont.isEmpty()) {
            throw new ContratoNotFoundException("Contrato não encontrado");
        }
        Contrato contrato = opCont.get();
        ContratoDTOConverters.ContratoUpdateDTOToModel(novoContrato, contrato, cliente, outdoor);
        
        contratoRepository.save(contrato);
    }

    // public void updateByCliente(Cliente cliente, ContratoUpdateDTO novoContrato) throws ContratoNotFoundException {
    //     Optional<Contrato> opCont = contratoRepository.findByCliente(cliente);

    //     if (opCont.isEmpty()) {
    //         throw new ContratoNotFoundException("Contrato não encontrado");
    //     }
    //     Contrato contrato = opCont.get();

    //     ContratoDTOConverters.ContratoUpdateDTOToModel(novoContrato, contrato);
    //     contrato.setOutdoor(novoContrato.getOutdoor());
    //     contrato.setAssinaturaDigital(novoContrato.getAssinaturaDigital());
    //     contrato.setCliente(contrato.getCliente());
    //     contrato.setData(contrato.getData());
    //     contrato.setPrazo(contrato.getPrazo());
    //     contratoRepository.save(contrato);
    // }
}