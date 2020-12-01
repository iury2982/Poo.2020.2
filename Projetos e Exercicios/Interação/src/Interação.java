import java.util.Scanner;
public class Interação{
    String name;
    Interação(String name){
        this.name = name;
    }
    public String toString() {
        return "Nome: " + this.name;
    }
    public static void main(String[] args) {
        Interação mago = new Interação("Iury o Magro");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){//init _nome
                mago = new Interação(ui[1]);
            }else if(ui[0].equals("show")){
                System.out.println(mago);
            }else{
                System.out.println("Comando invalido");
            }
        }
        scanner.close();
    }
}