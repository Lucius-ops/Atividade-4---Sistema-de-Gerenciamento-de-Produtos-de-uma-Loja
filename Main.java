import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.println("=== Sistema de Gerenciamento de Produtos ===");

        Produto produto = cadastrarProduto();

        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    produto.apresentar();
                    break;
                case 2:
                    realizarVenda(produto);
                    break;
                case 3:
                    int qtdRepor = lerInteiro("Quantidade a repor no estoque: ");
                    produto.reporEstoque(qtdRepor);
                    break;
                case 4:
                    if (produto instanceof Alimento) {
                        ((Alimento) produto).verificarValidade();
                    } else {
                        System.out.println("Essa opção só está disponível para alimentos.");
                    }
                    break;
                case 5:
                    if (produto instanceof Eletronico) {
                        int meses = lerInteiro("Quantos meses se passaram desde a compra? ");
                        ((Eletronico) produto).calcularGarantiaRestante(meses);
                    } else {
                        System.out.println("Essa opção só está disponível para eletrônicos.");
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 6);

        scanner.close();
    }

    static Produto cadastrarProduto() {
        System.out.println("\nCadastro do Fornecedor:");
        System.out.print("Nome do fornecedor: ");
        String nomeForn = scanner.nextLine();
        System.out.print("Telefone do fornecedor: ");
        String telForn = scanner.nextLine();
        System.out.print("CNPJ do fornecedor: ");
        String cnpjForn = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(nomeForn, telForn, cnpjForn);

        System.out.println("\nQual tipo de produto deseja cadastrar?");
        System.out.println("1 - Alimento");
        System.out.println("2 - Eletrônico");
        System.out.println("3 - Smartphone");
        int tipo = lerInteiro("Opção: ");

        System.out.print("\nNome do produto: ");
        String nome = scanner.nextLine();
        double preco = lerDouble("Preço do produto: ");
        int estoque = lerInteiro("Quantidade em estoque: ");

        switch (tipo) {
            case 1:
                LocalDate validade = lerData("Data de validade (dd/MM/yyyy): ");
                return new Alimento(nome, preco, estoque, fornecedor, validade);
            case 2:
                int garantia = lerInteiro("Garantia (em meses): ");
                return new Eletronico(nome, preco, estoque, fornecedor, garantia);
            case 3:
                int garantiaSmart = lerInteiro("Garantia (em meses): ");
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                double tela = lerDouble("Tamanho da tela (polegadas): ");
                return new Smartphone(nome, preco, estoque, fornecedor, garantiaSmart, marca, tela);
            default:
                System.out.println("Opção inválida! Cadastrando como Eletrônico com garantia 0.");
                return new Eletronico(nome, preco, estoque, fornecedor, 0);
        }
    }

    static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Apresentar informações do produto");
        System.out.println("2. Vender produto");
        System.out.println("3. Repor estoque");
        System.out.println("4. Verificar validade (apenas alimentos)");
        System.out.println("5. Calcular garantia restante (apenas eletrônicos)");
        System.out.println("6. Encerrar o programa");
    }

    static void realizarVenda(Produto produto) {
        int quantidade = lerInteiro("Quantidade a vender: ");

        System.out.println("Como deseja registrar a venda?");
        System.out.println("1 - Apenas dar baixa no estoque");
        System.out.println("2 - Informar valor pago (sem desconto)");
        System.out.println("3 - Informar valor pago e desconto");
        int opcaoVenda = lerInteiro("Opção: ");

        switch (opcaoVenda) {
            case 1:
                produto.vender(quantidade);
                break;
            case 2:
                double valorPago = lerDouble("Valor pago pelo cliente: ");
                produto.vender(quantidade, valorPago);
                break;
            case 3:
                double pagamento = lerDouble("Valor pago pelo cliente: ");
                double desconto = lerDouble("Valor do desconto: ");
                produto.vender(quantidade, pagamento, desconto);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número inteiro válido.");
            scanner.next();
            System.out.print(mensagem);
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
            System.out.print(mensagem);
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    static LocalDate lerData(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine();
            try {
                return LocalDate.parse(texto, formatoData);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
            }
        }
    }
}
