package Exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Aluno> alunos = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();

int opcao = -1;
while (opcao != 0) {
    System.out.println("\n--- MENU ---");
    System.out.println("1 - Cadastrar livro");
    System.out.println("2 - Cadastrar aluno");
    System.out.println("3 - Registrar emprestimo");
    System.out.println("4 - Registrar devolucao");
    System.out.println("5 - Consultar livros emprestados");
    System.out.println("6 - Consultar alunos com emprestimos em aberto");
    System.out.println("0 - Sair");
    System.out.print("Opcao: ");
    opcao = sc.nextInt();
    sc.nextLine();

    switch (opcao) {
        case 1:
            System.out.print("Titulo: ");
            String titulo = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("Quantidade em estoque: ");
            int quantidade = sc.nextInt();
            sc.nextLine();
            try {
                Livro l = new Livro(titulo, autor, quantidade);
                livros.add(l);
                System.out.println("Livro cadastrado!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 2:
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Telefone: ");
            String telefone = sc.nextLine();
            try {
                Aluno a = new Aluno(nome, telefone);
                alunos.add(a);
                System.out.println("Aluno cadastrado!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 3:
            System.out.println("-- Livros --");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println(i + " - " + livros.get(i).getTitulo() +
                        " (estoque: " + livros.get(i).getQuantidadeEstoque() + ")");
            }
            System.out.print("Escolha o livro: ");
            int indiceLivro = sc.nextInt();
            sc.nextLine();
            Livro livroEscolhido = livros.get(indiceLivro);

            System.out.println("-- Alunos --");
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println(i + " - " + alunos.get(i).getAluno());
            }
            System.out.print("Escolha o aluno: ");
            int indiceAluno = sc.nextInt();
            sc.nextLine();
            Aluno alunoEscolhido = alunos.get(indiceAluno);

            try {
                Emprestimo emp = new Emprestimo(livroEscolhido, alunoEscolhido);
                emprestimos.add(emp);
                System.out.println("Emprestimo registrado!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 4:
            System.out.println("-- Emprestimos em aberto --");
            for (int i = 0; i < emprestimos.size(); i++) {
                if (!emprestimos.get(i).isDevolvido()) {
                    System.out.println(i + " - " +
                            emprestimos.get(i).getAluno().getAluno() +
                            " | " + emprestimos.get(i).getLivro().getTitulo());
                }
            }
            System.out.print("Escolha o emprestimo para devolver: ");
            int indiceEmp = sc.nextInt();
            sc.nextLine();
            try {
                emprestimos.get(indiceEmp).devolver();
                System.out.println("Livro devolvido!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            break;

        case 5:
            System.out.println("-- Livros emprestados --");
            boolean temEmprestado = false;
            for (Emprestimo emp : emprestimos) {
                if (!emp.isDevolvido()) {
                    System.out.println(emp.getLivro().getTitulo() +
                            " -> " + emp.getAluno().getAluno());
                    temEmprestado = true;
                }
            }
            if (!temEmprestado) System.out.println("Nenhum livro emprestado.");
            break;

        case 6:
            System.out.println("-- Alunos com emprestimos em aberto --");
            boolean temAberto = false;
            for (Emprestimo emp : emprestimos) {
                if (!emp.isDevolvido()) {
                    System.out.println(emp.getAluno().getAluno() +
                            " | tel: " + emp.getAluno().getTelefone() +
                            " | livro: " + emp.getLivro().getTitulo());
                    temAberto = true;
                }
            }
            if (!temAberto) System.out.println("Nenhum emprestimo em aberto.");
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