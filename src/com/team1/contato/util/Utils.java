package com.team1.contato.util;

import com.team1.contato.model.Contato;

public class Utils {
    public static boolean verificarTelefoneValido(String telefone) {
        boolean telefoneEstaValido = true;
        if(telefone.length() == 11) {
            if(verificarTelefoneCadastrado(telefone)) telefoneEstaValido = false;
        } else telefoneEstaValido = false;
        return telefoneEstaValido;
    }

    public static boolean verificarTelefoneCadastrado(String telefone){
        boolean telefoneEstaValido = false;
        for(Contato contato : Contato.getListaContatos()){
            if(contato.getTelefone().equals(telefone)){
                telefoneEstaValido = true;
                break;
            }
        }
        return telefoneEstaValido;
    }

    public static boolean verificarEmailValido(String email) {

        for (Contato contato : Contato.getListaContatos()) {
            if (contato.getEmail().equals(email)) {
                return false;
            }
        }
        return ((email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"))  );
    }
}