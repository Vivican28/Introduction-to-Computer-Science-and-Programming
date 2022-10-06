package utilsArrays;

/**
 * Classe RecorregutOCerca: mètodes que, en funció del sentit (ascendent
 * o descendent) en què es visiten els elements de l'array, es resolen com 
 * recorregut, com cerca o com una combinació de les dues estrategies.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */


// PER A RECORREGUTS S'UTILITZEN BUCLES FOR I PER A CERQUES, BUCLES WHILE


public class RecorregutOCerca {
    private RecorregutOCerca() { }
    
    /** Donat un array de caràcters v, compta quants espais en blanc 
     *  apareixen (consecutius) al final de l'array.
     *  @param v char[] (v.length > 0).
     *  @return int, número d'espais en blanc consecutius al final de l'array.
     *  Estratègia: Recorregut iteratiu ascendent. 
     */
    public static int blancsFinalAsc(char[] v) {   
        int blancsFinal = 0; 
        for (int i = 0; i < v.length; i++) {
            if (v[i] == ' ') { blancsFinal++; }
            else { blancsFinal = 0; }
        }
        
        return blancsFinal; 
    }

    /** Donat un array de caràcters v, compta quants espais en blanc 
     *  apareixen (consecutius) al final de l'array.
     *  @param v char[] (v.length > 0). 
     *  @return int, número d'espais en blanc consecutius al 
     *               final de l'array.
     *  Estratègia: Cerca linial iterativa descendent. 
     */
    public static int blancsFinalDesc(char[] v) {   
        int i = v.length - 1, blancsFinal = 0; 
        while (i >= 0 && v[i] == ' ') {
            blancsFinal++;
            i--;
        }
        return blancsFinal; 
    }

    /** Donat un array d'enters v, obté la posició  
     *  de l'últim element senar de l'array.
     *  @param v int[] (v.length > 0).
     *  @return int, posició de l'últim senar o 
     *              -1 si no hi ha senars a l'array.
     *  Estratègia: Recorregut iteratiu ascendent. 
     */
    public static int posUltimSenarAsc(int[] v) {   
        int posUltSenar = -1; 
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 1) { posUltSenar = i; }
        }
        return posUltSenar; 
    }

    /** Donat un array d'enters v, obté la posició 
     *  de l'últim element senar de l'array.
     *  @param v int[] (v.length > 0).
     *  @return int, posició de l'últim senar o 
     *              -1 si no hi ha senars a l'array.
     *  Estratègia: Cerca linial iterativa descendent. 
     */
    public static int posUltimSenarDesc(int[] v) {   
        int i = v.length - 1; 
        while (i>= 0 && v[i] % 2 != 1) { i--; }
        return i;
    }

    /** Donat un array d'enters positius v, suma els elements
     *  que apareixen després del primer senar.
     *  @param v int[] (v.length > 0, v[i] >= 0, 0 <= i < v.length).
     *  @return int, suma dels elements que apareixen després del
     *          primer senar, o -1 si no hi ha senars a l'array.
     *  Estratègia: Cerca linial iterativa ascendent  
     *              + Recorregut iteratiu ascendent. 
     */
    public static int sumaDespresPrimerSenar(int[] v) {   
        int i = 0, suma = 0; 
        while (i < v.length && v[i] % 2 != 1) { i++; }
        if (i == v.length) {
            System.out.println("No hi ha senars a l'array");
            return -1;
        }
        else { 
            for (int j = i +1; j < v.length; j++) {
                suma += v[j];
            }
            return suma;
        }
    }

    /** Donat un array de String, determinar per a cada String de l'array 
     *  la primera repetició. El resultat ha de ser un String en el qual 
     *  en cada línia estiga la dada i les dues posicions en les quals apareix.
     *  @param a String[] (a.length > 0).
     *  @return String, el resultat en el format indicat.
     *  Estratàgia: Recorregut ascendent de l'array en què per a cada element 
     *  es realitzarà, a la vegada, la cerca ascendent d'una component igual 
     *  a ell des de la seua posició en endavant.
     */
    public static String duplicatsLlista(String[] a) {
        String res = "";
        for (int i = 0; i < a.length - 1; i++) {
            int j = i + 1;
            while (j < a.length && !a[i].equals(a[j])) { j++; }
            if (j < a.length) {
                res += a[i] + " duplicat en: " + i + " i " + j + "\n";
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        // array per provar el metode duplicatsLlista
        String[] noms = {"Marta Lopez", "Paco Gomez", "Marta Lopez",
                         "Luisa Garcia", "Mario Jimenez", "Luisa Garcia",
                         "Marta Lopez", "Joel Saez", "Marta Lopez"};
                         
        System.out.println(duplicatsLlista(noms));                 
    }
}
