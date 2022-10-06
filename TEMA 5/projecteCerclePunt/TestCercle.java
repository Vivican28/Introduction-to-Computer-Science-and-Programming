import java.util.Locale;
import java.util.Scanner;
/**
 * Classe TestCercle: classe programa que prova les classes Cercle i Punt.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class TestCercle {
    /** No hi ha objectes d'aquesta classe. */
    private TestCercle() { }
    
    /** Torna un enter, llegit des de l'entrada estàndard (teclat), 
     *  que indica el número de l'opció triada per l'usuari d'entre 
     *  les 4 possibles d'un menú mostrat en l'eixida estàndard 
     *  (pantalla).
     *  @param t Scanner, l'entrada estàndard (teclat).
     *  @return int, el número de l'opció del menú triada.
     */ 
    private static int menu(Scanner t) {
        System.out.println(" MENÚ");
        System.out.println("1. Mostrar per pantalla");
        System.out.println("2. Ressalt");
        System.out.println("3. Canviar color");
        System.out.println("4. Acabar");
        System.out.print("\nTria una opció: ");
        int opc = t.nextInt();
        if (opc < 1 || opc > 4) { opc = 4; }
        return opc;
    }
    
    /** Mètode principal de l'aplicació.
     *  @param args String[].  
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Introdueix les dades del CERCLE 1: ");
        System.out.print("Radi: "); double r = tec.nextDouble();
        System.out.print("Abscissa del centre: "); double abs = tec.nextDouble();
        System.out.print("Ordenada del centre: "); double ord = tec.nextDouble();
        // el color es genera aleaòriament
        int col = (int) (Math.random() * 3);
        String c = col == 0 ? "transparent" : (col == 1 ? "translucid" : "opac");
        System.out.println("Color: " + c);
        
        // Crear un Cercle c1 de radi r, color col i centre (abs,ord)
        Cercle c1 = new Cercle(r, col, abs, ord);
        
        // Crear un Cercle c2 de radi 50, opac i centre en (100,100), 
        // aço és, un cercle amb les dades per defecte 
        Cercle c2 = new Cercle();
        
        // Cridar al mètode menu
        int opcio = menu(tec);
        // Utilitzar una instrucció switch:
        switch (opcio) {
            case 1: // Mostrar per pantalla la descripció dels 2 cercles
                System.out.println("CERCLE 1: " + c1);
                System.out.println("CERCLE 2: " + c2);
                break;
            case 2: // Comparar els 2 cercles en funció del que ressalten
                    // i mostrar per pantalla el que ressalta més. 
                    // Si ressalten igual, mostrar qualsevol dels 2. 
                int ressalt = c1.compareTo(c2);
                String ressaltaMes = "\nRessalta més: ";
                if (ressalt < 0) { System.out.println(ressaltaMes + c2); }
                else if (ressalt > 0) { System.out.println(ressaltaMes + c1); }
                else { System.out.println("\nRessalten igual " + c1); }
                break;
            case 3: // Consultar en quina zona del pla es troba el centre del Cercle c1. 
                    // Si està en el centre de coordenades, fer que c1 siga opac.
                    // Si està en l'eix d'abscisses u ordenades, fer que c1 siga translucid.
                    // Si està en un del 4 quadrants, fer que c1 siga transparent.
                    // USAR les constants definides en les classes Punt i Cercle.                
                System.out.println("\nCERCLE 1: " + c1);
                int pos = c1.getCentre().posicioEnPla();
                if (pos == Punt.CENTRE_COORDENADES) {
                    c1.setColor(Cercle.OPAC);
                }
                else if (pos == Punt.EIX_ABSCISSES || pos == Punt.EIX_ORDENADES) {
                    c1.setColor(Cercle.TRANSLUCID);
                }
                else {
                    c1.setColor(Cercle.TRANSPARENT);
                }
                System.out.println("\nCERCLE 1: " + c1);
                break;       
            default: // Mostrar per pantalla un missatge que indique 
                     // el final de l'execució
                System.out.println("\nFi");
        }        
    }
}
