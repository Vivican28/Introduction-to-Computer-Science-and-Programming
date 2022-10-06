package utilsArrays;

/**
 * Classe Cerca: problemes de cerca seqüencial (o linial) en arrays.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class Cerca {
    private Cerca() { }
    
    /** Torna la posició en l'array a d'una dada donada.
     *  @param a String[] (a.length > 0).
     *  @param dada String.
     *  @return int, posició de dada en l'array o -1 si no està.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              amb guarda que avalua la propietat.
     */
    public static int cercarPosAsc(String[] a, String dada) {
        int i = 0;
        while (i < a.length && !a[i].equals(dada)) { i++; }
        if (i < a.length) { return i; }
        else { return -1; }
    }

    /** Torna la posició en l'array a d'una dada donada.
     *  @param a double[] (a.length > 0).
     *  @param dada double.
     *  @return int, posició de dada en l'array o -1 si no està.
     *  Estratègia: cerca linial iterativa descendent sense garantia d'èxit,
     *              amb guarda que avalua la propietat.
     */
    public static int cercarPosDesc(double[] a, double dada) {
        int i = a.length - 1;
        while (i >= 0 && a[i] != dada) { i--; }
        return i;
    }
    
    /** Torna la posició en l'array a d'una dada donada
     *  existent en l'array.
     *  @param a String[] (a.length > 0).
     *  @param dada String.
     *  @return int, posició de dada en l'array.
     *  Estratègia: cerca linial iterativa ascendent amb garantia d'èxit.
     */
    public static int cercarPosAscEsta(String[] a, String dada) {
        int i = 0;
        while (!a[i].equals(dada)) { i++; }
        return i;
    }
    
    /** Torna la posició en l'array a d'una dada donada
     *  existent en l'array.
     *  @param a double[] (a.length > 0).
     *  @param dada double.
     *  @return int, posició de dada en l'array.
     *  Estratègia: cerca linial iterativa descendent amb garantia d'èxit.
     */
    public static int cercarPosDescEsta(double[] a, double dada) {
        int i = a.length - 1;
        while (a[i] != dada) { i--; }
        return i;
    }
    
    /** Comprova si hi ha algun element en l'array a més gran
     *  que una dada donada.
     *  @param a double[] (a.length > 0).
     *  @param dada double.
     *  @return boolean, true si està, false en cas contrari.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              amb guarda que avalua la propietat.  
     */
    public static boolean hiHaMajor(double[] a, double dada) {
        int i = 0;
        while (i < a.length && a[i] <= dada) { i++; }
        return (i < a.length);
    }

    /** Torna, si existeix, la posició del primer element de l'array 
     *  més gran que la suma dels anteriors. Si no, torna -1.
     *  @param a int[] (a.length > 0).
     *  @return int, posició del primer element més gran que la suma 
     *  dels anteriors si existeix, o -1 si no existeix.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              amb guarda que avalua la propietat.
     */
    public static int cercaPosMajorQueSuma(int[] a) {
        int i = 1, suma = a[0];
        while (i < a.length && a[i] <= suma) { suma += a[i]; i++; }
        if (i < a.length) { return i; }
        else { return -1; }
    }
    
    /** A partir de les mesures diaries de pluviositat d'una setmana i de 
     *  la mitjana d'aquestes mesures, indica si algun dia ha plogut el 
     *  doble de la mitjana.
     *  @param plutja double[] (plutja.length > 0).
     *  @param mitjana double.
     *  @return boolean, true si hi ha un dia que ha plogut el doble de 
     *  la mitjana, o false en cas contrari.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              utilitzant una variable de tipus boolean.
     */ 
    public static boolean dobleMitjana(double[] plutja, double mitjana) {
        double dobleMitjana = mitjana * 2; 
        boolean hiHaDoble = false;
        int i = 0;      
        while (i < plutja.length && !hiHaDoble) {
            if (i < plutja.length && !hiHaDoble) { hiHaDoble = true; }
            else { i++; }
        }
        return hiHaDoble;
    }

    /** A partir de les mesures diaries de pluviositat d'una setmana i de 
     *  la mitjana d'aquestes mesures, indica si algun dia ha plogut el 
     *  doble de la mitjana.
     *  @param plutja double[] (plutja.length > 0).
     *  @param mitjana double.
     *  @return boolean, true si hi ha un dia que ha plogut el doble de 
     *  la mitjana, o false en cas contrari.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              amb guarda que avalua la propietat.
     */ 
    public static boolean dobleMitjana2(double[] plutja, double mitjana) {
        double dobleMitjana = mitjana * 2; 
        int i = 0;  
        while (i < plutja.length && plutja[i] != dobleMitjana) { i++; }
            if (i < plutja.length) { return true; }
            else { return false; } // El if es substituible per return i < plutja.length;
        
    }
    
    /** A partir de les mesures diaries de pluviositat d'una setmana donades
     *  en l'array plutja, comprova si l'array est� ordenat ascendentment.
     *  @param plutja double[] (plutja.length > 0).
     *  @return boolean, true si està ordenat ascendentment, o false 
     *  en cas contrari.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              amb guarda que avalua la propietat.
     */
    public static boolean ordenAsc(double[] plutja) {
        int i = 0; 
        while (i < plutja.length && plutja[i] <= plutja[i + 1]) { i++;}
        if (i < plutja.length) { return false; }
        else { return true; } // return i == plutja.length;
    }
    
    /** A partir de les mesures diaries de pluviositat d'una setmana donades
     *  en l'array plutja, comprova si l'array és capicua.
     *  @param plutja double[] (plutja.length > 0).
     *  @return boolean, true si és capicua, o false en cas contrari.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              amb guarda que avalua la propietat.
     */
    public static boolean esCapicua(double[] plutja) {
        int i = 0, j = plutja.length - 1; 
        while (i < j && plutja[i] == plutja[j]) { i++; j--; }
        if (i < j) { return false; }
        else { return true; }
    }
    
    /** Torna la posició, si n'hi ha, de la primera subseqüencia de l'array v
     *  que comprenga, almenys, tres nombres enters consecutius en tres  
     *  posicions consecutives de l'array.
     *  @param v int[] (v.length > 0).
     *  @return int, la posició si existeix, o -1 si no existeix.
     *  Estratègia: cerca linial iterativa ascendent sense garantia d'èxit,
     *              utilitzant una variable de tipus boolean. 
     */
    public static int tresConsec(double[] v) {   
        int i = 0, n = v.length; 
        boolean subsec = false;   
        while (i <= n - 3 && !subsec) {
            if (v[i] + 1 == v[i + 1] && v[i + 1] + 1 == v[i + 2]) { subsec = true; }
            else { i++; }
        }
        
        if (subsec) { 
            System.out.println("Comença en " + i);
            return i; 
        }
        else { 
            System.out.println("No es troba"); 
            return -1; 
        }
    }
}
