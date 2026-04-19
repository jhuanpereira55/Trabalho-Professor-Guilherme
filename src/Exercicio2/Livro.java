package Exercicio2;

public class Livro {
    private String titulo;
    private String autor;
    private int quantidadeEstoque;
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0){
            throw new IllegalArgumentException("A quantidade estoque nao pode ser menor do que Zero!");
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()){
            throw new IllegalArgumentException("Erro:Nao e possivel registrar o Autor.");
        }
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("Erro:Nao e possivel registrar o titulo.");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public Livro(String titulo, String autor, int quantidadeEstoque) {
       setAutor(autor);
       setTitulo(titulo);
       setQuantidadeEstoque(quantidadeEstoque);
    }






}
