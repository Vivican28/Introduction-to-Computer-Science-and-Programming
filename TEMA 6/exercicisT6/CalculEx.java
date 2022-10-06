import java.util.Scanner;
import java.util.Locale;
/**
 * Classe CalculEx: mètodes que implementen el desenvolupament 
 * en serie de Taylor per al càlcul d'e^x.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class CalculEx {
    private CalculEx() { }
    
    /**
     * Mostra el valor dels n primers termes de la sèrie de Taylor, 
     * per a valors de x i de n donats, x>=0 i n>=0.
     */
    public static void mostraTerms(int x, int n) {
        double term = 1; // valor de l’últim terme calculat
        int i = 0;       // índex de l’últim terme calculat
        while (i < n) { 
            i++;
            term = term * ((double) x / i);
            System.out.printf("El terme %2d-èsim de la sèrie és %.4f\n", 
                              i, term);      
        } 
    }
    
    /**
     * Calcula la suma dels n+1 primers termes de la sèrie de Taylor, 
     * per a valors de x i de n donats, x>=0 i n>=0.
     */
    public static double sumaExpFins(int x, int n) {
        double term = 1; // valor de l’últim terme calculat
        int i = 0;       // índex de l’últim terme calculat
        double suma = term; // acumula la suma dels termes calculats
        while (i < n) { 
        i++;
        term = term * ((double) x / i);
        suma = suma + term;
        } 
        return suma;
    }
    
    /** 
     *  Donats un valor enter x>=0 i un valor real epsilon, 0<epsilon<=1,
     *  calcula el valor d’e^x mitjançant el desenvolupament en sèrie de
     *  Taylor amb un error epsilon (sumant tots els termes generats fins  
     *  que l’últim calculat siga menor que epsilon).  
     */
    public static double exp(double x, double epsilon) {
        double term = 1; // valor de l’últim terme calculat
        int i = 0;       // índex de l’últim terme calculat
        double suma = term; // acumula la suma dels termes calculats
        // double dif = 100;
        while (term >= epsilon) { 
        i++;
        term = term * (x / i);
        suma = suma + term;
        }
        return suma;
    }
}
