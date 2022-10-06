import java.util.Locale;
import java.util.Scanner;
/**
 * Write a description of class TestTelescopiP1 here.
 *
 * @author Violeta Vicente Cantero
 * @version Curs 2019-20
 */
public class TestTelescopiP1 {
    private TestTelescopiP1() { }
    
    public static void main(String[] args){
        //Cree un objecte de la classe Telescopi
        Telescopi t = new Telescopi();
        //amb una lent principal de 76.2 mm de
        //diàmetre, una distància focal de 165.1 mm
        //i una distància focal ocular de 20.32 mm
        t.setDiametre(76.2);
        t.setDFL(165.1);
        t.setDFO(20.32);
        
        //Mostre per pantalla els augments i la relació focal del telescopi t 
        //(amb 2 xifres decimals)
        System.out.println("Arguments: " 
            + Math.round(t.augments() * 100) / 100.0);
        
        //Mostre per pantalla la nova relació focal de t
        //(amb 2 xifres decimals)
        System.out.println("Relació focal: "
            + Math.round(t.relacioFocal() * 100) / 100.0);
            
        //Actualitze a un nou valor llegit des de teclat el
        //diàmetre de t
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Introdueix un nou diametre: ");
        double d = tec.nextDouble();
        t.setDiametre(d);
        
        //Mostre per pantalla la nova relació focal de t
        //(amb 2 xifres decimals)
        System.out.println("Relació focal: " + Math.round(t.relacioFocal() * 100 / 100.0));
    }    
}
