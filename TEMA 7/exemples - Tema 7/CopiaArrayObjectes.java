/**
 * Classe CopiaArraysObjectes
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class CopiaArrayObjectes {  
    private CopiaArrayObjectes() { }
    
    public static void main(String[] args) {
        final int NUM_PUNTS = 20;
        Punt[] cami = new Punt[NUM_PUNTS];
        for (int i = 0; i < cami.length; i++) {
            cami[i] = new Punt();
        }
        // s'han creat els 20 objects Punt de cami   
        System.out.println("Distància entre els dos primers punts: " 
                           + cami[0].distancia(cami[1]));    
        Punt[] copiaP = copiarPunt(cami);
    }
    
    public static Punt[] copiarPunt(Punt[] orig) {
        Punt[] copia = new Punt[orig.length];
        for (int i = 0; i < orig.length; i++) {
            copia[i] = new Punt(orig[i].getX(), orig[i].getY());
        }
        return copia;
    }     
}
