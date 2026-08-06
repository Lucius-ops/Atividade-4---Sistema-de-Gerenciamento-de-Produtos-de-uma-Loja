public class Fornecedor {
    private String nome;
    private String telefone;
    private String cnpj;

    public Fornecedor(String nome, String telefone, String cnpj) {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getCnpj() { return cnpj; }
}
