package service;

import dao.ContatoDAO;
import model.Contato;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AgendaService {
    private final ContatoDAO dao;

    public AgendaService(ContatoDAO dao) {
        this.dao = dao;
    }

    // CRUD
    public Contato add(String nome, String telefone) {
        return dao.save(new Contato(nome, telefone));
    }

    public List<Contato> listAll() {
        return dao.findAll();
    }

    public void updateByIndex(int index, String novoNome, String novoTelefone) {
        var atual = dao.findByIndex(index)
                .orElseThrow(() -> new ContatoNotFoundException("Contato não encontrado: " + index));
        var atualizado = atual.withNome(novoNome).withTelefone(novoTelefone);
        dao.replace(index, atualizado);
    }

    public void deleteByIndex(int index) {
        dao.deleteByIndex(index);
    }

    // ====== BUSCAS / STREAMS ======

    /** Busca por substring no nome (case-insensitive). */
    public List<Contato> findByNomeContains(String termo) {
        final String t = termo.toLowerCase(Locale.ROOT);
        return dao.search(c -> c.nome().toLowerCase(Locale.ROOT).contains(t));
    }

    /** Busca por telefone que começa com determinado prefixo. */
    public List<Contato> findByTelefoneStartsWith(String prefixo) {
        return dao.search(c -> c.telefone().startsWith(prefixo));
    }

    /** Busca por regex no telefone (ex.: "^81-?9\\d{4}-\\d{4}$"). */
    public List<Contato> findByTelefoneRegex(String regex) {
        Pattern p = Pattern.compile(regex);
        return dao.search(c -> p.matcher(c.telefone()).matches());
    }

    /** Lista ordenada por nome (ASC, case-insensitive). */
    public List<Contato> listSortedByNome() {
        return dao.findAll().stream()
                .sorted(Comparator.comparing(Contato::nome, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    /** Primeiro contato com nome exatamente igual (case-insensitive). */
    public Optional<Contato> findFirstByNomeEqualsIgnoreCase(String nome) {
        String alvo = nome.toLowerCase(Locale.ROOT);
        return dao.findAll().stream()
                .filter(c -> c.nome().toLowerCase(Locale.ROOT).equals(alvo))
                .findFirst();
    }
}
