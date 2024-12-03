package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.model.Notificacao;
import com.example.pi.impakto.demo.model.Usuario;
import com.example.pi.impakto.demo.dto.notificacao.GetNotificacaoDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoInsertDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoListDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoUpdateDTO;

public class NotificacaoDTOConverters {
    
    public static Notificacao NotificacaoInsertDTOModel(NotificacaoInsertDTO notificacaoDTO, Usuario usuario){
        Notificacao notificacaoModel = new Notificacao();
        notificacaoModel.setMensagem(notificacaoDTO.getMensagem());
        notificacaoModel.setTitulo(notificacaoDTO.getTitulo());
        notificacaoModel.setHora(notificacaoDTO.getHora());
        notificacaoModel.setData(notificacaoDTO.getData());
        notificacaoModel.setUsuario(usuario);
          
        return notificacaoModel;
    }

    public static NotificacaoListDTO notificacaoListDTOToModel (Notificacao notificacaoModel){
        NotificacaoListDTO notificacaoDTO = new NotificacaoListDTO();
        notificacaoDTO.setMensagem(notificacaoModel.getMensagem());
        notificacaoDTO.setTitulo(notificacaoModel.getTitulo());
        notificacaoDTO.setHora(notificacaoModel.getHora());
        notificacaoDTO.setData(notificacaoModel.getData());
        notificacaoDTO.setUsuario(notificacaoModel.getUsuario());
        notificacaoDTO.setId(notificacaoModel.getId());

        return notificacaoDTO;
    }

    public static void NotificacaoUpdateDTOToModel(NotificacaoUpdateDTO notificacaoUpdateDTO, Notificacao notificacao, Usuario usuario){
        notificacao.setMensagem(notificacaoUpdateDTO.getMensagem());
        notificacao.setTitulo(notificacaoUpdateDTO.getTitulo());
        notificacao.setHora(notificacaoUpdateDTO.getHora());
        notificacao.setData(notificacaoUpdateDTO.getData());
        notificacao.setUsuario(usuario);
    }

    public static GetNotificacaoDTO getNotificacaoDTOToModel (Notificacao notificacao){
        GetNotificacaoDTO notificacaoDTO = new GetNotificacaoDTO();

        notificacaoDTO.setMensagem(notificacao.getMensagem());
        notificacaoDTO.setTitulo(notificacao.getTitulo());
        notificacaoDTO.setHora(notificacao.getHora());
        notificacaoDTO.setData(notificacao.getData());
        notificacaoDTO.setUsuario(notificacao.getUsuario());

        return notificacaoDTO;

    }
}
