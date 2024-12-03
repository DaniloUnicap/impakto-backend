package com.example.pi.impakto.demo.service;

import com.example.pi.impakto.demo.exception.UsuarioNotFoundException;
import com.example.pi.impakto.demo.model.Usuario;
import com.example.pi.impakto.demo.repository.UsuarioRepository;
import com.example.pi.impakto.demo.dto.usuario.GetUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.ListUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.RegisterDTO;
import com.example.pi.impakto.demo.dto.usuario.UpdateUsuarioDTO;
import com.example.pi.impakto.demo.service.converters.UsuarioDTOConverters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

   
    public void insertUsuario (RegisterDTO usuarioDTO) {
        Usuario usuarioModel = UsuarioDTOConverters.insertUsuarioDTOToModel(usuarioDTO);
        usuarioRepository.save(usuarioModel);
    }
  
    
    // public Usuario loginUsuario(String nomeUsuario, String senha) {
    //     Optional<Usuario> usuarioOpt = usuarioRepository.findByNomeUsuario(nomeUsuario);
    //     if (usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha)) {
    //         return usuarioOpt.get();
    //     } else {
    //         throw new UsuarioNotFoundException("Usuário ou senha incorretos.");
    //     }
    // }

    
    public List<ListUsuarioDTO> listUsuario(){
        List<ListUsuarioDTO> usuariosDTO = new ArrayList<>(); 
        List<Usuario> usuariosModel = usuarioRepository.findAll(); 
        
        for(int i=0; i<usuariosModel.size(); i++){
            Usuario usuarioModel = usuariosModel.get(i); 
            ListUsuarioDTO usuarioDTO = UsuarioDTOConverters.listUsuariDTOToModel(usuarioModel); 
            usuariosDTO.add(usuarioDTO); 
        }

        return usuariosDTO; 
    }

    
    public GetUsuarioDTO getUsuarioById(Long idUsuario) throws UsuarioNotFoundException{
        Optional<Usuario> opUser = usuarioRepository.findById(idUsuario);

        if(opUser.isEmpty()){
            throw new UsuarioNotFoundException("Usuário não encontrado");
        }

        return UsuarioDTOConverters.getUsuarioDTOToModel(opUser.get());
    }

  
    public Usuario updateUsuarioById(Long idUsuario, UpdateUsuarioDTO usuarioDetails) throws UsuarioNotFoundException {
        Optional<Usuario> opUser = usuarioRepository.findById(idUsuario);
        
        if (opUser.isEmpty()) {
            throw new UsuarioNotFoundException("Usuário não encontrado");
        }
  
        Usuario usuario = opUser.get();

        UsuarioDTOConverters.usuarioUpdateDTOToModel(usuarioDetails, usuario);

        return usuarioRepository.save(usuario); 
    }

   
    public void deleteUsuario(Long idUsuario) {
        Optional<Usuario> opUser = usuarioRepository.findById(idUsuario);

        if (opUser.isEmpty()) {
            throw new UsuarioNotFoundException("Usuário não encontrado");
        }
  
        Usuario usuario = opUser.get();
        usuarioRepository.delete(usuario);
    }

    // public Usuario findByNomeUsuario(String nomeUsuario) throws UsuarioNotFoundException{
    //     Optional<Usuario> opUsuario = usuarioRepository.findByNomeUsuario(nomeUsuario); 

    //     if(opUsuario.isEmpty()){
    //         throw new UsuarioNotFoundException("Usuário não encontrado."); 
    //     }

    //     Usuario usuario = opUsuario.get(); 
    //     return usuario; 
    // }


}