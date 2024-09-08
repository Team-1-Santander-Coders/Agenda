package com.team1.mensagem.utils;

import com.team1.mensagem.controller.AdministradorController;
import com.team1.mensagem.controller.UsuarioController;
import com.team1.mensagem.model.Administrador;
import com.team1.mensagem.model.Usuario;

public class Utils {
    public static boolean verificarSenhaValida(String senha) {
        return senha.length() >= 8;
    }

    public static boolean validarCadastroJaInserido(String email){
        return (verificarUsuarioJaInserido(email) || verificarAdministradorJaInserido(email));
    }

    private static boolean verificarUsuarioJaInserido(String email){
        boolean usuarioJaInserido = false;
        for(Usuario usuario : UsuarioController.getListaUsuarios()){
            if(usuario.getEmail().equals(email)){ usuarioJaInserido = true; break; }
        }
        return usuarioJaInserido;
    }

    private static boolean verificarAdministradorJaInserido(String email){
        boolean administradorJaInserido = false;
        for(Administrador admin : AdministradorController.getListaAdministradores()){
            if(admin.getEmail().equals(email)){ administradorJaInserido = true; break; }
        }
        return administradorJaInserido;
    }
}