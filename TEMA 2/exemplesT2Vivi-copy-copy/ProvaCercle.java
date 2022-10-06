/**
 * Classe ProvaCercle: classe programa que prova 
 * la classe Cercle.
 * @author IIP 
 * @version Curs 2019/20
 */
public class ProvaCercle {
    // No s'usen objectes d'aquesta classe
    private ProvaCercle() { }
    
    public static void main(String[] args) {
        Cercle c1 = new Cercle(); 
        System.out.println(c1.toString());
        c1.decreix(); 
        System.out.print("Decreix el radi a " + c1.getRadi());
        System.out.println(" i la seua àrea és " + c1.area());
    }    
}
