import java.util.Scanner;
/**
 * Class Lectura: classe d'utilitats amb mètodes 
 * per a lectura validada
 * @author IIP 
 * @version Curs 2019-20
 */
public class Lectura {
    private Lectura() { }
    
    /** Torna un valor enter positiu llegit des de tec 
     *  segons la petició expressada en el mitssage msg. 
     */
    public static int llegirIntPos(String msg, Scanner tec) {
        int n;
        do {
            System.out.print(msg);
            n = tec.nextInt();
        } while (n < 0); 
        return n;
    }
    
    /** Torna un valor enter comprès entre x i y, llegit des de tec 
     *  segons la petició expressada en el mitssage msg.  
     *  Precondición: x <= y
     */
    public static int llegirIntEntre(String msg, Scanner tec, int x, int y) {
        int n;
        do {
            System.out.print(msg);
            n = tec.nextInt();
        } while (n < x || n > y); //REVISAR: tenia mal la guarda
        return n;
    } 
     
    /** Torna un valor real positiu llegit des de tec 
     *  segons la petició expressada en el mitssage msg. 
     */
    public static double llegirDoublePos(String msg, Scanner tec) {
        double n;
        do {
            System.out.print(msg);
            n = tec.nextInt();
        } while (n < 0); 
        return n;
    }    
    
    /** Torna un valor real comprès entre x i y, llegit des de tec 
     *  segons la petició expressada en el mitssage msg.  
     *  Precondición: x <= y
     */
    public static double llegirDoubleEntre(String msg, Scanner tec, double x, double y) {
        double n;
        do {
            System.out.print(msg);
            n = tec.nextInt();
        } while (n < x || n > y); 
        return n;
    }
}
