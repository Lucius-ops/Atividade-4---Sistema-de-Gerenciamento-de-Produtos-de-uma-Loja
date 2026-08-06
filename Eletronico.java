public class Eletronico extends Produto {
    private int garantia;

    public Eletronico(String nome, double preco, int estoque, Fornecedor fornecedor, int garantia) {
        super(nome, preco, estoque, fornecedor);
        this.garantia = garantia;
    }

    public int getGarantia() { return garantia; }

    public void calcularGarantiaRestante(int mesesDecorridos) {
        int restante = garantia - mesesDecorridos;
        if (restante > 0) {
            System.out.println("Garantia restante: " + restante + " meses");
        } else {
            System.out.println("Garantia expirada!");
        }
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Garantia: " + garantia + " meses");
    }
}
