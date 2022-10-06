/**
 * Classe PasParametres
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class PasParametres {
    private PasParametres() { }
    
    public static void main(String[] args) {
        double[] lArray = {5.0, 6.4, 3.2, 0.0};
        metode1(lArray);
        // l'array no ha sigut modificat en absolut 
        metode2(lArray);
        // el primer component de l'array val ara 0.1
    }
    
    public static void metode1(double[] copia) {
        copia = new double[4]; // Aquest array desapareix en acabar el metode
    }
    
    public static void metode2(double[] copia) {
        copia[0] = 0.1; 
    }
}
