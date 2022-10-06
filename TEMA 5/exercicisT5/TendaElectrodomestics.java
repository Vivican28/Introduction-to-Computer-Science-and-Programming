import java.util.Locale;
import java.util.Scanner;
/**
 * Classe TendaElectrodomestics: en una tenda d’electrodomèstics, per liquidació, 
 * s’apliquen distints descomptes en funció del total de les compres realitzades:
 * - Si total < 500 €, no s’aplica descompte.
 * - Si 500 € <= total <= 2000 €, s’aplica un descompte del 30%.
 * - Si total > 2000 €, aleshores s’aplica un descompte del 50%. 
 * 
 * Per tal d’implementar el problema en Java, s’ha d’usar una única variable 
 * (total de tipus double) que emmagatzema el total de les compres realitzades 
 * (abans d’aplicar el descompte) i també el total a cobrar (després d’aplicar 
 * el descompte corresponent). És a dir, la variable total és, a la vegada, 
 * dada i resultat. S’ha de resoldre el problema amb una única instrucció 
 * condicional (niuada). 
 * Completar la instrucció si la condició és total>=500 o total<=2000.
 *
 * @author IIP 
 * @version Curs 2019/20
 */
public class TendaElectrodomestics {
    private TendaElectrodomestics() { }
    
    public static void main(String[] args) { 
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);    
        System.out.print("Total compra (sense descompte)? ");
        double total = tec.nextDouble();
        // Versio 1:
        if (total >= 500) {
            if (total <= 2000) { total = total - 0.3 * total; }
            
            else { total = total - 0.5 * total; }
            // O if (total <= 2000) { total *= 0.7; }
            // Y else { total *= 0.5; }
        }
        // Versio 2:
        // if (total <= 2000){
        //     if (total >= 500) { total = total * 0.5; }
        // }
        // else { total *= 0.7; }
        
        System.out.println("Total compra (amb descompte): " + total + " €");
    }
}
