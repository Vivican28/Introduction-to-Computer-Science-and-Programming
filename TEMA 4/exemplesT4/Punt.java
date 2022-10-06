/**
 * Classe Punt: defineix punts en un espai bidimensional real 
 * amb la funcionalitat que s'indica a continuació. 
 * 
 * Se poden determinar els objectes creats consultant l'atribut
 * estàtic, o variable de classe, comptador, utilitzant 
 * el mètode numPunts.
 * 
 * @author Llibre IIP-PRG
 * @version 2019-20
 */
public class Punt {  
    // Un Punt TÉ ...
    private static int comptador = 0;  // UN comptador dels punts creats
                                       // (objectes de la classe) 
    private double x;  // UNA abscissa  
    private double y;  // UNA ordenada    
        
    /** Crea un Punt (abs, ord), incrementant en 1 
     *  el número de punts creats. 
     *  @param abs double que representa l'abscissa.
     *  @param ord double que representa l'ordenada.
     */
    public Punt(double abs, double ord) {
        x = abs; 
        y = ord; 
        comptador++; 
        // la JVM automàticament executa
        // return this;
    } 
    
    /** Crea un Punt estàndard, i.e., el (0.0, 0.0),
     *  incrementant en 1 el número de punts creats.
     */
    public Punt() { 
        x = 0.0; y = 0.0; // se podria comentar
        comptador++;        
    }     
    
    /** Crea un Punt amb les mateixes coordenades que 
     *  un altre Punt p donat. Incrementa en 1 el número 
     *  de punts creats.
     *  @param p Punt.
     */
    public Punt(Punt p) { 
        x = p.x; y = p.y; 
        comptador++; 
    }
    
    /** Torna l'abscissa del Punt.  
     *  @return double, l'abscissa.
     */
    public double getX() { return x; } 
    
    /** Torna l'ordenada del Punt.  
     *  @return double, l'ordenada.  
     */
    public double getY() { return y; }
    
    /** Actualitza l'abscissa del Punt.  
     *  @param px double que representa el nou valor de l'abscissa. 
     */
    public void setX(double px) { x = px; }
    
    /** Actualitza l'ordenada del Punt.  
     *  @param py double que representa el nou valor de l'ordenada.   
     */
    public void setY(double py) { y = py; }
    
    /** Desplaça el Punt, incrementant l'abscissa i l'ordenada
     *  en dos valors donats. 
     *  @param px double que representa l'increment de l'abscissa.
     *  @param py double que representa l'increment de l'ordenada.
     */
    public void moure(double px, double py) { 
        x += px; 
        y += py; 
    } 
    
    /* Mètode privat que torna un valor enter aleatori en  
       el rang [0, (2 * distància del punt a l'origen)]. */
    private int aleatori() { 
        return (int) (Math.random() * (2 * distOrigen() + 1)); 
    } 
    
    /** Desplaça el Punt a unes coordenades aleatories. */   
    public void moureAleat() { 
        x += aleatori(); 
        y += aleatori(); 
    }
    
    /** Torna la distància del Punt a l'origen de coordenades. 
     *  @return double, la distància.
     */  
    public double distOrigen(/* Punt this */) {
        // la JVM, automàticament, assigna
        // a this l'objecte en curs
        return Math.sqrt(x * x + y * y); 
    }
        
    /**
     * Torna la distància entre un Punt p donat i el Punt actual.
     * @param p Punt.
     * @return double, la distància.
     */  
    public double distancia(Punt p) { 
        double abs = p.x - this.x; 
        double ord = p.y - this.y;
        return Math.sqrt(abs * abs + ord * ord); 
    }
    
    /** Torna el nombre d'objectes Punt creats. 
     *  @return int, nombre de Punts.
     */    
    public static int numPunts() { return comptador; }
    
    /** Torna un Punt a partir de les coordenades polars, 
     *  la distància del qual a l'origen es r i amb angle a 
     *  respecte a l'eix X. 
     *  @param a double que representa l'angle (en radians) 
     *  respecte a l'eix X.
     *  @param r double que representa la distància a l'origen.
     *  @return Punt, el Punt resultat.
     */
    public static Punt polarsAPunt(double a, double r) {
        return new Punt(r * Math.cos(a), r * Math.sin(a));
    }
    
    /** Comprova si o és un Punt i les seues coordenades
     *  coincideixen amb les del Punt actual.
     *  @param o Object a comparar.
     *  @return boolean, true si són iguals o false en cas contrari.
     */
    // public boolean equals(Object o) {
        // return o instanceof Punt
            // && this.x == ((Punt) o).x
            // && this.y == ((Punt) o).y;
    // }
    
    /** Torna un String que representa el Punt actual en el  
     *  format típic matemàtic, i.e., (abscissa,ordenada) 
     *  @return String, el resultat.
     */
    // public String toString() {
        // return "(" + x + "," + y + ")";
    // }
    
    /* mètode usat a la classe PasParametres per 
     * exemplificar el pas de parametres amb variables
     * de tipus referència
     */
    public void intercanviX(Punt b) {
        double aux = this.x;
        this.x = b.x;
        b.x = aux;
    }
}
