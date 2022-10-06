/**
 * Classe Conjunt: permet representar un conjunt de naturals
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class Conjunt {
    private boolean[] conjunt;
    private int ultim;
    
    /** Crea un conjunt buit que contindra 
     *  naturals en el rang [0..ult], ult > 0 */
    public Conjunt(int ult) {
        conjunt = new boolean[ult + 1];
        ultim = ult;
    }
    
    /** Comprova si un x donat pertany o no al conjunt, 
     *  0 <= x <= ultim */
    public boolean pertany(int x) { return conjunt[x]; }

    /** Afegeix al conjunt un x donat,
     *  0 <= x <= ultim */
    public void afegeix(int x) { conjunt[x] = true; }
  
    /** Elimina del conjunt un x donat,
     *  0 <= x <= ultim */
    public void elimina(int x) { conjunt[x] = false; }
    
    /** Torna el cardinal del conjunt */
    public int cardinal() {
        int card = 0;
        for (int i = 0; i < conjunt.length; i++) {
            if (conjunt[i]) { card++; }
        }
        return card;
    }
    
    /** Genera de forma aleatoria els elements 
     *  del conjunt */
    public void setAlAtzar() {
        for (int i = 0; i < conjunt.length; i++) {
            conjunt[i] = (Math.random() >= 0.5);
        }
    }
}
