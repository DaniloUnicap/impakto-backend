package com.example.pi.impakto.demo.controller;

import com.example.pi.impakto.demo.controller.openAPI.UsuarioControllerOpenAPI;
import com.example.pi.impakto.demo.dto.usuario.GetUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.ListUsuarioDTO;
import com.example.pi.impakto.demo.dto.usuario.UpdateUsuarioDTO;
import com.example.pi.impakto.demo.exception.UsuarioNotFoundException;
import com.example.pi.impakto.demo.service.UsuarioService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController implements UsuarioControllerOpenAPI{
 
    @Autowired
    private UsuarioService usuarioService;
  
   
    // @PostMapping("/add")
    // public void insertUsuario(@RequestBody RegisterDTO usuariomodel) {
    //     usuarioService.insertUsuario(usuariomodel);
    // }
  
    @GetMapping("/all")
    public List<ListUsuarioDTO> getAllUsuarios() {
        return usuarioService.listUsuario();
    }
 
    @GetMapping("/{id}")
    public GetUsuarioDTO getUsuarioById(@PathVariable ("id") Long id) throws UsuarioNotFoundException{
            return usuarioService.getUsuarioById(id);
    }
 
  
    @PutMapping("/{id}")
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody UpdateUsuarioDTO usuarioDetails){
        try {
            usuarioService.updateUsuarioById(id, usuarioDetails);
        } catch (UsuarioNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
 
 
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable Long id) {
            usuarioService.deleteUsuario(id);
    }
}
 