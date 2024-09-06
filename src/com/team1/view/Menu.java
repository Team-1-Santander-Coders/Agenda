package com.team1.view;

import com.team1.contato.controller.ContatoController;
import com.team1.contato.model.Contato;
import com.team1.mensagem.controller.AdministradorController;
import com.team1.mensagem.controller.UsuarioController;
import com.team1.mensagem.model.Administrador;
import com.team1.mensagem.model.Usuario;
import com.team1.agenda.controller.Agenda;
import com.team1.mensagem.utils.Utils;

import java.util.Scanner;

public class Menu {
    private static Usuario usuarioLogado = null;
    private static Administrador administradorLogado = null;
    private static final Agenda agenda = new Agenda();
    private static final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        boolean sair = false;

        while (!sair) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    detalharContato();
                    break;
                case 3:
                    editarContato();
                    break;
                case 4:
                    removerContato();
                    break;
                case 5:
                    listarContatos();
                    break;
                case 6:
                    acessarEmail();
                    break;
                case 7:
                    cadastrarUsuario();
                    break;
                case 8:
                    if (usuarioLogado == null && administradorLogado == null) {
                        sair = true;
                    } else {
                        enviarEmail();
                    }
                    break;
                case 9:
                    if (usuarioLogado != null || administradorLogado != null) {
                        verMeusEmails();
                    } else {
                        System.out.println("Opção inválida. Faça login para acessar esta funcionalidade.");
                    }
                    break;
                case 10:
                    if (administradorLogado != null) {
                        verEmailsDeOutroUsuario();
                    } else {
                        System.out.println("Opção inválida. Somente administradores podem acessar esta funcionalidade.");
                    }
                    break;
                case 11:
                    if (usuarioLogado != null || administradorLogado != null) {
                        logout();
                    } else {
                        System.out.println("Opção inválida. Faça login para acessar esta funcionalidade.");
                    }
                    break;
                case 12:
                    if (usuarioLogado != null || administradorLogado != null) {
                        sair = true;
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private void exibirMenuPrincipal() {
        System.out.println(" /---------------------------\\ ");
        System.out.println(" |           AGENDA           |");
        System.out.println(" \\---------------------------/ ");
        System.out.println(" |   >>> Menu Principal <<<   |");
        System.out.println(" |---------------------------| ");
        System.out.println(" | 1 - Adicionar Contato     | ");
        System.out.println(" | 2 - Detalhar Contato      | ");
        System.out.println(" | 3 - Editar Contato        | ");
        System.out.println(" | 4 - Remover Contato       | ");
        System.out.println(" | 5 - Listar Contatos       | ");
        System.out.println(" | 6 - Acessar Email         | ");
        System.out.println(" | 7 - Cadastrar Usuário     | ");
        if (usuarioLogado == null && administradorLogado == null) {
            System.out.println(" | 8 - Sair                  | ");
        } else {
            System.out.println(" | 8 - Enviar email          | ");
            System.out.println(" | 9 - Ver meus emails       | ");
            if (administradorLogado != null) {
                System.out.println(" | 10 - Ver emails de outro usuário | ");
            }
            System.out.println(" | 11 - Trocar de conta      | ");
            System.out.println(" | 12 - Sair                 | ");
        }
        System.out.println(" |---------------------------| ");
        System.out.print(" Escolha uma opção: ");
    }


    private void cadastrarUsuario() {
        System.out.println("\n  Cadastro de novo usuário");
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        Contato contato = Contato.getContatoPeloEmail(email);


        if (contato == null) {
            System.out.println("\nEmail não está cadastrado na agenda.");
            return;
        }

        String nome = contato.getEmail();
        String telefone = contato.getTelefone();




        if (!Utils.verificarSenhaValida(senha)) {
            System.out.println("\nSenha inválida. A senha deve ter pelo menos 8 caracteres. O cadastro não foi realizado.");
            return;
        }

        System.out.print("\nEste usuário será um administrador? (S/N): ");
        String resposta = scanner.nextLine().toUpperCase();

        if (resposta.equals("S")) {
            AdministradorController.cadastrarAdministrador(nome, telefone, email, senha);
            System.out.println("\nAdministrador cadastrado com sucesso!");
        } else {
            UsuarioController.cadastrarUsuario(nome, telefone, email, senha);
            System.out.println("\nUsuário cadastrado com sucesso!");
        }
    }

    private void adicionarContato() {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o email do contato: ");
        String email = scanner.nextLine();

        Contato contato = ContatoController.novoContato(nome, telefone, email);
        if (contato != null) {
            agenda.adicionarNaAgenda(contato);
        }
    }

    private void detalharContato() {
        System.out.print("Digite o telefone do contato: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String detalhes = agenda.detalharContato(id - 1);
        System.out.println(detalhes);
    }

    private void editarContato() {
        System.out.print("Digite o telefone do contato que deseja editar: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o novo nome (ou Enter para manter): ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite o novo telefone (ou Enter para manter): ");
        String novoTelefone = scanner.nextLine();
        System.out.print("Digite o novo email (ou Enter para manter): ");
        String novoEmail = scanner.nextLine();

        agenda.editarContato(telefone, novoNome, novoTelefone, novoEmail);
    }

    private void removerContato() {
        System.out.print("Digite o telefone do contato que deseja remover: ");
        String telefone = scanner.nextLine();
        agenda.removerDaAgenda(telefone);
        System.out.println("Contato removido com sucesso!");
    }

    private void listarContatos() {
        String listaContatos = agenda.listarContatos();
        System.out.println(listaContatos);
    }

    private void acessarEmail() {
        System.out.print("Digite o seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a sua senha: ");
        String senha = scanner.nextLine();

        usuarioLogado = UsuarioController.fazerLogin(email, senha);
        administradorLogado = AdministradorController.fazerLogin(email, senha);

        if (usuarioLogado != null) {
            System.out.println("Login realizado com sucesso como usuário!");
        } else if (administradorLogado != null) {
            System.out.println("Login realizado com sucesso como administrador!");
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
        }
    }

    private void enviarEmail() {
        if (usuarioLogado != null || administradorLogado != null) {
            System.out.print("Digite o email do destinatário: ");
            String emailDestinatario = scanner.nextLine();
            Usuario destinatario = UsuarioController.buscarUsuarioPorEmail(emailDestinatario);

            if (destinatario != null) {
                System.out.print("Digite a mensagem: ");
                String conteudo = scanner.nextLine();
                if (usuarioLogado != null) {
                    usuarioLogado.enviarMensagem(destinatario, conteudo);
                } else if (administradorLogado != null) {
                    administradorLogado.enviarMensagem(destinatario, conteudo);
                }
                System.out.println("Mensagem enviada com sucesso!");
            } else {
                System.out.println("Destinatário não encontrado.");
            }
        } else {
            System.out.println("Você deve estar logado para enviar emails.");
        }
    }

    private void verMeusEmails() {
        if (usuarioLogado != null) {
            usuarioLogado.verEmails();
        } else if (administradorLogado != null) {
            administradorLogado.verEmails();
        }
    }

    private void verEmailsDeOutroUsuario() {
        if (administradorLogado != null) {
            System.out.print("Digite o email do usuário: ");
            String emailUsuario = scanner.nextLine();
            Usuario usuario = UsuarioController.buscarUsuarioPorEmail(emailUsuario);

            if (usuario != null) {
                administradorLogado.verEmailsDeOutroUsuario(usuario);
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } else {
            System.out.println("Você deve estar logado como administrador para ver emails de outros usuários.");
        }
    }

    private void logout() {
        usuarioLogado = null;
        administradorLogado = null;
        System.out.println("Logout realizado com sucesso.");
    }
}