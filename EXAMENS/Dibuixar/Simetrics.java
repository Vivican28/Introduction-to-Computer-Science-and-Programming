
/**
 * Write a description of class Simetrics here.
 *
 * @author (your name)
 * @version 2017-2018
 */
public class Simetrics {
    public static boolean simetrics(double a[]) {
        boolean sol = true;
        double sum = a[a.length - 1] + a[0];
        for (int i = a.length - 1, j = 0; j <= i && sol ; i--, j++) {
            if (sum == a[i] + a[j]) { sol = false; }
        } 
        return sol;
    }
}
