public class Produto {
    protected String nome;
    protected double preco;
    protected int quantidadeEstoque;
    protected Fornecedor fornecedor;

    public Produto(String nome, double preco, int quantidadeEstoque, Fornecedor fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para venda.");
            return;
        }
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
            System.out.println("Venda de " + quantidade + " unidade(s) de \"" + nome + "\" realizada com sucesso!");
        } else {
            System.out.println("Estoque insuficiente! Disponível: " + quantidadeEstoque + " unidade(s).");
        }
    }

    public void vender(int quantidade, double valorPagamento) {
        vender(quantidade, valorPagamento, 0.0);
    }

    public void vender(int quantidade, double valorPagamento, double desconto) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para venda.");
            return;
        }
        if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente! Disponível: " + quantidadeEstoque + " unidade(s).");
            return;
        }

        double valorTotal = preco * quantidade;
        double valorComDesconto = valorTotal - desconto;
        if (valorComDesconto < 0) {
            valorComDesconto = 0;
        }

        if (valorPagamento >= valorComDesconto) {
            quantidadeEstoque -= quantidade;
            double troco = valorPagamento - valorComDesconto;
            System.out.println("Venda de " + quantidade + " unidade(s) de \"" + nome + "\" realizada com sucesso!");
            System.out.printf("Valor total: R$ %.2f | Desconto: R$ %.2f | Valor a pagar: R$ %.2f%n",
                    valorTotal, desconto, valorComDesconto);
            System.out.printf("Troco: R$ %.2f%n", troco);
        } else {
            System.out.printf("Pagamento insuficiente! Valor a pagar: R$ %.2f, mas foi informado R$ %.2f%n",
                    valorComDesconto, valorPagamento);
        }
    }

    public void reporEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para reposição.");
            return;
        }
        quantidadeEstoque += quantidade;
        System.out.println(quantidade + " unidade(s) adicionadas ao estoque de \"" + nome + "\".");
    }

    public void apresentar() {
        System.out.println("----- Produto -----");
        System.out.println("Nome: " + nome);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque + " unidade(s)");
        if (fornecedor != null) {
            fornecedor.apresentar();
        }
    }
}
