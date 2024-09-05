package com.team1.agenda.controller;
import com.team1.contato.model.Contato;
import com.team1.contato.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Contato> listaDeContato = new ArrayList<>();

    public  List<Contato> getListaDeContatos() {
        return listaDeContato;
    }

    public void adicionarNaAgenda(Contato contato){
        try{
            if(contato == null) throw new Exception("Impossível adicionar um contato vazio");
            else this.listaDeContato.add(contato);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public  void removerDaAgenda(String telefone){
        listaDeContato.removeIf(contato -> contato.getTelefone().equals(telefone));
    }

    public void editarContato(String telefone, String novoNome, String novoTelefone, String novoEmail) {
        telefone = telefone.replaceAll("\\D", "");

        try{
            if(!Utils.verificarTelefoneJaInserido(telefone)){
                throw new Exception ("Contato não encontrado: Telefone inválido");

            } else{
                if(novoNome.isEmpty() && novoTelefone.isEmpty() && novoEmail.isEmpty()){
                    throw new Exception ("Contato não foi editado: Nenhum novo dado foi passado.");
                }

                if(!novoNome.isEmpty()){
                    listaDeContato.get(getIdContato(telefone)).setNome(novoNome);
                }

                if(!novoTelefone.isEmpty()){
                    novoTelefone = novoTelefone.replaceAll("\\D", "");
                    if(Utils.verificarTelefoneValido(telefone)){
                        listaDeContato.get(getIdContato(telefone)).setTelefone(novoTelefone);
                    }
                }

                if(!novoEmail.isEmpty()){
                    listaDeContato.get(getIdContato(telefone)).setEmail(novoEmail);
                }
            }

        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public Contato getContato(int id){
        return listaDeContato.get(id);
    }

    public int getIdContato(String telefone){
        int id = -1;
        for(Contato contato : listaDeContato){
            if(contato.getTelefone().equals(telefone)){
                id = contato.getId() - 1;
            }
        }
        return id;
    }

    public boolean verificarTelefoneJaInserido(String telefone){
        boolean resultado = false;

        for (Contato contato : this.listaDeContato) {
            if (contato.getTelefone().equals(telefone)) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }
}


