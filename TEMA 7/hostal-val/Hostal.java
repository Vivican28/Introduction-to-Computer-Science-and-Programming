/**
 * Classe Hostal: permet representar la informacio dels clients que 
 * ocupen les habitacions d'un hostal rural.
 * 
 * @author IIP
 * @version Curs 2019/20
 */
public class Hostal {
    // Un Hostal TE...
    
    // (a) Com atributs de classe publics, les seguents constants:
    /** Numero maxim de clients. */
    public static final int MAX_CLIENTS = 10;//1000
    /** Numero maxim d'habitacions. */
    public static final int MAX_HAB = 5; // 25
    /** Preu/nit d'una habitacio en regim d'allojament i desdejuni. */
    public static final double PREU_AD = 30; 
    /** Preu/nit d'una habitacio en regim de mitja pensio. */
    public static final double PREU_MP = 40;
    /** Preu/nit d'una habitacio en regim de pensio completa. */
    public static final double PREU_PC = 50;
    
    // (b) Com atributs d'instancia privats, els seguents:
    // array de Client que representa totes les habitacions d'un Hostal
    private Client[] habitacions;
    // enter que indica el numero actual d'habitacions lliures d'un Hostal
    private int lliures;
    // enter que indica el numero actual de clients en regim de PC d'un Hostal
    private int pCompleta;
    // array d'String amb els nif de tots els clients que han visitat l'Hostal
    private String[] historic;
    // enter que indica el numero de clients que han visitat l'Hostal
    private int clients;
    
    /**
     * Crea un {@code Hostal} amb totes les habitacions lliures, es a dir,
     * no hi ha clients i, per tant, no hi ha clients en regim de pensio 
     * completa ni historic de NIF.
     */
    public Hostal() {
        habitacions = new Client[MAX_HAB + 1]; //habitacions empieza en 1
        historic = new String[MAX_CLIENTS]; //historic empieza en 0
        clients = 0;
        lliures = MAX_HAB;
        pCompleta = 0;
    }  
      
    /**
     * Torna el numero d'habitacions lliures. 
     * @return {@code int}, el numero d'habitacions lliures.
     */
    public int getLliures() { return lliures; }
    
    /**
     * Torna el numero de clients en l'historic. 
     * @return {@code int}, el numero de clients en l'historic.
     */
    public int getClientsHistoric() { return clients; }
    
    /**
     * Torna el numero d'habitacions ocupades per clients en  
     * regim de pensio completa.
     * @return {@code int}, el numero d'habitacions ocupades 
     * per clients en regim de pensio completa.
     */
    public int getPC() { return pCompleta; }
    
    /**
     * Torna el {@link Client} que ocupa l'habitacio {@code i}
     * (sent {@code i} un numero d'habitacio valid) o {@code null} 
     * si l'habitacio esta lliure. 
     * 
     * Precondicio: {@code i} es un numero d'habitacio valid
     * @param i {@code int}, el numero d'habitacio.
     * @return {@code Client}, el client que ocupa l'habitacio 
     * {@code i} o {@code null} si l'habitacio esta lliure.
     */
    public Client getClient(int i) { return habitacions[i]; }
    
    /**
     * Torna {@code true} si hi ha habitacions lliures i 
     * torna {@code false} en cas contrari.
     * @return {@code boolean}, {@code true} si hi ha 
     * habitacions lliures i {@code false} en cas contrari.
     */
    public boolean hiHaLliures() { return (lliures != 0); } 
    
    /**
     * Torna el numero de la primera habitacio lliure (la de numero
     * menor) si hi ha habitacions lliures o torna un {@code -1} 
     * si no hi ha.
     * @return {@code int}, numero de la primera habitacio lliure 
     * si hi ha habitacions lliures o {@code -1} si no hi ha.
     */
    public int primeraLliure() {
        int lliure = -1; 
        for(int i = 1; i < habitacions.length; i++) { //MAX_HAB
            if (habitacions[i] == null) { lliure = i; i = MAX_HAB + 1; }
        }
        return lliure;
        }
    
    /**
     * Donat un NIF, comprova si esta a l'historic de NIF.
     * Si esta, torna la posicio que ocupa a l'array historic. 
     * En cas contrari, torna -1 indicant que no s'ha trobat.
     */
    private int cercar(String nif) {
        int i = 0;
        boolean trobat = false;
        while (i < clients && trobat == false) {
            
            if (historic[i].equals(nif)) {
                trobat = true;
            } else { i++; }
        }
        if (trobat == false) { i = -1; }
        return i;
        }
    
    
    
    /**
     * Donat un Client, si el seu NIF no esta a l'historic, 
     * l'afegeix.
     */
    private void afegirHistoric(Client c) {
        if (cercar(c.getNif()) == -1 && clients != MAX_CLIENTS) {
            historic[clients] = c.getNif();
            clients ++;
        }
    }
    
    /**
     * Check in d'un client de nif {@code nif}, nom {@code nom},
     * data d'arribada {@code arribada} i data d'eixida {@code eixida}, 
     * tornant {@code true} si s'ha pogut fer i {@code false} 
     * en cas contrari (si no hi ha habitacions lliures).
     * Si hi ha habitacions lliures, la primera d'elles (la de numero menor)
     * passa a estar ocupada pel client.
     * Si el nif del client no esta a l'historic, l'afegeix. 
     * 
     * Precondicio: arribada es anterior a eixida.
     * @param nif {@code String}, el NIF.
     * @param nom {@code String}, el nom.
     * @param arribada {@code Data}, la data d'arribada.
     * @param eixida {@code Data}, la data d'eixida.
     * @return boolean, {@code true} si s'ha fet el check in i 
     *                  {@code false} en cas contrari.
     */
    public boolean checkIn(String nif, String nom, Data arribada, Data eixida) {
        Client c = new Client(nif, nom, arribada, eixida);
        boolean aconseguit = false;
        int i = 1;
        if (hiHaLliures() == true) {
            habitacions[primeraLliure()] = c;
            if (c.getRegim() == Client.PC) { pCompleta ++; }
            lliures --;
            afegirHistoric(c);
            if (hiHaLliures() == true) { aconseguit = true; }
        }
        
        return aconseguit;
    } 
    
    /**
     * Check out del client que ocupa l'habitacio {@code i} (sent {@code i} 
     * un numero d'habitacio valid), tornant el preu a pagar o {@code 0} si 
     * l'habitacio no estava ocupada. 
     * L'habitacio {@code i}, si estava ocupada, passa a estar lliure.
     * 
     * Precondicio: {@code i} es un numero d'habitacio valid
     * @param i {@code int}, el numero d'habitacio.
     * @return double, el preu a pagar pel client que deixa l'habitacio 
     * o {@code 0} si no estava ocupada.
     */
    public double checkOut(int i) {
        double diners = 0;
        double nit = 0;
        if (habitacions[i] != null) {
            switch(habitacions[i].getRegim()) {
                case 0:
                    nit = PREU_AD;
                    break;
                case 1:
                    nit = PREU_MP;
                    break;
                case 2:
                    nit = PREU_PC;
                    pCompleta --;
                    break;
                }
            diners = habitacions[i].getArribada().difDies(habitacions[i].getEixida()) * nit;
            habitacions[i] = null;
            lliures += 1;
            
        } else { diners = 0; }
        return diners;
       }
        
    
    
    /**
     * Check out de tots els clients tals que la seua data d'eixida es 
     * la {@code Data d} donada, tornant el preu total a pagar o {@code 0} 
     * si no hi ha cap client amb aquesta data d'eixida.
     * 
     * @param d {@code Data}.
     * @return double, el preu total a pagar pels clients que deixen 
     * les habitacions o {@code 0} si cap deixa la seua habitacio.
     */
    public double checkOut(Data d) {
        double diners = 0;
        double nit = 0;
        for (int i = 1; i < habitacions.length; i++) {
            switch(habitacions[i].getRegim()) {
                case 0:
                    nit = PREU_AD;
                    break;
                 case 1:
                    nit = PREU_MP;
                    break;
                case 2:
                    nit = PREU_PC;
                    break;
            }
            diners += habitacions[i].getArribada().difDies(d) * nit;
            habitacions[i] = null;
            lliures += 1;
        }
        return diners;
    }

    /**
     * Torna un {@code String} que descriu l'hostal, es a dir, quins 
     * clients ocupen quines habitacions i quines habitacions estan lliures<br>
     * Si no hi ha clients, torna {@code "Hostal buit"} (acabat en {@code "\n"}).
     * <br>
     * El format de l'{@code String} resultat es com en l'exemple que segueix, 
     * on el numero d'habitacio va seguit d'un tabulador {@code "\t"}:<br>
     * {@code 1     María Medina Urrutia       85859463H  05/12/2017  10/12/2017  PC}<br>
     * {@code 2     Pepe Pérez Gutiérrez       74747474I  15/12/2017  21/12/2017  AD}<br>
     * {@code 3 lliure}<br>
     * {@code 4     Juan López Alegría         12345678J  19/12/2017  31/12/2017  MP}<br>
     * {@code 5     lliure}<br>
     * {@code 6     Germán García Santaeulalia 98765432M  24/11/2017  04/12/2017  PC}<br>
     * {@code 7     lliure}<br>
     * {@code ...}<br><btrrrrrr<brrbewsitaaaaaaa>>
     * {@code 25    Andrés Sánchez Miralles    13457892A  27/11/2017  28/11/2017  AD}<br>
     * 
     * @return {@code String}, el resultat.
     */
    public String toString() {
        String patata = "";
        for (int i = 1; i < habitacions.length; i++) {
            if (habitacions[i] != null) {
                patata +=  i + "\t" + habitacions[i].toString() + "\n";
            } else { patata +=  i + "\t" + "lliure" + "\n"; }
            
            if (getLliures() == MAX_HAB) { patata = "Hostal buit" + "\n"; }
        
        }
        return patata;
    }
    /**
     * Torna un array amb els numeros d'habitacions ocupades pels 
     * clients en regim de pensio completa. La longitud d'aquest array 
     * sera igual al numero de clients en regim de pensio completa, 
     * o 0 si no hi ha cap client en aquest regim a l'hostal.
     * 
     * @return int[], array amb els numeros d'habitacions ocupades pels 
     * clients en regim de pensio completa.
     */
    public int[] pensioCompleta() {
        int[] res = new int[pCompleta];
        int j = 0; //contador
        for(int i = 0; i < habitacions.length && j < pCompleta; i++) {
            if (habitacions[i] != null && habitacions[i].getRegim() == Client.PC) {
                res[j] = i;
                j++;
            }
        } 
        return res;
    }   

}
