public class Caminhao extends Veiculo {
    // Atributos exclusivos do caminhão
    private double capacidadeCarga; // em toneladas
    private int numeroEixos;
    private boolean possuiCarroceria;

    // Construtor
    public Caminhao(String marca, String modelo, int ano, String cor, double preco,
        double capacidadeCarga, int numeroEixos, boolean possuiCarroceria) {
        
        super(marca, modelo, ano, cor, preco); // Chama o construtor da classe Veiculo
        this.capacidadeCarga = capacidadeCarga;
        this.numeroEixos = numeroEixos;
        this.possuiCarroceria = possuiCarroceria;
    }

    // Getters e Setters
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    public boolean isPossuiCarroceria() {
        return possuiCarroceria;
    }

    public void setPossuiCarroceria(boolean possuiCarroceria) {
        this.possuiCarroceria = possuiCarroceria;
    }

    // Método exclusivo do caminhão
    public void carregar(double peso) {
        if (peso <= capacidadeCarga) {
            System.out.println("Caminhão carregado com " + peso + " toneladas.");
        } else {
            System.out.println("Erro: peso excede a capacidade máxima de " + capacidadeCarga + " toneladas.");
        }
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); // exibe os atributos de Veiculo
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " toneladas");
        System.out.println("Número de Eixos: " + numeroEixos);
        System.out.println("Possui Carroceria: " + (possuiCarroceria ? "Sim" : "Não"));
    }
}
