import java.util.Scanner;

enum Moeda{
    M05(0.05f, 1),
    M10(0.10f, 1),
    M15(0.15f, 2),
    M25(0.25f, 4),
    M50(0.50f, 2),
    M100(1.0f, 4);

    float valor;
    int volume;

    Moeda(float valor, int volume){
        this.valor = valor;
        this.volume = volume;
    }

    public String toString() {
        return "Valor: " + valor + " Volume: " + volume;
    }

}

class Item{

    String descricao;
    int volume;

    Item(String descricao, int volume){
        this.descricao = descricao;
        this.volume = volume;
    }

    public String toString() {
        return "Descrição: " + descricao + " Volume: " + volume;
    }
}

class Porco{
    String item = "";
    float valor = 0.0f;
    int volume = 0;
    int volumeMax;
    boolean quebrado = false;

    Porco(int volumeMax){
        this.volumeMax = volumeMax;
    }

    public String toString() {
        
        return "Items: " + item + " \nValor: " + valor + " \nVolume: " + volume + "/" + volumeMax + " \nO Cofre ta quebrado?: " + quebrado;
    }


    boolean colocarMoeda(Moeda moeda){
        if(quebrado){
            System.out.println("O Cofre está quebrado");
            return false;
        }
        if(this.volume + moeda.volume > this.volumeMax){
            System.out.println("O cofre está cheio");
            return false;
        }
        this.valor += moeda.valor;
        this.volume += moeda.volume;
        return true;
    }
    boolean colocarItem(Item item){
        if(quebrado){
            System.out.println("O Cofre está quebrado");
            return false;
        }
        if(this.volume + item.volume > this.volumeMax){
            System.out.println("O cofre está cheio");
            return false;
        }
        this.volume += item.volume;
        if(this.item.equals("")){
            this.item = item.descricao;
        }
        else {
            this.item += ", " + item.descricao;
        }
        return true;
    }    

    boolean quebrarCofre(){
        if(quebrado){
            System.out.println("O Cofre ja está quebrado");
            return false;
        }
        this.quebrado = true;
        this.volumeMax = 0;
        return true;
    }

    float pegarDinheiro(){
        if(!quebrado){
            System.out.println("É necessario quebrar o cofre primeiro");
            return 0.0f;
        }
        float money = this.valor;
        this.valor = 0.0f;
        return money;
    }

    String pegarItem(){
        if(!quebrado){
            System.out.println("É necessario quebrar o cofre primeiro");
            return "";
        }
        String coisa = this.item;
        this.item = "";
        return coisa;
    }

}

public class Cofre {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Porco porco = new Porco(0);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("setVolume")){
                porco = new Porco(Integer.parseInt(ui[1]));
            }

            else if(ui[0].equals("end")){
                System.out.println("Fim do programa");
                break;
            }
            
            else if(ui[0].equals("show")){
                System.out.println(porco);
            }

            else if(ui[0].equals("put")){
                if(ui[1].equals("Moeda")){
                    if(ui[2].equals("0,05")){
                        porco.colocarMoeda(Moeda.M05);
                    }
                    else if(ui[2].equals("0,10")){
                        porco.colocarMoeda(Moeda.M10);
                    }
                    else if(ui[2].equals("0,15")){
                        porco.colocarMoeda(Moeda.M15);
                    }
                    else if(ui[2].equals("0,25")){
                        porco.colocarMoeda(Moeda.M25);
                    }
                    else if(ui[2].equals("0,50")){
                        porco.colocarMoeda(Moeda.M50);
                    }
                    else if(ui[2].equals("1,00")){
                        porco.colocarMoeda(Moeda.M100);
                    }
                }
                if(ui[1].equals("Item")){
                    porco.colocarItem(new Item(ui[2], Integer.parseInt(ui[3])));
                }
            }

            else if(ui[0].equals("break")){
                porco.quebrarCofre();
            }

            else if(ui[0].equals("recall")){
                System.out.println("Voce tem ->" + porco.pegarDinheiro());
                System.out.println("Os items são ->" + porco.pegarItem());
            }
            else System.out.println("FAIL: Comando errado!!!");
        }
        scanner.close();
    }
}
