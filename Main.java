import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Solicita que o usuário insira os atributos do carro
            Carro carro = criarCarro(scanner);
            System.out.println("Carro criado: " + carro);

            // Chama os métodos do carro
            System.out.println("\nMétodos do carro:");
            System.out.println(carro.ligar());
            System.out.println(carro.acelerar());
            System.out.println(carro.frear());
            System.out.println(carro.desligar());

            // Pergunta se o usuário deseja criar outro carro
            System.out.print("\nDeseja criar outro carro? (s/n): ");
            String resposta = scanner.nextLine();

            // Verifica a resposta do usuário
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false; // Sai do loop se a resposta não for "s"
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private static Carro criarCarro(Scanner scanner) {
        // Solicita que o usuário insira os atributos do carro
        System.out.print("Digite o motor do carro: ");
        String motor = scanner.nextLine();

        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite a cor do carro: ");
        String cor = scanner.nextLine();

        System.out.print("Digite o ano de fabricação do carro: ");
        int anoFabricacao = scanner.nextInt();

        System.out.print("Digite o número de portas do carro: ");
        int numeroPortas = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner após nextInt()

        // Cria o objeto Carro com os dados fornecidos pelo usuário
        return new Carro(motor, marca, modelo, cor, anoFabricacao, numeroPortas);
    }
}
