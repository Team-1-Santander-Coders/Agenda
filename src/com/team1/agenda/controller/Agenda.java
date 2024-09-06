package com.team1.agenda.controller;

import com.team1.contato.model.Contato;
import com.team1.contato.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Contato> listaDeContato = new ArrayList<>();

    public List<Contato> getListaDeContatos() {
        return listaDeContato;
    }

    public void adicionarNaAgenda(Contato contato) {
        try {
            if (contato == null) throw new Exception("Impossível adicionar um contato vazio");
            else {
                this.listaDeContato.add(contato);
                System.out.println("Contato adicionado com sucesso!");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void removerDaAgenda(String telefone) { listaDeContato.removeIf(contato -> contato.getTelefone().equals(telefone)); }

    public void editarContato(String telefone, String novoNome, String novoTelefone, String novoEmail) {
        telefone = telefone.replaceAll("\\D", "");

        try {
            if (!verificarTelefoneJaInserido(telefone)) throw new Exception("Contato não encontrado: Telefone inválido");

            else {
                if (novoNome.isEmpty() && novoTelefone.isEmpty() && novoEmail.isEmpty()) throw new Exception("Contato não foi editado: Nenhum novo dado foi passado.");

                if (!novoNome.isEmpty()) listaDeContato.get(getIdContato(telefone)).setNome(novoNome);

                if (!novoEmail.isEmpty()) listaDeContato.get(getIdContato(telefone)).setEmail(novoEmail);

                if (!novoTelefone.isEmpty()) {
                    novoTelefone = novoTelefone.replaceAll("\\D", "");
                    if (Utils.verificarTelefoneValido(telefone)) listaDeContato.get(getIdContato(telefone)).setTelefone(novoTelefone);
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String listarContatos() {
        StringBuilder builder = new StringBuilder();
        try {
            if (listaDeContato.isEmpty()) throw new Exception("Sem contatos na lista.");
            else {
                // Encontrar o comprimento máximo de cada coluna
                int maxIdLength = "Id".length(); // Inicializa com o comprimento do título "Id"
                int maxNomeLength = "Nome".length(); // Inicializa com o comprimento do título "Nome"
                int maxTelefoneLength = "Telefone".length(); // Inicializa com o comprimento do título "Telefone"
                int maxEmailLength = "Email".length(); // Inicializa com o comprimento do título "Email"

                // Percorre todos os contatos para encontrar o comprimento máximo de cada coluna
                for (Contato contato : listaDeContato) {
                    String telefoneFormatado = formatarTelefone(contato.getTelefone()); // Formata o telefone
                    maxIdLength = Math.max(maxIdLength, String.valueOf(contato.getId()).length()); // Atualiza o comprimento máximo do ID
                    maxNomeLength = Math.max(maxNomeLength, contato.getNome().length()); // Atualiza o comprimento máximo do Nome
                    maxTelefoneLength = Math.max(maxTelefoneLength, telefoneFormatado.length()); // Atualiza o comprimento máximo do Telefone
                    maxEmailLength = Math.max(maxEmailLength, contato.getEmail().length()); // Atualiza o comprimento máximo do Email
                }

                // Construir o cabeçalho da tabela com a largura ajustada
                String header = String.format(
                        "| %" + maxIdLength + "s | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                        "Id", "Nome", "Telefone", "Email"
                );

                // Construir uma linha de separação com base no comprimento do cabeçalho
                String linha = "+";
                for (int i = 0; i < header.length() - 2; i++) { // -2 para ajustar ao comprimento dos símbolos '+' nas extremidades
                    linha += "-";
                }
                linha += "+";

                // Construir as linhas da tabela

                builder.append(linha).append("\n"); // Adiciona a linha superior da tabela
                builder.append(header).append("\n"); // Adiciona o cabeçalho
                builder.append(linha).append("\n"); // Adiciona a linha separadora abaixo do cabeçalho

                // Adiciona os dados de cada com.team1.contato na tabela
                for (Contato contato : listaDeContato) {
                    String telefoneFormatado = formatarTelefone(contato.getTelefone()); // Formata o telefone
                    builder.append(String.format(
                            "| %" + maxIdLength + "d | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                            contato.getId(), contato.getNome(), telefoneFormatado, contato.getEmail()
                    )).append("\n");
                }

            }
        } catch (Exception e) {
            return (e.getMessage());
        }

        return builder.toString();
    }

    public Contato getContato(int id) {
        return listaDeContato.get(id);
    }

    public int getIdContato(String telefone) {
        int id = -1;
        for (Contato contato : listaDeContato) {
            if (contato.getTelefone().equals(telefone)) {
                id = contato.getId() - 1;
            }
        }
        return id;
    }

    public String detalharContato(int id) {

        try {
            if (listaDeContato.get(id) == null) throw new Exception("Contato não encontrado");

            else {
                Contato contato = listaDeContato.get(id);
                int maxIdLength = "Id".length();
                int maxNomeLength = "Nome".length();
                int maxTelefoneLength = "Telefone".length();
                int maxEmailLength = "Email".length();

                String telefoneFormatado = formatarTelefone(contato.getTelefone());
                maxIdLength = Math.max(maxIdLength, String.valueOf(contato.getId()).length());
                maxNomeLength = Math.max(maxNomeLength, contato.getNome().length());
                maxTelefoneLength = Math.max(maxTelefoneLength, telefoneFormatado.length());
                maxEmailLength = Math.max(maxEmailLength, contato.getEmail().length());

                // Construir o cabeçalho
                String header = String.format(
                        "| %" + maxIdLength + "s | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                        "Id", "Nome", "Telefone", "Email"
                );

                // Construir a linha de separação
                String linha = "+";
                for (int j = 0; j < header.length() - 2; j++) {
                    linha += "-";
                }
                linha += "+";

                // Construir o detalhe do com.team1.contato

                return "Detalhes do contato:\n" +
                        linha + "\n" +
                        header + "\n" +
                        linha + "\n" +
                        String.format(
                                "| %" + maxIdLength + "d | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                                contato.getId(), contato.getNome(), telefoneFormatado, contato.getEmail()
                        ) +
                        "\n" +
                        linha;
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public boolean verificarTelefoneJaInserido(String telefone) {
        boolean resultado = false;

        for (Contato contato : this.listaDeContato) {
            if (contato.getTelefone().equals(telefone)) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    private String formatarTelefone(String telefone) {
        if (telefone.length() == 10) {
            return telefone.replaceFirst("(\\d{2})(\\d{4})(\\d+)", "$1 $2-$3");
        } else if (telefone.length() == 11) {
            return telefone.replaceFirst("(\\d{2})(\\d{5})(\\d+)", "$1 $2-$3");
        }
        return telefone;
    }
}


