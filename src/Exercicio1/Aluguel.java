package Exercicio1;

public class Aluguel {
private Horario horario;
private Cliente cliente;
private double valortotal;
private String data;

public Aluguel(Cliente cliente , Horario horario, String data){
    if (horario.isOcupado()){
        throw new IllegalArgumentException("Horario ja esta reservado!");
}

    this.cliente = cliente;
    this.horario = horario;
    this.data = data;
        horario.setOcupado(true);//marcando como ocupado na hora q o aluguel for criado
        this.valortotal = horario.getValor();
}

public Horario getHorario() {
    return horario;
}

public Cliente getCliente() {
    return cliente;
}

public String getData() {
    return data;
}

public double getValortotal() {
    return valortotal;
}

}
