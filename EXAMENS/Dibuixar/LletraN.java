
/**
 * Write a description of class LletraN here.
 *
 * @author (your name)
 * @version Recu 2017-2018
 */
public class LletraN {
    public static void LletraN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("N");
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("N");
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.println("N");
        }
    }
}
