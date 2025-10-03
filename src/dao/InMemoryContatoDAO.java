package dao;

import model.Contato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryContatoDAO implements ContatoDAO {
    private final List<Contato> contatos = new ArrayList<>();

    @Override
    public Contato save(Contato c) {
        contatos.add(c);
        return c;
    }

    @Override
    public List<Contato> findAll() {
        return Collections.unmodifiableList(contatos);
    }

    @Override
    public Optional<Contato> findByIndex(int index) {
        if (index < 0 || index >= contatos.size()) return Optional.empty();
        return Optional.of(contatos.get(index));
    }

    @Override
    public void deleteByIndex(int index) {
        if (index < 0 || index >= contatos.size())
            throw new IndexOutOfBoundsException("índice inválido");
        contatos.remove(index);
    }

    @Override
    public void replace(int index, Contato novo) {
        if (index < 0 || index >= contatos.size())
            throw new IndexOutOfBoundsException("índice inválido");
        contatos.set(index, novo);
    }

    @Override
    public List<Contato> search(Predicate<Contato> predicate) {
        return contatos.stream().filter(predicate).collect(Collectors.toList());
    }
}
