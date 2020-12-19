import java.util.Scanner;

public class Tamagochi {
    public int energia;
    public int energia_max;
    public int saciedade;
    public int saciedade_max;
    public int limp_max;
    public int limp;   
    public int diamante = 0;
    public int idade = 0; 
    public boolean alive = true;

    Tamagochi(int energia_max, int saciedade_max, int limp_max){
        
        this.energia_max = energia_max;
        this.saciedade_max = saciedade_max;
        this.limp_max = limp_max;

        this.energia = energia_max;
        this.saciedade = saciedade_max;
        this.limp = limp_max;
    }


    public void comer(){
        if(alive == false){
            System.out.println("fail: o pet esta morto");
        }else if(saciedade < saciedade_max - 4 && alive == true){
            saciedade += 4;
            energia --;
            limp -= 2;
            idade ++;
        }else if(saciedade >= saciedade_max - 4 && alive == true){
            saciedade = saciedade_max;
            energia --;
            limp -= 2;
            idade ++;
        }else if(energia <= 0 && alive == true){
            System.out.println("fail: pet morreu de fraqueza");
            energia = 0;
            alive = false;
        }else if(limp <= 0 && alive == true){
            System.out.println("fail: pet morreu de sujeira");
            limp = 0;
            alive = false;
        }
    }

    public void brincar(){
        if(alive == false){
            System.out.println("fail: o pet esta morto");
        }else{
        energia -= 2;
        saciedade --;
        limp -= 3;
        diamante ++;
        idade ++;
        
        if(limp <= 0 && alive == true){
            System.out.println("fail: pet morreu de sujeira");
            limp = 0;
            alive = false;
        }else if(energia <= 0 && alive == true){
            System.out.println("fail: pet morreu de fraqueza");
            energia = 0;
            alive = false;
        }else if(saciedade <= 0 && alive == true){
            System.out.println("fail: pet morreu de fome");
            saciedade = 0;
            alive = false;
        }
        }
    }
    public void dormir(){
        if(alive == false){
            System.out.println("fail: o pet esta morto");
        }else if(energia > 15 && alive == true){
            System.out.println("fail: nao esta com sono");
        }else if(saciedade <= 0 && alive == true){
            System.out.println("fail: pet morreu de fome");
            saciedade = 0;
            alive = false;
        }else if(alive == false){
            System.out.println("fail: o pet esta morto");
        }else{
            idade += energia_max - energia;
            energia = energia_max;
            saciedade --;
        }
    }

    public void TomarBanho(){
        if(alive == false){
            System.out.println("fail: o pet esta morto");
        }else if(energia <= 0 && alive == true){
            System.out.println("fail: pet morreu de fraqueza"); 
            energia = 0;
            alive = false;   
        }else if(saciedade <= 0 && alive == true){
            System.out.println("fail: pet morreu de sujeira");
            saciedade = 0;
            alive = false;
        }else{
            energia -= 3;
            saciedade --;
            limp = limp_max;
            idade += 2;
        }
    }

    public String toString(){
        return "E: " + energia + "/" + energia_max + " S: " + saciedade + "/"+ saciedade_max + " L: " + limp + "/" + limp_max + " D: " + diamante + " I: " + idade;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Tamagochi tamagochi = null;

        while(true){
            String line = scanner.nextLine();
            String [] ui = line.split(" ");
            if(ui[0].equals("$init")){
                tamagochi = new Tamagochi(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]));
            }if(line.equals("$show")){
                System.out.println(tamagochi);
            }if(line.equals("$play")){
                tamagochi.brincar();
            }if(line.equals("$eat")){
                tamagochi.comer();
            }if(line.equals("$sleep")){
                tamagochi.dormir();
            }if(line.equals("$clean")){
                tamagochi.TomarBanho();
            }if(line.equals("$end")){
                break;
            }
    
        }
        scanner.close();
    }
}
