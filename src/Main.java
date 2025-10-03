import cli.AgendaCLI;
import dao.ContatoDAO;
import dao.InMemoryContatoDAO;
import service.AgendaService;
import service.ContatoNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoDAO dao = new InMemoryContatoDAO();
        AgendaService service = new AgendaService(dao);
        AgendaCLI cli = new AgendaCLI(service);

        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1-Adicionar 2-Listar 3-Atualizar 4-Remover 5-BuscarNome 6-BuscarPrefixo 7-BuscarRegex 8-ListarOrdenado 9-Sair");
            try {
                opcao = scan.nextInt();
                scan.nextLine(); // consumir quebra de linha
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida.");
                scan.nextLine();
                opcao = -1;
            }

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome: ");
                        String nome = scan.nextLine();
                        System.out.print("Telefone: ");
                        String tel = scan.nextLine();
                        cli.adicionarContato(nome, tel);
                    }
                    case 2 -> cli.listarContatos();
                    case 3 -> {
                        System.out.println("Digite o índice do contato a ser atualizado:");
                        cli.listarContatos();
                        int idx = scan.nextInt(); scan.nextLine();
                        System.out.print("Novo nome: "); String novoNome = scan.nextLine();
                        System.out.print("Novo telefone: "); String novoTel = scan.nextLine();
                        cli.atualizarContato(idx, novoNome, novoTel);
                    }
                    case 4 -> {
                        System.out.println("Índice para remover:");
                        cli.listarContatos();
                        int idx = scan.nextInt(); scan.nextLine();
                        cli.removerContato(idx);
                    }
                    case 5 -> {
                        System.out.print("Termo no nome: ");
                        String termo = scan.nextLine();
                        cli.buscarPorNome(termo);
                    }
                    case 6 -> {
                        System.out.print("Prefixo telefone: ");
                        String prefixo = scan.nextLine();
                        cli.buscarPorTelefonePrefixo(prefixo);
                    }
                    case 7 -> {
                        System.out.print("Regex telefone: ");
                        String regex = scan.nextLine();
                        cli.buscarPorRegexTelefone(regex);
                    }
                    case 8 -> cli.listarOrdenadoPorNome();
                    case 9 -> System.out.println("Saindo...");
                    default -> {}
                }
            } catch (ContatoNotFoundException | IndexOutOfBoundsException | IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        } while (opcao != 9);
        scan.close();
    }
}
