import java.util.*;
/**
 * Write a description of class NombrePoligonal here.
 *
 * @author (your name)
 * @version (2018/19)
 */
public class NombrePoligonal {
    public NombrePoligonal() {}
    Scanner tec = new Scanner(System.in);
    /** Precondicio: k > 0 i l > 2 */
    public static boolean Comprobat(int k, int l) {
        int n = 2;
        double recurr = 0;
        while (recurr < k) {
            recurr = (n * ((l-2) * n - (l - 4))) / 2;
            System.out.println(recurr);
            n++;
        }
        // if (recurr == k) {
            // return true;
        // } else { return false; }
        return recurr == k;
        
    } 


}
