import java.util.Scanner;
/**
 * Classe AutoEscola: Calcula la tarifa d'una autoescola tenint en compte
 * el tipus de carnet (A, B, C, D) i el número de pràctiques realitzades.
 * Preus de les matrícules (en euros): A 150, B 325, C 520, D 610. 
 * Preus per pràctica segons carnet (en euros): A 15, B 21, C 36, D 50.
 *
 * @author IIP 
 * @version Curs 2019/20
 */
public class AutoEscola {    
    private AutoEscola() { }
    
    public static void main(String[] args) {  
        Scanner teclat = new Scanner(System.in);    
        System.out.print("Tipus de carnet? (A, B, C o D) "); 
        char carnet = teclat.next("\\S").charAt(0); 
        System.out.print("Número de pràctiques realitzades? "); 
        int pract = teclat.nextInt(); 
        
        int preu = 0;       
        if (('A' <= carnet && carnet <= 'D'
            || 'a' <= carnet && carnet <= 'd') && pract > 0) {
            preu = tarifa(carnet, pract);
        }
        
        if (preu > 0) { 
            System.out.println("Preu: " + preu + " euros."); 
        } else { 
            System.out.println("Dades incorrectes!"); 
        }           
    } // del main
    
    /**
     * Calcula la tarifa d'una autoescola segons el tipus de carnet 
     * (A, B, C, D) i el número de pràctiques realitzades.
     * Preus de les matrícules (en euros): A 150, B 325, C 520, D 610. 
     * Preus per pràctica segons carnet (en euros): A 15, B 21, C 36, D 50.
     *
     * @param carnet char, tipus de carnet.
     * @param numPr int, número de pràctiques. 
     * @return int, la tarifa de l'autoescola.
     */
    public static int tarifa(char carnet, int numPr) {
        int preu = 0;
        switch (carnet) {
            case 'A': case 'a':
                preu = 150 + 15 * numPr;
                break;
            case 'B': case 'b':
                preu = 325 + 21 * numPr;
                break;
            case 'C': case 'c':
                preu = 520 + 36 * numPr;
                break;    
            case 'D': case 'd':
                preu = 610 + 50 * numPr;
                break;
            default:
                System.out.println("El tipus de carnet introduït és erroni");
        }
        
        return preu; 
    }
}
