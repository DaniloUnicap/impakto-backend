package com.example.pi.impakto.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pi.impakto.demo.controller.openAPI.ContratoControllerOpenAPI;
import com.example.pi.impakto.demo.dto.contrato.ContratoInsertDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoListDTO;
import com.example.pi.impakto.demo.dto.contrato.ContratoUpdateDTO;
import com.example.pi.impakto.demo.dto.contrato.GetContratoDTO;
import com.example.pi.impakto.demo.exception.ContratoNotFoundException;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.service.ContratoSevice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api/contrato")
@AllArgsConstructor
public class ContratoController implements ContratoControllerOpenAPI{
    
    @Autowired
    private ContratoSevice contratoSevice;

    @GetMapping("/all")
    public List<ContratoListDTO> listAllContratosHandler(){
        return contratoSevice.listContratos();
    }

    @GetMapping("/{id}")
    public GetContratoDTO getContratoById(@PathVariable("id") Long id) throws ContratoNotFoundException{
            return contratoSevice.getById(id);
    }

    @PostMapping("/add")
    public void inserContrato(@RequestBody ContratoInsertDTO contrato) {
        contratoSevice.insertContrato(contrato);
    }
    
    @DeleteMapping("/{id}")
    public void deteleContrato(@PathVariable ("id") Long id){
            contratoSevice.deleteById(id); 
    }

    @GetMapping("/cliente")
    public GetContratoDTO getContratoByCliente(@RequestBody Cliente cliente){
        try {
            return contratoSevice.getByCliente(cliente);
        } catch (ContratoNotFoundException e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public void updateOutdoorById(@PathVariable("id") Long id, @RequestBody ContratoUpdateDTO novoContrato){
            contratoSevice.updateById(id, novoContrato);
    }

    // @PutMapping("/update/{cliente}")
    // public void updateOutdoorByCliente(@RequestBody Cliente cliente, ContratoUpdateDTO novoContrato){
    //     try {
    //         contratoSevice.updateByCliente(cliente, novoContrato);
    //     } catch (ContratoNotFoundException e) {
    //         throw new RuntimeException(e.getMessage());
    //     }
    // }
}
