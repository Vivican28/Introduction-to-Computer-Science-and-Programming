package grupsPrimerCurs;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/**
 * Classe PrimerCurs: representa als alumnes de tots els grups de primer curs.
 * - Per poder provar els mètodes d'aquesta classe, s’ha definit un constructor 
 * que llig les dades d’un fitxer de text (alumnes.txt), evitant d’aquesta manera 
 * tenir que teclejar-los en cada prova.
 * - Comenta les declaracions de les constants ALUMNES i NOMGRUPS i descomenta les 
 * que hi ha definides a continuació per a 3 grups de 6, 5 i 7 alumnes, respectivament.
 * - Crea un objecte PrimerCurs amb aquest constructor, passant-li com a paràmetre el nom 
 * del fitxer (”grupsPrimerCurs/alumnes.txt”). Inspecciona’l i comprova que els alumnes 
 * se corresponen amb els del fitxer.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class PrimerCurs {
    // public static final int[] ALUMNES = {47, 56, 58, 61, 32, 23, 62, 58, 50, 13};
    // public static final char[] NOMGRUPS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static final int[] ALUMNES = {6, 5, 7};
    public static final char[] NOMGRUPS = {'A', 'B', 'C'};
    private Alumne[][] grups;
    
    /**
     * Constructor d'un objecte PrimerCurs.
     * @param tec Scanner.
     */
    public PrimerCurs(Scanner tec) {
        grups = new Alumne[ALUMNES.length][];
        for (int i = 0; i < grups.length; i++) {
            grups[i] = new Alumne[ALUMNES[i]];
            for (int j = 0; j < grups[i].length; j++) {
                grups[i][j] = new Alumne(tec);
                grups[i][j].setGrup(NOMGRUPS[i]);
            }
        }
    }
    
    /**
     * Constructor d'un objecte PrimerCurs que llig
     * les dades d'un fitxer el nom del qual se passa com a parametre
     * Nomes serveix per al cas particular de 3 grups amb 6, 5 i 7 alumnes
     * Format del fitxer:
     * Grup1
     * DNI Nota Nom
     * DNI Nota Nom
     * ...
     * Grup2
     * DNI Nota Nom
     * DNI Nota Nom
     * ...
     */
    public PrimerCurs(String nomF) {
        grups = new Alumne[ALUMNES.length][];
        for (int i = 0; i < grups.length; i++) {
            grups[i] = new Alumne[ALUMNES[i]];
        }
        try {
            Scanner fAl = new Scanner(new File(nomF));        
            for (int i = 0; i < NOMGRUPS.length; i++) {
                char g = fAl.next().trim().charAt(0);
                for (int j = 0; j < grups[i].length; j++) {
                    long dni = fAl.nextLong();
                    double n = fAl.nextDouble();
                    String nom = fAl.nextLine().trim();
                    grups[i][j] = new Alumne(nom, dni, g, n);
                }
            }
        } catch (IOException e) { System.err.println(e); }
    }
    
    /** 
     * Torna un llistat amb la informació de tots els alumnes 
     * d'un grup donat.
     * @param g char. El grup.
     * @return String, el llistat.
     * Estratègia: cerca linial iterativa ascendent en l'array NOMGRUPS per
     *             comprovar que el grup és vàlid.
     *             Si ho és, recorregut iteratiu ascendent de la fila de 
     *             l'array grups que representa el grup. 
     */
    public String llistarAlumnes(char g) {
        int i = 0; 
        while (i < NOMGRUPS.length && NOMGRUPS[i] != g) { i++; }
        String res = "";
        if (i < NOMGRUPS.length) {            
            for (int j = 0; j < grups[i].length; j++) {
                res += grups[i][j] + "\n";
            }
        }
        else { res = g + "no és un grup vàlid"; }
        return res;
    }    
    
    /**
     * Torna el darrer alumne amb la nota mínima.
     * @return Alumne.
     * Estratègia: recorregut iteratiu ascendent.
     */
    public Alumne notaMinima() {
        double notaMin = Double.MAX_VALUE;
        Alumne aMin = null;
        for (int i = 0; i < grups.length; i++) {
            for (int j = 0; j < grups[i].length; j++) {
                if (grups[i][j].getNota() <= notaMin) {     
                    notaMin = grups[i][j].getNota(); 
                    aMin = grups[i][j];
                }
            }
        }
        return aMin;
    }
    
    /** 
     * Torna un array amb la nota mitjana de cada grup.
     * @return double[], array resultat.
     * Estratègia: recorregut iteratiu ascendent.
     */
    public double[] mitjanaGrup() {
        double[] mitjana = new double[NOMGRUPS.length];
        for (int i = 0; i < grups.length; i++) {
            double suma = 0;
            for (int j = 0; j < grups[i].length; j++) {
                suma += grups[i][j].getNota();
                
            }
            mitjana[i] = suma / grups[i].length;
        }
        return mitjana;
    }

    /**
     * Torna un llistat amb el primer alumne amb MH de cada grup.
     * @return String, el llistat.
     * Estratègia: recorregut iteratiu ascendent de totes les files 
     *             de l'array grups. Per a cada fila, cerca linial 
     *             iterativa ascendent per trobar la primera MH.
     */
    public String matrHonorGrup() {
        String res = "";
        for (int i = 0; i < grups.length; i++) {
            int j= 0;
            while (j < grups[i].length && grups[i][j].getNota() != 10) { j++; }
            if (j< grups[i].length) {
                res += grups[i][j].toString() + "\n";
            }
        }
    return res;
}
}