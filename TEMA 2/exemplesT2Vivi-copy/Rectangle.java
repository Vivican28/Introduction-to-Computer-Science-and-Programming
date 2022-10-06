/** 
 * Classe Rectangle: defineix un rectangle amb certa base i altura, color i
 * posició del seu centre, amb la funcionalitat que apareix a continuació.
 * @author IIP 
 * @version Curs 2019/20
 */  
public class Rectangle {
    private double base, altura;
    private String color;
    private int centreX, centreY;
    
    /** Crea un Rectangle de base 20, altura 10, color negre i 
     *  centre en (100, 100). 
     */        
    public Rectangle() {
        base = 20;
        altura = 10;
        color = "negre"; 
        centreX = 100; 
        centreY = 100;
    }    
    
    /** Crea un Rectangle de base b, altura a, color c i 
     *  centre en (cx, cy).
     */    
    public Rectangle(double b, double a, String col, int cx, int cy) {
        base = b;
        altura = a;
        color = col; 
        centreX = cx; 
        centreY = cy;
    }

    /** Torna la base del Rectangle. */
    public double getBase() { return base; }
    
    /** Torna l'altura del Rectangle. */
    public double getAltura() { return altura; }    
    
    /** Torna el color del Rectangle. */
    public String getColor() { return color; }
    
    /** Torna l'abscissa del centre del Rectangle. */
    public int getCentreX() { return centreX; }
    
    /** Torna l'ordenada del centre del Rectangle. */
    public int getCentreY() { return centreY; }
    
    /** Actualitza la base del Rectangle a novaBase. */
    public void setBase(double novaBase) { base = novaBase; }
    
    /** Actualitza l'altura del Rectangle a novaAltura. */
    public void setAltura(double novaAltura) { altura = novaAltura; }    
    
    /** Actualitza el color del Rectangle a nouColor. */
    public void setColor(String nouColor) { color = nouColor; }
    
    /** Actualitza el centre del Rectangle a la posició (cx,cy). */
    public void setCentre(int cx, int cy) { centreX = cx; centreY = cy; }
    
    /** Torna l'àrea del Rectangle. */
    public double area() { return base * altura; }
    
    /** Torna el perímetre del Rectangle. */
    public double perimetre() { return 2 * (base + altura); }    
    
    /** Torna un String amb les dades del Rectangle. */
    public String toString() {
        String res = "Rectangle de base " + base;
        res += ", altura " + altura;
        res += ", color " + color;
        res += " i centre (" + centreX + "," + centreY + ")";
        return res;
    }
} // de Rectangle
