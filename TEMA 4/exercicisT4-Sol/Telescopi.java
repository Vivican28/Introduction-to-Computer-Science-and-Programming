import java.util.Locale;
/**
 * Un telescopi es caracteritza b�sicament per tres mesures num�riques:<br>
 * - el di�metre de l'objectiu o lent principal (diametre en mm)<br>
 * - la dist�ncia focal de la lent principal (dFL en mm)<br>
 * - la dist�ncia focal de l'ocular (dFO en mm)<br>
 * <br>
 * A partir d�aquestos valors es poden calcular, entre altres:<br>
 * - els augments: relaci� entre dFL i dFO <br>
 * - la relaci� focal: relaci� entre dFL i diametre <br>
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class Telescopi {
    // constants d'un telescopi est�ndard 
    /** Valor (double) del di�metre d'un telescopi est�ndard, en mm. */ 
    public static final double DIAMETRE_ESTANDARD = 150.0;
    /** Valor (double) de la dist�ncia focal de la lent principal, 
     *  o dist�ncia focal, d'un telescopi est�ndard, en mm. */
    public static final double D_F_L_ESTANDARD = 1000.0;
    /** Valor (double) de la dist�ncia focal de l'ocular, 
     *  o dist�ncia ocular, d'un telescopi est�ndard, en mm.  */
    public static final double D_F_O_ESTANDARD = 10.0; 
    
    // atributs d'instancia
    private double diametre; // di�metre
    private double dFL;      // dist�ncia focal lent principal
    private double dFO;      // dist�ncia focal ocular   
    
    /**
     * Construeix un telescopi d'un di�metre, dist�ncia focal i ocular donats.
     * @param d double, el di�metre.
     * @param dF double, la dist�ncia focal.
     * @param dFOcular double, la dist�ncia focal ocular.  
     */
    public Telescopi(double d, double dF, double dFOcular) {
        diametre = d; 
        dFL = dF; 
        dFO = dFOcular;
    }

    /**
     * Construeix un telescopi de di�metre donat i 
     * dist�ncia focal i ocular est�ndard.
     * @param d double, el di�metre.
     */
    public Telescopi(double d)   {
        //diametre = d; dFL = D_F_L_ESTANDARD; dFO = D_F_O_ESTANDARD;
        // o equivalentment:
        this(d, D_F_L_ESTANDARD, D_F_O_ESTANDARD);
    }
    
    /**
     * Construeix un telescopi de mesures est�ndard.
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
     * Torna el di�metre.
     * @return double, di�metre del telescopi actual.
     */
    public double getDiametre() { return diametre; }
    
    /**
     * Torna la dist�ncia focal de la lent principal. 
     * @return double, dist�ncia focal del telescopi actual.  
     */
    public double getDFL() { return dFL; }
    
    /**
     * Torna la dist�ncia focal de l'ocular.
     * @return double, dist�ncia ocular del telescopi actual.  
     */
    public double getDFO() { return dFO; }
    
    /**
     * Actualitza el valor del di�metre a un valor donat.
     * @param d double, el nou di�metre.    
     */
    public void setDiametre(double d) { diametre = d; }
    
    /**
     * Actualitza el valor de la dist�ncia focal 
     * de la lent principal a un valor donat.
     * @param dfl double, la nova dist�ncia focal.
     */
    public void setDFL(double dfl) { dFL = dfl; }
    
    /**
     * Actualitza el valor de la dist�ncia focal 
     * de l'ocular a un valor donat.
     * @param dfo double, la nova dist�ncia ocular.
     */
    public void setDFO(double dfo) { dFO = dfo; }
    
    /**
     * Torna els augments del telescopi actual.
     * @return double, dist�ncia focal/dist�ncia ocular. 
     */
    public double augments() { return dFL / dFO; }
    
    /**
     * Torna la relaci� focal del telescopi actual.
     * @return double, dist�ncia focal/di�metre.
     */
    public double relacioFocal() { return dFL / diametre; }
    
    /**
     * Comprova si el telescopi actual �s igual a un altre 
     * telescopi donat, i.e. si coincideixen en di�metre,  
     * dist�ncia focal de la lent i dist�ncia focal ocular
     * (sobreescriptura del m�tode equals d'Object).
     * @param o Object a comparar amb el telescopi actual. 
     * @return boolean, true si s�n iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        return o instanceof Telescopi  
            && this.diametre == ((Telescopi) o).diametre   
            && this.dFL == ((Telescopi) o).dFL 
            && this.dFO == ((Telescopi) o).dFO;
    }
    
    /**
     * Torna la representaci� del telescopi actual en forma de String
     * (sobreescriptura del m�tode toString d'Object).  
     * @return String, representaci� del telescopi actual.
     */
    public String toString() {
        // String res = "Telescopi de di�metre = " + diametre;
        // res += ", dist�ncia focal = " + dFL;
        // res += " i dist�ncia focal ocular = " + dFO; 
        
        // Utilitzant String.format:
        String res = String.format(Locale.US, "Telescopi de di�metre = %.2f", diametre);
        res += String.format(Locale.US, ", dist�ncia focal = %.2f", dFL);
        res += String.format(Locale.US, " i dist�ncia focal ocular = %.2f", dFO);
        return res;
    }
}
