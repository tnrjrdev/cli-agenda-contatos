import java.util.ArrayList;


public class AgendaCLI {
    static ArrayList<Contato> contatos = new ArrayList<>();

    public static void adicionarContato(String nome, String telefone) {
        contatos.add(new Contato(nome, telefone));
        System.out.println("Contato adicionado");
    }

    public static void listarContatos() {
        for (int i = 0; i < contatos.size(); i++) {
            Contato c = contatos.get(i);
            System.out.println(i + ": " + c.nome + " - " + c.telefone);
        }
    }
    public static void atualizarContato(int indice, String novoNome, String novoTelefone) {
        if (indice >= 0 && indice < contatos.size()) {
            Contato contato = contatos.get(indice);
            contato.nome = novoNome;
            contato.telefone = novoTelefone;
            System.out.println("Contato atualizado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

}