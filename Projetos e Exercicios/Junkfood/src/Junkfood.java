import java.util.ArrayList;
import java.util.Scanner;

class Espiral{
    public String nome = "-";
    public float valor = 0.2f;
    public int qtd;

    public Espiral(String nome, float valor, int qtd){
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    public void edit(String nome, float valor, int qtd){
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    public String toString() {
        return nome + " : " + qtd + " U " + " : " + valor + "$";
    }
}




public class Junkfood {
    public float saldo;
    public Float lucro;
    public ArrayList<Espiral> espiral;

    public Junkfood(){
        this.saldo = 0;
        this.lucro = 0.0f;
        this.espiral = new ArrayList<>();

    }


    public void AdicionarDinheiro(Float dindin){
        this.saldo = dindin;
    }

    public void AdicionarProduto(String nome, float valor, int qtd){
        espiral.add(new Espiral(nome, valor, qtd));
    }

    public void troco(){
        if(saldo > 0){
            System.out.println("System: Seu troco é de " + saldo + "$");
            this.saldo = 0;
        }
        else System.out.println("System: não há troco");
    }

    public void comprar(int indice, int qtd){
        for(int i = 0; i < qtd; i++){
            if(indice >= 0 && indice < espiral.size()){
                if(espiral.get(indice).valor <= this.saldo){
                    if(espiral.get(indice).qtd > 0){
                        this.saldo -= espiral.get(indice).valor;
                        this.lucro += espiral.get(indice).valor;
                        espiral.get(indice).qtd --;
                    }
                    else {
                        System.out.println("SYSTEM-FAIL:Produto insuficiente");
                        break;
                    }
                }
                else {
                    System.out.println("SYSTEM-FAIL:Saldo insuficiente");
                    break;
                }
            }
            else {
                System.out.println("SYSTEM-FAIL:Indice não existe");
                break;
            }
            
        }
        
    }

    public boolean alterarEspiral(int indice, String nome, float valor, int qtd){
        if(indice >= 0 && indice < espiral.size()){
            espiral.get(indice).edit(nome, valor, qtd);
            return true;
        }
        return false;
    }
    
    public float getSaldo(){
        return saldo;
    }

    public String toString() {
        String saida = "Saldo : " + this.saldo + "\n";
        int i=0;
        for(Espiral espira : espiral){
            saida += i +"- [ " + espira + " ] \n";
            i++;
        }
        return saida;
    }

  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Junkfood maquina1 = new Junkfood();
        
        System.out.println("COMANDOS----------------/n");
        System.out.println("$init\n$end\n$dinheiro qtd\n$produto nome valor qtd\n$troco\n$comprar indice qtd\n$set indice nome valor qtd\n$show\n");

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("$init")){
                maquina1 = new Junkfood();
                System.out.println(maquina1);
            }

            if(ui[0].equals("$end")){
                System.out.println("Fim do programa");
                break;
            }

            if(ui[0].equals("$dinheiro")){
                maquina1.AdicionarDinheiro(Float.parseFloat(ui[1]));
                System.out.println(maquina1);
            }

            if(ui[0].equals("$produto")){
                maquina1.AdicionarProduto(ui[1], Float.parseFloat(ui[2]), Integer.parseInt(ui[3]));
                System.out.println(maquina1);
            }
            
            if(ui[0].equals("$troco")){
                maquina1.troco();
            }

            if(ui[0].equals("$comprar")){
                maquina1.comprar(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                System.out.println(maquina1);
            }

            if(ui[0].equals("$set")){
                maquina1.alterarEspiral(Integer.parseInt(ui[1]), ui[2], Float.parseFloat(ui[3]), Integer.parseInt(ui[4]));
                System.out.println(maquina1);
            }

            if(ui[0].equals("$show")){
                System.out.println(maquina1);
            }

            
        }
        scanner.close();
    
    }


}
