package utilsArrays;

/**
 * Classe Recorregut: problemes de recorregut en arrays
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class Recorregut {
    private Recorregut() { }
    
    /** Suma dels elements d'un array de enters 
     *  @param v int[] (v.length > 0).
     *  @return int, la suma.
     *  Estratègia: Recorregut iteratiu ascendent.
     */
    public static int sumaIteAsc(int[] v) {
        int suma = 0;
        for (int i = 0; i < v.length; i++) {
            suma = suma + v[i];
        }
        return suma;
    }
    
    /** Mitjana dels elements d'un array de enters 
     *  @param v int[] (v.length > 0).
     *  @return double, la mitjana.
     *  Estratègia: Recorregut iteratiu ascendent.
     */
    public static double mitjanaIteAsc(int[] v) {
        double suma = 0;
        for (int i = 0; i < v.length; i++) {
            suma = suma + v[i];
        }
        return suma / v.length;
    }

    /** Mitjana dels elements d'un array de enters 
     *  entre dues posicions donades (0 <= esq <= dre < a.length).
     *  @param a int[] (a.length > 0).
     *  @param esq int. 
     *  @param dre int.
     *  @return double, la mitjana.
     *  Estratègia: Recorregut iteratiu ascendent.
     */
    public static double mitjana(int[] a, int esq, int dre) {
        double suma = 0;
        for (int i = esq; i <= dre; i++) { suma += a[i]; }
        return suma / (dre - esq + 1);
    }
    
    /** Suma dels elements d'un array de enters 
     *  @param v int[] (v.length > 0).
     *  @return int, la suma.
     *  Estratègia: Recorregut iteratiu descendent.
     */
    public static int sumaIteDesc(int[] v) {
        int suma = 0;
        for (int i = v.length - 1; i >= 0; i--) {
            suma = suma + v[i];
        }
        return suma;
    }

    /** Torna la posició del màxim d'un array de String. 
     *  @param a String[] (a.length > 0).
     *  @return int, la posició del màxim.
     *  Estratègia: Recorregut iteratiu ascendent.
     */
    public static int maxim(String[] a) {
        int posMax = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[posMax]) > 0) { posMax = i; }
        }
        return posMax;
    }

    /** Torna la posició del màxim d'un array de double. 
     *  @param a double[] (a.length > 0).
     *  @return int, la posició del màxim.
     *  Estratègia: Recorregut iteratiu descendent.
     */
    public static int maxim(double[] a) {
        int posMax = a.length - 1;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > a[posMax]) { posMax = i; }
        }
        return posMax;
    }

    /** A partir de les mesures diaries de pluviositat d'una setmana, 
     *  indica quina és la mesura mínima i el dia de la setmana que 
     *  es va produir. 
     *  @param plutja double[] (plutja.length > 0)
     *  Estratègia: Recorregut iteratiu ascendent.
     */
    public static void minimPlutja(double[] plutja) {
        double min = plutja[0]; 
        int dia = 0;
        for (int i = 1; i < plutja.length; i++) {
            if (plutja[i] <= min) {
                    min = plutja[i];
                    dia = i;
            }
        }
        System.out.println("Mínim: " + min + " Dia: " + (dia + 1));   
    }
    
    /** Donat un array d'enters v i dues posicions donades, esq i dre, 
     *  de l'array, 0 <= esq <= dre <= v.length-1, duplica el valor 
     *  dels elements de l'array situats entre aquestes posicions.
     *  @param v int[] (v.length > 0).
     *  @param esq int. 
     *  @param dre int.
     *  Estratègia: Recorregut iteratiu ascendent.
     */  
    public static void duplicar(int[] v, int esq, int dre) {
       for (int i = esq; i <= dre; i++) {
           v[i] = v[i] * 2;
       }
    }    
    
    /** Donat un array de reals v, i dues posicions donades, ini i fi, 
     *  de l'array, 0 <= ini <= fi <= v.length-1, inverteix tots els 
     *  elements de l'array situats entre aquestes posicions.
     *  @param v double[] (v.length > 0).
     *  @param ini int. 
     *  @param fi int.
     *  Estratègia: Recorregut iteratiu.
     */
    public static void invertir(double[] v, int ini, int fi) {
        for (int i = ini, j = fi; i < j; i++, j--) {
            double aux = v[i];
            v[i] = v[j];
            v[j] = aux;
        }
    }
    
    /** Donat un array d'enters v i dues posicions donades, esq i dre, 
     *  de l'array, 0 <= esq <= dre < v.length-1, desplasa una posició 
     *  cap a la DRETA tots els elements de l'array situats entre les 
     *  posicions esq i dre, ambdues inclusive.
     *  @param v int[] (v.length > 0).
     *  @param esq int. 
     *  @param dre int.
     */
    public static void desplasarDreta(int[] v, int esq, int dre) {
        for (int pos = dre + 1; pos > esq; pos--) {
            v[pos] = v[pos - 1];
        }
    }
    
    /** Donat un array d'enters v i dues posicions donades, esq i dre, 
     *  de l'array, 0 < esq <= dre <= v.length-1, desplasa una posició 
     *  cap a l'ESQUERRA tots els elements de l'array situats entre les 
     *  posicions esq i dre, ambdues inclusive.
     *  @param v int[] (v.length > 0).
     *  @param esq int. 
     *  @param dre int.
     */ 
    public static void desplasarEsquerra(int[] v, int esq, int dre) {
        for (int pos = esq - 1; pos < dre; pos++) {
            v[pos] = v[pos + 1];
        }
    }
    
    /** Calcula la moda d'un array que conté elements enters 
     *  en el rang [0, n].
     *  @param a int[] (a.length > 0).
     *  @param n int (n >= 0)
     */
    public static int modaDe0aN(int[] a, int n) {
        // es construeix un array entre 0 i n
        int[] frequencia = new int[n + 1];
        // recorregut d'a i obtencio de frequencies
        for (int i = 0; i < a.length; i++) { frequencia[a[i]]++; }
        // la moda es el maxim de l'array frequencia
        int moda = 0;
        for (int i = 1; i < frequencia.length; i++) {
            if (frequencia[i] > frequencia[moda]) { moda = i; }
        }
        return moda;
    }
}