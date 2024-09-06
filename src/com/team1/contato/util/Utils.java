package com.team1.contato.util;

import com.team1.agenda.controller.Agenda;
import com.team1.contato.model.Contato;

public class Utils {

    public static boolean verificarTelefoneValido(String telefone) {
        return (verificarTamanhoTelefoneValido(telefone));
    }

    public static boolean verificarTamanhoTelefoneValido(String telefone){
        return ((telefone.length() == 11));
    }

    public static boolean verificarEmailValido(String email) {
        return (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
    }

    public static boolean detalharContato(){
        return false;
    }
}
