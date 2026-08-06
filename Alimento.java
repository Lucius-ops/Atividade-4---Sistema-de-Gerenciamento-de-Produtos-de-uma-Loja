import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimento extends Produto {
    private LocalDate validade;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Alimento(String nome, double preco, int quantidadeEstoque, Fornecedor fornecedor, LocalDate validade) {
        super(nome, preco, quantidadeEstoque, fornecedor);
        this.validade = validade;
    }

    public void verificarValidade() {
        LocalDate hoje = LocalDate.now();
        if (validade.isBefore(hoje)) {
            System.out.println("O alimento \"" + nome + "\" está VENCIDO desde " + validade.format(FORMATO) + "!");
        } else if (validade.isEqual(hoje)) {
            System.out.println("O alimento \"" + nome + "\" vence HOJE!");
        } else {
            System.out.println("O alimento \"" + nome + "\" está dentro da validade. Vence em "
                    + validade.format(FORMATO) + ".");
        }
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Tipo: Alimento");
        System.out.println("Validade: " + validade.format(FORMATO));
        System.out.println("--------------------");
    }
}
