package com.example.pi.impakto.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import com.example.pi.impakto.demo.dto.cliente.ClienteInsertDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteListDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteUpdateDTO;
import com.example.pi.impakto.demo.dto.cliente.GetClienteDTO;
import com.example.pi.impakto.demo.exception.ClienteNotFoundException;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.repository.ClienteRepository;
import com.example.pi.impakto.demo.service.converters.ClienteDTOConverters;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository; 

    //usando dto 
    public void insertCliente(ClienteInsertDTO clienteDTO){
        Cliente clienteModel = ClienteDTOConverters.clienteInsertDTOToModel(clienteDTO);
        clienteRepository.save(clienteModel);  
    }

    public void deleteById(Long id) throws ClienteNotFoundException{
        Optional<Cliente> opCliente = clienteRepository.findById(id);

        if (opCliente.isEmpty()) {
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
        Cliente cliente = opCliente.get();
        clienteRepository.delete(cliente);
    }

    //usando dto 
    public List<ClienteListDTO> listClientes(){
        List<ClienteListDTO> clientesDTO = new ArrayList<>(); 
        List<Cliente> clientesModel = clienteRepository.findAll(); 
        
        for(int i=0; i<clientesModel.size(); i++){
            Cliente clienteModel = clientesModel.get(i); 
            ClienteListDTO clienteDTO = ClienteDTOConverters.clienteListDTOToModel(clienteModel); 
            clientesDTO.add(clienteDTO); 
        }

        return clientesDTO; 
    }

    public GetClienteDTO getById(Long id) throws ClienteNotFoundException{
        Optional <Cliente> opCliente = clienteRepository.findById(id);
 
        if(opCliente.isEmpty()){
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
         return ClienteDTOConverters.getClienteDTOToModel(opCliente.get());
    }


    public void updateById(Long idCliente, ClienteUpdateDTO clienteAtualizado) throws ClienteNotFoundException{
        Optional<Cliente> opCliente = clienteRepository.findById(idCliente);
 
        if (opCliente.isEmpty()) {
            throw new ClienteNotFoundException("Cliente não encontrado.");
        }
 
        Cliente cliente = opCliente.get();

        ClienteDTOConverters.clienteUpdateDTOToModel(clienteAtualizado, cliente);
        
        clienteRepository.save(cliente);  
    }

    public void updateByNome(String nomeCliente, ClienteUpdateDTO clienteAtualizado) throws ClienteNotFoundException{
        Optional<Cliente> opCliente = clienteRepository.findByNome(nomeCliente);
 
        if (opCliente.isEmpty()) {
            throw new ClienteNotFoundException("Cliente não encontrado.");
        }
 
        Cliente cliente = opCliente.get();

        ClienteDTOConverters.clienteUpdateDTOToModel(clienteAtualizado, cliente);

        clienteRepository.save(cliente); 
    }

    public Cliente findByNome(String nome) throws ClienteNotFoundException{
        Optional<Cliente> opCliente = clienteRepository.findByNome(nome);

        if(opCliente.isEmpty()){
            throw new ClienteNotFoundException("Cliente não encontrado");
        }

        Cliente cliente = opCliente.get();
        return cliente;
    }

}
