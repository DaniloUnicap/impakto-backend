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

import com.example.pi.impakto.demo.controller.openAPI.AgendamentoControllerOpenAPI;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoInsertDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoListDTO;
import com.example.pi.impakto.demo.dto.agendamento.AgendamentoUpdateDTO;
import com.example.pi.impakto.demo.exception.AgendamentoNotFoundException;
import com.example.pi.impakto.demo.model.Agendamento;
import com.example.pi.impakto.demo.service.AgendamentoService;

 
@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController implements AgendamentoControllerOpenAPI{
    @Autowired
    public AgendamentoService agendamentoService;
 
    @PostMapping(value = "/add")
    public Agendamento insertAgendamento(@RequestBody AgendamentoInsertDTO agendamentoDTO) {
        return agendamentoService.insertAgendamento(agendamentoDTO);
    }
 
    @GetMapping(value = "/all")
    public List<AgendamentoListDTO> listAgendamentos() {
        return agendamentoService.listAgendamentos();
    }
 
    @GetMapping(value = "/{id}")
    public AgendamentoListDTO getAgendamentoById(@PathVariable Long id) throws AgendamentoNotFoundException {
        return agendamentoService.findAgendamentoById(id);
    }
   
    @PutMapping("/update/{id}")
    public Agendamento update(@PathVariable Long id, @RequestBody AgendamentoUpdateDTO agendamentoAtualizado) throws AgendamentoNotFoundException {
        return agendamentoService.updateAgendamentoById(id, agendamentoAtualizado);
    }
 
    @DeleteMapping("/{id}")
    public void deleteAgendamentoById(@PathVariable ("id") Long id) throws AgendamentoNotFoundException{
        agendamentoService.deleteAgendamentoById(id);
    }
}