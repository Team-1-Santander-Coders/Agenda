package com.team1.mensagem.model;

public class Mensagem {
    private final Usuario remetente;
    private final Usuario destinatario;
    private final String conteudo;

    public Mensagem(Usuario remetente, Usuario destinatario, String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "De: " + remetente.getNome() + " (" + remetente.getEmail() + ")\n" +
                "Para: " + destinatario.getNome() + " (" + destinatario.getEmail() + ")\n" +
                "Mensagem: " + conteudo;
    }
}