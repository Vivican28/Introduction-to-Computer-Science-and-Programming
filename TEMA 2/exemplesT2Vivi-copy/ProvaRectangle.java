
/**
 * Write a description of class ProvaRectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProvaRectangle {
    private ProvaRectangle() {}
    
    public static void main(String[] args) {
        //(1) Declarar i crear un objecte de tipus Rectangle l'identificador del qual siga r, de base 40.5, altura 81, color "roig" i centre en el punt (150, 150).
        Rectangle r = new Rectangle(40.5, 81, "roig", 150, 150);
        //(2) Mostrar per pantalla les dades del Rectangle r, açò és, el resultat del mètode toString().
        System.out.println("Dades: " + r.toString());
        //(3) Mostrar per pantalla l'àrea del Rectangle r.
        System.out.println("Àrea: " + r.area());
        //(4) Mostrar per pantalla el perímetre del Rectangle r.
        System.out.println("Perímetre: " + r.perimetre());
        
    }
}