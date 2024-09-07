package com.team1.contato.util;

public class Utils {
    public static boolean verificarTelefoneValido(String telefone) {
        return (telefone.length() == 11);
    }

    public static boolean verificarEmailValido(String email) {
        return (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
    }
}