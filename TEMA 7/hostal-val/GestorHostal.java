import java.util.Scanner;
/**
 * Classe GestorHostal: permet provar el comportament de les classes
 * {@link Hostal} i {@link Client}. 
 * 
 * @author IIP 
 * @version Curs 2019/20
 */
public class GestorHostal {
    private GestorHostal() { }

    /**
     * Mostra per pantalla un menu amb les operacions que
     * es poden realitzar en un hostal.
     * @param t {@code Scanner}.
     * @return {@code int}, l'opcio triada.
     */
    private static int menu(Scanner t) {
        int opc;
        do {
            System.out.println("\n********* HOSTAL **********");
            System.out.println(" 1. Check in");
            System.out.println(" 2. Check out d'una habitacio");
            System.out.println(" 3. Check out en una data");
            System.out.println(" 4. Visualitzacio");
            System.out.println(" 5. Clients en regim de PC");
            System.out.println(" 0. Acabar");
            System.out.println("*****************************");
            System.out.print("Tria una opcio: ");
            opc = t.nextInt();
            t.nextLine();
            if (opc < 0 || opc > 5) {
                System.out.println("\nOpcio incorrecta.\n");
            }
        } while (opc < 0 || opc > 5);
        return opc;
    }
    
    /**
     * Metode {@code main()} pel qual comença l'execucio de 
     * les proves sobre la classe {@link Hostal}.
     * @param args {@code String[]}.
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        // Crear un hostal
        Hostal host = new Hostal();
        int opcio;
        do {
            opcio = menu(tec);
            switch (opcio) {
                case 1: 
                    entrada(host, tec);                        
                    break;                        
                case 2: 
                    eixida(host, tec);                                          
                    break; 
                case 3:    
                    eixidaData(host, tec);
                    break;
                case 4: 
                    System.out.println("\n" + host.toString());        
                    break;                                               
                case 5: 
                    clientsPC(host);
                    break;                        
                default: 
                    System.out.println("\n*** Fi Gestor ***");
            }
        } while (opcio != 0);        
    } // de main
    
    /**
     * Metode que fa el check in d'un client a l'hostal donat.
     * @param h {@code Hostal}, l'hostal.
     * @param t {@code Scanner}.
     */ 
    private static void entrada(Hostal h, Scanner t) {
        System.out.print("\nNIF? ");
        String nif = t.nextLine();
        System.out.print("Nom? ");
        String nom = t.nextLine();
        Data arribada = new Data();
        Data eixida;
        System.out.println("Data d'eixida (posterior a " + arribada + ") ");
        do {
            System.out.print("Dia? ");
            int d = t.nextInt();
            System.out.print("Mes? ");
            int m = t.nextInt();
            System.out.print("Any? ");
            int a = t.nextInt();
            t.nextLine();    
            eixida = new Data(d, m, a);
        } while (!eixida.esCorrecta() || !arribada.esAnterior(eixida));
        if (h.checkIn(nif, nom, arribada, eixida)) {
            System.out.println("\nCheck in fet");
        }
        else { System.out.println("\nNo s'ha pogut fer el check in"); }
    }
    
    /**
     * Metode que fa el check out d'un client a l'hostal donat.
     * @param h {@code Hostal}, l'hostal.
     * @param t {@code Scanner}.
     */ 
    private static void eixida(Hostal h, Scanner t) {
        int n;
        do {
            System.out.print("\nNumero d'habitacio? ");
            n = t.nextInt();
            t.nextLine();
        } while (n < 1 || n > Hostal.MAX_HAB);
        
        double res = h.checkOut(n);        
        if (res > 0) {           
            System.out.println("\nTotal a pagar: " + res); 
        }
        System.out.println("\nHabitacio " + n + " lliure");
    }
    
    /**
     * Metode que fa el check out en una data determinada 
     * de tots els clients que la tenen com data d'eixida
     * a l'hostal donat.
     * @param h {@code Hostal}, l'hostal.
     * @param t {@code Scanner}.
     */ 
    private static void eixidaData(Hostal h, Scanner t) {
        Data dOut;
        System.out.println("\nData d'eixida: ");
        do {
            System.out.print("Dia? ");
            int d = t.nextInt();
            System.out.print("Mes? ");
            int m = t.nextInt();
            System.out.print("Any? ");
            int a = t.nextInt();
            t.nextLine();    
            dOut = new Data(d, m, a);
        } while (!dOut.esCorrecta());
        
        double res = h.checkOut(dOut); 
        if (res > 0) { System.out.println("\nTotal a pagar: " + res); }
        else { System.out.println("\nNo hi ha clients amb eixida " + dOut); }
    }
        
    /**
     * Metode que mostra per pantalla les dades dels pacients critics 
     * d'un hospital donat.
     * @param h {@code Hospital}, l'hospital.
     */ 
    private static void clientsPC(Hostal h) {
        int[] aux = h.pensioCompleta();
        if (aux.length != 0) {
            System.out.println("\nClients en regim de PC: ");
            for (int i = 0; i < aux.length; i++) {
                System.out.println(h.getClient(aux[i]));
            }
        }
        else { 
            System.out.println("\nNo hi ha clients en regim de PC a l'hostal");
        }
    }
}
