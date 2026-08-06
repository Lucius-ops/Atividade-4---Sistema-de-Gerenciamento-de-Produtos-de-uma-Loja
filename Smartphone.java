public class Smartphone extends Eletronico {
    private String marca;
    private double tamanhoTela;

    public Smartphone(String nome, double preco, int estoque, Fornecedor fornecedor, int garantia, String marca, double tamanhoTela) {
        super(nome, preco, estoque, fornecedor, garantia);
        this.marca = marca;
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Marca: " + marca);
        System.out.println("Tamanho da tela: " + tamanhoTela + "\"");
    }
}
