import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Excecoes.ClienteNaoEncontradoException;
import Excecoes.VeiculoIndisponivelException;

public class Main {
    private static List<Caminhao> caminhoes = new ArrayList<>();
    private static List<Carro> carros = new ArrayList<>();
    private static List<Moto> motos = new ArrayList<>();
    private static List<Pessoa> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {
        // Dados de exemplo (opcional)
        carros.add(new Carro("Chevrolet", "Onix", 2015, "Prata", 45000, 4, "Flex", 280));
        carros.add(new Carro("Fiat", "Uno", 2012, "Branco", 22000, 4, "Flex", 200));
        motos.add(new Moto("Yamaha", "FZ", 2019, "Preta", 15000, 600, true, "Esportiva"));
        motos.add(new Moto("Honda", "CB 500", 2018, "Vermelha", 17000, 500, true, "Naked"));
        clientes.add(new Pessoa("Leonardo", 52, "Rua 1 n123", "1138325599", "leo@email.com", 192, 98.4));
        
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        do {
            try {
                exibirMenu();
                escolha = scanner.nextInt();
                scanner.nextLine();
                switch (escolha) {
                    case 1:
                        mostrarTodosVeiculos();
                        break;
                    case 2:
                        cadastrarVeiculo(scanner);
                        break;
                    case 3:
                        venderVeiculo(scanner);
                        break;
                    case 4:
                        cadastrarCliente(scanner);
                        break;
                    case 5:
                        mostrarClientes();
                        break;
                    case 6:
                        gerarRelatorio();
                        break;
                    case 7:
                        sugerirVeiculosPorBiotipo(scanner);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu Concessionaria ===");
        System.out.println("1 - Mostrar Veículos");
        System.out.println("2 - Cadastrar Veículo");
        System.out.println("3 - Vender Veículo");
        System.out.println("4 - Cadastrar Cliente");
        System.out.println("5 - Mostrar Clientes");
        System.out.println("6 - Gerar Relatório de Vendas");
        System.out.println("7 - Sugerir Veículos por Biotipo");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    // ------------- Veículos -------------
    private static void mostrarTodosVeiculos() {
        if (caminhoes.isEmpty() && carros.isEmpty() && motos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        System.out.println("\n--- Veículos Cadastrados ---");
        int idx = 1;
        for (Caminhao cam : caminhoes) {
            System.out.println("[" + idx + "] (Caminhão) " + cam.getMarca() + " " + cam.getModelo() + " - R$" + cam.getPreco());
            cam.exibirInformacoes();
            System.out.println("------------------------");
            idx++;
        }
        for (Carro c : carros) {
            System.out.println("[" + idx + "] (Carro) " + c.getMarca() + " " + c.getModelo() + " - R$" + c.getPreco());
            c.exibirInformacoes();
            System.out.println("------------------------");
            idx++;
        }
        for (Moto m : motos) {
            System.out.println("[" + idx + "] (Moto) " + m.getMarca() + " " + m.getModelo() + " - R$" + m.getPreco());
            m.exibirInformacoes();
            System.out.println("------------------------");
            idx++;
        }
    }

    private static void cadastrarVeiculo(Scanner scanner) {
        System.out.println("\nCadastrar Veículo: 1-Caminhão 2-Carro  3-Moto");
        int tipo = scanner.nextInt(); scanner.nextLine();
        System.out.print("Marca: "); String marca = scanner.nextLine();
        System.out.print("Modelo: "); String modelo = scanner.nextLine();
        System.out.print("Ano: "); int ano = scanner.nextInt(); scanner.nextLine();
        System.out.print("Cor: "); String cor = scanner.nextLine();
        System.out.print("Preço: "); double preco = scanner.nextDouble(); scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Capacidade de Carga (toneladas): "); double capacidadeCarga = scanner.nextDouble(); scanner.nextLine();
            System.out.print("Número de Eixos: "); int eixos = scanner.nextInt(); scanner.nextLine();
            System.out.print("Possui Carroceria (true/false): "); boolean possuiCarroceria = scanner.nextBoolean(); scanner.nextLine();
            caminhoes.add(new Caminhao(marca, modelo, ano, cor, preco, capacidadeCarga, eixos, possuiCarroceria));
        } else if (tipo == 2) {
            System.out.print("Número de portas: "); int portas = scanner.nextInt(); scanner.nextLine();
            System.out.print("Tipo de combustível: "); String combustivel = scanner.nextLine();
            System.out.print("Capacidade do porta-malas (litros): "); int capacidade = scanner.nextInt(); scanner.nextLine();
            carros.add(new Carro(marca, modelo, ano, cor, preco, portas, combustivel, capacidade));
        } else if (tipo == 3) {
            System.out.print("Cilindradas: "); int cil = scanner.nextInt(); scanner.nextLine();
            System.out.print("Partida elétrica? (true/false): "); boolean partida = scanner.nextBoolean(); scanner.nextLine();
            System.out.print("Categoria: "); String categoria = scanner.nextLine();
            motos.add(new Moto(marca, modelo, ano, cor, preco, cil, partida, categoria));
        }
        System.out.println("Veículo cadastrado com sucesso!");
    }

    // ------------- Clientes -------------
    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Idade: "); int idade = scanner.nextInt(); scanner.nextLine();
        System.out.print("Endereço: "); String endereco = scanner.nextLine();
        System.out.print("Telefone: "); String telefone = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Altura em cm: "); double altura = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Peso em kg: "); double peso = scanner.nextDouble(); scanner.nextLine();

        clientes.add(new Pessoa(nome, idade, endereco, telefone, email, altura, peso));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n--- Clientes Cadastrados ---");
        for (Pessoa p : clientes) {
            p.exibirInformacoes();
            System.out.println("------------------------");
        }
    }

    // ------------- Vendas -------------
    private static void venderVeiculo(Scanner scanner) throws Exception {
        if (caminhoes.isEmpty() && carros.isEmpty() && motos.isEmpty()) {
            System.out.println("Sem veículos para vender.");
            return;
        }
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente antes de vender.");
            return;
        }

        System.out.print("Digite o telefone do comprador: ");
        String telefone = scanner.nextLine();
        Pessoa comprador = clientes.stream()
                .filter(c -> c.getTelefone().equals(telefone))
                .findFirst()
                .orElse(null);
        if (comprador == null) {
            throw new ClienteNaoEncontradoException("Cliente com telefone " + telefone + " não encontrado.");
        }

        // Mostrar veículos com índice global
        List<Veiculo> todos = new ArrayList<>();
        todos.addAll(caminhoes);
        todos.addAll(carros);
        todos.addAll(motos);
        System.out.println("\nEscolha o veículo pelo índice:");
        for (int i = 0; i < todos.size(); i++) {
            Veiculo v = todos.get(i);
            System.out.println((i+1) + " - " + v.getMarca() + " " + v.getModelo() + " - R$" + v.getPreco());
        }
        int escolha = scanner.nextInt(); scanner.nextLine();
        if (escolha < 1 || escolha > todos.size()) {
            throw new VeiculoIndisponivelException("Índice de veículo inválido.");
        }
        Veiculo escolhido = todos.get(escolha-1);

        System.out.print("Preço de venda: "); double valorVenda = scanner.nextDouble(); scanner.nextLine();
        Venda venda = new Venda(escolhido, comprador, valorVenda, LocalDateTime.now());
        vendas.add(venda);

        // remover da lista original
        if (escolhido instanceof Caminhao) caminhoes.remove(escolhido);
        else if (escolhido instanceof Carro) carros.remove(escolhido);
        else if (escolhido instanceof Moto) motos.remove(escolhido);

        System.out.println("Venda realizada com sucesso!");
    }

    private static void gerarRelatorio() {
        if (vendas.isEmpty()) {
            System.out.println("Não existem vendas cadastradas!");
            return;
        }
        System.out.println("\n=== Relatório de Vendas ===");
        for (Venda venda : vendas) {
            double lucro = venda.getValor() - venda.getVeiculo().getPreco();
            System.out.println("Data: " + venda.getDataVenda());
            System.out.println("Veículo: " + venda.getVeiculo().getMarca() + " " + venda.getVeiculo().getModelo() + " (" + venda.getVeiculo().getAno() + ")");
            System.out.println("Cliente: " + venda.getComprador().getNome() + " - " + venda.getComprador().getTelefone());
            System.out.printf("Preço de venda: R$ %.2f\n", venda.getValor());
            System.out.printf("Preço de compra (estoque): R$ %.2f\n", venda.getVeiculo().getPreco());
            System.out.printf("Lucro/Perda: R$ %.2f\n", lucro);
            System.out.println("------------------------");
        }
    }

    // ------------- Sugestão por biotipo (IMC) -------------
    private static void sugerirVeiculosPorBiotipo(Scanner scanner) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado para sugerir.");
            return;
        }
        System.out.print("Digite o telefone do cliente para sugerir veículos: ");
        String tel = scanner.nextLine();
        Pessoa p = clientes.stream().filter(c -> c.getTelefone().equals(tel)).findFirst().orElse(null);
        if (p == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        double alturaM = p.getAltura() / 100.0;
        double imc = p.getPeso() / (alturaM * alturaM);
        System.out.printf("IMC do cliente: %.2f\n", imc);

        System.out.println("\nSugestões de veículos para o cliente:");
        List<Veiculo> sugeridos = new ArrayList<>();
        if (imc < 18.5) {
            // Biotipo mais enxuto
            for (Moto m : motos) sugeridos.add(m);
            for (Carro c : carros) if (c.getCapacidadePortaMalas() < 300) sugeridos.add(c);
            for (Caminhao cam : caminhoes) if (cam.getCapacidadeCarga() <= 10) sugeridos.add(cam);
        } else if (imc < 25) {
            // Biotipo médio
            for (Carro c : carros) if (c.getnPortar() >= 4) sugeridos.add(c);
            for (Moto m : motos) if (m.getCilindradas() <= 600) sugeridos.add(m);
            for (Caminhao cam : caminhoes) if (cam.getCapacidadeCarga() <= 15) sugeridos.add(cam);
        } else {
            // Biotipo maior
            for (Carro c : carros) if (c.getCapacidadePortaMalas() >= 300) sugeridos.add(c);
            for (Caminhao cam : caminhoes) if (cam.getCapacidadeCarga() > 15) sugeridos.add(cam);
        }

        if (sugeridos.isEmpty()) {
            System.out.println("Nenhuma sugestão encontrada com base no biotipo.");
        } else {
            for (Veiculo v : sugeridos) {
                System.out.println("- " + v.getMarca() + " " + v.getModelo() + " - R$" + v.getPreco());
            }
        }
    }
}
