/**
 * Classe Comptadors: classe programa que simula el llançament
 * d'un dau de 10 cares (numerades del 0 al 9) i obté la freqüència
 * d'aparició de cadascun dels valors.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class Comptadors {
    private Comptadors() { }
    
    public static void main(String[] args) {
        int[] compt = new int[10];
        int val;
        for (int i = 0; i < 1000; i++) {
            val = (int) (Math.random() * 10);
            compt[val]++;
        }
        llistarFreq(compt);
    }    
    
    /** Llista la frequencia d'aparicio */
    public static void llistarFreq(int[] a) {
        System.out.println("Digits i frequencies:");
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d (%d vegades).\n", i, a[i]);
        }
    }
}
