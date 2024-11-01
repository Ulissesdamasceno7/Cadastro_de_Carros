import java.util.UUID;

public class Carro {
    String id;
    String motor;
    String marca;
    String modelo;
    String cor;
    int anoFabricacao;
    int numeroPortas;

    // Construtor
    public Carro(String motor, String marca, String modelo, String cor, int anoFabricacao, int numeroPortas) {
        this.id = UUID.randomUUID().toString(); // Gera um ID único
        this.motor = motor;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.numeroPortas = numeroPortas;
    }

    // Métodos
    String ligar() {
        return "O carro está ligado";
    }

    String desligar() {
        return "O carro está desligado";
    }

    String acelerar() {
        return "O carro está acelerando";
    }

    String frear() {
        return "O carro está freando";
    }

    // Método para exibir informações do carro
    @Override
    public String toString() {
        return "ID: " + id + ", Carro [motor: " + motor + ", marca: " + marca + ", modelo: " + modelo + 
               ", cor: " + cor + ", anoFabricacao: " + anoFabricacao + 
               ", numeroPortas: " + numeroPortas + "]";
    }
}
