/**
 * Classe Dibuixa: classe d'utilitats amb mètodes per a
 * dibuixar figures geomètriques
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class Dibuixa {
    private Dibuixa() { }
    
    /** Mostra per pantalla un rectangle de 
     *  base i altura donades utilitzant *
     */
    public static void rectangle(int base, int altura) {
        System.out.println();
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /** Mostra per pantalla un triangle rectangle de 
     *  base donada utilitzant *
     */
    public static void triangleRec(int base) {
        System.out.println();
        for (int i = 1; i < base; i++) {
           for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }    
    }
    
    public static void triangleRec2(int base) {
        System.out.println();
        
        for (int i = 1; i <= base; i++) {
            for (int j = 1; i <= base ; i++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }    
    }
    
    /** Mostra per pantalla, donat un enter n>=0, una zeta 
     *  utilitzant el caràcter 'Z' en n línies
     */
    public static void zeta(int n) {
       System.out.println();
       for (int i = 0; i < n; i++) {
           System.out.print('Z');
       }
       System.out.println();
       for (int i = 0; i < n - 2 ; i++) {
           for (int j = 0; j < n - 2 - i; j++) {
               System.out.print(' ');
           }
           System.out.println('Z');
       }
       for (int i = 0; i < n; i++) {
           System.out.print('Z');
       }
       System.out.println();
    }
}
