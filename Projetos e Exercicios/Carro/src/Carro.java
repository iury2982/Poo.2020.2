import java.util.Scanner;

public class Carro{
    public int num_pessoas;
    public int num_pmax;
    public int tanque;
    public int tanque_max;
    public int km;

    Carro(int num_pessoas, int num_pmax, int tanque, int tanque_max){
        this.num_pessoas = num_pessoas;
        this.num_pmax = num_pmax;
        this.tanque = tanque;
        this.tanque_max = tanque_max;    
    }

    public void Entrar(){
        if(num_pessoas >= num_pmax){
            System.out.println("fail: limite de pessoas atingido");
        }else{
            num_pessoas ++;
        }
    }

    public void Sair(){
        if(num_pessoas <= num_pmax && num_pessoas > 0){
            num_pessoas --;
        }else if(num_pessoas == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }
    }

    public void Abastecer(int qtd){
        tanque += qtd;
        if(tanque > tanque_max){
            tanque = tanque_max;
        }
    }

    public void Dirigir(int dist){
        if(tanque < dist && num_pessoas > 0){
            km += tanque;
            System.out.println("fail: tanque vazio apos andar " + tanque + " km");
            tanque = 0;
            return;
        }else if(tanque > km && num_pessoas > 0){
            km += dist;
            tanque -= dist;
        }else if(num_pessoas == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }else if(tanque == 0){
            System.out.println("fail: tanque vazio");
        }
    }

    public String toString(){
        return "pass: " + num_pessoas + " gas: " + tanque + " km: " + km; 
    }
    public static void main(String[] args) throws Exception {
        Carro carro = new Carro(0, 2, 0, 100);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(line.equals("$show")){
                System.out.println(carro);
            }else if(line.equals("$in")){
                carro.Entrar();
            }else if(line.equals("$out")){
                carro.Sair();
            }else if(ui[0].equals("$fuel")){
                carro.Abastecer(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("$drive")){
                carro.Dirigir(Integer.parseInt(ui[1]));
            }if(ui[0].equals("$end")){
                break;
            }
        }
        scanner.close(); 
        }
    }
