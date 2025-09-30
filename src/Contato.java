import java.util.ArrayList;

public class Contato {
    String nome;
    String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

//    Contato[] contatos = new Contato[100];
//    int total = 0;

    ArrayList<Contato> contatos = new ArrayList<>();
}
