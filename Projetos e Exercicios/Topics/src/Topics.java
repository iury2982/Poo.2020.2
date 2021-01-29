import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

class Pass implements Comparable<Pass> {
    private String nome;
    private int idade;
    private String id;

    public Pass(String nome, int idade, String id) {
        this.nome = nome;
        this.idade = idade;
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return this.getId() + ":" + this.nome + ":" + this.idade + "Anos";
    }

    public int compareTo(Pass other) {
        return getId().compareTo(other.getId());
    }
}

class Veiculo {
    ArrayList<Pass> assentos;

    public Veiculo(int tamanho) {
        assentos = new ArrayList<>(Collections.nCopies(tamanho, null));
    }

    public void reservar(String id, String nome, int idade, int index) {
        if (index < 0 || index > assentos.size()) {
            System.out.println("Assento Invalido");
            return;
        }

        if (assentos.get(index) != null) {
            System.out.println("Assento Ocupado");
            return;
        }

        for (Pass assentos : assentos) {
            if (assentos != null && assentos.getId().equals(id)) {
                System.out.println("Ja existe essa pessoa na Van");
                return;
            }
        }

        assentos.set(index, new Pass(id, idade, nome));
    }

    public void cancelar(String id) {
        boolean encontrei = false;
        for (int i = 0; i < assentos.size(); i++) {
            if (assentos.get(i) != null && assentos.get(i).getId().equals(id)) {
                assentos.set(i, null);
                encontrei = true;
                break;
            }
        }
        if(encontrei) System.out.println("Reserva de assento cancelada");
        else System.out.println("Id não encontrado");
    }

    public String toString() {
        String saida = "[ ";
        for(Pass pass: assentos){
            if(pass == null) saida += "-";
            else saida += pass + " ";
        }
        return saida + " ]";
    }
}

public class Topics{
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo(12);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("Iniciar")){
                veiculo = new Veiculo(Integer.parseInt(ui[1]));
                System.out.println(veiculo);
            }

            if(ui[0].equals("Encerrar")){
                System.out.println("Fim do programa");
                break;
            }

            if(ui[0].equals("reservar")){
                veiculo.reservar(ui[1], ui[2], Integer.parseInt(ui[3]), Integer.parseInt(ui[4]));
                System.out.println(veiculo);
            }

            if(ui[0].equals("cancelar")){
                veiculo.cancelar(ui[1]);
                System.out.println(veiculo);
            }

            
        }
        scanner.close();
    
    }

}