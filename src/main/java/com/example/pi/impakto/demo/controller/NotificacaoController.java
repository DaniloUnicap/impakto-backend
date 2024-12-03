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

import com.example.pi.impakto.demo.exception.NotificacaoNotFoundException;
import com.example.pi.impakto.demo.model.Usuario;
import com.example.pi.impakto.demo.service.NotificacaoService;

import lombok.AllArgsConstructor;

import com.example.pi.impakto.demo.controller.openAPI.NotificacaoControllerOpenAPI;
import com.example.pi.impakto.demo.dto.notificacao.GetNotificacaoDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoInsertDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoListDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoUpdateDTO;


@RestController
@RequestMapping(value = "/api/notificacao")
@AllArgsConstructor
public class NotificacaoController implements NotificacaoControllerOpenAPI{
    
    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/add") 
    public void insertNotificacao(@RequestBody NotificacaoInsertDTO notificacao){
        notificacaoService.insertNotificacao(notificacao);
    }

    @GetMapping("/all")
    public List<NotificacaoListDTO> listarTodasNotificacoes(){
        return notificacaoService.getAllNotificacoes(); 
    }

    @GetMapping("/{id}")
    public GetNotificacaoDTO getNotificacaoById(@PathVariable("id") Long id){
            return notificacaoService.getById(id);
    }

    // @DeleteMapping("{titulo}/")
    // public void deleteByTitulo(@PathVariable String titulo){
    //     try {
    //         notificacaoService.deleteByTitulo(titulo);
    //     } catch(NotificacaoNotFoundException e){
    //         throw new RuntimeException(e.getMessage()); 
    //     }
    // }

    @DeleteMapping("/{id}")
    public void deteleNotificacao(@PathVariable ("id") Long id){
            notificacaoService.deleteById(id);  
    }

    @PutMapping("/update/{id}")
    public void updateNotificacaoById (@PathVariable("id") Long id, @RequestBody NotificacaoUpdateDTO novaNotificacao) {
            notificacaoService.updateById(id, novaNotificacao);  
    }


    @PutMapping("/update-by-user/{usuario}")
    public void updateNotificacaoByUsuario (@RequestBody Usuario usuario, NotificacaoUpdateDTO novaNotificacao) {
        try {
            notificacaoService.updateByUsuario(usuario, novaNotificacao); 
        } catch (NotificacaoNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
