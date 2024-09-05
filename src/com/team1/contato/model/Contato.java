package com.team1.contato.model;

import com.team1.sms.controller.Sms;

import java.util.ArrayList;
import java.util.List;

public class Contato {
    private final int id;
    private String nome;
    private String telefone;
    private String email;
    private final List<Sms> listaDeSms;
    private static final List<Contato> listaContatos = new ArrayList<>();

    public Contato(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.listaDeSms = new ArrayList<>();
        listaContatos.add(this);
    }

    public static List<Contato> getListaContatos() { return listaContatos; }

    public  List<Sms> getListaDeSms() {
        return listaDeSms;
    }

    public void adicionarSmsNaLista(Sms sms){
        listaDeSms.add(sms);
    }

    public int getId(){ return id; }

    public String getNome() { return nome;}

    public String getTelefone() { return telefone;}

    public String getEmail() { return email;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
