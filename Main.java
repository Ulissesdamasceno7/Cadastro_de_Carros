import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar um carro");
            System.out.println("2 - Excluir um carro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer após nextInt

            switch (opcao) {
                case 1:
                    Cadastrar.iniciarCadastro();
                    break;
                case 2:
                    Excluir.excluirCarro("carros_criados.txt");
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
