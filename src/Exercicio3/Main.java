package Exercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
ArrayList<Produto> produtos = new ArrayList<>();
ArrayList<Pedido> pedidos = new ArrayList<>();

int opcao = -1;
while (opcao != 0) {
    System.out.println("\n--- MENU ---");
    System.out.println("1 - Cadastrar produto");
    System.out.println("2 - Criar pedido");
    System.out.println("3 - Adicionar produto ao pedido");
    System.out.println("4 - Finalizar pedido");
    System.out.println("5 - Consultar pedidos por dia");
    System.out.println("0 - Sair");
    System.out.print("Opcao: ");
    opcao = sc.nextInt();
    sc.nextLine();

    switch (opcao) {
        case 1:
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Descricao: ");
            String descricao = sc.nextLine();
            System.out.print("Preco: ");
            double preco = sc.nextDouble();
            sc.nextLine();
            try {
                Produto p = new Produto(nome, descricao, preco);
                produtos.add(p);
                System.out.println("Produto cadastrado!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 2:
            System.out.print("Data do pedido (ex: 2026-04-18): ");
            String data = sc.nextLine();
            try {
                Pedido ped = new Pedido(data);
                pedidos.add(ped);
                System.out.println("Pedido criado! Indice: " + (pedidos.size() - 1));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 3:
            System.out.println("-- Pedidos em aberto --");
            for (int i = 0; i < pedidos.size(); i++) {
                if (!pedidos.get(i).isFinalizado())
                    System.out.println(i + " - Pedido " + i + " | " + pedidos.get(i).getData());
            }
            System.out.print("Escolha o pedido: ");
            int indicePedido = sc.nextInt();
            sc.nextLine();

            System.out.println("-- Produtos --");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(i + " - " + produtos.get(i).getNome() +
                        " R$" + produtos.get(i).getPreco());
            }
            System.out.print("Escolha o produto: ");
            int indiceProduto = sc.nextInt();
            sc.nextLine();

            try {
                pedidos.get(indicePedido).adicionarProduto(produtos.get(indiceProduto));
                System.out.println("Produto adicionado!");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 4:
            System.out.println("-- Pedidos em aberto --");
            for (int i = 0; i < pedidos.size(); i++) {
                if (!pedidos.get(i).isFinalizado())
                    System.out.println(i + " - Pedido " + i + " | total parcial: R$" +
                            pedidos.get(i).calcularTotal());
            }
            System.out.print("Escolha o pedido para finalizar: ");
            int indFinalizar = sc.nextInt();
            sc.nextLine();
            try {
                pedidos.get(indFinalizar).finalizar();
                System.out.println("Pedido finalizado! Total: R$" +
                        pedidos.get(indFinalizar).calcularTotal());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 5:
            System.out.print("Digite a data (ex: 2026-04-18): ");
            String dataBusca = sc.nextLine();
            double faturamento = 0;
            boolean encontrou = false;
            for (Pedido ped : pedidos) {
                if (ped.getData().equals(dataBusca) && ped.isFinalizado()) {
                    System.out.println("Pedido | Total: R$" + ped.calcularTotal());
                    for (Produto p : ped.getProdutos()) {
                        System.out.println("  - " + p.getNome() + " R$" + p.getPreco());
                    }
                    faturamento += ped.calcularTotal();
                    encontrou = true;
                }
            }
            if (encontrou) {
                System.out.println("Faturamento do dia: R$" + faturamento);
            } else {
                System.out.println("Nenhum pedido encontrado nessa data.");
            }
            break;

        case 0:
            System.out.println("Encerrando...");
            break;

        default:
            System.out.println("Opcao invalida!");
    }
}
sc.close();
}
}