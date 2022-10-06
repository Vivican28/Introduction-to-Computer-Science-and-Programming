
/**
 * Write a description of class freqAcumulada here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class freqAcumulada {
    int[] limits = {15, 35, 50, 37, 25, 70};
    double[] valors = {10.0, 20.0, 50.0, 40.0, 30.0, 80.0};
    
    public static int[] freqAcumulada(int[] limits, double[] valors) {
        int[] res = new int[limits.length];
        for (int i = 0; i < limits.length; i++) {
            for (int j = 0; j < valors.length; j++) {
                if (valors[j] < limits[i]) {
                    res[i] ++;
                }
            }
        }
        return res;
    }
}
