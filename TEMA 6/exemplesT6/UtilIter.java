/**
 * Classe UtilIter: classe d'utilitats amb iteracions
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class UtilIter {
    private UtilIter() { }
    
    /** Torna el producte de a per n,
     *  sense usar l'operador *, basant-nos en sumes.
     *  Precondició: a >= 0, n >= 0
     */
    public static int producteAperN(int a, int n) {
        int producte = 0, cont = 0;
        while (cont != n) {
            producte = producte + a;
            cont++;
        }
        return producte;
    }
    
    /** Torna la suma de les xifres d'un número n donat. 
     *  Precondició: n >= 0
     */
    public static int sumaXifres(int n) {
        int res = 0, num = n;
        while (num > 0) { 
            res = res + num % 10;
            num = num / 10;
        }  
        return res;
    }
    
    /** Torna el producte de n i m (n x m)
     *  aplicant l'estratègia de multiplicació
     *  "à la russe".
     *  Precondició: n >= 0, m >= 0
     */
    public static int multRussa(int n, int m) {
        int multiplicand = n, multiplicador = m, producte = 0;
        while (multiplicand != 0) { 
            if (multiplicand % 2 != 0) {
                producte = producte + multiplicador;
            }
            multiplicand = multiplicand / 2;
            multiplicador = multiplicador + multiplicador;
        }
        return producte;
    }
    
    /** Torna el màxim comú divisor de x i y
     *  Precondició: x > 0, y > 0 
     */
    public static int mcd(int x, int y) {
        int a = x, b = y;
        while (a != b) {
            if (a > b) { a = a - b; }
            else { b = b - a; }
        }
        return a;
    }
    
    /** Torna el màxim comú divisor de x i y
     *  Precondició: x > 0, y > 0 
     *  Versió millorada
     */
    public static int mcd2(int x, int y) {
        int a = x, b = y;
        int r = a % b;
        while (r > 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
}
