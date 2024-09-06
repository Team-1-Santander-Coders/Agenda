package com.team1.view;

import com.team1.agenda.controller.Agenda;
import com.team1.contato.controller.ContatoController;
import com.team1.contato.model.Contato;
import controladorOld.ContatoManagerOld;

import java.util.Scanner;

public class Menu {
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        ContatoManagerOld contatoManager = new ContatoManagerOld();
        Agenda agenda = new Agenda();
        boolean sair = false;

        while (!sair) {
            // Menu estilizado com bordas
            System.out.println();
            System.out.println(" /---------------------------\\ ");
            System.out.println(" |           AGENDA           |");
            System.out.println(" \\---------------------------/ ");
            System.out.println(" |   >>> Menu Contato <<<    |");
            System.out.println(" |---------------------------| ");
            System.out.println(" | 1 - Adicionar Contato     | ");
            System.out.println(" | 2 - Detalhar Contato      | ");
            System.out.println(" | 3 - Editar Contato        | ");
            System.out.println(" | 4 - Remover Contato       | ");
            System.out.println(" | 5 - Listar Contatos       | ");
            System.out.println(" | 6 - Sair                  | ");
            System.out.println(" |---------------------------| ");
            System.out.print(" Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("\n Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print(" Email: ");
                    String email = scanner.nextLine();
                    System.out.print(" Telefone: ");
                    String telefone = scanner.nextLine();
                    try {
                        if(agenda.verificarTelefoneJaInserido(telefone)) throw new Exception("Telefone já inserido.");
                        else agenda.adicionarNaAgenda(ContatoController.novoContato(nome, telefone, email));
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case "2":
                    System.out.print("\n Digite o telefone do com.team1.contato: ");
                    String telefoneDetalhar = scanner.nextLine();
                    System.out.println("\n " + agenda.detalharContato(agenda.getIdContato(telefoneDetalhar)) + "\n");
                    break;

                case "3":
                    System.out.print("\n Digite o telefone do com.team1.contato a ser editado: ");
                    String telefoneAntigo = scanner.nextLine();

                    if (!(agenda.detalharContato(agenda.getIdContato(telefoneAntigo)) == null)){
                        System.out.print("\n Esses são os dados atuais:");
                        System.out.println(agenda.detalharContato(agenda.getIdContato(telefoneAntigo)));
                        System.out.print(" Novo Nome (deixe em branco para manter o mesmo): ");
                        String novoNome = scanner.nextLine();
                        System.out.print(" Novo Email (deixe em branco para manter o mesmo): ");
                        String novoEmail = scanner.nextLine();
                        System.out.print(" Novo Telefone (deixe em branco para manter o mesmo): ");
                        String novoTelefone = scanner.nextLine();
                        agenda.editarContato(telefoneAntigo, novoNome, novoTelefone, novoEmail);
                    }
                    else {
                        System.out.println("\n Contato não encontrado. \n");
                    }

                    break;

                case "4":
                    System.out.print("\n Digite o telefone do com.team1.contato a ser removido: ");
                    String telefoneRemover = scanner.nextLine();
                    agenda.removerDaAgenda(telefoneRemover);
                    break;

                case "5":
                    System.out.println("\n " + agenda.listarContatos() + "\n");  // Lista os contatos
                    break;

                case "6":
                    sair = true;
                    System.out.println("\n Saindo. Até logo!");
                    break;

                default:
                    System.out.println("\n Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
