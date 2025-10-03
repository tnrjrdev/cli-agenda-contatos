package cli;

import model.Contato;
import service.AgendaService;

import java.util.List;

public class AgendaCLI {
    private final AgendaService service;

    public AgendaCLI(AgendaService service) {
        this.service = service;
    }

    public void adicionarContato(String nome, String telefone) {
        service.add(nome, telefone);
        System.out.println("Contato adicionado.");
    }

    public void listarContatos() {
        List<Contato> todos = service.listAll();
        if (todos.isEmpty()) {
            System.out.println("(vazio)");
            return;
        }
        for (int i = 0; i < todos.size(); i++) {
            var c = todos.get(i);
            System.out.printf("%d: %s - %s%n", i, c.nome(), c.telefone());
        }
    }

    public void atualizarContato(int indice, String novoNome, String novoTelefone) {
        service.updateByIndex(indice, novoNome, novoTelefone);
        System.out.println("Contato atualizado.");
    }

    public void removerContato(int indice) {
        service.deleteByIndex(indice);
        System.out.println("Contato removido.");
    }

    // buscas avançadas
    public void buscarPorNome(String termo) {
        var lista = service.findByNomeContains(termo);
        imprimirResultado("Busca por nome contém '" + termo + "'", lista);
    }

    public void buscarPorTelefonePrefixo(String prefixo) {
        var lista = service.findByTelefoneStartsWith(prefixo);
        imprimirResultado("Busca por telefone inicia com '" + prefixo + "'", lista);
    }

    public void buscarPorRegexTelefone(String regex) {
        var lista = service.findByTelefoneRegex(regex);
        imprimirResultado("Busca por regex de telefone '" + regex + "'", lista);
    }

    public void listarOrdenadoPorNome() {
        var lista = service.listSortedByNome();
        imprimirResultado("Lista ordenada por nome", lista);
    }

    private void imprimirResultado(String titulo, List<Contato> lista) {
        System.out.println("\n== " + titulo + " ==");
        if (lista.isEmpty()) {
            System.out.println("(sem resultados)");
            return;
        }
        for (var c : lista) System.out.printf("- %s (%s)%n", c.nome(), c.telefone());
    }
}
