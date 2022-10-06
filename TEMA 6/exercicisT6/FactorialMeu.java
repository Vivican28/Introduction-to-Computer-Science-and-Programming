import java.util.Scanner;
/**
 * Classe FactorialMeu: exercici no presencial de la sessió 2
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class FactorialMeu {
    private FactorialMeu() { }
    
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int num;
        do {
        System.out.print("Introdueix el número: ");
        num = teclat.nextInt();
        }
        while (num > 12 || num < 0); // que és el mateix que !(num >= 0 && num <= 12)
        num = teclat.nextInt();
        System.out.printf("El factorial de %d és %d\n", num, factorial(num));
    }
        
    /** Calcula el factorial d'un número n>=0 */
    public static long factorial(long n) {
        long fact = 1;
        for (long i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

}
