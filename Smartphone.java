public class Smartphone extends Eletronico {
    private String marca;
    private double tamanhoTela;

    public Smartphone(String nome, double preco, int quantidadeEstoque, Fornecedor fornecedor,
                       int garantia, String marca, double tamanhoTela) {
        super(nome, preco, quantidadeEstoque, fornecedor, garantia);
        this.marca = marca;
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public void apresentar() {
        System.out.println("----- Produto -----");
        System.out.println("Nome: " + nome);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque + " unidade(s)");
        if (fornecedor != null) {
            fornecedor.apresentar();
        }
        System.out.println("Tipo: Eletrônico / Smartphone");
        System.out.println("Garantia: " + garantia + " mês(es)");
        System.out.println("Marca: " + marca);
        System.out.printf("Tamanho da tela: %.1f polegadas%n", tamanhoTela);
        System.out.println("--------------------");
    }
}
