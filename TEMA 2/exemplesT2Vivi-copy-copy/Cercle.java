/** 
 * Classe Cercle: defineix un cercle d'un determinat radi, color i
 * posicio del seu centre, amb la funcionalitat que apareix a continuacio.
 * @author IIP 
 * @version Curs 2019/20
 */ 
public class Cercle {
    private double radi; 
    private String color; 
    private int centreX, centreY;   
    
    /** Crea un Cercle de radi 50, negre i centre en (100,100). */
    public Cercle() {
        radi = 50;
        color = "negre";
        centreX = 100;
        centreY = 100; 
    }
    
    /** Crea un Cercle de radi r, color c i centre en (px,py). */
    public Cercle(double r, String c, int px, int py) {
        radi = r;
        color = c;
        centreX = px;
        centreY = py; 
    }

    /** Torna el radi del Cercle. */
    public double getRadi() { return radi; }    

    /** Torna el color del Cercle.*/
    public String getColor() { return color; }  

    /** Torna l'abscissa del centre del Cercle. */
    public int getCentreX() { return centreX; }  

    /** Torna l'ordenada del centre del Cercle. */
    public int getCentreY() { return centreY; }
 
    /** Actualitza el radi del Cercle a nouRadi. */
    public void setRadi(double nouRadi) { radi = nouRadi; }   

    /** Actualitza el color del Cercle a nouColor. */
    public void setColor(String nouColor) { color = nouColor; }   
 
    /** Actualitza el centre del Cercle a la posicio (px,py). */
    public void setCentre(int px, int py) { centreX = px; centreY = py; }
    
    /** Augmenta en un factor de 1.3 el radi del Cercle. */
    public void creix() { radi = radi * 1.3; } 
	
    /** Redueix en un factor de 1.3 el radi del Cercle. */
    public void decreix() { radi = radi / 1.3; }   
  
    /** Torna l'àrea del Cercle.*/
    public double area() { return Math.PI * radi * radi; }
    
    /** Torna el perímetre del Cercle.*/
    public double perimetre() { return 2 * Math.PI * radi; }
    
    /** Torna un String amb les components del Cercle. */
    public String toString() { 
        String res = "Cercle de radi " + radi;
        res += ", color " + color;
        res += " i centre (" + centreX + "," + centreY + ")";
        return res; 
    }
} // de Cercle
        