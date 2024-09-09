## Projeto
Este projeto é uma aplicação de agenda em Java que permite gerenciar contatos de forma simples e eficiente. A aplicação oferece funcionalidades para adicionar, editar, detalhar contatos, criar usuário simulando um aplicativo de troca de mensagens, permitindo o envio de mensagens de um usuário para o outro e cadastro de administradores com privilégios. O desafio principal deste projeto foi incrementar o projeto inicial de uma agenda que está disponível na branch agenda 1.0 com mais conceitos de POO, inicialmente era obrigatório o uso de herança.

## Funcionalidades
- **Adicionar Contatos:** Permite ao usuário inserir novos contatos com informações básicas, como nome, telefone e e-mail.
- **Editar Contatos:** Oferece a possibilidade de modificar os detalhes de um contato existente.
- **Detalhar Contatos:** Exibe as informações completas de um contato específico.
- **Remover Contatos:** Remove o contato especificado da nossa lista.
- **Listar Contatos:** Exibe as informações de todos os contatos cadastrados.
- **Sistema de mensagens:** Podemos realizar o cadastro de usuário em um sistema de mensagens, podemos ter administradores e usuários comuns, os administradores tem alguns privilégios.

# Como executar

## Versão para Linux/macOS

**1. Clone o repositório e navegue até a pasta dele:**
   ```bash
   git clone https://github.com/Team-1-Santander-Coders/Agenda.git
   cd ./Agenda
   ```

**2. Compile e execute o projeto com o script Bash:**
   ```bash
   ./compile_and_run.sh
   ```

**3. Interaja com o Menu:**
Após a execução, será exibido um Menu para você interagir.mds

## Versão para Windows

**1. Clone o repositório e navegue até a pasta dele:**
   ```batch
   git clone https://github.com/Team-1-Santander-Coders/Agenda.git
   cd Agenda
   ```

**2. Compile e execute o projeto com o script `.bat`:**
   ```batch
   compile_and_run.bat
   ```

**3. Interaja com o Menu:**
   Após a execução, será exibido um Menu para você interagir.

# Estrutura do projeto

## Arquivos

```plaintext
src/
└── com/
   └── team1/
       ├── AgendaApp.java                  // Contém o método main, responsável por iniciar a aplicação e executar o menu principal.
       ├── agenda/
       │   └── controller/
       │       └── Agenda.java             // Gerencia os contatos, incluindo operações como adicionar, editar, remover e listar contatos.
       ├── contato/
       │   ├── controller/
       │   │   └── ContatoController.java  // Controla a criação de objetos da classe Contato, mediando entre a visão e o modelo.
       │   ├── model/
       │   │   └── Contato.java            // Classe modelo que define a estrutura de um contato, contendo getters e setters.
       │   └── util/
       │       └── Utils.java              // Contém verificadores de regras de negócio, como validações e utilidades relacionadas a contatos.
       ├── mensagem/
       │   ├── controller/
       │   │   ├── AdministradorController.java // Controla a criação e gestão de administradores.
       │   │   └── UsuarioController.java  // Controla a criação e gestão de usuários.
       │   ├── model/
       │   │   ├── Administrador.java      // Classe base para a criação de administradores, estendendo a classe Usuario.
       │   │   ├── Mensagem.java           // Define a estrutura de mensagens, incluindo o método para enviar mensagens entre usuários.
       │   │   └── Usuario.java            // Classe base para a criação de usuários, estendendo a classe Contato.
       │   └── utils/
       │       └── Utils.java              // Verifica regras de negócio relacionadas a mensagens, como a validação de senhas.
       ├── resources/
       │   └── Cores.java                  // Enum que define cores para personalizar a saída no terminal, utilizando uma classe abstrata.
       └── view/
           └── Menu.java  // Interface de usuário que comunica as funcionalidades da aplicação com o usuário, apresentando um menu interativo.
```


## Menu interativo

```plaintext
 /----------------------------------\
 |              AGENDA              |
 \----------------------------------/
 |      >>> Menu Principal <<<      |
 |----------------------------------|
 | 1 - Adicionar contato            |
 | 2 - Detalhar contato             |
 | 3 - Editar contato               |
 | 4 - Remover contato              |
 | 5 - Listar contatos              |
 | 6 - Acessar email                |
 | 7 - Cadastrar usuário            |
 | 8 - Sair                         |
 |----------------------------------|
```
## Menu usuário

```plaintext
 /----------------------------------\
 |              AGENDA              |
 \----------------------------------/
 |      >>> Menu Principal <<<      |
 |----------------------------------|
 | 1 - Adicionar contato            |
 | 2 - Detalhar contato             |
 | 3 - Editar contato               |
 | 4 - Remover contato              |
 | 5 - Listar contatos              |
 | 6 - Acessar email                |
 | 7 - Cadastrar usuário            |
 | 8 - Enviar email                 |
 | 9 - Ver meus emails              |
 | 10 - Logout                      |
 | 11 - Sair                        |
 |----------------------------------|
```

## Menu administrador

```plaintext
 /----------------------------------\
 |              AGENDA              |
 \----------------------------------/
 |      >>> Menu Principal <<<      |
 |----------------------------------|
 | 1 - Adicionar contato            |
 | 2 - Detalhar contato             |
 | 3 - Editar contato               |
 | 4 - Remover contato              |
 | 5 - Listar contatos              |
 | 6 - Acessar email                |
 | 7 - Cadastrar usuário            |
 | 8 - Enviar email                 |
 | 9 - Ver meus emails              |
 | 10 - Ver emails de outro usuário |
 | 10 - Logout                      |
 | 12 - Sair                        |
 |----------------------------------|
```

# Como Contribuir
1. Faça um fork do repositório.
2. Crie uma nova branch (git checkout -b feature/nome-da-sua-feature).
3. Commit suas mudanças (git commit -am 'Adiciona nova feature').
4. Faça um push para a branch (git push origin feature/nome-da-sua-feature).
5. Crie um Pull Request.

## Features que podem melhorar o funcionamento identificadas no momento:
1. Persistência de dados
2. Interface gráfica (Desktop ou Web)

## Projeto desenvolvido por:

[<img alt="Alecsandro Auer" height="75px" src="https://avatars.githubusercontent.com/u/54159302?v=4" width="75px"/>](https://github.com/aleschopf)
[<img alt="Christina Carvalho" height="75px" src="https://avatars.githubusercontent.com/u/175761726?v=4" width="75px"/>](https://github.com/ChristinaC-dev)
[<img alt="Lucas Moraes" height="75px" src="https://avatars.githubusercontent.com/u/106927402?v=4" width="75px"/>](https://github.com/lsmoraes16)
[<img alt="Maria Eduarda" height="75px" src="https://avatars.githubusercontent.com/u/134453107?v=4" width="75px"/>](https://github.com/mariaemrqs)
[<img alt="Matheus Lima" height="75px" src="https://avatars.githubusercontent.com/u/102155883?v=4" width="75px"/>](https://github.com/mathlimam)

## **Licença**

Este projeto é licenciado sob a [MIT License](LICENSE).