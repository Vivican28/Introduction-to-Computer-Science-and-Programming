package matrius;

/**
 * Classe UtilsMatrius: classe d'utilitats que permet 
 * fer operacions amb matrius.
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class UtilsMatrius {
    private UtilsMatrius() { }
    
    /** 
     * Torna la suma de dues matrius a i b donades.
     * a i b tenen la mateixa dimensió m x n, m>0, n>0.
     * La matriu resultat tindrà dimensió m x n.
     * @param a int[][].
     * @param b int[][].
     * @return int[][], matriu suma.
     */
    public static int[][] sumaMat(int[][] a, int[][] b) {   
        int[][] c = new int[a.length][a[0].length]; 
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j]; 
            }
        }
        return c;
    }

    /** 
     * Torna el producte de dues matrius a i b donades.
     * a és de dimensió m x n i b de dimensió n x p, m>0, n>0, p>0.
     * La matriu resultat tindrà dimensió m x p.
     * @param a int[][].
     * @param b int[][].
     * @return int[][], matriu producte.   
     */
    public static int[][] producteMat(int[][] a, int[][] b) {   
        int[][] c = new int[a.length][b[0].length]; 
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = 0;
                for (int k = 0; k < a[i].length; k++) {
                    c[i][j] = c[i][j] + (a[i][k] * b[k][j]); 
                }
            }
        }
        return c;
    }

    /** 
     * Torna el producte de matriu a per vector v.
     * a és de dimensió m x n i v de dimensió n, m>0, n>0.
     * El vector resultat tindrà dimensió m.
     * @param a int[][].
     * @param v int[].
     * @return int[][], producte de matriu per vector.
     */
    public static int[] matPerVec(int[][] a, int[] v) {   
        int[] c = new int[a.length]; 
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < v.length; j++) {
                c[i] =  c[i] + a[i][j] * v[j];
            }
        }
        return c;
    }
    
    /** 
     * Torna la transposada d'una matriu a donada.
     * a és de dimensió m x n, m>0, n>0.
     * La matriu resultat tindrà dimensió n x m.
     * @param a int[][].
     * @return int[][], matriu transposada.
     */
    public static int[][] transpMat(int[][] a) {
        int[][] at = new int[a[0].length][a.length];
        for (int i = 0; i < at.length; i++) {
            for(int j = 0; j < at[0].length; j++) {
                at[i][j] = a[j][i];
            } 
        }
        return at;
    }

    /** 
     * Transposa una matriu quadrada.
     * a és de dimensió n x n, n>0.
     * @param a int[][].
     */
    public static void transpMatQuad(int[][] a) {   
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int aux = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = aux;
            }
        }
    }

}
