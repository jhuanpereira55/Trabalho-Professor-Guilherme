package Exercicio2;

public class Aluno {


    private String aluno;
    private String telefone;

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()){
            throw new IllegalArgumentException("Erro ao cadastrar telefone.");
        }
        this.telefone = telefone;
    }

    public void setAluno(String aluno) {
        if (aluno == null || aluno.isBlank()){
            throw new IllegalArgumentException("Erro ao cadastrar Aluno.");
        }
        this.aluno = aluno;
    }

    public String getAluno() {
        return aluno;
    }

    public String getTelefone() {
        return telefone;
    }

    public Aluno(String aluno, String telefone) {
        setAluno(aluno);
        setTelefone(telefone);
    }
}
