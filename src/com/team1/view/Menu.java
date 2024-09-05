package com.team1.view;

import controladorOld.ContatoManagerOld;

import java.util.Scanner;

public class Menu {
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        ContatoManagerOld contatoManager = new ContatoManagerOld();
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
                    System.out.println("\n " + contatoManager.adicionarContato(nome, email, telefone) + "\n");
                    break;

                case "2":
                    System.out.print("\n Digite o telefone do com.team1.contato: ");
                    String telefoneDetalhar = scanner.nextLine();
                    System.out.println("\n " + contatoManager.detalharContato(telefoneDetalhar) + "\n");
                    break;

                case "3":
                    System.out.print("\n Digite o telefone do com.team1.contato a ser editado: ");
                    String telefoneAntigo = scanner.nextLine();
                    if (!contatoManager.detalharContato(telefoneAntigo).equals("Contato não encontrado.")){
                        System.out.print("\n Esses são os dados atuais:");
                        System.out.println(contatoManager.detalharContato(telefoneAntigo));
                        System.out.print(" Novo Nome (deixe em branco para manter o mesmo): ");
                        String novoNome = scanner.nextLine();
                        System.out.print(" Novo Email (deixe em branco para manter o mesmo): ");
                        String novoEmail = scanner.nextLine();
                        System.out.print(" Novo Telefone (deixe em branco para manter o mesmo): ");
                        String novoTelefone = scanner.nextLine();
                        System.out.println("\n " + contatoManager.editarContato(telefoneAntigo, novoNome, novoEmail, novoTelefone) + "\n");
                    }
                    else {
                        System.out.println("\n Contato não encontrado. \n");
                    }

                    break;

                case "4":
                    System.out.print("\n Digite o telefone do com.team1.contato a ser removido: ");
                    String telefoneRemover = scanner.nextLine();
                    System.out.println("\n " + contatoManager.apagarContato(telefoneRemover) + "\n");
                    break;

                case "5":
                    System.out.println("\n " + contatoManager.listarContatos() + "\n");  // Lista os contatos
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
