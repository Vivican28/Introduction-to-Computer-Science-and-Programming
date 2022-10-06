import java.util.Locale;
import java.util.Scanner;
/**
 * Classe Calculadora: simula una calculadora, considerant que els
 * càlculs possibles són del tipus num1 op num2, on num1 i num2
 * són dos números reals qualsevol i op és un operador d'entre: +, -, *, /. 
 * El programa demanarà a l'usuari en primer lloc el valor num1, a
 * continuació l'operador i finalment el valor num2.
 * 
 * @author IIP
 * @version Curs 2018/19
 */
public class Calculadora {   
    private Calculadora() { }
    
    public static void main(String[] args) { 
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);    
        System.out.print("num1? ");
        double num1 = tec.nextDouble();
        System.out.print("operador? ");
        char op = tec.next("\\S").charAt(0);
        System.out.print("num2? ");
        double num2 = tec.nextDouble();
    
        double result = 0; // per emmagatzemar el resultat de l'operació
        boolean error = false; // per indicar si hi ha algun error
        
        /* COMPLETAR amb un switch */
        switch (op) {
            case '+':
                result = num1 + num2; break;
            case '-':
                result = num1 - num2; break;
            case '*':
                result = num1 * num2; break;
            case '/':
                if (num2 == 0) { error = true; }
                else { result = num1 / num2; break; }
                break;
            default:
                error = true;
        }
        
        if (error) { System.out.println("Error"); }
        else { System.out.println("El resultat és: " + result); }   
    } // del main
}