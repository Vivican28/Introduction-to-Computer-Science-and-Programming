import java.util.Scanner;
/**
 * Classe Condicionals: exemples de mètodes que utilitzen instruccions 
 * condicionals.
 * 
 * @author IIP 
 * @version Curs 2019/20
 */
public class Condicionals {
    private Condicionals() { }
    
    /**
     * Donats un enter x i un char c, mostra per pantalla
     * un missatge en funció dels valors de x i c.
     * @param x int, l'enter.
     * @param c char, el caràcter.
     */
    public static void exercici4(int x, char c) {
        if (x < 0 && c == 'x') { System.out.println("Cas 1"); }
        else if (x < 0 && c != 'x') { System.out.println("Cas 2"); }
        else if (x >= 0 && c == 'y') { System.out.println("Cas 3"); }
        else if (x >= 0 && c != 'y') { System.out.println("Cas 4"); }

        /* Reescriu el codi amb la següent estructura, col.locant 
         * les condicions i instruccions System.out.println() 
         * adequades, de forma que donats qualssevol x, c, el resultat 
         * escrit en l’eixida estàndard coincidisca:
         */ 
        if (x < 0) {
            if ( c == 'x') { System.out.println("Cas 1"); }
            else { System.out.println("Cas 2"); }
        }
        else { // x >= 0
             if (c == 'y') { System.out.println("Cas 3"); }
             else { System.out.println("Cas 4"); }
        }    
    }
    
    /**
     * Donats tres valors enters distints qualsevol, els mostra 
     * per pantalla ordenadament, de major a menor.
     * @param a int, el primer enter.
     * @param b int, el segon enter.
     * @param c int, el tercer enter.
     */
    public static void deMajorAMenor3(int a, int b, int c) {
        int max, med, min;
        // Primera versió:
        if (a > b) { // a és major que b
            // calcular on es troba c
            if (c > a) { max = c; med = a; min = b; }
            else { // c és menor que a 
                if (c > b) { max = a; med = c; min = b; }
                else { max = a; med = b; min = c; }
            }
        }
        else { // a és menor que b
            // calcular on es troba c
            if (c < a) { max = b; med = a; min = c; }
            else  { max = c; med = b; min = a; }
        }
        
        System.out.println("màxim: " + max 
            + " intermedi: " + med + " mínim: " + min);
             
        // Segona versió:
        // 1. assignar a max el major de a i b  
        // i a min el menor de a i b
        if (a > b) { max = a; min = b; }
        else { max = b; min = a; }
        // 2. assignar a max el major de max i c 
        // i a min el menor de min i c        
        if (c > max) { med = max; max = c; }
        else if (c < min) {med = c; }
        else { med = min; min = c; }
        
        System.out.println("màxim: " + max 
            + " intermedi: " + med + " mínim: "+ min);
    }

    /**
     * Donats tres valors enters a, b i c, implementa distintes solucions a 
     * l'anàlisi per casos següent, fent ús de: operadors curtcircuitats i 
     * instruccions condicionals.
     *      a > b -> true
     *      a < b -> false
     *      a == b i a > c -> true
     *      a == b i a < c -> false
     *      a == b i a == c -> false
     * 
     * @param a int, primer enter
     * @param b int, segon enter
     * @param c int, tercer enter
     * @return boolean, resultat 
     */
    public static boolean simplifica(int a, int b, int c) {
        boolean resultat;
        /* Primera aproximació amb transcripció 
         * de l'enunciat a if ... else ... */
        if (a > b) { resultat = true; }
        else if (a < b) { resultat = false; }
        else if (a > c) { resultat = true; }
        else { resultat = false; }

        /* Segona aproximació realitzant un anàlisi per casos 
         * partint de les dos possibles solucions (true o false) */
        if ((a > b) || (a == b && a > c)) { resultat = true; }
        else { resultat = false; }

        /* La mateixa aproximació que l'anterior realitzant un anàlisi
         * per casos partint de les dos possibles solucions (true o false),
         * però implementat amb una instrucció condicional simple i
         * establint un dels dos casos per defecte (el false per exemple) */
        resultat = false;
        if ((a > b) || (a == b && a > c)) { resultat = true; }
        /* Tercera aproximació utilitzant una assignació en lloc 
         * d'una instrucció condicional */
        resultat = a > b || (a == b && a > c);
         
        /* Utilitzant l'operador ternari */
        
        
        return resultat;
    }
    
    /** 
     * Mètode principal que prova els mètodes anteriors.
     */
    public static void main(String[] args) {      
        Scanner tec = new Scanner(System.in);
        System.out.print("Escriu un enter: ");
        int enter = tec.nextInt();
        exercici4(enter, 'x');
        exercici4(enter, 'y');
        
        System.out.print("Escriu 3 valors distints a classificar: ");
        int x = tec.nextInt(); 
        int y = tec.nextInt();
        int z = tec.nextInt();
        
        deMajorAMenor3(x, y, z);
        
        System.out.println("\nResultat de simplificar: " + simplifica(x, y, z));
    }
}
