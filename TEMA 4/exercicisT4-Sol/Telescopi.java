import java.util.Locale;
/**
 * Un telescopi es caracteritza bàsicament per tres mesures numèriques:<br>
 * - el diàmetre de l'objectiu o lent principal (diametre en mm)<br>
 * - la distància focal de la lent principal (dFL en mm)<br>
 * - la distància focal de l'ocular (dFO en mm)<br>
 * <br>
 * A partir d’aquestos valors es poden calcular, entre altres:<br>
 * - els augments: relació entre dFL i dFO <br>
 * - la relació focal: relació entre dFL i diametre <br>
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class Telescopi {
    // constants d'un telescopi estàndard 
    /** Valor (double) del diàmetre d'un telescopi estàndard, en mm. */ 
    public static final double DIAMETRE_ESTANDARD = 150.0;
    /** Valor (double) de la distància focal de la lent principal, 
     *  o distància focal, d'un telescopi estàndard, en mm. */
    public static final double D_F_L_ESTANDARD = 1000.0;
    /** Valor (double) de la distància focal de l'ocular, 
     *  o distància ocular, d'un telescopi estàndard, en mm.  */
    public static final double D_F_O_ESTANDARD = 10.0; 
    
    // atributs d'instancia
    private double diametre; // diàmetre
    private double dFL;      // distància focal lent principal
    private double dFO;      // distància focal ocular   
    
    /**
     * Construeix un telescopi d'un diàmetre, distància focal i ocular donats.
     * @param d double, el diàmetre.
     * @param dF double, la distància focal.
     * @param dFOcular double, la distància focal ocular.  
     */
    public Telescopi(double d, double dF, double dFOcular) {
        diametre = d; 
        dFL = dF; 
        dFO = dFOcular;
    }

    /**
     * Construeix un telescopi de diàmetre donat i 
     * distància focal i ocular estàndard.
     * @param d double, el diàmetre.
     */
    public Telescopi(double d)   {
        //diametre = d; dFL = D_F_L_ESTANDARD; dFO = D_F_O_ESTANDARD;
        // o equivalentment:
        this(d, D_F_L_ESTANDARD, D_F_O_ESTANDARD);
    }
    
    /**
     * Construeix un telescopi de mesures estàndard.
     */
    public Telescopi() {
        // diametre = DIAMETRE_ESTANDARD; 
        // dFL = D_F_L_ESTANDARD; dFO = D_F_O_ESTANDARD;
        // o equivalentment:
        // this(DIAMETRE_ESTANDARD, D_F_L_ESTANDARD , D_F_O_ESTANDARD);
        // o equivalentment:
        this(DIAMETRE_ESTANDARD);
    }     
    
    /**
     * Torna el diàmetre.
     * @return double, diàmetre del telescopi actual.
     */
    public double getDiametre() { return diametre; }
    
    /**
     * Torna la distància focal de la lent principal. 
     * @return double, distància focal del telescopi actual.  
     */
    public double getDFL() { return dFL; }
    
    /**
     * Torna la distància focal de l'ocular.
     * @return double, distància ocular del telescopi actual.  
     */
    public double getDFO() { return dFO; }
    
    /**
     * Actualitza el valor del diàmetre a un valor donat.
     * @param d double, el nou diàmetre.    
     */
    public void setDiametre(double d) { diametre = d; }
    
    /**
     * Actualitza el valor de la distància focal 
     * de la lent principal a un valor donat.
     * @param dfl double, la nova distància focal.
     */
    public void setDFL(double dfl) { dFL = dfl; }
    
    /**
     * Actualitza el valor de la distància focal 
     * de l'ocular a un valor donat.
     * @param dfo double, la nova distància ocular.
     */
    public void setDFO(double dfo) { dFO = dfo; }
    
    /**
     * Torna els augments del telescopi actual.
     * @return double, distància focal/distància ocular. 
     */
    public double augments() { return dFL / dFO; }
    
    /**
     * Torna la relació focal del telescopi actual.
     * @return double, distància focal/diàmetre.
     */
    public double relacioFocal() { return dFL / diametre; }
    
    /**
     * Comprova si el telescopi actual és igual a un altre 
     * telescopi donat, i.e. si coincideixen en diàmetre,  
     * distància focal de la lent i distància focal ocular
     * (sobreescriptura del mètode equals d'Object).
     * @param o Object a comparar amb el telescopi actual. 
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        return o instanceof Telescopi  
            && this.diametre == ((Telescopi) o).diametre   
            && this.dFL == ((Telescopi) o).dFL 
            && this.dFO == ((Telescopi) o).dFO;
    }
    
    /**
     * Torna la representació del telescopi actual en forma de String
     * (sobreescriptura del mètode toString d'Object).  
     * @return String, representació del telescopi actual.
     */
    public String toString() {
        // String res = "Telescopi de diàmetre = " + diametre;
        // res += ", distància focal = " + dFL;
        // res += " i distància focal ocular = " + dFO; 
        
        // Utilitzant String.format:
        String res = String.format(Locale.US, "Telescopi de diàmetre = %.2f", diametre);
        res += String.format(Locale.US, ", distància focal = %.2f", dFL);
        res += String.format(Locale.US, " i distància focal ocular = %.2f", dFO);
        return res;
    }
}
