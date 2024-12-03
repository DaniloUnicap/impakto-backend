package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.model.Usuario;
import com.example.pi.impakto.demo.dto.usuario.GetUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.ListUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.RegisterDTO;
import com.example.pi.impakto.demo.dto.usuario.UpdateUsuarioDTO;

public class UsuarioDTOConverters {
   
    public static GetUsuarioDTO getUsuarioDTOToModel (Usuario usuario){
        GetUsuarioDTO usuarioDTO = new GetUsuarioDTO(); 

        usuarioDTO.setNomeUsuario(usuario.getNomeUsuario());
        usuarioDTO.setResposabilidadeDoDia(usuario.getResposabilidadeDoDia());
        usuarioDTO.setCargo(usuario.getCargo());

        return usuarioDTO; 
    }

     public static Usuario insertUsuarioDTOToModel (RegisterDTO usuarioDTO){
        Usuario usuarioModel = new Usuario(); 
        usuarioModel.setNomeUsuario(usuarioDTO.nomeUsuario());
        usuarioModel.setSenha(usuarioDTO.senha());
        usuarioModel.setRole(usuarioDTO.role());
      
        return usuarioModel; 
     
    }

    public static ListUsuarioDTO listUsuariDTOToModel (Usuario usuarioModel){

        ListUsuarioDTO usuarioDTO = new ListUsuarioDTO();

        usuarioDTO.setNome(usuarioModel.getNomeUsuario());
        usuarioDTO.setResposabilidadeDoDia(usuarioModel.getResposabilidadeDoDia());
        usuarioDTO.setCargo(usuarioModel.getCargo());
        usuarioDTO.setIdUsuario(usuarioModel.getIdUsuario());
        
        return usuarioDTO; 
    }

    public static void usuarioUpdateDTOToModel (UpdateUsuarioDTO usuarioUpdateDTO, Usuario usuario){

        usuario.setCargo(usuarioUpdateDTO.getCargo());
        usuario.setNomeUsuario(usuarioUpdateDTO.getNome());
        usuario.setResposabilidadeDoDia(usuarioUpdateDTO.getResposabilidadeDoDia());

    }

}
