package Exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String data;
    private List<Produto> produtos;
    private boolean finalizado;

    public Pedido(String data) {
        if (data == null || data.isBlank())
            throw new IllegalArgumentException("Data não pode ser vazia!");
        this.data = data;
        this.produtos = new ArrayList<>();
        this.finalizado = false;
    }

    public void adicionarProduto(Produto produto) {
        if (finalizado)
            throw new IllegalStateException("Pedido já finalizado!");
        produtos.add(produto);
    }

    public void finalizar() {
        if (produtos.isEmpty())
            throw new IllegalStateException("Pedido precisa ter pelo menos um produto!");
        this.finalizado = true;
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }

    public String getData() { return data; }
    public List<Produto> getProdutos() { return produtos; }
    public boolean isFinalizado() { return finalizado; }
}