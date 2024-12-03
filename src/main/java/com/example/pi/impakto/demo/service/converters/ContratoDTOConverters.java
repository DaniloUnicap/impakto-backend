package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.dto.contrato.ContratoInsertDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoListDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoUpdateDTO;
import com.example.pi.impakto.demo.dto.contrato.GetContratoDTO;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Contrato;
import com.example.pi.impakto.demo.model.Outdoor;

public class ContratoDTOConverters {
    
    public static Contrato ContratoInsertDTOModel(ContratoInsertDTO contratoDTO, Cliente cliente, Outdoor outdoor){
        Contrato contratoModel = new Contrato();
        contratoModel.setCliente(cliente);
        contratoModel.setOutdoor(outdoor);
        contratoModel.setData(contratoDTO.getData());
        contratoModel.setAssinaturaDigital(contratoDTO.getAssinaturaDigital());
        contratoModel.setPrazo(contratoDTO.getPrazo());
        return contratoModel;
    }

    public static ContratoListDTO contratoListDTOToModel (Contrato contratoModel){
        ContratoListDTO contratoDTO = new ContratoListDTO();
        contratoDTO.setCliente(contratoModel.getCliente());
        contratoDTO.setOutdoor(contratoModel.getOutdoor());
        contratoDTO.setData(contratoModel.getData());
        contratoDTO.setAssinaturaDigital(contratoDTO.getAssinaturaDigital());
        contratoDTO.setPrazo(contratoModel.getPrazo());
        contratoDTO.setId(contratoModel.getId());

        return contratoDTO;
    }

    public static void ContratoUpdateDTOToModel(ContratoUpdateDTO contratoUpdateDTO, Contrato contrato, Cliente cliente, Outdoor outdoor){
        contrato.setCliente(cliente);
        contrato.setOutdoor(outdoor);
        contrato.setData(contratoUpdateDTO.getData());
        contrato.setAssinaturaDigital(contratoUpdateDTO.getAssinaturaDigital());
        contrato.setPrazo(contratoUpdateDTO.getPrazo());
    }

    public static GetContratoDTO getContratoDTOToModel (Contrato contrato){
        GetContratoDTO contratoDTO = new GetContratoDTO();

        contratoDTO.setCliente(contrato.getCliente());
        contratoDTO.setOutdoor(contrato.getOutdoor());
        contratoDTO.setData(contrato.getData());
        contratoDTO.setAssinaturaDigital(contrato.getAssinaturaDigital());
        contratoDTO.setPrazo(contrato.getPrazo());

        return contratoDTO;

    }
}
