import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1-Adicionar 2-Listar 3-Atualizar 4-Sair");
            opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                System.out.println("Nome: ");
                String nome = scan.nextLine();
                System.out.println("Telefone: ");
                String telefone = scan.nextLine();
                AgendaCLI.adicionarContato(nome, telefone);
            } else if (opcao == 2) {
                AgendaCLI.listarContatos();
            } else if (opcao == 3) {
                System.out.println("Digite o índice do contato a ser atualizado:");
                AgendaCLI.listarContatos();
                int indice = scan.nextInt();
                scan.nextLine(); // Limpa o buffer do Scanner

                System.out.println("Novo nome: ");
                String novoNome = scan.nextLine();

                System.out.println("Novo telefone: ");
                String novoTelefone = scan.nextLine();

                AgendaCLI.atualizarContato(indice, novoNome, novoTelefone);
            }
        } while (opcao != 5);
        scan.close();

    }
}