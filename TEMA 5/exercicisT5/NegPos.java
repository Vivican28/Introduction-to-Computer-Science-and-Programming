import java.util.Scanner;
/**
 * Classe NegPos: donats dos números enters, num1 i num2, el programa 
 * ha d'escriure un dels dos missatges: "el producte dels dos números 
 * és positiu o zero" o bé "el producte dels dos números és negatiu". 
 * Sense calcular el producte.
 * 
 * @author IIP
 * @version Curs 2019/20
 */
public class NegPos {
    private NegPos() { }
    
    public static void main(String[] args) {  
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix dos nombres enters: ");
        int num1 = tec.nextInt();
        int num2 = tec.nextInt();
        final String MSG_PROD = "El producte dels dos números és ";
        if (noNegatiu(num1, num2)) {
            System.out.println(MSG_PROD + "positiu o zero");
        }
        else { System.out.println(MSG_PROD + "negatiu"); }   
    }
    
    /**
     * Torna true si el producte de num1 i num2 és positiu o zero 
     * i torna false si el producte de num1 i num2 és negatiu.
     * No hi ha que calcular el producte.
     * @param num1 int, el multiplicand. 
     * @param num2 int, el multiplicador.
     * @return boolean, true si num1 x num2 >= 0 i 
     *                 false si num1 x num2 < 0. 
     */
    public static boolean noNegatiu(int num1, int num2) {
        boolean res = true;
        /* COMPLETAR */
        return res;
    }
}
