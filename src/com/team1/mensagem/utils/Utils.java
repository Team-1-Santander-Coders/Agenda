package com.team1.mensagem.utils;

public class Utils {
    public static boolean verificarSenhaValida(String senha) {
        return senha.length() >= 8;
    }
}