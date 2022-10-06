package agendaSenseOrdre;

/**
 * Classe Agenda: representacio d'una agenda telefonica com un grup de 
 * contactes dinamic situats en posicions contigües de memoria, es a dir, 
 * mitjançant un array d'una certa Capacitat Per Defecte (C_P_D), que pot 
 * emmagatzemar com a maxim C_P_D objectes de tipus Contacte: atributs 
 * Contacte[] elArray i, associada a ell, la constant C_P_D = 250.
 * A mes, a partir de la seua creacio, el nombre de contactes 
 * que conte una agenda. Es a dir, la seua mida o talla, que varia entre  
 * 0 i C_P_D, per completar la representacio de l'agenda en memoria es fa 
 * necessari definir un atribut mes: int talla, que obviament pren valors 
 * en [0 .. C_P_D - 1].
 *
 * Per definir la funcionalitat (basica) d'una agenda --crear una agenda 
 * buida, afegir un nou contacte, actualitzar i esborrar-ne un ja existent, 
 * llistar els seus contactes i consultar la seua mida-- la classe Agenda 
 * defineix els metodes que figuren a continuacio.
 * Noteu que el seu codi es limita a manipular els atributs de la classe 
 * per implementar aquesta funcionalitat.
 * 
 * Es molt important notar tambe que una agenda, per definicio, no conte 
 * contactes repetits o, mes ben dit, noms de contactes repetits. Aixi 
 * mateix, cal subratllar que l'operacio imprescindible per accedir a un 
 * telefon d'una agenda, la informacio que realment conte, es la recerca 
 * del nom d'un contacte: tant per afegir un nou telefon, o actualitzar 
 * un ja existent, com per consultar un telefon o eliminar-lo de l'agenda, 
 * primer cal buscar el nom del contacte, que es converteix, per tant, en la 
 * clau d'acces a la informacio que conte l'agenda. Per aixo, perque la seua 
 * funcionalitat basica es la recerca d'informacio PER NOM O CLAU, es pot dir 
 * que una agenda telefonica no es mes que un tipus particular de Diccionari, 
 * les Entrades del qual son els seus Contactes.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class Agenda {
    private static final int C_P_D = 250;
    private Contacte[] lArray;
    private int talla;

    /**
     * Crea una Agenda buida, amb 0 contactes.
     */
    public Agenda() {
        lArray = new Contacte[C_P_D];
        talla = 0;
    }

    /**
     * Torna la talla de l'agenda, es a dir, del numero de contactes.
     * @return int, numero de contactes de l'agenda actual.
     */
    public int getTalla() { return talla; }
    
    /**
     * Consultor privat que cerca un Contacte donat a l'agenda.
     * Torna la posicio del contacte si el troba o -1 si no el troba.
     * IMPORTANT: cal recordar que dos contactes d'una agenda son iguals 
     * si els seus noms coincideixen, per la qual cosa, en realitat, la 
     * cerca que implementa aquest metode es una cerca PER NOM O CLAU, 
     * caracteristica de problemes com el de l'agenda. 
     * @param c Contacte, el contacte a cercar.
     * @result int, posicio de l'element si el troba o -1 si no el troba.
     */
    private int cercar(String nom) {  
        int i = 0;        
        while (i < talla && !lArray[i].getNom().equals(nom)) { i++; } {
            if (i < talla) { return i; } else { return -1; }
        }     
        return -1;
    }
    
    /**
     * Afegeix un nou contacte valid a l'agenda o l'actualitza si ja existeix.
     * Adona't que no poden haver-hi repetits.
     * Torna true si s'ha afegit amb exit o false en cas de que l'agenda 
     * estiga plena.
     * @param nou Contacte, contacte valid a afegir o a actualitzar 
     * si ja existeix.
     * @return boolean, indica que el Contacte s'ha afegit o actualitzat 
     * amb exit o no.
     */
    public boolean inserir(Contacte nou) {
        boolean cap = true;
        // cerca del nou contacte: si existeix, el reemplaça pel nou, 
        // l'actualitza; sino, si i nomes si cap, insereix el nou contacte 
        // darrere de l'ultim existent, es a dir, en posicio talla.
        int pos = cercar(nou.getNom());
        if (pos != -1) { lArray[pos] = nou; }
        else if (talla < C_P_D) { lArray[talla++] = nou; }
        else { cap = false; }
        return cap;
    }
    
    /**
     * Consultor privat que cerca un contacte a l'agenda donat un nom.
     * Torna la posicio de l'element si el troba o -1 si no el troba.
     * S'utilitza en recuperar i eliminar.
     * @param nom String, el nom a cercar.
     * @result int, posicio de l'element si el troba o -1 si no el troba.
     */
    private int cercar(String nom) {  
        int i = 0;        
        /* COMPLETAR */
        return -1; 
    }
    
    /**
     * Torna el telefon associat a un contacte de l'agenda, donat un nom valid.
     * Si no existeix, torna null per indicar-ho.
     * @param nom String, el nom del Contacte del qual es vol 
     * recuperar el telefon.
     * @result String, telefon associat al Contacte del nom donat o null 
     * si no existeix.
     */
    public String recuperar(String nom) { 
        String telefon = null;
        // cerca, per nom, el contacte del qual es vol recuperar el telefon: 
        // si existeix, el torna com resultat i si no existeix torna null 
        
        /* COMPLETAR */
        return telefon;
    }
    
    /**
     * Donat un nom valid, elimina el Contacte de l'agenda amb eixe nom.     
     * Torna true si s'ha pogut eliminar i false si no s'ha pogut eliminar 
     * perque no existeix un contacte amb eixe nom a l'agenda.
     * @param nom String, el nom del contacte a eliminar.
     * @result boolean, indica si el contacte amb el nom donat s'ha 
     * eliminat o no.
     */
    public boolean eliminar(String nom) {  
        boolean esta = true;
        // cerca, per nom, el contacte que es vol eliminar: si existeix, 
        // l'elimina: desplaça una posicio cap a l'esquerra tots els 
        // contactes posteriors al que es va a eliminar, actualitza la 
        // talla, i torna true com resultat. 
        // Si no troba el contacte a eliminar, torna false per a indicar-ho. 
        int pos = cercar(nom);
        if (pos != -1) {
            desplacarEsq(pos + 1, talla - 1);
            talla --; lArray[talla] = null;
        }
        else { esta = false; }
        return esta;
    }       
    
    /** 
     * Modificador imprescindible per tal d'eliminar un element de lArray: 
     * desplaça una posicio cap a l'esquerra tots els elements de lArray 
     * compresos entre les posicions ini i fi, ambdues incloses, 
     * 0 < ini <= fi <= elArray.length - 1.
     * @param ini int, la posicio inicial del (sub)array a desplaçar.
     * @param fi int, la posicio final del (sub)array a desplaçar.
     */ 
    private void desplacarEsq(int ini, int fi) {
        for (int pos = ini - 1; pos < fi; pos++) { 
            lArray[pos] = lArray[pos + 1];
        }
        // Equivalentment,
        // for (int pos = ini; pos <= fi; pos++) { 
        //     lArray[pos - 1] = lArray[pos];
        // }
    }
    
    /**
     * Sobreescriptura del metode toString de Object.
     * @return String, informacio de tots els contactes 
     * de l'agenda actual.
     */
    public String toString() {
        String res = "";
        /* COMPLETAR */
        return res;
    }
    
    
    
    
    private int cercarOr(String nom) {  
        int i = 0;        
        while (i < talla && lArray[i].getNom().compare(nom) < 0) { i++; } 
            if (i < talla) { return i; } else { return -1; }
        }     
        return -1;
    }
    
    public boolean inserirOr(Contacte nou) {
        boolean cap = true;
        // cerca del nou contacte: si existeix, el reemplaça pel nou, 
        // l'actualitza; sino, si i nomes si cap, insereix el nou contacte 
        // darrere de l'ultim existent, es a dir, en posicio talla.
        int pos = cercar(nou.getNom());
        if (pos != -1) { lArray[pos] = nou; }
        else if (talla < C_P_D) { lArray[talla++] = nou; }
        else { cap = false; }
        return cap;
    }
    
} // de Agenda
