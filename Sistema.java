import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    static Scanner sc = new Scanner(System.in);
    static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Fornecedor f1 = new Fornecedor("Distribuidora ABC", "51 9999-0000", "12.345.678/0001-90");
        Fornecedor f2 = new Fornecedor("Tech Import", "51 8888-1111", "98.765.432/0001-10");

        produtos.add(new Alimento("Arroz 5kg", 24.90, 50, f1, LocalDate.now().plusMonths(6)));
        produtos.add(new Eletronico("Fone Bluetooth", 149.90, 40, f2, 6));
        produtos.add(new Smartphone("Galaxy S", 1899.00, 15, f2, 12, "Samsung", 6.5));

        int opcao;
        do {
            System.out.println("\n1-Apresentar 2-Vender 3-Repor 4-Validade 5-Garantia 6-Sair");
            opcao = Integer.parseInt(sc.nextLine());
            Produto p = (opcao >= 1 && opcao <= 5) ? selecionar() : null;

            switch (opcao) {
                case 1 -> { if (p != null) p.apresentar(); }
                case 2 -> vender(p);
                case 3 -> { if (p != null) { System.out.print("Quantidade: "); p.reporEstoque(Integer.parseInt(sc.nextLine())); } }
                case 4 -> { if (p instanceof Alimento a) a.verificarValidade(); else if (p != null) System.out.println("Não é um alimento!"); }
                case 5 -> { if (p instanceof Eletronico e) { System.out.print("Meses decorridos: "); e.calcularGarantiaRestante(Integer.parseInt(sc.nextLine())); } else if (p != null) System.out.println("Não é um eletrônico!"); }
                case 6 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    static void vender(Produto p) {
        if (p == null) return;
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(sc.nextLine());
        System.out.print("Aplicar desconto? (s/n): ");
        boolean desconto = sc.nextLine().equalsIgnoreCase("s");
        System.out.print("Valor do pagamento: ");
        double pagamento = Double.parseDouble(sc.nextLine());
        if (desconto) {
            System.out.print("Valor do desconto: ");
            double valorDesconto = Double.parseDouble(sc.nextLine());
            p.vender(qtd, pagamento, valorDesconto);
        } else {
            p.vender(qtd, pagamento);
        }
    }

    static Produto selecionar() {
        for (int i = 0; i < produtos.size(); i++) System.out.println((i + 1) + " - " + produtos.get(i).getNome());
        int i = Integer.parseInt(sc.nextLine()) - 1;
        return (i >= 0 && i < produtos.size()) ? produtos.get(i) : null;
    }
}
