public class Eletronico extends Produto {
    protected int garantia;

    public Eletronico(String nome, double preco, int quantidadeEstoque, Fornecedor fornecedor, int garantia) {
        super(nome, preco, quantidadeEstoque, fornecedor);
        this.garantia = garantia;
    }

    public void calcularGarantiaRestante(int mesesDecorridos) {
        int restante = garantia - mesesDecorridos;
        if (restante <= 0) {
            System.out.println("O produto \"" + nome + "\" não está mais coberto pela garantia.");
        } else {
            System.out.println("O produto \"" + nome + "\" ainda possui " + restante + " mês(es) de garantia.");
        }
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Tipo: Eletrônico");
        System.out.println("Garantia: " + garantia + " mês(es)");
        System.out.println("--------------------");
    }
}
