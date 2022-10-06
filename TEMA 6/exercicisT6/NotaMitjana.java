import java.util.Scanner;
import java.util.Locale;
/** 
 * Classe NotaMitjana: classe programa per a lectura de notes 
 * i càlcul de la mitjana
 * @author IIP
 * @version Curs 2019-20
 */
public class NotaMitjana {
    private NotaMitjana() { }
    
    public static void main(String[] args) { 
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        // Sense validació de dades
        System.out.println("Introdueix les notes, per a acabar -1:");
        double suma = 0;
        int num = 0;
        double nota = tec.nextDouble();
        while (nota != -1) {
            suma = suma + nota;
            num++;
            nota = tec.nextDouble();
        } 
        if (num > 0) {
            System.out.printf("La mitjana de les %2d notes és %.3f\n",
                               num, suma / num);
        } else { System.out.println("No s'han introduit notes"); }
        
    } // de main
} 
