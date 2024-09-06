package com.team1.sms.controller;
import com.team1.contato.model.Contato;

public class Sms {
    private String mensagem;
    private String telefoneRemetente;
    private String telefoneDestinatario;

    public Sms(String mensagem) {
        this.mensagem = mensagem;
    }

    public static void enviarSms(String mensagem, Contato remetente, Contato destinatario){
        try {
            if (mensagem.isEmpty()) throw new Exception("Não é possível enviar uma mensagem vazia!");
            else if(remetente == null) throw new Exception("Impossível enviar a mensagem. Remetente vazio");
            else if (destinatario == null) throw new Exception("Impossível enviar a mensagem. Destinatário vazio");

            else{
                Sms smsEnviado = new Sms(mensagem);
                smsEnviado.setRemetente(remetente.getTelefone());
                smsEnviado.setDestinatario(destinatario.getTelefone());
                remetente.adicionarSmsNaLista(smsEnviado);
                destinatario.adicionarSmsNaLista(smsEnviado);
            }

            } catch(Exception e){
                System.err.println(e.getMessage());
            }
        }

    public String getMensagem() {
        return mensagem;
    }



    public void setRemetente(String telefoneRemetente) {
        this.telefoneRemetente = telefoneRemetente;
    }

    public void setDestinatario(String telefoneDestinatario){
        this.telefoneDestinatario = telefoneDestinatario;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "mensagem='" + mensagem + '\'' +
                ", remetente=" + telefoneRemetente +
                ", destinatário=" + telefoneDestinatario +
                '}';
    }
}


