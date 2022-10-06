package agendaSenseOrdre;

import java.util.Scanner;
/**
 * Classe GestorAgenda: llança l'aplicacio de simulacio d'una agenda 
 * telefonica, presentant a l'usuari en mode text una interficie basica 
 * amb la qual aquest pot manipular la seua agenda. Per aixo, el seu unic 
 * metode public es el main i en ell es descriuen via menu les opcions de 
 * treball que permet l'aplicacio.
 *
 * Es important insistir que GestorAgenda es simplement una interficie en 
 * la qual nomes es creen i manipulen objectes de l'aplicacio, es a dir, 
 * una agenda telefonica (basica) i els seus contactes. En treballar en 
 * mode text, es necessari definir metodes estatics i privats que 
 * s'encarreguen de la lectura de dades des de teclat i l'escriptura de 
 * resultats en pantalla usant un objecte de tipus Agenda, agendaMeua, i 
 * diversos objectes de tipus Contacte (que s'insereixen o s'actualitzen,
 * es consulten o eliminen seguint les opcions escollides per l'usuari).
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class GestorAgenda {
    private GestorAgenda() { }
    
    /** 
     *  Programa principal.
     *  @param args String[] 
     */
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        Agenda agendaMeua = new Agenda();
        
        int opc;        
        do {
            opc = menu(teclat);
            switch (opc) {
                case 1: // Mostrar contactes
                    System.out.println("\n" + agendaMeua);
                    break;
                case 2: // Afegir/Actualitzar un contacte
                    inserirContacte(agendaMeua, teclat);  
                    break;
                case 3: // Consultar telefon d'un contacte
                    recuperarTelefon(agendaMeua, teclat);
                    break;
                case 4: // Eliminar un contacte
                    eliminarContacte(agendaMeua, teclat); 
                    break;
                default: // Tancar l'agenda
                    System.out.println("\nAgenda tancada.");
            }        
        } while (opc != 0);
    }
    
    /** 
     *  Presenta un menu d'opcions per pantalla.
     *  @param teclat Scanner per fer la lectura de
     *  l'opcio triada des de teclat.  
     *  @return int, torna l'opcio valida triada per 
     *  l'usuari d'entre les opcions possibles.
     */  
    private static int menu(Scanner teclat) {
        int opcio;
        do {
            System.out.println("\n                MENU");
            System.out.println("---------------------------------------");
            System.out.println("| 1.- Mostrar contactes               |");
            System.out.println("| 2.- Afegir/Actualitar un contacte   |");
            System.out.println("| 3.- Consultar telefon d'un contacte |");
            System.out.println("| 4.- Eliminar un contacte            |");
            System.out.println("| 0.- Tancar l'agenda                 |");     
            System.out.println("---------------------------------------");    
            System.out.print("Tria una opcio: ");
            opcio = teclat.nextInt(); 
            teclat.nextLine();
            if (opcio < 0 || opcio > 4) {
                System.out.println("Opcio incorrecta, torna a intentar-ho");  
            }
        } while (opcio < 0 || opcio > 4);
        return opcio;        
    }
         
   
    /**
     * Afegeix/actualitza un nou contacte a l'agenda donada.
     * @param a Agenda on s'afegeix/actualitza un nou contacte.
     * @param teclat Scanner per fer la lectura de dades.
     */
    private static void inserirContacte(Agenda a, Scanner teclat) {
        String nom, telefon;
        // Filtre de dades: Un nom valid per a un Contacte de l'agenda 
        // pot estar compost per qualsevol caracter PERO CAL que tinga 
        // una longitud en l'interval [1...40] 
        do {
            System.out.print("\nNom del nou contacte "
                + "(minim una lletra i maxim 40): "); 
            nom = teclat.nextLine().trim();
        } while (nom.length() < 1 || nom.length() > 40);
        
        // Filtre de dades: Un telefon valid per a un Contacte de 
        // l'agenda CAL que estiga compost per 9 caracters de l'interval 
        // ['0'..'9'] PERO el primer d'ells NO pot ser el zero
        do { 
            System.out.print("Telefon del nou contacte "
                + "(9 digits, el primer d'ells no pot ser 0): "); 
            telefon = teclat.nextLine().trim();
        } while (!telefon.matches("[0-9]+") 
                 || telefon.length() != 9 || telefon.charAt(0) == '0');
       
        // Filtre de dades: la forma d'escriure un nom, amb o sense 
        // majuscules, no pot originar informacio redundant en l'agenda, 
        // es a dir, no pot donar lloc a contactes repetits. Per aixo, 
        // en l'agenda figuren els noms dels contactes en majuscules <--> 
        // qualsevol nom de contacte que es llija de teclat es passa a 
        // majuscules usant el metode toUpperCase de la classe String 
        Contacte nou = new Contacte(nom.toUpperCase(), telefon);
        if (a.inserir(nou)) {
            System.out.println("Contacte afegit amb exit:\n" + nou  
                + "\nDisposes de " + a.getTalla() 
                + " contactes a l'agenda.");
        }
        else { 
            System.out.println("La teua agenda esta plena, "
                + "pel que no es podran inserir nous contactes"
                + "fins que no elimines algun dels actuals.");
        }
    }
    
    /**
     * Recupera el telefon associat a un nom d'un contacte de l'agenda donada.
     * @param a Agenda d'on es recupera un telefon.
     * @param teclat Scanner per fer la lectura de dades.
     */
    private static void recuperarTelefon(Agenda a, Scanner teclat) {        
        String nom;
        // Filtre del nom
        do {
            System.out.print("\nNom del contacte del qual "
                + "vols coneixer el telefon: "); 
            nom = teclat.nextLine().trim();  
        } while (nom.length() < 1 || nom.length() > 40);
        // Filtre del nom (toUpperCase)
        String telefon = a.recuperar(nom.toUpperCase()); 
        if (telefon != null) {
            System.out.println("El telefon de " + nom + " es " + telefon);
        }
        else { 
            System.out.println("A la teua agenda no figura cap "
                + "contacte amb aquest nom.");
        }
    }
    
    /**
     * Elimina un contacte de l'agenda donada.
     * @param a Agenda d'on s'elimina un contacte.
     * @param teclat Scanner per fer la lectura de dades.
     */
    private static void eliminarContacte(Agenda a, Scanner teclat) {        
        String nom;
        // Filtre del nom 
        do {
            System.out.print("\nNom del contacte que vols eliminar: "); 
            nom = teclat.nextLine().trim();  
        } while (nom.length() < 1 || nom.length() > 40);
        // Filtre del nom (toUpperCase)
        boolean eliminat = a.eliminar(nom.toUpperCase()); 
        if (eliminat) {
            System.out.println("Contacte eliminat amb exit.");
        }
        else { 
            System.out.println("A la teua agenda no figura cap "
                + "contacte amb aquest nom.");
        }
    }
    
} // de GestorAgenda
