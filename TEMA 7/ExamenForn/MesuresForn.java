
/**
 * Write a description of class Mesura here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MesuresForn {
    public static final int MAX_MESURES = 3600;
    private Mesura[] mesures;
    private int numProblem;
    public MesuresForn() {
        mesures = new Mesura[MAX_MESURES];
        numProblem = 0;
    }
    public void AltaMEsura(int s, Mesura m) {
        if (m != null && mesures[s].getEstat() != Mesura.CORRECTA) { numProblem --; }
        mesures[s] = m;
        if (mesures[s].getEstat() != Mesura.CORRECTA) { numProblem ++; }
    }
    
    public int minPressio() {
        double min = Double.MAX_VALUE; //com la pressio es positiva, si la inicialita a un valor maxim
        int posMin = -1; //per a assegurar-nos de tornar el -1 i de que posMin < min
        for (int i = 0; i < mesures.length; i++) {
            if (mesures[i] != null && mesures[i].getPressio() <= min) {
                min = mesures[i].getPressio();
                posMin = i;
            }
        }
        return posMin;
    }
    // public int[] mesuresAmbProblemes() {
        
    // }
}
