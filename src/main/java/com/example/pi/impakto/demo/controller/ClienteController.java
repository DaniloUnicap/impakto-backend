package com.example.pi.impakto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pi.impakto.demo.controller.openAPI.ClienteControllerOpenAPI;
import com.example.pi.impakto.demo.dto.cliente.ClienteInsertDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteListDTO;
import com.example.pi.impakto.demo.dto.cliente.ClienteUpdateDTO;
import com.example.pi.impakto.demo.dto.cliente.GetClienteDTO;
import com.example.pi.impakto.demo.exception.ClienteNotFoundException;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.service.ClienteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/cliente")
@AllArgsConstructor
public class ClienteController implements ClienteControllerOpenAPI {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<ClienteListDTO> listAllClientesHandler() {
        return clienteService.listClientes();
    }

    @GetMapping("id/{id}")
    public GetClienteDTO getClienteById(@PathVariable("id") Long id) throws ClienteNotFoundException {
        return clienteService.getById(id);
    }

    @PostMapping("/add")
    public void inserCliente(@RequestBody ClienteInsertDTO cliente) {
        clienteService.insertCliente(cliente);
    }

    @DeleteMapping("delete/{id}")
    public void deteleCliente(@PathVariable("id") Long id) {
            clienteService.deleteById(id);   
    }

    @PutMapping("update/{id}")
    public void updateClienteById(@PathVariable("id") Long id, @RequestBody ClienteUpdateDTO clienteAtualizado) {
        try {
            clienteService.updateById(id, clienteAtualizado); // será que é clienteAtualizado mesmo? perguntar a iago
        } catch (ClienteNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // @PutMapping("update/{nome}")
    // public void updateClienteByNome(@RequestBody String nomeCliente,
    // ClienteUpdateDTO clienteAtualizado) throws ClienteNotFoundException{
    // try {
    // clienteService.updateByNome(nomeCliente, clienteAtualizado);
    // } catch (ClienteNotFoundException e) {
    // throw new RuntimeException(e.getMessage());
    // }
    // }

    @GetMapping("{nome}")
    public Cliente getClienteByNome(@PathVariable("id") String nome) throws ClienteNotFoundException {
        try {
            return clienteService.findByNome(nome);
        } catch (ClienteNotFoundException e) {
            return null;
        }
    }
}
