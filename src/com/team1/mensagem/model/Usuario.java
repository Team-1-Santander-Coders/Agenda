package com.team1.mensagem.model;

import com.team1.contato.model.Contato;
import com.team1.mensagem.model.Mensagem;
import com.team1.resources.Cores;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Contato {
    private final String senha;
    private final List<Mensagem> mensagensEnviadas;
    private final List<Mensagem> mensagensRecebidas;

    public Usuario(String nome, String telefone, String email, String senha) {
        super(nome, telefone, email);
        this.senha = senha;
        this.mensagensEnviadas = new ArrayList<>();
        this.mensagensRecebidas = new ArrayList<>();
    }

    public String getSenha() {
        return senha;
    }

    public void enviarMensagem(Usuario destinatario, String conteudo) {
        Mensagem mensagem = new Mensagem(this, destinatario, conteudo);
        mensagensEnviadas.add(mensagem);
        destinatario.receberMensagem(mensagem);
    }

    public void receberMensagem(Mensagem mensagem) {
        mensagensRecebidas.add(mensagem);
    }

    public void verEmails() {
        if (!mensagensEnviadas.isEmpty()){
            System.out.println("\nMensagens Enviadas:");
            for (Mensagem mensagem : mensagensEnviadas) {
                System.out.println(mensagem);
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println(Cores.CYAN.colorir("\n Usuário não possui mensagens enviadas.\n"));
        }

        if (!mensagensRecebidas.isEmpty()){
            System.out.println("\nMensagens Recebidas:");
            for (Mensagem mensagem : mensagensRecebidas) {
                System.out.println(mensagem);
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println(Cores.CYAN.colorir("\n Usuário não possui mensagens recebidas.\n"));
        }
    }
}