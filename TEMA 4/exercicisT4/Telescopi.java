
/**
 * Write a description of class Telescopi here.
 *
 * @author Violeta Vicente Cantero
 * @version 2019-2020
 */
public class Telescopi {
    /**Valor double de la dist�ncia focal de la lent principal*/
    public static final double D_F_L_ESTANDARD = 1000.0;
    /**Valor double de la dist�ncia focal ocular */
    public static final double D_F_O_ESTANDARD = 10.0;
    /**Valor double del di�metre de les lents*/
    public static final double DIAMETRE_ESTANDARD = 150.0;
    //Atributs d'inst�ncia
    private double dFL, dFO, diametre;
    /**Construeix un telescopi de mesures parametritzades.
    */
    public Telescopi(double d, double dF, double dFOcular) {
       dFL = dF;
       dFO = dFOcular;
       diametre = d;
    }
    
    /**Construeix un telescopi de mesures est�ndard.
    */
    public Telescopi() {
        dFL = D_F_L_ESTANDARD;
        dFO = D_F_O_ESTANDARD;
        diametre = DIAMETRE_ESTANDARD;
    }
    /**Torna els augments del telescopi actual
       @return double, dist�ncia focal/fist�ncia ocular.*/
    public double augments(){ return dFL/dFO; }
    
}
