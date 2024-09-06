package com.team1.contato.model;

import com.team1.contato.controller.ContatoController;

import java.util.ArrayList;
import java.util.List;

public class Contato {
    private final int id;
    private String nome;
    private String telefone;
    private String email;
    private static final List<Contato> listaContatos = new ArrayList<>();

    public Contato(String nome, String telefone, String email) {
        this.id = ContatoController.getId();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        listaContatos.add(this);
    }

    public String getListaContatos() {
        int tamanho = listaContatos.size();
        if (listaContatos.isEmpty()) {
            return "Sem contatos na lista.";
        }

        int maxIdLength = "Id".length();
        int maxNomeLength = "Nome".length();
        int maxTelefoneLength = "Telefone".length();
        int maxEmailLength = "Email".length();

        for (int indiceContato = 0; indiceContato < tamanho; indiceContato++) {
            String telefoneFormatado = formatarTelefone(listaContatos.get(indiceContato).getTelefone());
            maxIdLength = Math.max(maxIdLength, String.valueOf(listaContatos.get(indiceContato).getId()).length());
            maxNomeLength = Math.max(maxNomeLength, listaContatos.get(indiceContato).getNome().length());
            maxTelefoneLength = Math.max(maxTelefoneLength, telefoneFormatado.length());
            maxEmailLength = Math.max(maxEmailLength, listaContatos.get(indiceContato).getEmail().length());
        }

        String header = String.format(
                "| %" + maxIdLength + "s | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                "Id", "Nome", "Telefone", "Email"
        );

        String linha = "+";
        for (int i = 0; i < header.length() - 2; i++) {
            linha += "-";
        }
        linha += "+";

        StringBuilder builder = new StringBuilder();
        builder.append(linha).append("\n");
        builder.append(header).append("\n");
        builder.append(linha).append("\n");

        for (int indiceContato = 0; indiceContato < tamanho; indiceContato++) {
            String telefoneFormatado = formatarTelefone(listaContatos.get(indiceContato).getTelefone());
            builder.append(String.format(
                    "| %" + maxIdLength + "d | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                    listaContatos.get(indiceContato).getId(), listaContatos.get(indiceContato).getNome(), telefoneFormatado, listaContatos.get(indiceContato).getEmail()
            )).append("\n");
        }

        builder.append(linha);

        return builder.toString();
    }

    public String detalharContato(String telefone) {
        for (int indiceContato = 0; indiceContato < listaContatos.size(); indiceContato++) {
            if (listaContatos.get(indiceContato).getTelefone().equals(telefone)) {
                String telefoneFormatado = formatarTelefone(listaContatos.get(indiceContato).getTelefone());

                int maxIdLength = "Id".length();
                int maxNomeLength = "Nome".length();
                int maxTelefoneLength = "Telefone".length();
                int maxEmailLength = "Email".length();

                maxIdLength = Math.max(maxIdLength, String.valueOf(listaContatos.get(indiceContato).getId()).length());
                maxNomeLength = Math.max(maxNomeLength, listaContatos.get(indiceContato).getNome().length());
                maxTelefoneLength = Math.max(maxTelefoneLength, telefoneFormatado.length());
                maxEmailLength = Math.max(maxEmailLength, listaContatos.get(indiceContato).getEmail().length());

                String header = String.format(
                        "| %" + maxIdLength + "s | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                        "Id", "Nome", "Telefone", "Email"
                );

                String linha = "+";
                for (int j = 0; j < header.length() - 2; j++) {
                    linha += "-";
                }
                linha += "+";

                StringBuilder builder = new StringBuilder();
                builder.append("Detalhes do contato:\n");
                builder.append(linha).append("\n");
                builder.append(header).append("\n");
                builder.append(linha).append("\n");

                builder.append(String.format(
                        "| %" + maxIdLength + "d | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                        listaContatos.get(indiceContato).getId(), listaContatos.get(indiceContato).getNome(), telefoneFormatado, listaContatos.get(indiceContato).getEmail()
                )).append("\n");

                builder.append(linha);

                return builder.toString();
            }
        }
        return "Contato não encontrado.";
    }

    private String formatarTelefone(String telefone) {
        if (telefone.length() == 10) {
            return telefone.replaceFirst("(\\d{2})(\\d{4})(\\d+)", "$1 $2-$3");
        } else if (telefone.length() == 11) {
            return telefone.replaceFirst("(\\d{2})(\\d{5})(\\d+)", "$1 $2-$3");
        }
        return telefone;
    }

    public static Contato getContatoPeloEmail(String email) {
        for (Contato contato:listaContatos) {
            if (email.equals(contato.email)) {
                return contato;
            }
        }
        return null;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    public String getTelefone() { return telefone; }

    public String getEmail() { return email; }

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