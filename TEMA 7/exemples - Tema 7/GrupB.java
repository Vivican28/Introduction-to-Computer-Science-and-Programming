import java.util.Scanner;
/**
 * Class GrupB: representa als alumnes del grup B.
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class GrupB {
    public static final int ALUM_B = 48;
    private Alumne[] grupB;
    
    /** Crea un GrupB amb els alumnes del grup B, 
     *  les dades dels quals es lligen des de teclat.
     */
    public GrupB(Scanner tec) {
        grupB = new Alumne[ALUM_B];
        for (int i = 0; i < grupB.length; i++) {
            grupB[i] = new Alumne(tec);
            grupB[i].setGrup('B');
        }
    }
    
    /** Mostra per pantalla la informacio de tots
     *  els alumnes del grup. */
    public void mostrarAlumnes() {
        for (int i = 0; i < grupB.length; i++) {
            System.out.println(grupB[i]);
        }
    }   
}
