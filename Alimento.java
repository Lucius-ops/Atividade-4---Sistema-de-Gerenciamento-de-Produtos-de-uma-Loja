import java.time.LocalDate;

public class Alimento extends Produto {
    private LocalDate validade;

    public Alimento(String nome, double preco, int estoque, Fornecedor fornecedor, LocalDate validade) {
        super(nome, preco, estoque, fornecedor);
        this.validade = validade;
    }

    public void verificarValidade() {
        if (validade.isBefore(LocalDate.now())) {
            System.out.println("Alimento vencido em " + validade);
        } else {
            System.out.println("Alimento dentro da validade: " + validade);
        }
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Validade: " + validade);
    }
}
