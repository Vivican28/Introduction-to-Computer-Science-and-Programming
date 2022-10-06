
/**
 * Write a description of class Sufix here.
 *
 * @author (your name)
 * @version Recu 2018-2019
 */
public class Sufix {
    public static void sufix(char a[]) {
        String sol = "";
        for (int i = a.length - 1; i >= 0; i--) {
            sol = a[i] + sol;
            System.out.println(sol);
        }
    }
    
    //Me he equivocado en a.length, en vez de a.length - 1
    // <=, en vez de >=
    //No habia puesto void, sino String
    // Habia puesto \n en vez de S.o.pln
    //Habia puesto que se concatenase sol antes de a[i] i va detras
}
