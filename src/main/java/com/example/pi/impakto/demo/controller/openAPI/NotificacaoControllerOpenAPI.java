package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pi.impakto.demo.dto.notificacao.GetNotificacaoDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoInsertDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoListDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoUpdateDTO;
import com.example.pi.impakto.demo.model.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Notificação")
public interface NotificacaoControllerOpenAPI {
    @Operation(summary = "Inserir notificação")
    public void insertNotificacao(NotificacaoInsertDTO notificacao);

    @Operation(summary = "Listar todas notificações")
    public List<NotificacaoListDTO> listarTodasNotificacoes();

    @Operation(summary = "Pegar notificação pelo id")
    public GetNotificacaoDTO getNotificacaoById(@PathVariable("id") Long id);

    @Operation(summary = "Deletar notificação pelo id")
    public void deteleNotificacao(@PathVariable ("id") Long id);

    @Operation(summary = "Atualizar notificação pelo id")
    public void updateNotificacaoById (@PathVariable("id") Long id, @RequestBody NotificacaoUpdateDTO novaNotificacao);

    @Operation(summary = "Atualizar notificação por usuário")
    public void updateNotificacaoByUsuario (@RequestBody Usuario usuario, NotificacaoUpdateDTO novaNotificacao);


}
