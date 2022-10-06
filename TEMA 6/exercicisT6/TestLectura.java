import java.util.Scanner;
import java.time.Year;
/**
 * Classe TestLectura: classe programa que prova 
 * un mètode de la classe Lectura
 * @author IIP
 * @version Curs 2019-20
 */
public class TestLectura {
    private TestLectura() { }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in); 
        int valor = Lectura.llegirIntEntre("Valor entre 1 i 6: ", tec, 1, 6);
        System.out.println("Llegit: " + valor);
        
        // Sol.licita del teclat un any, com 
        // un valor comprès entre 1900 i el del sistema.
        int anySistema = Year.now().getValue();
        String msg = "Any [1900, " + anySistema + "]: ";
        int any = Lectura.llegirIntEntre(msg, tec, 1900, anySistema);
        
        // while (any < 1900 || any > anySistema) {
            // System.out.println("Any [1900, " + anySistema + "]: ");
            // any = tec.nextInt();
        // }
        
        // Sol.licita del teclat un any en el futur (màxim 3000)
        msg = "Any futur [" + (anySistema + 1) + ", 3000]: ";
        int anyFutur = Lectura.llegirIntEntre(msg, tec, anySistema + 1, 3000);
        
        
        // Mostra per pantalla la diferència entre els dos anys.
        System.out.println("La diferència entre els dos anys és de " 
                           + (anyFutur - any) + " anys");
    }    
}
