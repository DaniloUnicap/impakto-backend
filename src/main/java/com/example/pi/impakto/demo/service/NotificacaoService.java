package com.example.pi.impakto.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pi.impakto.demo.exception.NotificacaoNotFoundException;
import com.example.pi.impakto.demo.model.Notificacao;
import com.example.pi.impakto.demo.model.Usuario;
import com.example.pi.impakto.demo.repository.NotificacaoRepository;
import com.example.pi.impakto.demo.repository.UsuarioRepository;
import com.example.pi.impakto.demo.dto.notificacao.GetNotificacaoDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoInsertDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoListDTO;
import com.example.pi.impakto.demo.dto.notificacao.NotificacaoUpdateDTO;
import com.example.pi.impakto.demo.service.converters.NotificacaoDTOConverters;

import jakarta.persistence.EntityNotFoundException;



@Service
public class NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void insertNotificacao (NotificacaoInsertDTO notificacao){
        Usuario usuario = usuarioRepository.findById(notificacao.getIdUsuario())
        .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        
       Notificacao notificacaoModel = NotificacaoDTOConverters.NotificacaoInsertDTOModel(notificacao, usuario);
        notificacaoRepository.save(notificacaoModel);
    }

   public GetNotificacaoDTO getById(Long id) throws NotificacaoNotFoundException{
        Optional<Notificacao> opNotificacao = notificacaoRepository.findById(id);

        if(opNotificacao.isEmpty()){
            throw new NotificacaoNotFoundException("Notificação não encontrada");
        }

        Notificacao notificacao = opNotificacao.get();
        return new GetNotificacaoDTO(
            notificacao.getMensagem(),
            notificacao.getTitulo(),
            notificacao.getHora(),
            notificacao.getData(),
            notificacao.getUsuario()
        );
    }

    // public void deleteByTitulo(String titulo) throws NotificacaoNotFoundException {
    //     Optional<Notificacao> opnotificacao = notificacaoRepository.getByTitulo(titulo); 
    
    //     if (opnotificacao.isEmpty()) {
    //         throw new NotificacaoNotFoundException("Não há notificação com o título");
    //     }
    
    //     Notificacao notificacao = opnotificacao.get(); 
    //     notificacaoRepository.delete(notificacao);
    // }

    public void deleteById(Long id) throws NotificacaoNotFoundException{
        Optional<Notificacao> opNotificacao = notificacaoRepository.findById(id);

        if (opNotificacao.isEmpty()) {
            throw new NotificacaoNotFoundException("Notificação não encontrada");
        }
        Notificacao notificacao = opNotificacao.get();
        notificacaoRepository.delete(notificacao);
    }

    public List<NotificacaoListDTO> getAllNotificacoes() {
        List<NotificacaoListDTO> notificacaosDTO = new ArrayList<>();
        List<Notificacao> notificacaosModel = notificacaoRepository.findAll();

        for(int i = 0; i<notificacaosModel.size(); i++){
            Notificacao notificacaoModel = notificacaosModel.get(i);
            NotificacaoListDTO notificacaoDTO = NotificacaoDTOConverters.notificacaoListDTOToModel(notificacaoModel);
            notificacaosDTO.add(notificacaoDTO);
        }
        return notificacaosDTO;
    }

    public void updateById(Long idNotificacao, NotificacaoUpdateDTO novaNotificacao) throws NotificacaoNotFoundException {
        Usuario usuario = usuarioRepository.findById(novaNotificacao.getIdUsuario())
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    
        Notificacao notificacao = notificacaoRepository.findById(idNotificacao)
            .orElseThrow(() -> new NotificacaoNotFoundException("Notificação não encontrada"));

        NotificacaoDTOConverters.NotificacaoUpdateDTOToModel(novaNotificacao, notificacao, usuario);

        notificacaoRepository.save(notificacao);
    }
   

    public void updateByUsuario(Usuario usuario, NotificacaoUpdateDTO novaNotificacao) throws NotificacaoNotFoundException {
        Notificacao notificacao = notificacaoRepository.findByUsuario(usuario)
            .orElseThrow(() -> new NotificacaoNotFoundException("Não há notificação"));
    
        NotificacaoDTOConverters.NotificacaoUpdateDTOToModel(novaNotificacao, notificacao, usuario);

        notificacaoRepository.save(notificacao);
    }
}    

