package Exercicio2;

public class Emprestimo {
    private Livro livro;
    private Aluno aluno;
    private boolean devolvido;

public Emprestimo(Livro livro, Aluno aluno) {

if (livro.getQuantidadeEstoque() == 0){
    throw new IllegalArgumentException("Livro sem estoque!");
}
    this.livro = livro;
    this.aluno = aluno;
    this.devolvido = false;
        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() - 1);
}
public void devolver(){
    if (devolvido){
        throw new IllegalArgumentException("Este livro ja foi devolvido!");
}
    this.devolvido = true;
        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() + 1);
}

public boolean isDevolvido() {
    return devolvido;
}

public Aluno getAluno() {
    return aluno;
}

public Livro getLivro() {
    return livro;
}


}
