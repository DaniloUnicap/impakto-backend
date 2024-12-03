package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import com.example.pi.impakto.demo.dto.usuario.GetUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.ListUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.UpdateUsuarioDTO;
import com.example.pi.impakto.demo.exception.UsuarioNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuário")
public interface UsuarioControllerOpenAPI {
    @Operation(summary = "Listar todos os usuários")
    public List<ListUsuarioDTO> getAllUsuarios();

    @Operation(summary = "Pegar usuário pelo id")
    public GetUsuarioDTO getUsuarioById(Long id) throws UsuarioNotFoundException;

    @Operation(summary = "Atualizar usuário pelo id")
    public void updateUsuario(Long id, UpdateUsuarioDTO usuarioDetails);

    @Operation(summary = "Deletar usuário pelo id")
    public void deleteUsuario(Long id);

}
