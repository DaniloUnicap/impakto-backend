package com.example.pi.impakto.demo.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.pi.impakto.demo.model.Enum.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data; 

@Data
@Entity
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column
    private String nomeUsuario;
    @Column
    private String resposabilidadeDoDia;
    @Column
    private String cargo;
    @Column
    private String senha;

    private UserRole role; 

    public Usuario(String nomeUsuario, String senha, UserRole role) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.role = role;
    }

    public Usuario() {

    }

    @ManyToOne
    @JoinColumn(name = "relatorio_id")
    @JsonIgnore
    private Relatorio relatorio; 


    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Notificacao> listaNotificacoes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
    } 
}
