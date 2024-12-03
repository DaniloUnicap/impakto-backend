package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.dto.cliente.ClienteInsertDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteListDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteUpdateDTO;
import com.example.pi.impakto.demo.dto.cliente.GetClienteDTO;
import com.example.pi.impakto.demo.model.Cliente;

public class ClienteDTOConverters {

    public static Cliente clienteInsertDTOToModel (ClienteInsertDTO clienteDTO){
        Cliente clienteModel = new Cliente(); 
        clienteModel.setNome(clienteDTO.getNome());
        // clienteModel.setListaContratos(clienteDTO.getListaContratos());
        clienteModel.setNumeroContato(clienteDTO.getNumeroContato());
        clienteModel.setCpfCliente(clienteDTO.getCpfCliente());
        clienteModel.setEmailCliente(clienteDTO.getEmailCliente());
        clienteModel.setCnpjCliente(clienteDTO.getCnpjCliente());

        return clienteModel; 
    }

    public static ClienteListDTO clienteListDTOToModel (Cliente clienteModel){
        ClienteListDTO clienteDTO = new ClienteListDTO();
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setListaContratos(clienteModel.getListaContratos());
        clienteDTO.setNumeroContato(clienteModel.getNumeroContato());
        clienteDTO.setCpfCliente(clienteModel.getCpfCliente());
        clienteDTO.setEmailCliente(clienteModel.getEmailCliente());
        clienteDTO.setCnpjCliente(clienteModel.getCnpjCliente());
        clienteDTO.setIdCliente(clienteModel.getIdCliente());
        
        return clienteDTO; 
    }

    public static void clienteUpdateDTOToModel (ClienteUpdateDTO clienteUpdateDTO, Cliente cliente){

        cliente.setNome(clienteUpdateDTO.getNome());
        cliente.setNumeroContato(clienteUpdateDTO.getNumeroCliente()); 
        cliente.setCpfCliente(clienteUpdateDTO.getCpf());
        cliente.setCnpjCliente(clienteUpdateDTO.getCnpj());
        cliente.setEmailCliente(clienteUpdateDTO.getEmail());
    }

    public static GetClienteDTO getClienteDTOToModel (Cliente cliente){
        GetClienteDTO clienteDTO = new GetClienteDTO(); 

        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setListaContratos(cliente.getListaContratos());
        clienteDTO.setNumeroCliente(cliente.getNumeroContato());
        clienteDTO.setCpf(cliente.getCpfCliente());
        clienteDTO.setEmail(cliente.getEmailCliente());
        clienteDTO.setCnpj(cliente.getCnpjCliente());

        return clienteDTO; 
    }
    
}
