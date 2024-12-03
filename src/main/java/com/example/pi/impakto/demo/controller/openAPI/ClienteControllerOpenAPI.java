package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import com.example.pi.impakto.demo.dto.cliente.ClienteInsertDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteListDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteUpdateDTO;
import com.example.pi.impakto.demo.dto.cliente.GetClienteDTO;
import com.example.pi.impakto.demo.exception.ClienteNotFoundException;
import com.example.pi.impakto.demo.model.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cliente")
public interface ClienteControllerOpenAPI {
    @Operation(summary = "Listar todos clientes")
    public List<ClienteListDTO> listAllClientesHandler();

    @Operation(summary = "Pegar cliente pelo id")
    public GetClienteDTO getClienteById(Long id) throws ClienteNotFoundException;

    @Operation(summary = "Inserir cliente")
    public void inserCliente(ClienteInsertDTO cliente);

    @Operation(summary = "Deletar cliente pelo id")
    public void deteleCliente(Long id);

    @Operation(summary = "Atualizar cliente pelo id")
    public void updateClienteById(Long id, ClienteUpdateDTO clienteAtualizado);

    // @Operation(summary = "Atualizar cliente pelo nome")
    // public void updateClienteByNome(String nomeCliente, ClienteUpdateDTO clienteAtualizado) throws ClienteNotFoundException;


    @Operation(summary = "Pegar cliente pelo nome")
    public Cliente getClienteByNome(String nome) throws ClienteNotFoundException;

}
