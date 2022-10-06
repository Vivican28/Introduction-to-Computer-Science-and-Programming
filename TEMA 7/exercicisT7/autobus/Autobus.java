package autobus;

/**
 * Classe Autobus: representa les reserves de seients
 * d'un autobus.
 * 
 * @author IIP
 * @version 2019-20
 */
public class Autobus {
    public static final int MAX_PLACES = 50;
    private String[] places;
    
    /** Crea un Autobus buit */
    public Autobus() {
        places = new String[MAX_PLACES];
    }
    
    /** Reserva el seient i al passatger nom
     *  Precondició: 0 <= i < MAX_PLACES i places[i] lliure
     */
    public void reservar(int i, String nom) { places[i] = nom; }
    
    /** Cancel.la la reserva del seient i 
     *  Precondició: 0 <= i < MAX_PLACES i places[i] ocupat
     */
    public void cancelar(int i) { places[i] = null; }
    
    /** Torna el numero de places ocupades en l'Autobus 
     *  comptant quantes posicions del seu array places 
     *  son diferents de null. */
    public int numeroReserves() { 
        int num = 0;
        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) { num++; }
        }
        return num;
    }

    /** Torna el nom del passatger de l'Autobus que 
     *  tinga el "nom major" segons l'ordre lexicografic 
     */
    public String nomMajor() {
        String res = "";
        for (int i = 0; i < places.length; i++) {
            if (places[i] != null && places[i].compareTo(res) >= 0) {
                res = places[i];
            }
        }
        return res;
    }
    
    /** Torna un String amb els noms dels passatgers i 
     *  les places que ocupen. 
     */
    public String llistaPassatgers() {
        String res = "";
        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                res += 1 + ", " + i + "\n";
            }
        }
        return res;
    }
    
    /** Torna un String amb els numeros de seients 
     *  que no estan ocupats.
     */
    public String llistaSeientsLliures() {
        String res = "";
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                res += 1 + ", ";
            }
        }
        return res;
    }
    
    /** Torna true si l'Autobus esta complet 
     *  i torna false, en cas contrari.
     */
    public boolean estaComplet() {
        int i = 0;
        while (i < places.length && places[i] != null) { i++; }
        return i == places.length;
    }
}
