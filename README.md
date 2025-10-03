# CLI Agenda de Contatos

## 📌 Descrição
Projeto em Java para gerenciar contatos via linha de comando (CLI), aplicando conceitos de **POO, DAO, Streams e boas práticas**.

Permite:
- Adicionar contatos
- Listar contatos
- Atualizar contatos
- Remover contatos
- Buscar por nome, telefone ou regex
- Listar ordenado por nome

---

## 🛠 Estrutura de Pacotes
```
src/
  cli/        -> Interface de linha de comando (AgendaCLI)
  dao/        -> Interfaces e implementações de persistência (DAO)
  model/      -> Classe de domínio (Contato)
  service/    -> Regra de negócio (AgendaService)
  Main.java   -> Ponto de entrada do programa
```

---

## 🚀 Como executar

### Compilar
Linux/Mac:
```bash
javac -d out $(find src -name "*.java")
```

Windows (PowerShell):
```powershell
Get-ChildItem -Recurse src\*.java | % FullName | javac -d out -cp .
```

### Executar
```bash
java -cp out Main
```

---

## 📖 Exemplo de Uso

```
1-Adicionar 2-Listar 3-Atualizar 4-Remover 
5-BuscarNome 6-BuscarPrefixo 7-BuscarRegex 
8-ListarOrdenado 9-Sair
```

- Adicionar contato → pede nome e telefone
- Listar contatos → mostra todos com índice
- Atualizar → escolhe índice, digita novos dados
- Remover → exclui pelo índice
- BuscarNome → filtra contatos cujo nome contém o termo
- BuscarPrefixo → filtra telefones que começam com o prefixo
- BuscarRegex → busca por expressão regular
- ListarOrdenado → lista em ordem alfabética

---

## ✅ Tecnologias
- Java 17+
- Conceitos de DAO (Data Access Object)
- Records do Java
- Streams API
- Tratamento de exceções personalizadas
