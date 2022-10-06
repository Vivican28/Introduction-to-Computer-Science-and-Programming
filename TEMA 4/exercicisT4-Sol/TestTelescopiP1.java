import java.util.Locale;
import java.util.Scanner;
/**
 * Classe TestTelescopiP1: classe programa que prova la 
 * classe Telescopi (Exercici - P1)
 *
 * @author IIP
 * @version Curs 2019-20
 */
public class TestTelescopiP1 {
    private TestTelescopiP1() { }
    
    public static void main(String[] args) {
        // Crear un telescopi
        Telescopi t = new Telescopi();

        // diàmetre a 76.2, distància focal a 165.1 
        // i distancia focal ocular a 20.32
        t.setDiametre(76.2);   
        t.setDFL(165.1);   
        t.setDFO(20.32);   
        
        // Mostrar per pantalla els augments de t
        // amb un arredoniment de 2 decimals
        double augments = Math.round(t.augments() * 100) / 100.0;
        System.out.println("Augments: " + augments);
        // Mostrar per pantalla la relació focal de t
        // amb un arredoniment de 2 decimals
        double relFocal = Math.round(t.relacioFocal() * 100) / 100.0;
        System.out.println("Relació focal: " + relFocal);
        
        // Actualitzar a un nou valor llegit des de teclat el diàmetre de t
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introdueix un valor real per al diàmetre: ");
        double nouDiametre = teclat.nextDouble();
        t.setDiametre(nouDiametre);
        
        // Mostrar per pantalla la nova relació focal de t 
        // amb un arredoniment de 2 decimals, utilitzant printf
        System.out.printf(Locale.US, "Relació focal: %.2f", t.relacioFocal());
    }    
}
