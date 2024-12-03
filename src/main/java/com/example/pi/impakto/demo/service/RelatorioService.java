package com.example.pi.impakto.demo.service;

import com.example.pi.impakto.demo.dto.relatorio.RelatorioDetailDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioInsertDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioListDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioUpdateDTO;
import com.example.pi.impakto.demo.exception.ResourceNotFoundException;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Outdoor;
import com.example.pi.impakto.demo.model.Relatorio;
import com.example.pi.impakto.demo.repository.ClienteRepository;
import com.example.pi.impakto.demo.repository.OutdoorRepository;
import com.example.pi.impakto.demo.repository.RelatorioRepository;
import com.example.pi.impakto.demo.service.converters.RelatorioDTOConverters;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired OutdoorRepository outdoorRepository;

    // Método para criar um novo Relatório
    public RelatorioDetailDTO createRelatorio(RelatorioInsertDTO dto) {
        Outdoor outdoor = outdoorRepository.findById(dto.getOutdoorId())
                .orElseThrow(() -> new EntityNotFoundException("Outdoor não encontrado"));

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Relatorio relatorio = RelatorioDTOConverters.relatorioInsertDTOToModel(dto, cliente, outdoor);
        Relatorio savedRelatorio = relatorioRepository.save(relatorio);
        return RelatorioDTOConverters.toRelatorioDetailDTO(savedRelatorio);
    }

    // Obter um Relatório por ID e retornar detalhes
    public RelatorioDetailDTO getRelatorioById(Long id) {
        Relatorio relatorio = relatorioRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relatório não encontrado"));

        return RelatorioDTOConverters.toRelatorioDetailDTO(relatorio);
    }

    // Obter todos os Relatórios com listagem simplificada
    public List<RelatorioListDTO> getAllRelatorios() {
        return relatorioRepository
                .findAll()
                .stream()
                .map(RelatorioDTOConverters::toRelatorioListDTO)
                .collect(Collectors.toList());
    }

    // Deletar um Relatório por ID
    public void deleteRelatorio(Long id) {
        if (!relatorioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Relatório não encontrado");
        }
        relatorioRepository.deleteById(id);
    }

    // Atualizar um Relatório com base no RelatorioUpdateDTO
    public RelatorioDetailDTO updateRelatorio(Long id, RelatorioUpdateDTO dto) {
        Outdoor outdoor = outdoorRepository.findById(dto.getOutdoorId())
                .orElseThrow(() -> new EntityNotFoundException("Outdoor não encontrado"));

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        Relatorio relatorio = relatorioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relatório não encontrado"));

        RelatorioDTOConverters.relatorioUpdateDTOToModel(dto, relatorio, cliente, outdoor);
        Relatorio updatedRelatorio = relatorioRepository.save(relatorio);
        return RelatorioDTOConverters.toRelatorioDetailDTO(updatedRelatorio);
    }
}

