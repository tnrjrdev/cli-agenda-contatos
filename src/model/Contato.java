package model;

/**
 * Contato como record (imutável).
 * Atualizações geram uma nova instância via withNome/withTelefone.
 */
public record Contato(String nome, String telefone) {

    public Contato {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("nome obrigatório");
        }
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("telefone obrigatório");
        }
    }

    public Contato withNome(String novoNome) {
        return new Contato(novoNome, this.telefone);
    }

    public Contato withTelefone(String novoTelefone) {
        return new Contato(this.nome, novoTelefone);
    }
}
