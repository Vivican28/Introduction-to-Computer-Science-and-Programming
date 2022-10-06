 /** 
 * Classe Cercle: defineix un cercle d'un determinat radi, 
 * color (transparent, translucid o opac) i posició del seu 
 * centre (punt bidimensional), amb la funcionalitat que 
 * apareix a continuació.
 * @author IIP 
 * @version Curs 2019/20
 */ 
public class Cercle {
    // Atributs estàtics per representar el color
    public static final int TRANSPARENT = 0;
    public static final int TRANSLUCID = 1;
    public static final int OPAC = 2;
    // Atributs d'instància
    private double radi; 
    private int color; 
    private Punt centre;   
    
    /** Crea un Cercle de radi 50, opac i centre en (100,100). */
    public Cercle() {
        radi = 50;
        color = OPAC;
        centre = new Punt(100, 100);
    }
    
    /** Crea un Cercle de radi r, color c i centre en (px,py). 
     *  @param r double, el radi.
     *  @param c int, el color.
     *  @param px double, l'abscissa del centre.
     *  @param py double, l'ordenada del centre.
     */
    public Cercle(double r, int c, double px, double py) {
        radi = r;
        color = c;
        centre = new Punt(px, py);
    }

    /** Torna el radi del Cercle. 
     *  @return double, el radi.  
     */
    public double getRadi() { return radi; }    

    /** Torna el color del Cercle.
     *  @return int, el color.  
     */
    public int getColor() { return color; }  

    /** Torna l'abscissa del centre del Cercle. 
     *  @return double, l'abscissa del centre.  
     */
    public double getCentreX() { return centre.getX(); }  

    /** Torna l'ordenada del centre del Cercle. 
     *  @return double, l'ordenada del centre.    
     */
    public double getCentreY() { return centre.getY(); }
 
    /** Torna el centre del Cercle. 
     *  @return Punt, el centre.  
     */
    public Punt getCentre() { return centre; }
    
    /** Actualitza el radi del Cercle a nouRadi. 
     *  @param nouRadi double, el nou radi.  
     */
    public void setRadi(double nouRadi) { radi = nouRadi; }   

    /** Actualitza el color del Cercle a nouColor. 
     *  @param nouColor int, el nou color.    
     */
    public void setColor(int nouColor) { color = nouColor; }   
 
    /** Actualitza el centre del Cercle a la posició (px,py). 
     *  @param px double, la nova abscissa del centre.
     *  @param py double, la nova ordenada del centre.
     */
    public void setCentre(double px, double py) { 
        centre.setX(px); 
        centre.setY(py); 
    }
    
    /** Comprova si un Cercle (this) és igual a un altre (o).
     *  És a dir, si coincideixen en centre, color i radi.
     *  @param o Object, Cercle a comparar amb this.
     *  @return boolean, true si son iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        return o instanceof Cercle
            && this.centre.equals (((Cercle) o).centre)
            && this.color == ((Cercle) o).color
            && this.radi == ((Cercle) o).radi;
    }
    
    /** Torna un String amb la descripció del Cercle, com en el seguent
     *  exemple:
     *  "Cercle de radi 150.5, translucid i centre (15.0,25.9)"
     *  Has d'usar obligatòriament una instruccio switch per convertir 
     *  en text el color del Cercle.
     *  @return String, el resultat.
     */
    public String toString() { 
        String tipus = "";
        switch (color) {
            case TRANSPARENT:
                tipus = "transparent";
                break;
            case TRANSLUCID:
                tipus = "translucid";
                break;
            case OPAC:
                tipus = "opac";
        }
        String res = "Cercle de radi " + radi + ", " + tipus + " i centre " + centre;       
        return res; 
    }
    
    /** Compara un Cercle this amb un Cercle altre en base als criteris de ressalt
     *  que figuren a continuació. Torna un int negatiu si this ressalta menys que
     *  altre, positiu si this ressalta més que altre i un zero si ressalten igual.
     *  Criteris de ressalt:
     *  -- Un cercle ressalta menys o més que un altre en funció de la posició del 
     *  seu centre en el pla. La relació d'ordre que s'estableix entre les diferents
     *  posicions que pot ocupar el centre en el pla és la seguent:
     *      PRIMER_QUADRANT < SEGON_QUADRANT < TERCER_QUADRANT < QUART_QUADRANT
     *      < EIX_ABSCISSES < EIX_ORDENADES < CENTRE_COORDENADES.
     *  -- A igualtat de posició del centre en el pla, un cercle transparent ressalta
     *  menys que un cercle translucid u opac i un cercle translucid ressalta menys
     *  que un cercle opac (TRANSPARENT < TRANSLUCID < OPAC).
     *  -- A igualtat de posició del centre i color, un cercle ressalta menys que un 
     *  altre si el seu radi és menor. 
     *  @param altre Cercle.
     *  @return int, negatiu, positiu o zero si this ressalta menys, més o igual que altre.
     */
    public int compareTo(Cercle altre) {
        int res = this.centre.posicioEnPla() - altre.centre.posicioEnPla();
        if (res == 0) {
            res = this.color - altre.color;
            if (res == 0) {
                double diff = (this.radi - altre.radi);
                if (diff < 0) { res = -1; }
                else if (diff > 0) { res = 1; }
            }
        }
        // int res = 0;
        // int posThis = this.centre.posicioEnPla();
        // int posAltre = altre.centre.posicioEnPla();
        // if (posThis < posAltre) { res = -1; }
        // else if (posThis > posAltre) { res = 1; }
        // else if (this.color < altre.color) { res = -1; }
        // else if (this.color > altre.color) { res = 1; }
        // else if (this.radi < altre.radi) { res = -1; }
        // else if (this.radi > altre.radi) { res = 1; }
        return res;
    }
}         