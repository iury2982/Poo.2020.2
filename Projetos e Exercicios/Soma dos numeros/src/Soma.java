import java.util.Scanner;

public class Soma {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Digite os numeros");

        int acc = 0;
        while(true){
            int a = scanner.nextInt();
            if(a == -1)
                break;
            acc += a;
        }
        System.out.println(acc);
        scanner.close();
    }
}
