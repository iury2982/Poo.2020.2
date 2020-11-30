public class Calango {

    int bucho; //atributos
    int maxBucho;
    int beber;
    int maxBeber;
    int nPatas;
    boolean alive;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int bucho, int maxBucho, int beber, int maxBeber,int nPatas){ //parametros
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.beber = beber;
        this.maxBeber = maxBeber;
        this.nPatas = nPatas;
    }

    void Full(){
        this.bucho = this.maxBucho;
        this.beber = this.maxBeber;
        this.nPatas = 4;
    }

    void Low(){
        this.bucho = 1;
        this.beber = 1;
        this.nPatas = 4;
    }

    void Condição(){
        if(bucho == 0 || beber == 0){
            this.alive = false;
            System.out.println("Calanguinho Morreu");
        }else{
            this.alive = true;
            System.out.println("Calaguinho ainda está Vivo");
        }
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
    }
    void beber(int qtd){
        beber += qtd;
        if(beber > maxBeber){
            beber = maxBeber;
            System.out.println("Bebi até ficar Saciado");
        }else{
            System.out.println("Já estou Saciado");
        }
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }



    public String toString() {
        return "Comida: " + bucho + "/" + maxBucho + " Agua " + beber + "/" + maxBeber + " Patas: " + nPatas + " Vivo: " + alive;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        Calango deadlango = new Calango(0, 20, 0, 20, 4);
        
        // Função que altra as propriedades para o Maximo de Status.  
        // deadlango.Full();

        // Função que altera as propriedas para o Menor status que não seja 0.
        // deadlango.Low();
        
        // Função que Alerta a Condição do calango se este chegar a 0 consta que ele ja não está entre nós
        // deadlango.Condição();

        deadlango.Low();
        deadlango.andar();
        deadlango.Condição();

        System.out.println(deadlango);
        System.out.println(" ");
        
        deadlango.Full();
        deadlango.andar();
        deadlango.Condição();

        System.out.println(deadlango);

    }
}


        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();

         // for(int i = 0; i < 25; i++)
        //    deadlango.comer(1);
        //System.out.println(deadlango);
        
        
        // System.out.println(deadlango);

        // for(int i = 0; i < 25; i++)
        //    deadlango.andar();
        // System.out.println(deadlango);