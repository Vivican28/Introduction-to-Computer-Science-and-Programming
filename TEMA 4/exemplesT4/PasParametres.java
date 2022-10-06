
/**
 * Class PasParametres: classe programa que exemplifica el pas de
 * paràmetres amb variables de tipus primitiu i referència.
 * Per fer la traça amb el depurador de BlueJ, estableix un 
 * punt de ruptura en les línies del main on s'invoca als mètodes 
 * intercanvi i intercanviX.
 * 
 * @author IIP 
 * @version 2019-20
 */
public class PasParametres {
    private PasParametres() { }    
    
    public static void intercanvi(int a, int b) {
        int aux = a;
        a = b;
        b = aux;
    }

    public static void intercanvi(Punt a, Punt b) {
        Punt aux = a;
        a = b;
        b = aux;
    }

    public static void main(String[] args) {
        // Pas de paràmetres amb variables de tipus primitiu
        // Els canvis són locals, NO permanents. Cap modificació 
        // d’un tipus primitiu dins d’un mètode és visible des de fora
        int i = 5, j = 7;
        System.out.println("Abans de intercanvi(i, j):   i = " + i + ", j = " + j);
        intercanvi(i, j); 
        System.out.println("Despres de intercanvi(i, j): i = " + i + ", j = " + j);
        System.out.println();
        
        // Pas de paràmetres amb variables de tipus referència
        // Els canvis són locals, NO permanents. Cap modificació 
        // d’una referència dins d’un mètode és visible des de fora
        Punt p = new Punt(3.0, 5.0);
        Punt q = new Punt(6.0, 2.0); 
        System.out.println("Abans de intercanvi(p, q):   p = " + p + ", q = " + q);
        intercanvi(p, q); 
        System.out.println("Despres de intercanvi(p, q): p = " + p + ", q = " + q);
        System.out.println();
        
        // Quan es passa una referència a un objecte, 
        // SÍ que es possible accedir als seus atributs i modificar-los
        System.out.println("Abans de p.intercanviX(q):   p = " + p + ", q = " + q);
        p.intercanviX(q);
        System.out.println("Despres de p.intercanviX(q): p = " + p + ", q = " + q);
    }
}
