import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


class Fone{
    String label;
    String number;

    public Fone(String label, String number){
        this.label = label;
        this.number = number;
    }

    public static boolean validate(String number){
        String validos = "0123456789()-";
        for(int i = 0; i < number.length(); i++)
            if(validos.indexOf(number.charAt(i)) == -1)
                return false;
        return true;
    }
    public String toString(){
        return label + ":" + number;
    }
}

class Contato{
    String nome;
    ArrayList<Fone> fones;

    public String getNome(){
        return nome;
    }

    public Contato(String nome){
        this.nome = nome;
        this.fones = new ArrayList<>();
    }

    public void addFone(String label, String number){
        if(Fone.validate(number))
            fones.add(new Fone(label, number));
    }

    Fone getFone(int index){
        if(index >= 0 && index < fones.size()) {
            return fones.get(index);
        }
        System.out.println("Indice invalido");
        return null;
    }
    
    Fone getFone(String label) {    //se nao encontrar, retorna null
        for(Fone fone : fones)
            if(fone.label.equals(label))
                return fone;
        return null;
    }
    boolean rmFone(int index){
        if(index < 0 || index >= fones.size())
            return false;
        fones.remove(index);
        return true;
    }

    boolean rmFone(String number){
        if(!Fone.validate(number)){
            System.out.println("Digite um numero valido");
            return false;
        }
        for(Fone fone : fones){
            if(fone.number.equals(number)){
                fones.remove(fone);
                break;
            }
        }
        return false;
    }

    public String toString(){
        String saida = this.nome;
        int i = 0;
        for(Fone fone : fones){
            saida += " [" + i + ":" + fone + "]";
            i++;
        }
        return saida;
    }

}

class Agenda{
    private TreeMap<String, Contato> contatos;
    
    public Agenda(){
        contatos = new TreeMap<>();
    }

    Contato getContato(String name) {
        for(Contato cont: contatos.values()){
            if(cont.getNome().equals(name)){
                return cont;
            }
        }
        return null;
    }
    
    public boolean initContato(String nome){
        Contato cont = getContato(nome);
        if(cont != null) return false;
        contatos.put(nome, new Contato(nome));
        return true;
    }

    public void addContato(String name, String id, String number){
        Contato cont = getContato(name);
        if(cont == null){
            cont = new Contato(name);
            cont.addFone(id, number);
        }
        else if(cont != null){
            cont.addFone(id, number);    
        }
        
    }
    
    public boolean rmContato(String name){
        Contato cont = getContato(name);
        if(cont == null){
            return false;
        }
        contatos.remove(name);
        return true;
    }

    public void search(String label){
        
        ArrayList<Contato> pesquisa = new ArrayList<>();
        
        for(Contato cont : contatos.values()){
            if(cont.toString().indexOf(label) != -1)
                pesquisa.add(cont);
        }
        
        for(int i = 0; i < pesquisa.size(); i++){
            System.out.println(pesquisa.get(i));
        }
    }

    public void rmFoneindice(String name, int indice){
        Contato contatos = getContato(name);
        if(contatos != null)
            contatos.rmFone(indice);
    }

    public ArrayList<Contato> getContatos(){
        return (ArrayList<Contato>) contatos.values();
    }
    
    public void show(){
        for(Contato cont : contatos.values()){
            System.out.println(cont);
        }
    }
}

class Busca{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        while(true){
            
            String line = scan.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            
            if(ui[0].equals("end")){
                break;
                 
            }else if(ui[0].equals("add")){

                agenda.initContato(ui[1]);
                
                for(int i = 2; i < ui.length; i++){
                    String partes[] = ui[i].split(":");
                    agenda.addContato(ui[1], partes[0], partes[1]);
                }
            
            }else if(ui[0].equals("rmFone")){
                agenda.rmFoneindice(ui[1], Integer.parseInt(ui[2]));
            
            }else if(ui[0].equals("agenda")){
                agenda.show();

            }else if(ui[0].equals("rmContato")){
                agenda.rmContato(ui[1]);
                
            }else if(ui[0].equals("search")){ 
                agenda.search(ui[1]);
                
            }else{
                System.out.println("fail: comando inválido");
            }
        }
        scan.close();
    }
}