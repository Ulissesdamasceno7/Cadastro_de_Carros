import java.io.*;
import java.util.*;

public class Excluir {

    // Método para ler o conteúdo do arquivo e exibir todos os carros
    public static List<String> listarCarros(String nomeArquivo) {
        List<String> carros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                carros.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return carros;
    }

    // Método para excluir um carro específico do arquivo
    public static void excluirCarro(String nomeArquivo, String idCarro) {
        List<String> carros = listarCarros(nomeArquivo); // Obter lista de carros
        boolean encontrado = false;
        
        Iterator<String> iterator = carros.iterator();
        while (iterator.hasNext()) {
            String carro = iterator.next();
            if (carro.contains(idCarro)) { // Verifica se a linha contém o ID do carro
                iterator.remove();
                encontrado = true;
                System.out.println("Carro com ID " + idCarro + " foi excluído.");
                break;
            }
        }

        if (encontrado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
                for (String carro : carros) {
                    writer.write(carro);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Carro com ID " + idCarro + " não encontrado.");
        }
    }

    // Método principal para executar o exemplo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = "carros.txt"; // Nome do arquivo onde os carros estão salvos

        // Listar carros cadastrados
        List<String> carros = listarCarros(nomeArquivo);
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            System.out.println("Carros cadastrados:");
            for (String carro : carros) {
                System.out.println(carro);
            }

            // Pergunta qual carro o usuário deseja excluir
            System.out.print("Digite o ID do carro que deseja excluir: ");
            String idCarro = scanner.nextLine();

            // Excluir o carro
            excluirCarro(nomeArquivo, idCarro);
        }

        scanner.close();
    }
}