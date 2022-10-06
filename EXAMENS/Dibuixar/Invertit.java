
/**
 * Write a description of class Invertit here.
 *
 * @author (your name)
 * @version (recup. 2018/19)
 */
public class Invertit {
    public static int nombreXifres(double n) {
        int xifres = 1;
        double m = n;
        while (n > 9) {
            m = n / 10;
            xifres ++;
        }
        return xifres;
    }
    public static int invertit(int n) {
        int i = nombreXifres(n), add = 0;
        while (i > 0) {
            add = add * 10 + (n % 10);
            n = n / 10; i--;
        }
        return add;
    }
    
}
