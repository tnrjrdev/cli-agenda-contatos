package dao;

import model.Contato;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface ContatoDAO {
    Contato save(Contato c);                    // adiciona
    List<Contato> findAll();                    // lista todos
    Optional<Contato> findByIndex(int index);   // busca por índice lógico
    void deleteByIndex(int index);              // exclui por índice
    void replace(int index, Contato novo);      // atualiza pelo índice

    // Buscas avançadas com Streams
    List<Contato> search(Predicate<Contato> predicate);
}