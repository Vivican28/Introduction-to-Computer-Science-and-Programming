/**
 * Classe CopiaArraysPrimitius
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class CopiaArraysPrimitius {
    private CopiaArraysPrimitius() { }
    
    public static void main(String[] args) {
        double[] a = {5.0, 6.4, 3.2, 0.0};
        double[] copia = copiar(a);
        // els elements de l'array copia son copies dels de a
    }
    
    public static double[] copiar(double[] orig) {
        double[] aux = new double[orig.length];
        for (int i = 0; i < orig.length; i++) {
            aux[i] = orig[i];
        }
        return aux;
    }
}
