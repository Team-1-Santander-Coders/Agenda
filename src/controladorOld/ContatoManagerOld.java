package controladorOld;

public class ContatoManagerOld {
    private ContatoOld[] contatoOlds;
    private int tamanho;
    private int id = 1;

    public ContatoManagerOld() {
        contatoOlds = new ContatoOld[1]; // Inicializa o array com 1 slot
        tamanho = 0; // Inicializa com zero contatos
    }

    // Método para adicionar um com.team1.contato ao array
    public String adicionarContato(String nome, String email, String telefone) {
        String retorno = "";
        telefone = telefone.replaceAll("\\D", ""); // Remove tudo que não for número

        if (telefone.length() < 10 || telefone.length() > 11) {
            return "Número de telefone inválido.";
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            return "Endereço de email inválido.";
        }

        if (tamanho == contatoOlds.length) { // Verifica se o array está cheio
            expandirArray(); // Expande o array se estiver cheio
        }

        ContatoOld contatoOld = ContatoOld.criarContato(id, nome, email, telefone);

        contatoOlds[tamanho++] = contatoOld; // Adiciona o com.team1.contato e incrementa o tamanho
        id++; // Incrementa o id

        for (int indiceContato = 0; indiceContato < tamanho; indiceContato++) {
            if (contatoOlds[indiceContato].getTelefone().equals(contatoOld.getTelefone()) && contatoOlds[indiceContato].getId() != contatoOld.getId()) { // Verifica se tem um número igual
                retorno = "Já existe um com.team1.contato com esse número de telefone, operação abortada.";
                removerContato(contatoOld.getId() - 1); // Apaga o com.team1.contato da array
                id--; // Decrementa o id, pois o com.team1.contato não pôde ser adicionado
                contatoOld = null; // Apaga o objeto da memória
                break;
            } else {
                retorno = "Contato adicionado";
            }
        }
        return retorno;
    }

    // Método para remover um com.team1.contato do array
    private void removerContato(int indice) {
        for (int indiceContato = indice; indiceContato < tamanho - 1; indiceContato++) { // Move os elementos subsequentes uma posição para frente
            contatoOlds[indiceContato] = contatoOlds[indiceContato + 1];
        }
        contatoOlds[tamanho - 1] = null; // Limpa a última posição do array
        tamanho--; // Decrementa o tamanho
    }

    public String apagarContato(String numero) {
        boolean encontrado = false;
        String retorno = "";
        for (int indiceContato = 0; indiceContato < tamanho; indiceContato++) {
            if (contatoOlds[indiceContato].getTelefone().equals(numero)) { // Verifica se tem um com.team1.contato com o telefone informado
                retorno = "Contato com o número " + numero + " apagado.";
                removerContato(indiceContato); // Remove o com.team1.contato usando o método removerContato
                encontrado = true;
                break; // Encerra o loop após encontrar e remover o com.team1.contato
            }
        }
        if (!encontrado) {
            retorno += "Telefone não encontrado no banco de dados.";
        }
        return retorno;
    }

    // Método para editar um com.team1.contato existente
    public String editarContato(String telefone, String novoNome, String novoEmail, String novoTelefone) {
        for (int indiceContato = 0; indiceContato < tamanho; indiceContato++) {
            if (contatoOlds[indiceContato].getTelefone().equals(telefone)) {
                // Verifica se o novo número já existe em outro com.team1.contato
                if (!novoTelefone.isEmpty()) {
                    novoTelefone = novoTelefone.replaceAll("\\D", "");
                    if (novoTelefone.length() < 10 || novoTelefone.length() > 11) {
                        return "Número de telefone inválido.";
                    }

                    // Verifica se o novo número já existe em outro com.team1.contato
                    for (int i = 0; i < tamanho; i++) {
                        if (i != indiceContato && contatoOlds[i].getTelefone().equals(novoTelefone)) {
                            return "O número de telefone " + formatarTelefone(novoTelefone) + " já está cadastrado em outro com.team1.contato.";
                        }
                    }

                    // Atualiza o telefone se não houver conflito
                    contatoOlds[indiceContato].setTelefone(novoTelefone);
                }

                if (!novoEmail.isEmpty()) {
                    if (!novoEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        return "Endereço de email inválido.";
                    }
                    contatoOlds[indiceContato].setEmail(novoEmail);
                }

                if (!novoNome.isEmpty()) {
                    contatoOlds[indiceContato].setNome(novoNome);
                }
                return "Contato com id " + contatoOlds[indiceContato].getId() + " atualizado.";
            }
        }
        return "Contato não encontrado.";
    }

    public String detalharContato(String telefone) {
        for (int i = 0; i < tamanho; i++) {
            if (contatoOlds[i].getTelefone().equals(telefone)) {
                // Formatar o telefone
                String telefoneFormatado = formatarTelefone(contatoOlds[i].getTelefone());

                // Calcular o comprimento máximo das colunas para formatação
                int maxIdLength = "Id".length();
                int maxNomeLength = "Nome".length();
                int maxTelefoneLength = "Telefone".length();
                int maxEmailLength = "Email".length();

                maxIdLength = Math.max(maxIdLength, String.valueOf(contatoOlds[i].getId()).length());
                maxNomeLength = Math.max(maxNomeLength, contatoOlds[i].getNome().length());
                maxTelefoneLength = Math.max(maxTelefoneLength, telefoneFormatado.length());
                maxEmailLength = Math.max(maxEmailLength, contatoOlds[i].getEmail().length());

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
                StringBuilder builder = new StringBuilder();
                builder.append("Detalhes do com.team1.contato:\n");
                builder.append(linha).append("\n");
                builder.append(header).append("\n");
                builder.append(linha).append("\n");

                builder.append(String.format(
                        "| %" + maxIdLength + "d | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                        contatoOlds[i].getId(), contatoOlds[i].getNome(), telefoneFormatado, contatoOlds[i].getEmail()
                )).append("\n");

                builder.append(linha); // Linha final para fechar a tabela

                return builder.toString();
            }
        }
        return "Contato não encontrado.";
    }

    // Método para listar todos os contatos
    public String listarContatos() {
        // Verifica se a lista de contatos está vazia
        if (tamanho == 0) {
            return "Sem contatos na lista.";
        }

        // Encontrar o comprimento máximo de cada coluna
        int maxIdLength = "Id".length(); // Inicializa com o comprimento do título "Id"
        int maxNomeLength = "Nome".length(); // Inicializa com o comprimento do título "Nome"
        int maxTelefoneLength = "Telefone".length(); // Inicializa com o comprimento do título "Telefone"
        int maxEmailLength = "Email".length(); // Inicializa com o comprimento do título "Email"

        // Percorre todos os contatos para encontrar o comprimento máximo de cada coluna
        for (int i = 0; i < tamanho; i++) {
            String telefoneFormatado = formatarTelefone(contatoOlds[i].getTelefone()); // Formata o telefone
            maxIdLength = Math.max(maxIdLength, String.valueOf(contatoOlds[i].getId()).length()); // Atualiza o comprimento máximo do ID
            maxNomeLength = Math.max(maxNomeLength, contatoOlds[i].getNome().length()); // Atualiza o comprimento máximo do Nome
            maxTelefoneLength = Math.max(maxTelefoneLength, telefoneFormatado.length()); // Atualiza o comprimento máximo do Telefone
            maxEmailLength = Math.max(maxEmailLength, contatoOlds[i].getEmail().length()); // Atualiza o comprimento máximo do Email
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
        StringBuilder builder = new StringBuilder();
        builder.append(linha).append("\n"); // Adiciona a linha superior da tabela
        builder.append(header).append("\n"); // Adiciona o cabeçalho
        builder.append(linha).append("\n"); // Adiciona a linha separadora abaixo do cabeçalho

        // Adiciona os dados de cada com.team1.contato na tabela
        for (int indiceContato = 0; indiceContato < tamanho; indiceContato++) {
            String telefoneFormatado = formatarTelefone(contatoOlds[indiceContato].getTelefone()); // Formata o telefone
            builder.append(String.format(
                    "| %" + maxIdLength + "d | %" + maxNomeLength + "s | %" + maxTelefoneLength + "s | %" + maxEmailLength + "s |",
                    contatoOlds[indiceContato].getId(), contatoOlds[indiceContato].getNome(), telefoneFormatado, contatoOlds[indiceContato].getEmail()
            )).append("\n");
        }

        builder.append(linha); // Linha final para fechar a tabela

        return builder.toString(); // Retorna a tabela formatada como uma string
    }

    // Método para expandir o array quando necessário
    private void expandirArray() {
        int novoTamanho = contatoOlds.length + 1; // Aumenta a capacidade do array
        ContatoOld[] novaArray = new ContatoOld[novoTamanho]; // Cria um novo array com a nova capacidade

        // Copia manualmente os elementos do array antigo para o novo array
        for (int i = 0; i < tamanho; i++) {
            novaArray[i] = contatoOlds[i];
        }

        contatoOlds = novaArray; // Substitui o array antigo pelo novo
    }

    // Método para formatar o telefone no formato "## #####-####"
    private String formatarTelefone(String telefone) {
        if (telefone.length() == 10) {
            return telefone.replaceFirst("(\\d{2})(\\d{4})(\\d+)", "$1 $2-$3");
        } else if (telefone.length() == 11) {
            return telefone.replaceFirst("(\\d{2})(\\d{5})(\\d+)", "$1 $2-$3");
        }
        return telefone;
    }
}
