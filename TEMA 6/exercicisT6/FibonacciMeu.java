import java.util.Scanner;
/**
 * Classe FibonacciMeu: classe programa que prova el mètode fibonacci.
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class FibonacciMeu {
    private FibonacciMeu() { }

    public static void main(String[] args) { 
        Scanner tec = new Scanner(System.in);
        String msg = "Escriu un número enter positiu (>= 0): ";
        int n = Lectura.llegirIntPos(msg, tec);
        System.out.printf("Terme %d-èsim de fibonacci = %d\n", 
                          n, fibonacci(n));
    } 
    
    /** Torna el n-èsim terme de la sèrie de Fibonacci
     *  Precondició: n>=0 
     */
    public static int fibonacci(int n) {
        int penultim = 0, // valor del penúltim terme calculat
            ultim = 1, // valor de l’últim terme calculat
            i = 1, // índex de l’últim terme calculat
            term = 1; // valor del terme i-èsim
        while (i < n) {
            term = ultim + penultim;
            penultim = ultim;
            ultim = term;
            i++;
        }
    
        return ultim;
    }

}
