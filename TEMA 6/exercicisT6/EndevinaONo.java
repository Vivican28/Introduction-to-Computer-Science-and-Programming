import java.util.Scanner;
/**
 * Classe EndevinaONo: classe programa per endevinar un número d'un interval 
 * en un nombre màxim d'intents
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class EndevinaONo {
    private static final int MAX_INTENTS = 5;
    
    private EndevinaONo() { }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Estic pensant un número entre 0 i 50");
        int numSecret = (int) (Math.random() * 51);
        int intents = MAX_INTENTS;
        System.out.println("Tens " + intents + " intents per endevinar-lo");
        int num;
        do {
            System.out.println("Quin nombre és?");
            num = tec.nextInt();
            if (num == numSecret) {
                System.out.println("Has encertat! El nombre és el " + numSecret);
            } else {
                System.out.println("No has encertat! El nombre a endevinar és ");   
                if (num < numSecret) {
                    System.out.println("major que " + num);
                }
                else {
                    System.out.println("menor que " + num);
                }
                intents--;
                System.out.println("Te queden " + intents + " intents per endevinar-ho");
            }
        } while (num == numSecret || intents == 0); 
       //FALTAN COSAS
        if (intents == 0) {
            System.out.println("El número a endevinar era el " + numSecret);
        }
        else {
            System.out.println("L'has endevinat en " + (MAX_INTENTS - intents + 1) + " intents");
        }
    }
}
