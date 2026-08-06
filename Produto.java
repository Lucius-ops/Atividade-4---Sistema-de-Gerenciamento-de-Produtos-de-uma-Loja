public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private Fornecedor fornecedor;

    public Produto(String nome, double preco, int estoque, Fornecedor fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public Fornecedor getFornecedor() { return fornecedor; }

    public void vender(int qtd) {
        if (qtd > 0 && qtd <= estoque) {
            estoque -= qtd;
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }

    public void vender(int qtd, double valorPagamento) {
        vender(qtd, valorPagamento, 0);
    }

    public void vender(int qtd, double valorPagamento, double desconto) {
        if (qtd <= 0 || qtd > estoque) {
            System.out.println("Estoque insuficiente!");
            return;
        }
        double total = (preco * qtd) - desconto;
        if (valorPagamento >= total) {
            estoque -= qtd;
            System.out.println("Venda realizada com sucesso! Total: R$ " + total + " Troco: R$ " + (valorPagamento - total));
        } else {
            System.out.println("Pagamento insuficiente! Faltam R$ " + (total - valorPagamento));
        }
    }

    public void reporEstoque(int qtd) {
        estoque += qtd;
        System.out.println("Estoque atualizado: " + estoque);
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Estoque: " + estoque);
        System.out.println("Fornecedor: " + fornecedor.getNome() + " | Tel: " + fornecedor.getTelefone() + " | CNPJ: " + fornecedor.getCnpj());
    }
}
