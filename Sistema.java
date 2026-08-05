import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    static Scanner sc = new Scanner(System.in);
    static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        produtos.add(new Alimento("Arroz 5kg", 24.90, 50, LocalDate.now().plusMonths(6)));
        produtos.add(new Eletronico("Smartphone", 1899.00, 15, 12));

        int opcao;
        do {
            System.out.println("\n1-Apresentar 2-Vender 3-Repor 4-Validade 5-Garantia 6-Sair");
            opcao = Integer.parseInt(sc.nextLine());
            Produto p = (opcao >= 1 && opcao <= 5) ? selecionar() : null;

            switch (opcao) {
                case 1 -> { if (p != null) p.apresentar(); }
                case 2 -> { if (p != null) { System.out.print("Quantidade: "); p.vender(Integer.parseInt(sc.nextLine())); } }
                case 3 -> { if (p != null) { System.out.print("Quantidade: "); p.reporEstoque(Integer.parseInt(sc.nextLine())); } }
                case 4 -> { if (p instanceof Alimento a) a.verificarValidade(); else if (p != null) System.out.println("Não é um alimento!"); }
                case 5 -> { if (p instanceof Eletronico e) { System.out.print("Meses decorridos: "); e.calcularGarantiaRestante(Integer.parseInt(sc.nextLine())); } else if (p != null) System.out.println("Não é um eletrônico!"); }
                case 6 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    static Produto selecionar() {
        for (int i = 0; i < produtos.size(); i++) System.out.println((i + 1) + " - " + produtos.get(i).getNome());
        int i = Integer.parseInt(sc.nextLine()) - 1;
        return (i >= 0 && i < produtos.size()) ? produtos.get(i) : null;
    }
}
