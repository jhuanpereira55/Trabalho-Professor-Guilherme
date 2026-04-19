package Exercicio1;
import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
List<Aluguel> alugueis = new ArrayList<>();
List<Horario> horarios = new  ArrayList<>();
List<Cliente> clientes = new ArrayList<>();

 int opcao = -1;
    while(opcao != 0){
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar horário");
        System.out.println("3 - Registrar aluguel");
        System.out.println("4 - Consultar aluguéis por dia");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao){
            case 1:
                System.out.println("Nome client: ");
                String nome = sc.nextLine();

                System.out.println("Telefone: ");
                String telefone = sc.nextLine();

                Cliente c = new Cliente(nome,telefone);
                clientes.add(c);
                System.out.println("Cliente Casdastrado!");
                break;
            case 2:
                System.out.println("Informe horario(ex:08:00): ");
                String horario = sc.nextLine();

                System.out.println("Informe o  valor da Hora: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                Horario h = new Horario(horario,valor);
                horarios.add(h);
                break;
            case 3:
                System.out.println("--Clientes--");
              for(int i = 0; i < clientes.size(); i++){
                  System.out.println(i+" - " + clientes.get(i).getNome());
              }
                System.out.println("Escolha o Cliente: ");
                int indiceCliente = sc.nextInt();
                sc.nextLine();
                Cliente clienteEscolhido = clientes.get(indiceCliente);
//---------------------------
                System.out.println("--Horarios--\n");
                for (int i = 0; i < horarios.size(); i++){
                    System.out.println(i+" - "+ horarios.get(i).getHorario());
                }
                System.out.println("Escolha Horario: ");
                int indiceHorario = sc.nextInt();
                sc.nextLine();
                Horario horarioEscolhido = horarios.get(indiceHorario);
//---------------------------
                System.out.println("Data (ex:2026-04-18): ");
                String data = sc.nextLine();
//---------------------------
                try{
                    Aluguel a = new Aluguel(clienteEscolhido, horarioEscolhido,data);
                    alugueis.add(a);
                    System.out.println("Aluguel registrado!");
                }catch (IllegalArgumentException e){
                    System.out.println("Erro: "+ e.getMessage());
                }
                break;
            case 4:
                System.out.println("Digite a data (ex: 2026-04-18): ");
                String dataBusca = sc.nextLine();

                double total = 0 ;
                boolean encontrou = false;

                for (Aluguel a : alugueis) {
                    if (a.getData().equals(dataBusca)) {
                        System.out.println(a.getCliente().getNome() + " - " + a.getHorario().getHorario() + " - R$" + a.getValortotal());
                        total += a.getValortotal();
                        encontrou = true;
                    }
                }
                if (encontrou){
                    System.out.println("Total do dia: R$ "+total);
                }else{
                    System.out.println("Nenhum alguel econtrado nessa data.");
                }
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opcao invalida!");
        }

        }
    }

}

