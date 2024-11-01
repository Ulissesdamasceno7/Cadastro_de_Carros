import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cadastrar {

    // Método principal para criar carros em loop e salvar no arquivo
    public static void iniciarCadastro() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        try (FileWriter fw = new FileWriter("carros_criados.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {

            while (continuar) {
                // Cria um novo carro
                Carro carro = criarCarro(scanner);
                System.out.println("Carro criado: " + carro);

                // Salva o carro no arquivo
                salvarCarroEmArquivo(carro, pw);

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

        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    // Método para criar um carro com dados fornecidos pelo usuário
    private static Carro criarCarro(Scanner scanner) {
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

        return new Carro(motor, marca, modelo, cor, anoFabricacao, numeroPortas);
    }

    // Método para salvar o carro em um arquivo
    private static void salvarCarroEmArquivo(Carro carro, PrintWriter pw) {
        pw.println(carro.toString());
        pw.flush(); // Garante que os dados sejam escritos imediatamente
        System.out.println("Carro salvo no arquivo.");
    }
}
