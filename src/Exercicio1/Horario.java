package Exercicio1;

public class Horario {
    private String horario;
    private double valor;
    private boolean ocupado;

public Horario(String  horario , double valor){
    setHorario(horario);
    setValor(valor);
}

public void setHorario(String horario) {
    if (horario.isBlank()){
        throw new IllegalArgumentException("Horario nao pode ser negativo!");
}
        this.horario = horario;
}

public void setValor(double valor) {
    if (valor < 0 ){
        throw new IllegalArgumentException("Nao e permitido o valor ser negativo!");
}
        this.valor = valor;
}

public boolean isOcupado(){
    return ocupado;
}
public void setOcupado(boolean ocupado){
    if (this.ocupado == true){
        throw new IllegalArgumentException("Horario ja esta Reservado.");
    }
        this.ocupado = ocupado;
}
public String getHorario() {
    return horario;
}

public Double getValor() {
    return valor;
}
}
