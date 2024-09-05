import com.team1.agenda.controller.Agenda;
import com.team1.contato.controller.ContatoController;
import com.team1.sms.controller.Sms;

public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        agenda.adicionarNaAgenda(ContatoController.novoContato("Matheus", "(71) 99944-8860", "math@math.com"));
        agenda.adicionarNaAgenda(ContatoController.novoContato("Math", "(71) 98704-0274", "math@math.com"));

        Sms.enviarSms("Eita preula, quem diria, né?", agenda.getContato(0), agenda.getContato(1));
        Sms.enviarSms("Pois é, menino. Maluquice...", agenda.getContato(1), agenda.getContato(0));

        System.out.println(agenda.getListaDeContatos().get(1).getNome());
        System.out.println(agenda.getListaDeContatos().get(1).getTelefone());
        System.out.println(agenda.getListaDeContatos().get(1).getEmail());

        for(Sms sms : agenda.getListaDeContatos().get(0).getListaDeSms()){
            System.out.println(sms);
        }


    }
}
