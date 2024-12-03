package com.example.pi.impakto.demo.dto.cliente;

public class ClienteInsertDTO {

    // private List<Contrato> listaContratos; 
    private String nome; 
    private String numeroContato; 
    private String cpfCliente; 
    private String emailCliente; 
    private String cnpjCliente; 


    // public List<Contrato> getListaContratos() {
    //     return listaContratos;
    // }

    // public void setListaContratos(List<Contrato> listaContratos) {
    //     this.listaContratos = listaContratos;
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroContato() {
        return numeroContato;
    }
    
    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }
    
}
